package api.rest.indra.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import api.rest.indra.models.dao.IPersonaDao;
import api.rest.indra.models.entity.Persona;

@Service
public class PersonaServiceImpl implements IPersonaService {

	@Autowired
	private IPersonaDao personaDao;
	


	@Transactional(readOnly = true)
	public List<Persona> findAll() {
		return (List<Persona>) personaDao.findAll();
	}

	
	@Transactional
	public void save(Persona persona) {
		personaDao.save(persona);
	}

	
	@Transactional(readOnly = true)
	public Persona findById(Long id) {
		return personaDao.findById(id).orElse(null);
	}

	
	@Transactional
	public void delete(Persona persona) {
		personaDao.delete(persona);
		
	}

}
