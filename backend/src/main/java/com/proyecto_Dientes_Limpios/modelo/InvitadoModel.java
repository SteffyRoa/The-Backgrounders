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
@Table (name = "invitado")
public class InvitadoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@Column(name="nombreI")
	private String nombre;
	
	@Column(name="apellidoI")
	private String apellido;
	
	@Column(name="correoI")
	private String correo;
	
	@Column(name="fecha_nacimientoI")
	private Date fecha;
	
	@Column(name="telefonoI")
	private String telefono;
	
	@OneToMany(mappedBy = "invitado")
	private List<CitaModel> citas;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<CitaModel> getCitas() {
		return citas;
	}

	public void setCitas(List<CitaModel> citas) {
		this.citas = citas;
	}
}
