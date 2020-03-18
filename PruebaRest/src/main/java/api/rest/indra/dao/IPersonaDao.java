package api.rest.indra.dao;

import org.springframework.data.repository.CrudRepository;
import api.rest.indra.entities.Persona;

public interface IPersonaDao extends CrudRepository<Persona, String> {

}
