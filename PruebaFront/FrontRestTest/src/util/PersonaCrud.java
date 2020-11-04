package util;

public class PersonaCrud {
	public String crear(String nombres, String apellidos, String cedula, String genero, int edad) {
		return "se ha creado la persona";
	}
	
	public String consultar(Long id) {
		return "bien";
	}
	
	public String modificar(Long id, String nombres, String apellidos, String cedula, String genero, int edad) {
		return "bien";
	}
	
	public String borrar(Long id) {
		return "bien";
	}
	
	private String htmlRequest (String json) {
		String resp = "";
		return resp;
	}
}
