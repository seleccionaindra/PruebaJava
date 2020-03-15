package api.rest.indra.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import api.rest.indra.model.entity.Personas;

public interface IPersonasRepository extends CrudRepository<Personas, String>{

	@Query("SELECT prs FROM Personas prs")
	public List<Personas> buscarPersonasTodo();
	

}
