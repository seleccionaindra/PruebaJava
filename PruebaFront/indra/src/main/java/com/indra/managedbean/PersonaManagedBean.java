package com.indra.managedbean;

import com.indra.api.IApiClientRX;
import com.indra.model.Persona;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Named
public class PersonaManagedBean {

    private List<Persona> personas;
    private Persona persona = new Persona();

    @Autowired
    public IApiClientRX apiClient;

    @PostConstruct
    public void init() {
        this.personas = apiClient.getPersona();
    }

    public void delete(Persona persona) {
        apiClient.removePersona(persona.getCedula());
        personas.remove(persona);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Eliminado correctamente"));
    }

    public void add() {
        apiClient.addPersona(persona);
        this.personas = (List<Persona>) apiClient.getPersona();
        this.persona = new Persona();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Añadido correctamente"));
    }

    public void update(Persona persona) {
        apiClient.updatePersona(persona);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Actualizado correctamente"));
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
