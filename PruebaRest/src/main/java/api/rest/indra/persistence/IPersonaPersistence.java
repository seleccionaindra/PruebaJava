package api.rest.indra.persistence;

import api.rest.indra.domain.Persona;
import org.springframework.data.repository.CrudRepository;

public interface IPersonaPersistence extends CrudRepository<Persona, Long> {
    
}
