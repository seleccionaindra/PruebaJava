package api.rest.indra.rest;

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
public class TestPersonaResource {

	@Autowired
	private PersonaResource personaResource;
	
	@Test
	public void contextLoads() {
		assertNotNull(personaResource);
	}

	@Test
	public void testAll() {
		List<Persona> personas = personaResource.all();
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
        Persona newPerson = personaResource.save(persona);
        assertSame(newPerson.getId(), 6L);
	}

	@Test
	public void testGet() {
		Persona persona = personaResource.get(5L);
		assertEquals(persona.getNombres(), "Erich");
	}

	@Test
	public void testUpdate() {
		Persona persona = personaResource.get(2L);
		persona.setNombres("Pedro Pablo");
        Persona personUpdated = personaResource.update(persona, 2L);
        assertEquals(personUpdated.getNombres(), "Pedro Pablo");
        assertEquals(personUpdated.getApellidos(), "Doe");
	}

	@Test
	public void testRemove() {
		personaResource.remove(3L);
		List<Persona> personas = personaResource.all();
		System.out.println("personas.size() "+ personas.size());
		assertEquals(personas.size(), 5);
		
	}

}
