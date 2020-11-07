package api.rest.indra.exceptions;

/**
 * Clase que mapea el tipo error 204
 * @author Kaleth Bahena
 * @version 0.0.1 2020/11/06
 * @since 0.0.1 2020/11/06
 */
public class DataNotFoundException extends RuntimeException
{
    /** Default serial */
    private static final long serialVersionUID = 1L;
    
    public DataNotFoundException(String detail)
    {
        super(detail);
    }
    
    public DataNotFoundException(String detail, Throwable e)
    {
        super(detail, e);
    }
    
}
