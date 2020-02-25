package api.rest.indra.models.services;

import java.util.List;

import api.rest.indra.models.entity.Persona;

public interface IPersonaService {

	public List<Persona> findAll();

	public void save(Persona persona);

	public Persona findById(Long id);

	public void delete(Persona persona);

}
