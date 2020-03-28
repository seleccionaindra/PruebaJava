package api.rest.indra.exception;
public class PersonaNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PersonaNotFoundException(Long id) {
		super("No se pudo encontrar persona: " + id);
	}
}