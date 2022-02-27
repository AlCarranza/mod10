package mx.com.medmex.MedMex;

import java.io.Serializable;

import jakarta.enterprise.inject.Model;
import jakarta.inject.Inject;

@Model
public class ConsultorioBean implements Serializable {

	private static final long serialVersionUID = 5443351151396868724L;
    
	@Inject
	private ConsultoriosListBean consultoriosListBean;
	
	@Inject
	private Mensajes mensaje;
	
	private String nombre;
	private String telefono;
	private String correo;
	private String direccion;
	private int cp;
	private String status;
	private String response; 
	
	public Mensajes getMensaje() {
		return mensaje;
	}
	public void setMensaje(Mensajes mensaje) {
		this.mensaje = mensaje;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String registrar() {
		System.out.println("guardando nombre: " + nombre);
		System.out.println("guardando telefono: " + telefono);
		System.out.println("guardando correo: " + correo);
		
		response = "El consultorio " + nombre + " ha quedado registrado";
		
		ConsultorioModel model = new ConsultorioModel();
		model.setNombre(nombre);
		model.setTelefono(telefono);
		model.setCorreo(correo);
		model.setDireccion(direccion);
		model.setCp(cp);
		model.setStatus(status);
		consultoriosListBean.agregar(model);
		
		for(ConsultorioModel consultorio: consultoriosListBean.getConsultorios()) {
			System.out.println(consultorio);
		}
		
		mensaje.setMensajes(response);
		
		return "index";
	}	
	
}
