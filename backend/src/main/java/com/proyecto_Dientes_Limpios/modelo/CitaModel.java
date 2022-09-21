package com.proyecto_Dientes_Limpios.modelo;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "cita")
public class CitaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "id_paciente")
	@JsonProperty(access = Access.WRITE_ONLY)
	private PacienteRModel cita;

	@Column(name = "fechaC", nullable = false)
	private int fechaC;

	@Column(name = "horaC", nullable = false)
	private int horaC;


	@Column(name = "id_odontologo", nullable = false)
	private int id_odontologo;

	@Column(name = "servicio", nullable = false)
	private String servicio;

	@Column(name = "confirmacionC", nullable = false)
	private boolean confirmacionC;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFechaC() {
		return fechaC;
	}

	public void setFechaC(int fechaC) {
		this.fechaC = fechaC;
	}

	public int getHoraC() {
		return horaC;
	}

	public void setHoraC(int horaC) {
		this.horaC = horaC;
	}

	
	public int getId_odontologo() {
		return id_odontologo;
	}

	public void setId_odontologo(int id_odontologo) {
		this.id_odontologo = id_odontologo;
	}

	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	public boolean isConfirmacionC() {
		return confirmacionC;
	}

	public void setConfirmacionC(boolean confirmacionC) {
		this.confirmacionC = confirmacionC;
	}

	public CitaModel() {
		super();
	}

	public CitaModel(int id, PacienteRModel cita, int fechaC, int horaC, int id_paciente, int id_odontologo,
			String servicio, boolean confirmacionC) {
		super();
		this.id = id;
		this.fechaC = fechaC;
		this.horaC = horaC;
		this.id_odontologo = id_odontologo;
		this.servicio = servicio;
		this.confirmacionC = confirmacionC;
	}

	
}
