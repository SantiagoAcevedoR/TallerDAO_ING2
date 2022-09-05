package co.edu.unbosque.model.persistence;

import java.io.Serializable;

public class PersonaDTO implements Serializable {
	
	private String nombre;
	private String apellido;
	private String sexo;
	private String telefono;
	private String edad;
	private String cedula;
	
	public PersonaDTO(String nombre, String apellido, String sexo, String telefono, String edad, String cedula) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.telefono = telefono;
		this.edad = edad;
		this.cedula = cedula;
	}

	
	public PersonaDTO() {
	}


	public String getCedula() {
		return cedula;
	}


	public void setCedula(String cedula) {
		this.cedula = cedula;
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}
	
	
	

}
