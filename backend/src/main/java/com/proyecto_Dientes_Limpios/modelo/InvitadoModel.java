package com.proyecto_Dientes_Limpios.modelo;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table

public class InvitadoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "nombreI", nullable = false)
	private String nombre;
	@Column(name = "apellidoI", nullable = false)
	private String apellido;
	@Column(name = "correoI", nullable = false)
	private String  correo;
	@Column(name = "fecha_nacimientoI", nullable = false)
	private Date fecha_nacimiento;
	@Column(name = "telefonoI", nullable = false)
	private String telefono;
	
	
	
	
	@OneToMany(mappedBy = "invitado")
	private List<CitaModel> citas;

}
