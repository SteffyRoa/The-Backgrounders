package com.proyecto_Dientes_Limpios.modelo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class EspecialidadModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column (name = "nombreE", nullable = false)
	private String nombre;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombreE() {
		return nombre;
	}
	public void setNombreE(String nombreE) {
		this.nombre = nombreE;
	}

}
