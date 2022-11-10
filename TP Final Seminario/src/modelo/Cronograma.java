package modelo;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Cronograma {
	private int dia;
	private List<Horario> horarios;
	
	public Cronograma(int dia) {
		this.dia = dia;
		this.horarios = new ArrayList<Horario>();
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public List<Horario> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}

	@Override
	public String toString() {
		return "Cronograma [dia=" + dia + ", horarios=" + horarios + "]\n";
	}
	//traer horario por hora inicio y hora fin
	public Horario traerHorario(LocalTime inicio, LocalTime fin) {
		int i=0;
		Horario aux = null;
		while (aux==null && i<horarios.size()) {
			if(horarios.get(i).getInicio().equals(inicio) && horarios.get(i).getFin().equals(fin)) {
				aux=horarios.get(i);//si las horas especificadas son iguales a las del horario en la posicion i
			}i++;
		}
		return aux;
	}
	//traer horario por Horario COMO OBJETO
	public Horario traerHorario(Horario horario) {
		int i=0;
		Horario aux = null;
		while (aux==null && i<horarios.size()) {
			if(horarios.get(i).equals(horario)) {
				aux=horarios.get(i);
			}i++;
		}
		return aux;
	}
	//agrega horario por hora inicio y hora fin
	public boolean agregarHorario(LocalTime inicio, LocalTime fin) throws Exception {
		if (traerHorario(inicio, fin) != null) throw new Exception("ERROR: Ese horario ya se encuentra en el cronograma");//si el horario ya existe en el dia del cronograma	
		return horarios.add(new Horario(inicio, fin));
	}
	//agrera horario por HORARIO COMO OBJETO
	public boolean agregarHorario(Horario horario) throws Exception {
		if (traerHorario(horario) != null) throw new Exception("ERROR: Ese horario ya se encuentra en el cronograma");//si el horario ya existe en el dia del cronograma	
		return horarios.add(horario);
	}
	//eliminar horario por hora inicio y hora fin
	public boolean eliminarHorario(LocalTime inicio, LocalTime fin) throws Exception {
		Horario aux=traerHorario(inicio, fin);//creo horario auxiliar para no repetir el método dos veces
		if (aux == null) throw new Exception("ERROR: Ese horario no se encuentra en el cronograma");//si el horario no existe no puede eliminar nada		
		return horarios.remove(aux);//elimina
	}
	//eliminar horario por HORARIO COMO OBJETO
	public boolean eliminarHorario(Horario horario) throws Exception {
		Horario aux=traerHorario(horario);//creo horario auxiliar para no repetir el método dos veces
		if (aux == null) throw new Exception("ERROR: Ese horario no se encuentra en el cronograma");		
		return horarios.remove(aux);
	}
	
}
