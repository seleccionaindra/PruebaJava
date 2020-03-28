package api.rest.indra.services;

import api.rest.indra.services.IPersonaServices;
import api.rest.indra.domain.Persona;
import java.util.List;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonaServicesTest {
    
    private Persona persona;
    private Persona nuevaPersona;
    
    @Autowired
    private IPersonaServices personaServices;
    
    public PersonaServicesTest() {
        persona = new Persona();
    }
    
    @Before
    public void setUp() {
        persona = setData();
    }
    
    @Test
    public void contextLoads() {
        assertNotNull(personaServices);
    }

    /**
     * Test of get method, of class PersonaServices.
     */
    @Test
    public void testGet() {
        List<Persona> lstPersona = personaServices.get();
        assertNotNull(lstPersona);
    }

    /**
     * Test of create method, of class PersonaServices.
     */
    @Test
    public void testCreate() {
        nuevaPersona = personaServices.create(persona);
        persona.setId(nuevaPersona.getId());
        assertSame(persona, nuevaPersona);
    }

    /**
     * Test of update method, of class PersonaServices.
     */
    @Test
    public void testUpdate() {
        persona.setId(1L);
        nuevaPersona = personaServices.update(persona);
        assertEquals(persona.getId(), nuevaPersona.getId());
        assertEquals(persona.getNombres(), nuevaPersona.getNombres());
        assertEquals(persona.getApellidos(), nuevaPersona.getApellidos());
    }

    /**
     * Test of delete method, of class PersonaServices.
     */
    @Test
    public void testDelete() {
        List<Persona> lstPersonaInicial = personaServices.get();
        personaServices.delete(4L);
        List<Persona> lstPersonaActual = personaServices.get();
        assertNotNull(lstPersonaActual);
        assertEquals(lstPersonaInicial.size(), 6);
        assertEquals(lstPersonaActual.size(), 5);
    }

    /**
     * Test of getPersona method, of class PersonaServices.
     */
    @Test
    public void testGetPersona() {
        persona = personaServices.getPersona(1L);
        assertNotNull(persona);
    }
    
    
    private Persona setData() {
        Persona personaFunc = new Persona();
        
        personaFunc.setNombres("Dan");
        personaFunc.setApellidos("Brown");
        personaFunc.setCedula("1234");
        personaFunc.setGenero("M");
        personaFunc.setEdad(40);
        
        return personaFunc;
    }
}
