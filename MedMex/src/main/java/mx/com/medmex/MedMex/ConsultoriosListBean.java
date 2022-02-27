package mx.com.medmex.MedMex;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.SessionScoped;
import jakarta.enterprise.inject.Model;
import jakarta.inject.Named;

@Named
@SessionScoped
public class ConsultoriosListBean implements Serializable {

	private static final long serialVersionUID = 5443351151396868724L;
	
	private List<ConsultorioModel> consultorios;
	
	public ConsultoriosListBean() {
		this.consultorios = new ArrayList<ConsultorioModel>();
	}

	public List<ConsultorioModel> getConsultorios() {
		return consultorios;
	}

	public void setConsultorios(List<ConsultorioModel> consultorios) {
		this.consultorios = consultorios;
	}
	
	public void agregar(ConsultorioModel consultorioModel) {
		consultorios.add(consultorioModel);
	}
	
}
