package com.proyecto_Dientes_Limpios.modelo;

import javax.persistence.*;



import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name= "cita")
public class CitaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String servicio;	

	
	@ManyToOne
	@JoinColumn( name = "id_paciente")
	@JsonProperty(access = Access.WRITE_ONLY)
	private PacienteRModel cita;
	
	
	/**
	 * @return the idcita
	 */
	public int getIdcita() {
		return id;
	}

	/**
	 * @param idcita the idcita to set
	 */
	public void setIdcita(int idcita) {
		this.id = idcita;
	}

	/**
	 * @return the cita
	 */
	public PacienteRModel getCita() {
		return cita;
	}

	/**
	 * @param cita the cita to set
	 */
	public void setCita(PacienteRModel cita) {
		this.cita = cita;
	}

	/**
	 * @return the servicio
	 */
	public String getServicio() {
		return servicio;
	}

	/**
	 * @param servicio the servicio to set
	 */
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	
	
}
