package api.rest.indra.application;

import java.time.LocalDate;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import api.rest.indra.exceptions.BadRequestException;
import api.rest.indra.exceptions.ConflictException;
import api.rest.indra.exceptions.DataNotFoundException;
import api.rest.indra.exceptions.dto.ErrorMessageDto;
import lombok.extern.slf4j.Slf4j;

/**
 * Clase que mapea los errores para el controlador {@link PersonaRestService}
 * @author Kaleth Bahena
 * @version 0.0.1 2020/11/06
 * @since 0.0.1 2020/11/06
 */
@Slf4j
@RequestMapping(produces = "application/vnd.error+json")
@RestControllerAdvice(assignableTypes = PersonaRestService.class)
public class PersonaRestAdviceService
{
 
 private static final String ERROR_ADVICE_EXCEPTION_FORMAT = "Error Advicer - {0} - Exception type: {1}";
    
    /**
     * Error data corrupted persistence exception handler response entity.
     * @param conlictException the data corrupted persistence exception
     * @return the response entity
     */
    @ExceptionHandler(value = { ConflictException.class })
    public ResponseEntity<ErrorMessageDto> errorDataCorruptedExceptionHandler(final ConflictException conlictException)
    {
        log.info(ERROR_ADVICE_EXCEPTION_FORMAT, PersonaRestService.class, conlictException.getClass());
        
        ErrorMessageDto error = ErrorMessageDto.builder().message(conlictException.getMessage()).description(conlictException.getMessage()).statusCode(HttpStatus.CONFLICT.value())
                .timestamp(LocalDate.now()).build();
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }
    
    /**
     * Error data not found persistence exception handler response entity.
     * @param dataNotFoundPersistenceException the data not found persistence exception
     * @return the response entity
     */
    @ExceptionHandler(value = { DataNotFoundException.class })
    public ResponseEntity<ErrorMessageDto> errorDataNotFoundExceptionHandler(final DataNotFoundException dataNotFoundException)
    {
        log.info(ERROR_ADVICE_EXCEPTION_FORMAT, PersonaRestService.class, dataNotFoundException.getClass());
        ErrorMessageDto error = ErrorMessageDto.builder().message(dataNotFoundException.getMessage()).description(dataNotFoundException.getMessage()).statusCode(HttpStatus.NO_CONTENT.value())
                .timestamp(LocalDate.now()).build();
        return new ResponseEntity<>(error, HttpStatus.NO_CONTENT);
    }
    
    /**
     * Error data corrupted service exception handler response entity.
     * @param dataCorruptedServiceException the data corrupted service exception
     * @return the response entity
     */
    @ExceptionHandler(value = { BadRequestException.class })
    public ResponseEntity<ErrorMessageDto> errorDataCorruptedServiceExceptionHandler(final BadRequestException dataBadRequestException)
    {
        log.info(ERROR_ADVICE_EXCEPTION_FORMAT, PersonaRestService.class, dataBadRequestException.getClass());
        ErrorMessageDto error = ErrorMessageDto.builder().message(dataBadRequestException.getMessage()).description(dataBadRequestException.getMessage()).statusCode(HttpStatus.NO_CONTENT.value())
                .timestamp(LocalDate.now()).build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    
    
    /**
     * Error data corrupted service exception handler response entity.
     * @param dataCorruptedServiceException the data corrupted service exception
     * @return the response entity
     */
    @ExceptionHandler(value = { MethodArgumentNotValidException.class })
    public ResponseEntity<ErrorMessageDto> errorMethodArgumentNotValidException(final MethodArgumentNotValidException  dataBadRequestException)
    {
        log.info(ERROR_ADVICE_EXCEPTION_FORMAT, PersonaRestService.class, dataBadRequestException.getClass());
        BindingResult result = dataBadRequestException.getBindingResult();
        
        String fieldErrors = result.getFieldErrors().stream().map(e -> String.format("Campo: %s,  Mensaje: %s", e.getField(), e.getDefaultMessage())).collect(Collectors.joining(","));
        
        
        ErrorMessageDto error = ErrorMessageDto.builder().message(fieldErrors).description("Error en validación de parametros").statusCode(HttpStatus.NO_CONTENT.value())
                .timestamp(LocalDate.now()).build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
