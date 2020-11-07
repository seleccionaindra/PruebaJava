package api.rest.indra.application;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.rest.indra.domain.dto.CrearPersonaPeticionDto;
import api.rest.indra.domain.dto.PersonaRespuestaDto;
import api.rest.indra.domain.service.PersonaService;
import io.swagger.annotations.Api;
import lombok.Getter;

/**
 * Clase que maneja las operaciones de las personas
 * @author Kaleth Bahena
 * @version 0.0.1 2020/11/06
 * @since 0.0.1 2020/11/06
 */
@RestController
@RequestMapping(PersonaRestService.URL_PERSONAS)
@Validated
@Api("Clase que maneja las operaciones de las personas")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaRestService
{
    /** Constante para el mapeo de la url base del api */
    protected static final String URL_PERSONAS = "/api/v1/personas";
    
    /** Servicio encargado del manejo de las personas */
    @Autowired
    @Getter
    private PersonaService personaService;
    
    /**
     * Metodo que permite crear una nueva persona
     * @author Kaleth Bahena
     * @version 0.0.1 2020/11/06
     * @since 0.0.1 2020/11/06
     * @param peticion datos de la peticion
     * @return PersonaRespuestaDto
     */
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonaRespuestaDto> crearPersona(@RequestBody @Valid CrearPersonaPeticionDto peticion)
    {
        PersonaRespuestaDto respuesta = getPersonaService().crearPersona(peticion);
        return ResponseEntity.ok(respuesta);
    }
    
    /**
     * Metodo que permite listar las personas
     * @author Kaleth Bahena
     * @version 0.0.1 2020/11/06
     * @since 0.0.1 2020/11/06
     * @param peticion datos de la peticion
     * @return PersonaRespuestaDto
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PersonaRespuestaDto>> listar()
    {
        List<PersonaRespuestaDto> respuesta = getPersonaService().listar();
        return ResponseEntity.ok(respuesta);
    }
    
    /**
     * Metodo que permite eliminar una persona por su id
     * @author Kaleth Bahena
     * @version 0.0.1 2020/11/06
     * @since 0.0.1 2020/11/06
     * @param peticion datos de la peticion
     * @return PersonaRespuestaDto
     */
    @DeleteMapping(value = "/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Long id)
    {
        getPersonaService().eliminar(id);
        return ResponseEntity.noContent().build();
    }
    
    /**
     * Metodo que permite eliminar una persona por su id
     * @author Kaleth Bahena
     * @version 0.0.1 2020/11/06
     * @since 0.0.1 2020/11/06
     * @param peticion datos de la peticion
     * @return PersonaRespuestaDto
     */
    @PutMapping(value = "/actualizar/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonaRespuestaDto> actualizar(@PathVariable("id") Long id, @RequestBody @Valid CrearPersonaPeticionDto peticion)
    {
        PersonaRespuestaDto respuesta = getPersonaService().actualizar(id, peticion);
        return ResponseEntity.ok(respuesta);
    }
    
}
