package api.rest.indra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import api.rest.indra.DAOModel.PersonaRepo;
import api.rest.indra.model.Persona;

@Service
@Transactional
public class PersonaServImpl implements IPersonaServ{
	
	@Autowired
	private PersonaRepo repo;

	@Override
	public String crearPersona(Persona persona) {
		// TODO Auto-generated method stub
		String resp = null;
		resp = Integer.toString(repo.save(persona).getId());
		return resp;
	}

	@Override
	public String modificarPersona(Persona persona) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Persona consultarPersona(Integer ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Persona> consultarPersonas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void borrarProducto(Integer ID) {
		// TODO Auto-generated method stub
		
	}

}
