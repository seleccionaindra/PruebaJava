package api.rest.indra.domain.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import api.rest.indra.domain.dto.CrearPersonaPeticionDto;
import api.rest.indra.domain.dto.PersonaRespuestaDto;
import api.rest.indra.exceptions.DataNotFoundException;
import api.rest.indra.exceptions.ServiceException;
import api.rest.indra.infrastucture.entidades.Persona;
import api.rest.indra.infrastucture.repositorio.PersonaRepository;

@TestConfig
class PersonaImplServiceTest
{
    @Mock
    private PersonaRepository personaRepository;
    
    @InjectMocks
    private PersonaImplService personaImplService;
    
    @Test
    void when_consultarPersonas_then_retornaListaDePersonas()
    {
        
        when(this.personaRepository.findAll()).thenReturn(mapearListaPersonas());
        List<PersonaRespuestaDto> lista = this.personaImplService.listar();
        assertThat(lista).isNotEmpty();
    }
    
    @Test
    void when_consultarPersonas_then_retornaDataNotfoundException()
    {
        
        when(this.personaRepository.findAll()).thenReturn(Collections.emptyList());
        Assertions.assertThrows(DataNotFoundException.class, () -> this.personaImplService.listar());
        
    }
    
    @Test
    void when_crearPersona_then_retornaListaDePersonas()
    {
        CrearPersonaPeticionDto peticion = new CrearPersonaPeticionDto();
        peticion.setApellidos("Flandes");
        peticion.setCedula(22344L);
        peticion.setEdad(40);
        peticion.setGenero("M");
        peticion.setNombres("Amaranto");
        Persona persona = Persona.builder().apellidos(peticion.getApellidos()).cedula(peticion.getCedula()).edad(40).genero(peticion.getGenero()).nombres(peticion.getNombres()).build();
        when(this.personaRepository.save(persona)).thenReturn(persona);
        
        PersonaRespuestaDto respuesta = this.personaImplService.crearPersona(peticion);
        assertThat(respuesta).isNotNull();
    }
    
    @Test
    void when_crearPersona_then_retornaServiceException()
    {
        
        CrearPersonaPeticionDto peticion = new CrearPersonaPeticionDto();
        peticion.setApellidos("Flandes");
        peticion.setCedula(22344L);
        peticion.setEdad(40);
        peticion.setGenero("M");
        peticion.setNombres("Amaranto");
        Persona persona = Persona.builder().apellidos(peticion.getApellidos()).cedula(peticion.getCedula()).edad(40).genero(peticion.getGenero()).nombres(peticion.getNombres()).build();
        when(this.personaRepository.save(persona)).thenThrow(new NullPointerException());
        
        Assertions.assertThrows(ServiceException.class, () -> this.personaImplService.crearPersona(peticion));
        
    }
    
    @Test
    void when_eliminarPersona_then_vacio()
    {
        Persona persona = Persona.builder().apellidos("Lopez").cedula(1234L).edad(20).genero("M").id(1L).nombres("Juan").build();
        when(this.personaRepository.findById(1L)).thenReturn(Optional.of(persona));
        
        this.personaImplService.eliminar(1l);
        
    }
    
    @Test
    void when_eliminarPersona_then_retornaDataNotFoundException()
    {
        
        when(this.personaRepository.findById(1L)).thenReturn(Optional.empty());
        
        Assertions.assertThrows(DataNotFoundException.class, () -> this.personaImplService.eliminar(1l));
        
    }
    
    @Test
    void when_actualizarPersona_then_vacio()
    {
        CrearPersonaPeticionDto peticion = new CrearPersonaPeticionDto();
        peticion.setApellidos("Flandes");
        peticion.setCedula(22344L);
        peticion.setEdad(40);
        peticion.setGenero("M");
        peticion.setNombres("Amaranto");
        Persona persona = Persona.builder().apellidos(peticion.getApellidos()).id(1L).cedula(peticion.getCedula()).edad(40).genero(peticion.getGenero()).nombres(peticion.getNombres()).build();
        
        when(this.personaRepository.findById(1L)).thenReturn(Optional.of(persona));
        when(this.personaRepository.save(persona)).thenReturn(persona);
        PersonaRespuestaDto respuesta = this.personaImplService.actualizar(1L, peticion);
        assertThat(respuesta).isNotNull();
    }
    
    @Test
    void when_actualizarPersona_then_retornaDataNotFoundException()
    {
        
        CrearPersonaPeticionDto peticion = new CrearPersonaPeticionDto();
        peticion.setApellidos("Flandes");
        peticion.setCedula(22344L);
        peticion.setEdad(40);
        peticion.setGenero("M");
        peticion.setNombres("Amaranto");
        Persona persona = Persona.builder().apellidos(peticion.getApellidos()).id(1L).cedula(peticion.getCedula()).edad(40).genero(peticion.getGenero()).nombres(peticion.getNombres()).build();
        
        when(this.personaRepository.findById(1L)).thenReturn(Optional.empty());
        when(this.personaRepository.save(persona)).thenReturn(persona);
        
        Assertions.assertThrows(DataNotFoundException.class, () -> this.personaImplService.actualizar(1L, peticion));
        
    }
    
    @Test
    void when_actualizarPersona_then_retornaServiceException()
    {
        
        CrearPersonaPeticionDto peticion = new CrearPersonaPeticionDto();
        peticion.setApellidos("Flandes");
        peticion.setCedula(22344L);
        peticion.setEdad(40);
        peticion.setGenero("M");
        peticion.setNombres("Amaranto");
        Persona persona = Persona.builder().apellidos(peticion.getApellidos()).id(1L).cedula(peticion.getCedula()).edad(40).genero(peticion.getGenero()).nombres(peticion.getNombres()).build();
        
        when(this.personaRepository.findById(1L)).thenReturn(Optional.of(persona));
        when(this.personaRepository.save(persona)).thenReturn(null);
        
        Assertions.assertThrows(ServiceException.class, () -> this.personaImplService.actualizar(1L, peticion));
        
    }
    
    /**
     * @author Kaleth Bahena
     * @version 0.0.1 2020/11/06
     * @since 0.0.1 2020/11/06
     * @return
     */
    private List<Persona> mapearListaPersonas()
    {
        List<Persona> lista = new ArrayList<>();
        Persona persona = Persona.builder().apellidos("Lopez").cedula(1234L).edad(20).genero("M").id(1L).nombres("Juan").build();
        lista.add(persona);
        persona = Persona.builder().apellidos("Rodriguez").cedula(12345L).edad(20).genero("F").id(2L).nombres("Maria").build();
        lista.add(persona);
        persona = Persona.builder().apellidos("Duran").cedula(123456L).edad(20).genero("M").id(1L).nombres("Lucas").build();
        lista.add(persona);
        return lista;
    }
}
