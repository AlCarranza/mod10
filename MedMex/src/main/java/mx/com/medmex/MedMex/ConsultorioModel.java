package mx.com.medmex.MedMex;

import java.io.Serializable;

import jakarta.enterprise.inject.Model;
import jakarta.inject.Inject;

@Model
public class ConsultorioModel implements Serializable {

	private static final long serialVersionUID = 5443351151396868724L;
	
	private String nombre;
	private String telefono;
	private String correo;
	private String direccion;
	private int cp;
	private String status;
	private String response;
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
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	@Override
	public String toString() {
		return "ConsultorioModel [nombre=" + nombre + ", telefono=" + telefono + ", correo=" + correo + ", direccion="
				+ direccion + ", cp=" + cp + ", status=" + status + ", response=" + response + "]";
	} 	
}
