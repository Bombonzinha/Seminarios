package modelo;

import java.util.ArrayList;
import java.util.List;

public class Actividad extends Prestacion {
	
	private List<Profesor> lstProfesores;
	private List<Socio> lstSocios;
	
	public Actividad(int idReserva, String descripcion) {
		super(idReserva, descripcion);
		this.lstProfesores =  new ArrayList<Profesor>();
		this.lstSocios = new ArrayList<Socio>();
	}

	public List<Profesor> getLstProfesores() {
		return lstProfesores;
	}

	public void setLstProfesores(List<Profesor> lstProfesores) {
		this.lstProfesores = lstProfesores;
	}

	public List<Socio> getLstSocios() {
		return lstSocios;
	}

	public void setLstSocios(List<Socio> lstSocios) {
		this.lstSocios = lstSocios;
	}

	@Override
	public String toString() {
		return super.toString() + "Actividad [lstProfesores=" + lstProfesores + ", lstSocios=" + lstSocios + "]\n";
	}

	
}
