package mx.com.medmex.MedMex;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.SessionScoped;
import jakarta.enterprise.inject.Model;
import jakarta.inject.Named;

@Named
@SessionScoped
public class PacientesListBean implements Serializable {

	private static final long serialVersionUID = 5443351151396868724L;
	
	private List<PacienteModel> pacientes;
	
	public PacientesListBean() {
		this.pacientes = new ArrayList<PacienteModel>();
	}

	public List<PacienteModel> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<PacienteModel> pacientes) {
		this.pacientes = pacientes;
	}
	
	public void agregar(PacienteModel pacienteModel) {
		pacientes.add(pacienteModel);
	}
	
}
