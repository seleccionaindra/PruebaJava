package api.rest.indra.rest;

import api.rest.indra.entities.Persona;
import api.rest.indra.services.ICrudService;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "crud")
public class ApiCrud {

    private Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ICrudService taskService;

    @GetMapping(value = "obtenerPersonas")
    public List<Persona> getPersonas() {
        return taskService.getPersona();
    }

    @PostMapping(value = "add")
    public Persona addTask(@RequestBody Persona persona) {
        return taskService.addPersona(persona);
    }

    @PutMapping(value = "update")
    public Persona updateTask(@RequestBody Persona persona) {
        return taskService.updatePersona(persona);
    }

    @DeleteMapping(value = "delete/{id}")
    public boolean deleteTask(@PathVariable(value = "id") String id) {
        taskService.removePersona(id);
        return true;
    }

}
