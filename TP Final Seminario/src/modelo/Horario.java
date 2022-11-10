package modelo;

import java.time.LocalTime;

public class Horario {
	
	private LocalTime inicio;
	private LocalTime fin;
	
	public Horario(LocalTime inicio, LocalTime fin) {
		this.inicio = inicio;
		this.fin = fin;
	}
	public LocalTime getInicio() {
		return inicio;
	}
	public void setInicio(LocalTime inicio) {
		this.inicio = inicio;
	}
	public LocalTime getFin() {
		return fin;
	}
	public void setFin(LocalTime fin) {
		this.fin = fin;
	}
	@Override
	public String toString() {
		return "Horario de " + inicio + " a " + fin + "\n";
	}

	
}
