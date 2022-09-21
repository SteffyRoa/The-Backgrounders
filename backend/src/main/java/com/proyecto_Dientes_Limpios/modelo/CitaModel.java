package com.proyecto_Dientes_Limpios.modelo;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.*;



import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name= "cita")
public class CitaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "fechaC", nullable = false)
	private Date fechaC;
	@Column(name = "horaC", nullable = false)
	private Time horaC;
	@Column(name = "servicio", columnDefinition = "varchar(15)",  nullable = false)
	private String servicio;
	@Column(name = "confirmacionC", nullable = false)
	private int confirmacionC;

	
	@ManyToOne
	@JoinColumn( name = "id_paciente")
	@JsonProperty(access = Access.WRITE_ONLY)
	private PacienteRModel cita;
	
	/*@ManyToOne
	@JoinColumn( name = "id_invitado")
	@JsonProperty(access = Access.WRITE_ONLY)
	private InvitadoModel invitado;
	
	@ManyToOne
	@JoinColumn( name = "id_odontologo")
	@JsonProperty(access = Access.WRITE_ONLY)
	private OdontologoModel odontologos;*/
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaC() {
		return fechaC;
	}

	public void setFechaC(Date fechaC) {
		this.fechaC = fechaC;
	}

	public Time getHoraC() {
		return horaC;
	}

	public void setHoraC(Time horaC) {
		this.horaC = horaC;
	}

	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	public int getConfirmacionC() {
		return confirmacionC;
	}

	public void setConfirmacionC(int confirmacionC) {
		this.confirmacionC = confirmacionC;
	}

	/**
	 * @param cita 
	 * @param cita the cita to set
	 */
	public void setCita(PacienteRModel citaP, PacienteRModel cita) {
		this.cita = cita;
	}
	
	/**
	 * @return the cita
	 */
	public PacienteRModel getCita() {
		return cita;
	}
	
}
