package api.rest.indra.dao;

import org.springframework.data.repository.CrudRepository;

import api.rest.indra.model.Persona;

public interface IPersonaDao extends CrudRepository<Persona, Long> {

}
