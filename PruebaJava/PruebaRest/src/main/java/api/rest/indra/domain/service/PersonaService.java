package api.rest.indra.domain.service;

import java.util.List;

import javax.validation.Valid;

import api.rest.indra.domain.dto.CrearPersonaPeticionDto;
import api.rest.indra.domain.dto.PersonaRespuestaDto;

/**
 * Interface encargada de manejar los datos de las personas
 * @author Kaleth Bahena
 * @version 0.0.1 2020/11/06
 * @since 0.0.1 2020/11/06
 */
public interface PersonaService
{
    
    /**
     * Metodo que permite crear una nueva persona
     * @author Kaleth Bahena
     * @version 0.0.1 2020/11/06
     * @since 0.0.1 2020/11/06
     * @param peticion datos de la peticion
     * @return PersonaRespuestaDto
     */
    PersonaRespuestaDto crearPersona(@Valid CrearPersonaPeticionDto peticion);
    
    /**
     * Metodo que permite listar las personas
     * @author Kaleth Bahena
     * @version 0.0.1 2020/11/06
     * @since 0.0.1 2020/11/06
     * @param peticion datos de la peticion
     * @return PersonaRespuestaDto
     */
    List<PersonaRespuestaDto> listar();
    
    /**
     * Metodo que permite buscar las personas por su nombre
     * @author Kaleth Bahena
     * @version 0.0.1 2020/11/06
     * @since 0.0.1 2020/11/06
     * @param peticion datos de la peticion
     * @return PersonaRespuestaDto
     */
    List<PersonaRespuestaDto> buscarPorNombre(String nombre);
    
    /**
     * Metodo que permite eliminar una persona por su id
     * @author Kaleth Bahena
     * @version 0.0.1 2020/11/06
     * @since 0.0.1 2020/11/06
     * @param peticion datos de la peticion
     * @return PersonaRespuestaDto
     */
    void eliminar(Long id);
    
    /**
     * Metodo que permite eliminar una persona por su id
     * @author Kaleth Bahena
     * @version 0.0.1 2020/11/06
     * @since 0.0.1 2020/11/06
     * @param peticion datos de la peticion
     * @return PersonaRespuestaDto
     */
    PersonaRespuestaDto actualizar(Long id, CrearPersonaPeticionDto peticion);
    
    /**
     * Metodo que permite buscar una persona por su id
     * @author Kaleth Bahena
     * @version 0.0.1 2020/11/06
     * @since 0.0.1 2020/11/06
     * @param peticion datos de la peticion
     * @return PersonaRespuestaDto
     */
    PersonaRespuestaDto buscarPorId(Long id);
}
