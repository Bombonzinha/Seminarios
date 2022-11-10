package modelo;

import java.time.LocalDate;

public class Persona {
	protected long dni;
	protected String nombre;
	protected String apellido;
	protected LocalDate fechaNac;
	
	public Persona(long dni, String nombre, String apellido, LocalDate fechaNac) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNac = fechaNac;
	}
	
	public long getDni() {
		return dni;
	}
	public void setDni(long dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public LocalDate getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}
	
	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNac=" + fechaNac + "]\n";
	}

	
}
