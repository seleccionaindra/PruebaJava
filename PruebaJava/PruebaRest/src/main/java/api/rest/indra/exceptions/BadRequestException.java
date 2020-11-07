package api.rest.indra.exceptions;

/**
 * Clase que mapea error 400
 * @author Kaleth Bahena
 * @version 0.0.1 2020/11/06
 * @since 0.0.1 2020/11/06
 */
public class BadRequestException extends RuntimeException
{
    /** Default serial */
    private static final long serialVersionUID = 1L;
    
    public BadRequestException(String detail)
    {
        super(detail);
    }
    
    public BadRequestException(String detail, Throwable e)
    {
        super(detail, e);
    }
    
}
