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
	private Long id;
	@Column(name = "fechaC", nullable = false)
	private Date fechaC;
	@Column(name = "horaC", nullable = false)
	private String horaC;
	@Column(name = "servicio", columnDefinition = "varchar(15)",  nullable = false)
	private String servicio;
	@Column(name = "confirmacionC", nullable = false)
	private int confirmacionC;

	
	@ManyToOne
	@JoinColumn( name = "id_paciente")
	@JsonProperty(access = Access.WRITE_ONLY)
	private PacienteRModel cita;

	@ManyToOne 
	@JoinColumn( name = "id_invitado")
	@JsonProperty(access = Access.WRITE_ONLY) 
	private InvitadoModel invitado;



	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getFechaC() {
		return fechaC;
	}


	public void setFechaC(Date fechaC) {
		this.fechaC = fechaC;
	}


	public String getHoraC() {
		return horaC;
	}


	public void setHoraC(String horaC) {
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


	public PacienteRModel getCita() {
		return cita;
	}


	public void setCita(PacienteRModel cita) {
		this.cita = cita;
	}


	public InvitadoModel getInvitado() {
		return invitado;
	}


	public void setInvitado(InvitadoModel invitado) {
		this.invitado = invitado;
	}
	
	
	
	
}
