package modelo;

import java.time.LocalDate;

public class Profesor extends Persona{
	
	private String legajo;

	public Profesor(long dni, String nombre, String apellido, LocalDate fechaNac, String legajo) {
		super(dni, nombre, apellido, fechaNac);
		this.legajo = legajo;
	}

	public String getLegajo() {
		return legajo;
	}

	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}

	@Override
	public String toString() {
		return super.toString() + "Profesor [legajo=" + legajo + "]\n";
	}
	
	
}
