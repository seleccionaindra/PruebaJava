package api.rest.indra.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import api.rest.indra.model.Persona;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestPersonaService {

	@Autowired
	private PersonaService personaService;
	
	@Test
	public void contextLoads() {
		assertNotNull(personaService);
	}

	@Test
	public void testAll() {
		List<Persona> personas = personaService.getPersonas();
		assertEquals(personas.size(), 5);
	}


	@Test
	public void testSave() {
		Persona persona = new Persona();
		persona.setNombres("Nora Rocio");
		persona.setApellidos("Echeverry Castaño");
		persona.setCedula("1116443279");
		persona.setGenero("F");
		persona.setEdad(26);
        Persona newPerson = personaService.createPersona(persona);
        assertSame(newPerson.getId(), 7L);
	}

	@Test
	public void testGet() {
		Persona persona = personaService.getPersona(5L);
		assertEquals(persona.getNombres(), "Erich");
	}

	@Test
	public void testUpdate() {
		Persona persona = personaService.getPersona(2L);
		persona.setNombres("Pedro Pablo");
        Persona personUpdated = personaService.updatePersona(persona, 2L);
        assertEquals(personUpdated.getNombres(), "Pedro Pablo");
        assertEquals(personUpdated.getApellidos(), "Doe");
	}

	@Test
	public void testRemove() {
		personaService.removePersona(1L);
		List<Persona> personas = personaService.getPersonas();
		System.out.println("personas.size() "+ personas.size());
		assertEquals(personas.size(), 5);
		
	}

}
