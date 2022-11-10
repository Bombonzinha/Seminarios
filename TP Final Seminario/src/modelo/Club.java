package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Club {
	
	private String nombre;
	private List<Prestacion> lstPrestaciones;
	private List<Persona> lstPersonas;
	public Club(String nombre) {
		this.nombre = nombre;
		this.lstPrestaciones = new ArrayList<Prestacion>();
		this.lstPersonas = new ArrayList<Persona>();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Prestacion> getLstPrestaciones() {
		return lstPrestaciones;
	}
	public void setLstPrestaciones(List<Prestacion> lstPrestaciones) {
		this.lstPrestaciones = lstPrestaciones;
	}
	public List<Persona> getLstPersonas() {
		return lstPersonas;
	}
	public void setLstPersonas(List<Persona> lstPersonas) {
		this.lstPersonas = lstPersonas;
	}
	@Override
	public String toString() {
		return "Club [nombre=" + nombre + ", lstPrestaciones=" + lstPrestaciones + ", lstPersonas=" + lstPersonas + "]\n";
	}
	//traer persona por dni
	public Persona traerPersona(long dni) {
		Persona retorno = null;
		int i=0;
		while(retorno==null && i<lstPersonas.size()) {
			if(lstPersonas.get(i).getDni()==dni) {
				retorno=lstPersonas.get(i);
			}
			i++;
		}
		return retorno;
	}
	//CORREGIR traer profesor por legajo
	public Profesor traerProfesor(String legajo) {
		Profesor retorno = null;
		int i=0;
		while(retorno==null && i<lstPersonas.size()) {
			if(lstPersonas.get(i) instanceof Profesor) {
				Profesor aux = (Profesor) lstPersonas.get(i);
				if(aux.getLegajo().equals(legajo)) {
					retorno=aux;
				}
			}i++;
		}
		return retorno;
	}
	//CORREGIR traer socio por carnet
	public Socio traerSocio(String carnet) {
		Socio retorno = null;
		int i=0;
		while(retorno==null && i<lstPersonas.size()) {
			if(lstPersonas.get(i) instanceof Socio) {
				Socio aux = (Socio) lstPersonas.get(i);
				if(aux.getCarnet().equals(carnet)) {
					retorno=aux;
				}
			}i++;
		}
		return retorno;
	}
	//traer Profesores
	public List<Profesor> traerProfesores(){
		List<Profesor> lstRetorno = new ArrayList<Profesor>();
		for (int i=0;i<lstPersonas.size();i++) {
			if(lstPersonas.get(i) instanceof Profesor) {
				Profesor aux = (Profesor) lstPersonas.get(i);
				lstRetorno.add(aux);
			}
		}
		return lstRetorno;
	}
	//traer Socios
	public List<Socio> traerSocios(){
		List<Socio> lstRetorno = new ArrayList<Socio>();
		for (int i=0;i<lstPersonas.size();i++) {
			if(lstPersonas.get(i) instanceof Socio) {
				Socio aux = (Socio) lstPersonas.get(i);
				lstRetorno.add(aux);
			}
		}
		return lstRetorno;
	}
	//CORREGIR agregar profesor a la lista de PERSONAS (intentar con lista de profesores aparte)
	public boolean agregarProfesor(long dni, String nombre, String apellido, LocalDate fechaNac, String legajo) throws Exception {
		if (traerProfesor(legajo)!=null) throw new Exception("ERROR: El profesor ya se encuentra en el club");
		return lstPersonas.add(new Profesor(dni, nombre, apellido, fechaNac, legajo));
	}
	//CORREGIR agregar profesor a la lista de PERSONAS (intentar con lista de socios aparte)
	public boolean agregarSocio(long dni, String nombre, String apellido, LocalDate fechaNac, String carnet) throws Exception {
		if (traerSocio(carnet)!=null) throw new Exception("ERROR: El socio ya se encuentra en el club");
		return lstPersonas.add(new Socio(dni, nombre, apellido, fechaNac, carnet));
	}
	//CORREGIR Eliminar persona por dni SOLO VA A BORRAR LA PRIMER PERSONA QUE ENCUENTRA, OSEA QUE SI ESTA REPETIDO NO VA A BORRAR EL SEGUNDO
	public boolean eliminarPersona(long dni) throws Exception {
		if (traerPersona(dni)==null) throw new Exception("ERROR: La persona no existe");
		return lstPersonas.remove(traerPersona(dni));
	}
}
