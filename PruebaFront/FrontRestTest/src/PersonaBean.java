import java.io.Serializable;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import util.PersonaCrud;

@Named
@RequestScoped
public class PersonaBean implements Serializable{
	
	private Long id;
	private String nombres;
	private String apellidos;
	private String cedula;
	private String genero;
	private int edad;
	private PersonaCrud srvPersona;
	private String mensajeResp;
	private FacesContext faces;

	public PersonaBean() {
		srvPersona = new PersonaCrud();
	}
	
	public void acciones() {
		faces = FacesContext.getCurrentInstance();
		Map<String, String> params = faces.getExternalContext().getRequestParameterMap();
		
		int action = Integer.parseInt( (String) params.get("action") );
		
		switch (action) {
			case 1 : mensajeResp = srvPersona.crear(nombres,apellidos,cedula,genero,edad);
			case 2 : mensajeResp = srvPersona.consultar(id);
			case 3 : mensajeResp = srvPersona.modificar(id,nombres,apellidos,cedula,genero,edad);
			case 4 : mensajeResp = srvPersona.borrar(id);
			default : mensajeResp = "Opción inválida.";
		}
	}
	
	public PersonaCrud getSrvPersona() {
		return srvPersona;
	}
	public void setSrvPersona(PersonaCrud srvPersona) {
		this.srvPersona = srvPersona;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public String getMensajeResp() {
		return mensajeResp;
	}

	public void setMensajeResp(String mensajeResp) {
		this.mensajeResp = mensajeResp;
	}
	
}
