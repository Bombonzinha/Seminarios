package modelo;

import java.time.LocalDate;

public class Socio extends Persona{

	private String carnet;

	public Socio(long dni, String nombre, String apellido, LocalDate fechaNac, String carnet) {
		super(dni, nombre, apellido, fechaNac);
		this.carnet = carnet;
	}

	public String getCarnet() {
		return carnet;
	}

	public void setCarnet(String carnet) {
		this.carnet = carnet;
	}

	@Override
	public String toString() {
		return super.toString() + "Socio [carnet=" + carnet + "]\n";
	}
	
	
}
