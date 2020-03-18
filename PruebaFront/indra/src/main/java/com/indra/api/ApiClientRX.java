/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.indra.api;

import com.indra.model.Persona;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hernan_Restrepo
 */
@Service
public class ApiClientRX implements IApiClientRX {

    private final static String URL_BASE = "http://localhost:8080/crud/";
    Client client;

    public ApiClientRX() {
        client = ClientBuilder.newClient().register(new JacksonFeature());
    }

    @Override
    public List<Persona> getPersona() {
        List<Persona> personas = client
                .target(URL_BASE).path("obtenerPersonas")
                .request(MediaType.APPLICATION_JSON).get(new GenericType<List<Persona>>() {
        });
        return personas; //(List<Persona>) personaDao.findAll();
    }

    @Override
    public void addPersona(Persona persona) {
        WebTarget webTarget = client.target(URL_BASE).path("add");

        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.post(Entity.entity(persona, MediaType.APPLICATION_JSON));
        response.getStatus();
        response.readEntity(Persona.class);
    }

    @Override
    public void removePersona(String id) {
        WebTarget webTarget = client.target(URL_BASE).path("delete").path(id);

        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.delete();
        response.getStatus();
        response.readEntity(Boolean.class);
    }

    @Override
    public void updatePersona(Persona persona) {
        WebTarget webTarget = client.target(URL_BASE).path("update");

        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.put(Entity.entity(persona, MediaType.APPLICATION_JSON));
        response.getStatus();
        response.readEntity(Persona.class);
    }
}
