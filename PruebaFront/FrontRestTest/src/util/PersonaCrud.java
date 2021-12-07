package util;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dto.PersonaDTO;

public class PersonaCrud {
	public String crear(String nombres, String apellidos, String cedula, String genero, int edad) throws JsonProcessingException {
		String request = null;
		PersonaDTO persona = new PersonaDTO();
		persona.setNombres(nombres);
		persona.setApellidos(apellidos);
		persona.setCedula(cedula);
		persona.setGenero(genero);
		persona.setEdad(Integer.toString(edad));

		ObjectMapper mapper = new ObjectMapper();
	    request = mapper.writeValueAsString(persona);
		
		return htmlRequest(request,"POST","/crear");
	}
	
	public String consultar(Long id) {
		String request = null;
		return htmlRequest(request,"GET","/consultar/"+id);
	}
	
	public String modificar(Long id, String nombres, String apellidos, String cedula, String genero, int edad) throws JsonProcessingException {
		String request = null;
		PersonaDTO persona = new PersonaDTO();
		persona.setNombres(nombres);
		persona.setApellidos(apellidos);
		persona.setCedula(cedula);
		persona.setGenero(genero);
		persona.setEdad(Integer.toString(edad));
		
		ObjectMapper mapper = new ObjectMapper();
	    request = mapper.writeValueAsString(persona);
	    
		return htmlRequest(request,"POST","/actualizar/"+id);
	}
	
	public String borrar(Long id) {
		String request = null;
		return htmlRequest(request,"POST","/borrar/"+id);
	}
	
	private String htmlRequest (String json,String method,String path) {
		String resp = "";
		Client cliente = ClientBuilder.newClient();
		WebTarget webTarget = cliente.target("http://localhost:8989/svc/v1/personas");
		WebTarget personaWebTarget = webTarget.path(path);
		Invocation.Builder invocationBuilder 
		  = personaWebTarget.request(MediaType.APPLICATION_JSON);
	
		Response response; 
		
		switch(method) {
		case "GET" : response = invocationBuilder.get();
		case "POST" : response = invocationBuilder.post(Entity.entity(json, MediaType.APPLICATION_JSON));
		case "PUT" : response = invocationBuilder.put(Entity.entity(json, MediaType.APPLICATION_JSON));
		case "DELETE" : response = invocationBuilder.delete();
		default : response = invocationBuilder.get();
		}

		resp = Integer.toString(response.getStatus()) + response.getEntity().toString();
		return resp;
	}
}
