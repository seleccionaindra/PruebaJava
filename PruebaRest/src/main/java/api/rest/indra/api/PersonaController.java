package api.rest.indra.api;

import api.rest.indra.domain.Exception.PersonaException;
import api.rest.indra.domain.Persona;
import api.rest.indra.services.IPersonaServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController implements IPersonaController{
    
    @Autowired
    private IPersonaServices personaService;
    
    @GetMapping("/get")
    public List<Persona> get() {
        return personaService.get();
    }

    @Override
    @PostMapping("/create")
    public Persona create(@RequestBody Persona persona) {
        return personaService.create(persona);
    }

    @Override
    @PutMapping("/update")
    public Persona update(@RequestBody Persona persona) {
        return personaService.update(persona);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        personaService.delete(id);
    }

    @Override
    @GetMapping("/get/{id}")
    public Persona getPersona(@PathVariable Long id) {
        return personaService.getPersona(id);
    }
}
