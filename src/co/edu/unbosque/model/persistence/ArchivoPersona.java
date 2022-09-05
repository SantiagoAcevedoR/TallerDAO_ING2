package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ArchivoPersona {

	private File fileArchivo;

	private final String RUTA_PERSONA = "Data\\personas.dat";

	private ObjectInputStream entrada;

	private ObjectOutputStream salida;
	
	public ArchivoPersona() {

	}

	
	public void escribirArchivo(ArrayList<PersonaDTO> apostador) {
		if (!fileArchivo.exists()) {
			try {
				fileArchivo.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			fileArchivo.delete();
			salida = new ObjectOutputStream(new FileOutputStream(fileArchivo));
			salida.writeObject(apostador);
			salida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	
	@SuppressWarnings("unchecked")
	public ArrayList<PersonaDTO> leerArchivo(File file) {
		ArrayList<PersonaDTO> persona = new ArrayList<PersonaDTO>();
		if (file.length() != 0) {
			try {
				entrada = new ObjectInputStream(new FileInputStream(file));
				persona = (ArrayList<PersonaDTO>) entrada.readObject();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return persona;
	}


	public void asignarRutaArchivoPersonas(String ruta) {
		fileArchivo = new File(ruta);
	}


	public File getFileArchivo() {
		return fileArchivo;
	}


	public void setFileArchivo(File fileArchivo) {
		this.fileArchivo = fileArchivo;
	}


	public ObjectInputStream getEntrada() {
		return entrada;
	}


	public void setEntrada(ObjectInputStream entrada) {
		this.entrada = entrada;
	}


	public ObjectOutputStream getSalida() {
		return salida;
	}


	public void setSalida(ObjectOutputStream salida) {
		this.salida = salida;
	}


	public String getRUTA_PERSONA() {
		return RUTA_PERSONA;
	}
	
	


}
