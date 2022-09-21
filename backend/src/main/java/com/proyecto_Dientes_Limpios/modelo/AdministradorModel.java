package com.proyecto_Dientes_Limpios.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

	
	@Entity
	@Table(name = "administrador")
	public class AdministradorModel {
		
			@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;

		@Column(name = "nombreA")
		private String nombreA;

		@Column(name = "apellidoA")
		private String apellidoA;
		
		@Column(name = "contrasenaA")
		private String contrasenaA;

		@Column(name = "id_comentario")
		private int id_comentario;
		
		@Column(name = "id_empleado")
		private int id_empleado;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getNombreA() {
			return nombreA;
		}

		public void setNombreA(String nombreA) {
			this.nombreA = nombreA;
		}

		public String getApellidoA() {
			return apellidoA;
		}

		public void setApellidoA(String apellidoA) {
			this.apellidoA = apellidoA;
		}

		public String getContrasenaA() {
			return contrasenaA;
		}

		public void setContrasenaA(String contrasenaA) {
			this.contrasenaA = contrasenaA;
		}

		public int getId_comentario() {
			return id_comentario;
		}

		public void setId_comentario(int id_comentario) {
			this.id_comentario = id_comentario;
		}

		public int getId_empleado() {
			return id_empleado;
		}

		public void setId_empleado(int id_empleado) {
			this.id_empleado = id_empleado;
		}

		public AdministradorModel(int id, String nombreA, String apellidoA, String contrasenaA, int id_comentario,
				int id_empleado) {
			super();
			this.id = id;
			this.nombreA = nombreA;
			this.apellidoA = apellidoA;
			this.contrasenaA = contrasenaA;
			this.id_comentario = id_comentario;
			this.id_empleado = id_empleado;
		}

		public AdministradorModel() {
			super();
		}

	}



