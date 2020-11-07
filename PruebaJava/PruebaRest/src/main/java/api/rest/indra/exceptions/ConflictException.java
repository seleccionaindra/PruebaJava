package api.rest.indra.exceptions;

/**
 * Clase que mapea error 409
 * @author Kaleth Bahena
 * @version 0.0.1 2020/11/06
 * @since 0.0.1 2020/11/06
 */
public class ConflictException extends RuntimeException {
    
    /** Default serial*/
    private static final long serialVersionUID = 1L;

    public ConflictException(String detail) {
        super(detail);
    }

}