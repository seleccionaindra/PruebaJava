package api.rest.indra.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;

import api.rest.indra.domain.dto.CrearPersonaPeticionDto;
import api.rest.indra.domain.dto.PersonaRespuestaDto;
import api.rest.indra.exceptions.DataNotFoundException;
import api.rest.indra.exceptions.ServiceException;
import api.rest.indra.infrastucture.entidades.Persona;
import api.rest.indra.infrastucture.repositorio.PersonaRepository;
import lombok.Getter;

/**
 * Servicio que implementa {@link PersonaService} encargado de manejar los datos de las personas
 * @author Kaleth Bahena
 * @version 0.0.1 2020/11/06
 * @since 0.0.1 2020/11/06
 */
@Service
@Validated
class PersonaImplService implements PersonaService
{
    @Autowired
    @Getter
    private PersonaRepository personaRepository;
    
    /**
     * Mapea los datos de un dto a entidad
     * @author Kaleth Bahena
     * @version 0.0.1 2020/11/06
     * @since 0.0.1 2020/11/06
     * @return
     */
    private Function<CrearPersonaPeticionDto, Persona> mapearAEntidad()
    {
        return dto -> Persona.builder().nombres(dto.getNombres()).apellidos(dto.getApellidos()).cedula(dto.getCedula()).edad(dto.getEdad()).genero(dto.getGenero()).build();
    }
    
    /**
     * Mapea los datos de un dto a entidad
     * @author Kaleth Bahena
     * @version 0.0.1 2020/11/06
     * @since 0.0.1 2020/11/06
     * @return
     */
    private Function<Persona, PersonaRespuestaDto> mapearAPersonaRespuestaDto()
    {
        return dto -> PersonaRespuestaDto.builder().id(dto.getId()).nombres(dto.getNombres()).apellidos(dto.getApellidos()).cedula(dto.getCedula()).edad(dto.getEdad()).genero(dto.getGenero()).build();
    }
    
    /*
     * (non-Javadoc)
     * @see api.rest.indra.domain.service.PersonaService#crearPersona(api.rest.indra.domain.dto.CrearPersonaPeticionDto)
     * @author Kaleth Bahena
     * @version 0.0.1 2020/11/06
     * @since 0.0.1 2020/11/06
     */
    @Override
    public PersonaRespuestaDto crearPersona(@Valid CrearPersonaPeticionDto peticion)
    {
        try
        {
            Persona persona = mapearAEntidad().apply(peticion);
            getPersonaRepository().save(persona);
            return mapearAPersonaRespuestaDto().apply(persona);
        }
        catch (Exception e)
        {
            throw new ServiceException("Se ha presentado un error al crear la persona", e);
        }
    }
    
    /*
     * (non-Javadoc)
     * @see api.rest.indra.domain.service.PersonaService#listar()
     * @author Kaleth Bahena
     * @version 0.0.1 2020/11/06
     * @since 0.0.1 2020/11/0 *
     */
    @Override
    public List<PersonaRespuestaDto> listar()
    {
        List<Persona> respuestaConsultar = getPersonaRepository().findAll();
        if (CollectionUtils.isEmpty(respuestaConsultar))
        {
            throw new DataNotFoundException("No se encontraron registro de personas");
        }
        return respuestaConsultar.stream().map(mapearAPersonaRespuestaDto()).collect(Collectors.toList());
    }
    
    /*
     * (non-Javadoc)
     * @see api.rest.indra.domain.service.PersonaService#buscarPorNombre(java.lang.String)
     * @author Kaleth Bahena
     * @version 0.0.1 2020/11/06
     * @since 0.0.1 2020/11/0
     */
    @Override
    public List<PersonaRespuestaDto> buscarPorNombre(String nombre)
    {
        List<Persona> listadoPersona = getPersonaRepository().findByNombres(nombre);
        if (CollectionUtils.isEmpty(listadoPersona))
        {
            throw new DataNotFoundException(String.format("No se encontraron personas con el nombre %s:", nombre));
        }
        return listadoPersona.stream().map(mapearAPersonaRespuestaDto()).collect(Collectors.toList());
    }
    
    /*
     * (non-Javadoc)
     * @see api.rest.indra.domain.service.PersonaService#eliminar(java.lang.Long)
     * @author Kaleth Bahena
     * @version 0.0.1 2020/11/06
     * @since 0.0.1 2020/11/06
     */
    @Override
    public void eliminar(Long id)
    {
        Persona persona = getPersonaRepository().findById(id).orElseThrow(() -> new DataNotFoundException("La persona no existe!"));
        getPersonaRepository().delete(persona);
    }
    
    /*
     * (non-Javadoc)
     * @see api.rest.indra.domain.service.PersonaService#actualizar(java.lang.Long, api.rest.indra.domain.dto.CrearPersonaPeticionDto)
     * @author Kaleth Bahena
     * @version 0.0.1 2020/11/06
     * @since 0.0.1 2020/11/06
     */
    @Override
    public PersonaRespuestaDto actualizar(Long id, CrearPersonaPeticionDto peticion)
    {
        Persona persona = getPersonaRepository().findById(id).orElseThrow(() -> new DataNotFoundException("La persona no existe!"));
        
        persona.setApellidos(peticion.getApellidos());
        persona.setCedula(peticion.getCedula());
        persona.setEdad(peticion.getEdad());
        persona.setGenero(peticion.getGenero());
        persona.setNombres(peticion.getNombres());
        persona = Optional.ofNullable(getPersonaRepository().save(persona)).orElseThrow(() -> new ServiceException("Se ha presentado un error al crear la persona"));
        return mapearAPersonaRespuestaDto().apply(persona);
    }
    
    /*
     * (non-Javadoc)
     * @see api.rest.indra.domain.service.PersonaService#buscarPorId(java.lang.Long)
     * @author Kaleth Bahena
     * @version 0.0.1 2020/11/06
     * @since 0.0.1 2020/11/06
     */
    @Override
    public PersonaRespuestaDto buscarPorId(Long id)
    {
        Persona persona = getPersonaRepository().findById(id).orElseThrow(() -> new DataNotFoundException("La persona no existe!"));
        return mapearAPersonaRespuestaDto().apply(persona);
    }
}
