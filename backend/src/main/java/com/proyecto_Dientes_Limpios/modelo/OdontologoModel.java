package com.proyecto_Dientes_Limpios.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "odontologo")
public class OdontologoModel {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer idOdontologo;

	    @Column(name = "nombreO", length = 70, nullable = false)
	    private String nombreO;

	    @Column(name = "apellidoO", length = 70, nullable = false)
	    private String apellidoO;

	    @Column(name = "telefonoO", nullable = false)
	    private int telefonoO;

	    @Column(name = "correoO", nullable = false)
	    private String correo0;

	    @Column(name = "id_consultorio", nullable = false)
	    private int id_consultorio;

	    @Column(name = "id_especialidad", nullable = false)
	    private int id_especialidad;

		public Integer getIdOdontologo() {
			return idOdontologo;
		}

		public void setIdOdontologo(Integer idOdontologo) {
			this.idOdontologo = idOdontologo;
		}

		public String getNombreO() {
			return nombreO;
		}

		public void setNombreO(String nombreO) {
			this.nombreO = nombreO;
		}

		public String getApellidoO() {
			return apellidoO;
		}

		public void setApellidoO(String apellidoO) {
			this.apellidoO = apellidoO;
		}

		public int getTelefonoO() {
			return telefonoO;
		}

		public void setTelefonoO(int telefonoO) {
			this.telefonoO = telefonoO;
		}

		public String getCorreo0() {
			return correo0;
		}

		public void setCorreo0(String correo0) {
			this.correo0 = correo0;
		}

		public int getId_consultorio() {
			return id_consultorio;
		}

		public void setId_consultorio(int id_consultorio) {
			this.id_consultorio = id_consultorio;
		}

		public int getId_especialidad() {
			return id_especialidad;
		}

		public void setId_especialidad(int id_especialidad) {
			this.id_especialidad = id_especialidad;
		}

}
