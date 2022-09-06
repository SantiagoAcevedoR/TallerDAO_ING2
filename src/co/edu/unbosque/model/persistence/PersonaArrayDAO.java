package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

public class PersonaArrayDAO {

	private ArrayList<PersonaDTO> listaPersona;

	public PersonaArrayDAO() {
		this.listaPersona = new ArrayList<PersonaDTO>();
	}

	public PersonaDTO buscarPersona(String cedula) {
		PersonaDTO encontrado = null;
		for (int i = 0; i < listaPersona.size(); i++) {
			if (cedula.equals(listaPersona.get(i).getCedula())) {
				encontrado = listaPersona.get(i);
			}
		}
		return encontrado;
	}

	public ArrayList<PersonaDTO> buscarPersonasPorCedula(String cedula) {
		ArrayList<PersonaDTO> listaPersona2 = new ArrayList<PersonaDTO>();
		for (int i = 0; i < listaPersona.size(); i++) {
			String cedula1 = listaPersona.get(i).getCedula().substring(0, cedula.length());
			if(cedula.equals(cedula1)) {
				listaPersona2.add(listaPersona.get(i));
			}

		}
		return listaPersona2;

	}

	public boolean agregarPersona(String nombre, String apellido, String sexo, String telefono, String edad,
			String cedula) {
		boolean verificar = false;
		PersonaDTO alPersona;
		alPersona = new PersonaDTO(nombre, apellido, sexo, telefono, edad, cedula);
		if (buscarPersona(cedula) == null) {
			listaPersona.add(alPersona);

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
			listaPersona.remove(persona);
			verificar = true;
		} else {
			verificar = false;
		}
		return verificar;

	}

	public boolean editarPersona(String nombre, String apellido, String sexo, String telefono, String edad,
			String cedula) {
		boolean verificar = false;
		PersonaDTO persona = buscarPersona(cedula);
		if (persona != null) {
			this.eliminarPersona(cedula);
			this.agregarPersona(nombre, apellido, sexo, telefono, edad, cedula);
			verificar = true;
		} else {
			verificar = false;
		}
		return verificar;
	}

	/**
	 * @return the listaPersona
	 */
	public ArrayList<PersonaDTO> getListaPersona() {
		return listaPersona;
	}

	/**
	 * @param listaPersona the listaPersona to set
	 */
	public void setListaPersona(ArrayList<PersonaDTO> listaPersona) {
		this.listaPersona = listaPersona;
	}

}
