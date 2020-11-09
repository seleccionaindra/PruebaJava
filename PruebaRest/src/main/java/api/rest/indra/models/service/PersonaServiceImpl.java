package api.rest.indra.models.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import api.rest.indra.models.Persona;
import api.rest.indra.models.dao.IPersonaDao;

@Service
public class PersonaServiceImpl implements IPersonaService {

	@Autowired
	IPersonaDao personaDao;

	@Override
	public Persona crearPersona(Persona persona) {
		if (persona == null) {
			throw new RuntimeException("El objeto persona no puede ser nulo.");
		}
		if (persona.getCedula() == null) {
			throw new RuntimeException("La cedula de persona no puede ser nula.");
		}
		if (getPersona(persona.getCedula()) != null) {
			throw new RuntimeException("Ya existe una persona con la cedula indicada.");
		}
		personaDao.save(persona);
		return persona;
	}

	@Override
	public Persona getPersona(Long cedula) {
		return personaDao.findById(cedula).orElse(null);
	}

	@Override
	public List<Persona> getPersonas() {
		return StreamSupport
				  .stream(personaDao.findAll().spliterator(), false)
				  .collect(Collectors.toList());
	}

	@Override
	public Persona updatePersona(Long cedula, Persona personaNew) throws RuntimeException {
		if (cedula == null) {
			throw new RuntimeException("La cedula no puede ser nula.");
		}
		if (personaNew == null) {
			throw new RuntimeException("El objeto persona no puede ser nulo.");
		}

		if (!cedula.equals(personaNew.getCedula())) {
			throw new RuntimeException("La cedula de persona:(".concat(String.valueOf(personaNew.getCedula()))
					.concat(") no coincide con la cedula buscada:(").concat(String.valueOf(cedula)).concat(")."));
		}
		Persona personaOld = getPersona(cedula);
		if (personaOld != null) {
			personaDao.save(personaNew);
			return personaNew;
		}
		return personaOld;

	}

	@Override
	public Persona deletePersona(Long cedula) {
		Persona persona = getPersona(cedula);
		if (persona != null) {
			personaDao.deleteById(cedula);
		}
		return persona;
	}

}
