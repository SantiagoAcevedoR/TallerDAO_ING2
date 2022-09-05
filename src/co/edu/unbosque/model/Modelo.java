package co.edu.unbosque.model;

import java.util.ArrayList;

import co.edu.unbosque.model.persistence.PersonaArrayDAO;
import co.edu.unbosque.model.persistence.PersonaBinDAO;
import co.edu.unbosque.model.persistence.PersonaDTO;

public class Modelo {
	
	private PersonaArrayDAO personaArreglo;
	private PersonaBinDAO personaBin;
	private Conexion cone;
	
	public Modelo() {
		
		personaArreglo = new PersonaArrayDAO();
		personaBin = new PersonaBinDAO();
		cone = new Conexion();
		
	}
	
	public String[][] mostarInfoPersonas(ArrayList<PersonaDTO> listaPersona) {

		String[][] infoUsuarios = new String[listaPersona.size()][6];
		for (int i = 0; i < listaPersona.size(); i++) {
			infoUsuarios[i][0] = listaPersona.get(i).getNombre();
			infoUsuarios[i][1] = listaPersona.get(i).getApellido();
			infoUsuarios[i][2] = listaPersona.get(i).getTelefono();
			infoUsuarios[i][3] = listaPersona.get(i).getEdad();
			infoUsuarios[i][4] = listaPersona.get(i).getCedula();
			infoUsuarios[i][5] = listaPersona.get(i).getSexo();
		}
		return infoUsuarios;
	}

	/**
	 * @return the personaArreglo
	 */
	public PersonaArrayDAO getPersonaArreglo() {
		return personaArreglo;
	}

	/**
	 * @param personaArreglo the personaArreglo to set
	 */
	public void setPersonaArreglo(PersonaArrayDAO personaArreglo) {
		this.personaArreglo = personaArreglo;
	}

	/**
	 * @return the personaBin
	 */
	public PersonaBinDAO getPersonaBin() {
		return personaBin;
	}

	/**
	 * @param personaBin the personaBin to set
	 */
	public void setPersonaBin(PersonaBinDAO personaBin) {
		this.personaBin = personaBin;
	}

	/**
	 * @return the cone
	 */
	public Conexion getCone() {
		return cone;
	}

	/**
	 * @param cone the cone to set
	 */
	public void setCone(Conexion cone) {
		this.cone = cone;
	}
	
	

}
