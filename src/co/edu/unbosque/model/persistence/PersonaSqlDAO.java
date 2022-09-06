package co.edu.unbosque.model.persistence;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import co.edu.unbosque.model.Conexion;

public class PersonaSqlDAO {

	private Conexion connection = null;

	public PersonaSqlDAO() {
		connection = new Conexion();

	}
	public boolean insertarPersonaDB(PersonaDTO persona) {
		connection.abrirConexion();
		Statement stmt = null;
		try {
			connection.getConnection().setAutoCommit(false);
			stmt = connection.getConnection().createStatement();
			String sql = "INSERT INTO persona (cedula, nombre, apellido, sexo, edad, telefono) " + "VALUES ('"
					+ persona.getCedula() + "', '" + persona.getNombre() + "', '" + persona.getApellido()
					+ "' , '" + persona.getSexo() + "' , '" + persona.getEdad() + "', '" + persona.getTelefono() + "')";
			stmt.executeUpdate(sql);
			stmt.close();
			connection.getConnection().commit();	
			connection.getConnection().close();
			System.out.println("Records created successfully");
			return true;
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
			return false;
		}
	}

	public ArrayList<PersonaDTO> buscarPersonas() {
		connection.abrirConexion();
		Statement stmt = null;
		ArrayList<PersonaDTO> listaPersonas = new ArrayList<>();
		try {
			stmt = connection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM persona;");
			while (rs.next()) {
				String cedula = rs.getString("cedula");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String sexo = rs.getString("sexo");
				String edad = rs.getString("edad");
				String telefono = rs.getString("telefono");
				PersonaDTO persona = new PersonaDTO(nombre, apellido, sexo, telefono, edad, cedula);
				listaPersonas.add(persona);
			}
			rs.close();
			stmt.close();
			connection.getConnection().close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return listaPersonas;
	}
	
	public ArrayList<PersonaDTO> consultarPersonas(String cedula) {
		connection.abrirConexion();
		Statement stmt = null;
		ArrayList<PersonaDTO> listaPersonas = new ArrayList<>();
		try {

			stmt = connection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM persona WHERE cedula like '%" + cedula + "%'");
			while (rs.next()) {
				String cedula1 = rs.getString("cedula");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String sexo = rs.getString("sexo");
				String edad = rs.getString("edad");
				String telefono = rs.getString("telefono");
				PersonaDTO persona = new PersonaDTO(nombre, apellido, sexo, telefono, edad, cedula1);
				listaPersonas.add(persona);
			}
			rs.close();
			stmt.close();
			connection.getConnection().close();
		} catch (Exception e) {
			Logger.getLogger(PersonaSqlDAO.class.getName()).log(Level.SEVERE, null, e);
			return null;
		}
		return listaPersonas;
	}

	public boolean buscarPersonaPorCedula(String pcedula) {
		boolean res = true;
		connection.abrirConexion();
		Statement stmt = null;
		ArrayList<PersonaDTO> listaPersonas = new ArrayList<>();

		try {

			stmt = connection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM persona;");
			while (rs.next()) {
				String cedula = rs.getString("cedula");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String sexo = rs.getString("sexo");
				String edad = rs.getString("edad");
				String telefono = rs.getString("telefono");
				PersonaDTO persona = new PersonaDTO(nombre, apellido, sexo, telefono, edad, cedula);
				if (pcedula.equals(cedula)) {
					res = false;
					break;
				}

			}
			rs.close();
			stmt.close();
			connection.getConnection().close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return res;
	}
	/**
	 * @return the connection
	 */
	public Conexion getConnection() {
		return connection;
	}
	/**
	 * @param connection the connection to set
	 */
	public void setConnection(Conexion connection) {
		this.connection = connection;
	}
	
	

}
