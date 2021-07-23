package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="clientes")
public class Cliente {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cedula;
	@Column
	private String nombres;
	@Column
	private String apellidos;
	@Column
	private String direccion;
	@Column
	private long telefono;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRegistro;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaActualizacion;

	public long getCedula() {
		return cedula;
	}

	public void setCedula(long cedula) {
		this.cedula = cedula;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	@Override
	public String toString() {
		return "Cliente [cedula=" + cedula + ", nombres=" + nombres + ", apellidos=" + apellidos + ", direccion="
				+ direccion + ", telefono=" + telefono + ", fechaRegistro=" + fechaRegistro + ", fechaActualizacion="
				+ fechaActualizacion + "]";
	}

}
