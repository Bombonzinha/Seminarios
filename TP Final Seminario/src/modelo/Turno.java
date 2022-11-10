package modelo;

import java.time.LocalDate;

public class Turno {
	
	private int idTurno;
	private LocalDate fecha;
	private Horario horario;
	
	public Turno(int idTurno, LocalDate fecha, Horario horario) {
		this.idTurno = idTurno;
		this.fecha = fecha;
		this.horario = horario;
	}

	public int getIdTurno() {
		return idTurno;
	}

	public void setIdTurno(int idTurno) {
		this.idTurno = idTurno;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	@Override
	public String toString() {
		return "Turno [idTurno=" + idTurno + ", fecha=" + fecha + ", horario=" + horario + "]\n";
	}
	
	
}
