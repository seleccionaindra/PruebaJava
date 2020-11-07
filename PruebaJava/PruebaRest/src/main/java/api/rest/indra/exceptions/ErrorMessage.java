package api.rest.indra.exceptions;

/**
 * Clase encargada de mapear los datos de los errores del api
 * @author Kaleth Bahena
 * @version 0.0.1 2020/11/06
 * @since 0.0.1 2020/11/06
 */
public class ErrorMessage {

    private final String error;

    private final String message;

    private final String path;

    public ErrorMessage(Exception exception, String path) {
        this.error = exception.getClass().getSimpleName();
        this.message = exception.getMessage();
        this.path = path;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        return "ErrorMessage [error=" + error + ", message=" + message + ", path=" + path + "]";
    }

}
