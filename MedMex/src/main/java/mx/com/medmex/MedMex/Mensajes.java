package mx.com.medmex.MedMex;

import java.io.Serializable;

import jakarta.enterprise.inject.Model;

@Model
public class Mensajes implements Serializable {

	private static final long serialVersionUID = 5443351151396868724L;
	
	private String mensajes;

	public String getMensajes() {
		return mensajes;
	}

	public void setMensajes(String mensajes) {
		this.mensajes = mensajes;
	}
	
	
}
