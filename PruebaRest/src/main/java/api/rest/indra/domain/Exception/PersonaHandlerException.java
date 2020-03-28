package api.rest.indra.domain.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class PersonaHandlerException {
    
    @ResponseBody
    @ExceptionHandler(PersonaException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String ResponseErrorhandler(PersonaException personaException) {
        return personaException.getMessage();
    }
    
}
