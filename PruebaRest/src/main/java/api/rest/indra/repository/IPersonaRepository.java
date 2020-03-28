package api.rest.indra.repository;

import org.springframework.data.repository.CrudRepository;

import api.rest.indra.entity.PersonaEntity;

public interface IPersonaRepository extends CrudRepository<PersonaEntity, String>{

}
