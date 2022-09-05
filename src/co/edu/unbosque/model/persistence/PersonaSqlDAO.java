package co.edu.unbosque.model.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import co.edu.unbosque.model.Conexion;

public class PersonaSqlDAO {

	private static Conexion connection;

	public PersonaSqlDAO(Conexion connection) {

		this.connection = connection;
	}

	public void insertarPersonaDB(PersonaDTO persona) {
		connection.abrirConexion();
		PreparedStatement stmt = null;
		try {
			String sql = "INSERT INTO persona (cedula, nombre, apellido, sexo, edad, telefono) "
					+ "VALUES (?, ?, ?, ?, ?, ?)";
			stmt = connection.getConnection().prepareStatement(sql);
			stmt.setString(1, persona.getCedula());
			stmt.setString(2, persona.getNombre());
			stmt.setString(3, persona.getApellido());
			stmt.setString(4, persona.getSexo());
			stmt.setString(5, persona.getEdad());
			stmt.setString(6, persona.getTelefono());
			stmt.executeUpdate(sql);
			stmt.close();
			connection.getConnection().commit();
			connection.getConnection().close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("La información ha sido guardada correctamente");
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
		System.out.println("Información mostrada correctamente");
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
		System.out.println("Información mostrada correctamente");
		return res;
	}

}
