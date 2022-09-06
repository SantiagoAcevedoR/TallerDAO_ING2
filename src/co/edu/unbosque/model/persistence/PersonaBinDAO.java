package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

public class PersonaBinDAO {

	private ArrayList<PersonaDTO> listaPersonas;
	private ArchivoPersona archivoPersonas;

	
	public PersonaBinDAO() {
		this.archivoPersonas = new ArchivoPersona();
		this.archivoPersonas.asignarRutaArchivoPersonas(archivoPersonas.getRUTA_PERSONA());
		this.listaPersonas = archivoPersonas.leerArchivo(archivoPersonas.getFileArchivo());
	}

	
	public PersonaDTO buscarPersona(String cedula) {
		PersonaDTO encontrado = null;
		for (int i = 0; i < listaPersonas.size(); i++) {
			if (cedula.equals(listaPersonas.get(i).getCedula())) {
				encontrado = listaPersonas.get(i);
			}
		}
		return encontrado;

	}

	
	public boolean agregarPersona(String nombre, String apellido, String sexo, String telefono, String edad,
			String cedula) {
		boolean verificar = false;
		PersonaDTO alPersona;
		alPersona = new PersonaDTO(nombre, apellido, sexo, telefono, edad, cedula);
		if (buscarPersona(cedula) == null) {
			listaPersonas.add(alPersona);
			archivoPersonas.escribirArchivo(listaPersonas);
			verificar = true;
		} else {
			verificar = false;
		}
		return verificar;

	}

	
	public boolean eliminarPersona(String cedula) {
		boolean verificar = false;
		PersonaDTO persona = buscarPersona(cedula);
		if (persona != null) {
			listaPersonas.remove(persona);
			archivoPersonas.escribirArchivo(listaPersonas);
			verificar = true;
		} else {
			verificar = false;
		}
		return verificar;

	}

	
	public boolean editarPersona(String nombre, String apellido, String sexo, String telefono, String edad,
			String cedula) {
		boolean verificar = false;
		PersonaDTO apostador = buscarPersona(cedula);
		if (apostador != null) {
			this.eliminarPersona(cedula);
			this.agregarPersona(nombre, apellido, sexo, telefono, edad, cedula);
			verificar = true;
		} else {
			verificar = false;
		}
		return verificar;
	}

	public ArrayList<PersonaDTO> getListaPersonas() {
		return listaPersonas;
	}


	public void setListaPersonas(ArrayList<PersonaDTO> listaPersonas) {
		this.listaPersonas = listaPersonas;
	}


	public ArchivoPersona getArchivoPersonas() {
		return archivoPersonas;
	}


	public void setArchivoPersonas(ArchivoPersona archivoPersonas) {
		this.archivoPersonas = archivoPersonas;
	}


	
	

}
