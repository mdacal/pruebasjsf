package com.accesodatos.jsfjdbc.dominio;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class no_Persona implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nombre;
	private String apellidos;
	private Date fechaNacimiento;
	private String observaciones;
	
	public no_Persona() {
		super();
	}

	public no_Persona(int id, String nombre, String apellidos, Date fechaNacimiento, String observaciones) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.observaciones = observaciones;
	}

	public no_Persona(String nombre, String apellidos, Date fechaNacimiento, String observaciones) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.observaciones = observaciones;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		no_Persona other = (no_Persona) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fechaNacimiento="
				+ fechaNacimiento + ", observaciones=" + observaciones + "]";
	}

	


	
}

