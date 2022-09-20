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
@Table(name= "pacienteR")
public class PacienteRModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="nombreP")
	private String nombre;
	
	@Column(name="apellidoP")
	private String apellido;
	
	@Column(name="correoP")
	private String correo;
	
	@Column(name="fecha_nacimientoP")
	private Date fecha;
	
	@Column(name="telefonoP")
	private String telefono;
	
	@Column(name="contrasenaP")
	private String contrasena;
	
	@Column(name="iconoP")
	private int icono;
	
	@OneToMany(mappedBy = "cita")
	private List<CitaModel> citas;

	
	public PacienteRModel() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nombreP
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombreP to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellidoP
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the contrasena
	 */
	public String getContrasena() {
		return contrasena;
	}

	/**
	 * @param contrasena the contrasena to set
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	/**
	 * @return the icono
	 */
	public int getIcono() {
		return icono;
	}

	/**
	 * @param icono the icono to set
	 */
	public void setIcono(int icono) {
		this.icono = icono;
	}

	/**
	 * @return the citas
	 */
	public List<CitaModel> getCitas() {
		return citas;
	}

	/**
	 * @param citas the citas to set
	 */
	public void setCitas(List<CitaModel> citas) {
		this.citas = citas;
	}
	
}
