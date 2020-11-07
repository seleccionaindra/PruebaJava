package api.rest.indra.exceptions;

/**
 * Clase para el mapeo error usuario no autorizados
 * @author Kaleth Bahena
 * @version 0.0.1 2020/11/06
 * @since 0.0.1 2020/11/06
 */
public class UnauthorizedException extends RuntimeException
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    public UnauthorizedException(String detail)
    {
        super(detail);
    }
    
    public UnauthorizedException(String detail, Throwable e)
    {
        super(detail, e);
    }
    
}