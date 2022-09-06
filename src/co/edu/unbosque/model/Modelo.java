package co.edu.unbosque.model;

import java.util.ArrayList;

import co.edu.unbosque.model.persistence.PersonaArrayDAO;
import co.edu.unbosque.model.persistence.PersonaBinDAO;
import co.edu.unbosque.model.persistence.PersonaDTO;
import co.edu.unbosque.model.persistence.PersonaSqlDAO;

public class Modelo {
	
	private PersonaArrayDAO personaArreglo;
	private PersonaBinDAO personaBin;
	private PersonaSqlDAO personaSql;
	
	public Modelo() {	
		personaArreglo = new PersonaArrayDAO();
		personaBin = new PersonaBinDAO();	
		personaSql = new PersonaSqlDAO();		

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

	
	public boolean soloNumeros(String numero) {
		for (int i = 0; i < numero.length(); i++) {
			char aux = numero.charAt(i);
			int digito = aux - '0';
			if (digito > 9 || digito < 0) {
				return false;
			}
		}
		return true;
	}

	public void verificarNumero(String numero) throws ExceptionNumero {
		if (!soloNumeros(numero)) {
			throw new ExceptionNumero("Caracter no permitido en campo numérico");
		} else {
			if (Long.parseLong(numero) <= 0) {
				throw new ExceptionNumero("Ingrese una cantidad minimo de uno");
			}
		}
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
	 * @return the personaSql
	 */
	public PersonaSqlDAO getPersonaSql() {
		return personaSql;
	}

	/**
	 * @param personaSql the personaSql to set
	 */
	public void setPersonaSql(PersonaSqlDAO personaSql) {
		this.personaSql = personaSql;
	}

	
	

}
