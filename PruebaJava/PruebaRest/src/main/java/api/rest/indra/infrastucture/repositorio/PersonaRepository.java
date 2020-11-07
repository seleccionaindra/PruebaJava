package api.rest.indra.infrastucture.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.rest.indra.infrastucture.entidades.Persona;

/**
 * Repositorio encargado del manejo de acceso a datos de la entidad persona
 * @author Kaleth Bahena
 * @version 0.0.1 2020/11/06
 * @since 0.0.1 2020/11/06
 */
@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long>
{
 
    /**
     * Metodo que busca un usuario por el nombre
     * @author Kaleth Bahena
     * @version 0.0.1 2020/11/06
     * @since 0.0.1 2020/11/06
     * @param nombres
     * @return
     */
    List<Persona> findByNombres(String nombres);
 
}
