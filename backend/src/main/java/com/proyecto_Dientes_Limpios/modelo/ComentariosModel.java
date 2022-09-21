package com.proyecto_Dientes_Limpios.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comentario")
public class ComentariosModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nombrep")
	private String nombreP;

	@Column(name = "texto")
	private String texto;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getnombreP() {
		return nombreP;
	}

	public String getTexto() {
		return texto;
	}
	
	public void setnombreP(String nombreP) {
		this.nombreP  = texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public ComentariosModel(String nombreP, String texto) {
		super();
		this.nombreP = nombreP;
		this.texto = texto;
	}
}
