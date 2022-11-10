package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Prestacion {
	
	protected int idReserva;
	protected String descripcion;
	protected List<Turno> turnosReservados;
	protected List<Cronograma> cronograma;
	
	public Prestacion(int idReserva, String descripcion) {
		this.idReserva = idReserva;
		this.descripcion = descripcion;
		this.turnosReservados = new ArrayList<Turno>();
		this.cronograma = new ArrayList<Cronograma>();
	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Turno> getTurnosReservados() {
		return turnosReservados;
	}

	public void setTurnosReservados(List<Turno> turnosReservados) {
		this.turnosReservados = turnosReservados;
	}

	public List<Cronograma> getCronograma() {
		return cronograma;
	}

	public void setCronograma(List<Cronograma> cronograma) {
		this.cronograma = cronograma;
	}

	@Override
	public String toString() {
		return "Prestacion [idReserva=" + idReserva + ", descripcion=" + descripcion + ", turnosReservados="
				+ turnosReservados + ", cronograma=" + cronograma + "]\n";
	}
	//traer turno por id
	public Turno traerTurno(int idTurno) {
		Turno aux = null;
		int i=0;
		while (aux==null && i<turnosReservados.size()) {
			if(turnosReservados.get(i).getIdTurno()==idTurno) {
				aux=turnosReservados.get(i);
			}i++;
		}
		return aux;
	}
	//traer turno por fecha y horario
	public Turno traerTurno(LocalDate fecha, Horario horario) {
		Turno aux = null;
		int i=0;
		while (aux==null && i<turnosReservados.size()) {
			if(turnosReservados.get(i).getFecha().equals(fecha) && turnosReservados.get(i).getHorario().equals(horario)) {
				aux=turnosReservados.get(i);
			}i++;
		}
		return aux;
	}
	//agregar turno con fecha y horario
	public boolean agregarTurno(LocalDate fecha, Horario horario) throws Exception {
		if (traerTurno(fecha, horario)!=null) throw new Exception("ERROR: El turno ya está reservado");//si el turno YA existe en ese horario
		int maxId=0; if(!turnosReservados.isEmpty()) maxId=turnosReservados.get(turnosReservados.size()-1).getIdTurno()+1;//max Id
		return turnosReservados.add(new Turno(maxId, fecha, horario));//agrego el turno nuevo
	}
	//eliminar turno por id
	public boolean eliminarTurno(int idTurno) throws Exception {
		if (traerTurno(idTurno)==null) throw new Exception("ERROR: El turno no está en reserva");//si el turno NO existe
		return turnosReservados.remove(traerTurno(idTurno));
	}
	//eliminar turno por fecha y horario
	public boolean eliminarTurno(LocalDate fecha, Horario horario) throws Exception {
		if (traerTurno(fecha, horario)==null) throw new Exception("ERROR: El turno no está en reserva");//si el turno NO existe
		return turnosReservados.remove(traerTurno(fecha, horario));
	}
	//traer cronograma por dia (LUNES, MARTES, ETC)
	public Cronograma traerCronograma(int dia) {
		Cronograma aux=null; 
		int i=0;
		while (aux==null && i<cronograma.size()) {
			if(cronograma.get(i).getDia()==dia) {//si el dia especificado es igual al dia en la posicion i
				aux=cronograma.get(i);
			}i++;
		}
		return aux;
	}
	//agregar horario a un dia del cronograma (SI NO EXISTE EL DIA EN EL CRONOGRAMA, SE CREA)
	public boolean agregarAlCronograma(int dia, Horario horario) throws Exception {
		if(traerCronograma(dia)==null) cronograma.add(new Cronograma(dia));//si el dia no esta en el cronograma, se agrega
		if(traerCronograma(dia).traerHorario(horario.getInicio(), horario.getFin()) !=null) {
			throw new Exception("ERROR: El horario ya se encuentra en el cronograma");//si el horario especificado ya se encuentra en el DIA del cronograma
		}
		return traerCronograma(dia).agregarHorario(horario); //se agrega
	}
	//eliminar horario de un dia del cronograma (SI ERA EL UNICO HORARIO SE BORRA EL DIA DEL CRONOGRAMA)
	public boolean eliminarDelCronograma(int dia, Horario horario) throws Exception {
		if(traerCronograma(dia)==null) throw new Exception("ERROR: El dia especificado no existe en el cronograma");//si el dia no está en el cronograma
		traerCronograma(dia).eliminarHorario(horario);//borra el horario del dia especificado
		if(traerCronograma(dia).getHorarios().isEmpty()) cronograma.remove(traerCronograma(dia)); //se borra el dia de la lista de cronograma
		return true;
	}
}
