package api.rest.indra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.rest.indra.dao.repository.IPersonasRepository;
import api.rest.indra.model.entity.Personas;

@Service
public class PersonasService implements IPersonasService {
	
	@Autowired
	private IPersonasRepository iPersonasRepository;
	
	
	@Override
	public List<Personas> buscarPersonasTodo(){
		return iPersonasRepository.buscarPersonasTodo();
	}
	@Override
	public void guardarPersona(Personas personas){
		iPersonasRepository.save(personas);
	}
	
	@Override
	public void actualizarPersona(Personas personas) {
		iPersonasRepository.save(personas);	
	}
	
	@Override
	public void borrarPersona(String cedula) {
		iPersonasRepository.deleteById(cedula);
	}
	@Override
	public Personas buscarPersona(String cedula) {
		Personas persona=new Personas();
		
		persona=iPersonasRepository.findById(cedula).get();
		//System.out.println(persona.getApellidos());
		return persona;
	}
}
