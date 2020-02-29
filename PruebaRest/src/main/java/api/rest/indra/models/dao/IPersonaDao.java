package api.rest.indra.models.dao;

import org.springframework.data.repository.CrudRepository;

import api.rest.indra.models.entity.Persona;

public interface IPersonaDao extends CrudRepository<Persona, Long> {

}
