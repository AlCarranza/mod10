package mx.com.medmex.MedMex;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Model;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.ValidatorException;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.mail.MessagingException;
import jakarta.mail.Part;

@Model
public class PacienteBean implements Serializable {

	private static final long serialVersionUID = 5443351151396868724L;
	
	@Inject
	private PacientesListBean pacientesListBean;
	
	@Inject
	private Mensajes mensaje;
	
	private String nombre;
	private String apelPaterno;
	private String apelMaterno;
	private String telefono;
	private String correo;
	private String direccion;
	private int cp;
	private String padecimiento;
	private String status;
	private String response;
	private Part file;
	private String fileContent;
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApelPaterno() {
		return apelPaterno;
	}

	public void setApelPaterno(String apelPaterno) {
		this.apelPaterno = apelPaterno;
	}

	public String getApelMaterno() {
		return apelMaterno;
	}

	public void setApelMaterno(String apelMaterno) {
		this.apelMaterno = apelMaterno;
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

	public String getPadecimiento() {
		return padecimiento;
	}

	public void setPadecimiento(String padecimiento) {
		this.padecimiento = padecimiento;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}
	
	
	public String getFileContent() {
		return fileContent;
	}

	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}
	
	/*<!-- <h2>Historia Medica</h2>
	<h:inputFile id="file" value="#{pacienteBean.file}"
		validator="#{pacienteBean.validateFile}" />
	<h:commandButton value="Upload" action="#{pacienteBean.upload}">
		<f:ajax execute="file" render="@all" />
	</h:commandButton>
	<h:inputTextarea value="#{pacienteBean.fileContent}" readonly="true" /> -->*/
	/*Esto va en registroPaciente pero me generó error al dejarlo comentado en el xhtml*/

	public void validateFile(FacesContext ctx,
        UIComponent comp,
        Object value) throws MessagingException {
		List<FacesMessage> msgs = new ArrayList<FacesMessage>();
		Part file = (Part)value;
		if (file.getSize() > 1024) {
		msgs.add(new FacesMessage("file too big"));
		}
		if (!"text/plain".equals(file.getContentType())) {
		msgs.add(new FacesMessage("not a text file"));
		}
		if (!msgs.isEmpty()) {
		throw new ValidatorException(msgs);
		}
}

	public void upload() {
	    try {
	      try {
			fileContent = new Scanner(file.getInputStream())
			      .useDelimiter("\\A").next();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    } catch (IOException e) {
	      // Error handling
	    }
	  }

	public String registrar() {
		System.out.println("guardando nombre: " + nombre);
		System.out.println("guardando telefono: " + telefono);
		System.out.println("guardando correo: " + correo);
		
		response = "El paciente " + nombre + " " + apelPaterno + " ha quedado registrado";
		PacienteModel model = new PacienteModel();
		model.setNombre(nombre);
		model.setApelPaterno(apelPaterno);
		model.setApelMaterno(apelMaterno);
		model.setTelefono(telefono);
		model.setCorreo(correo);
		model.setDireccion(direccion);
		model.setCp(cp);
		model.setPadecimiento(padecimiento);
		model.setStatus(status);
		pacientesListBean.agregar(model);
		
		for(PacienteModel paciente: pacientesListBean.getPacientes()) {
			System.out.println(paciente);
		}
		mensaje.setMensajes(response);
		
		return "index";
	}	
}
