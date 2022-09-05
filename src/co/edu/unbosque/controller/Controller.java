package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import co.edu.unbosque.model.Modelo;
import co.edu.unbosque.model.persistence.PersonaDTO;
import co.edu.unbosque.view.Vista;

public class Controller implements ActionListener, KeyListener {

	private Vista vista;
	private Modelo modelo;

	public Controller() {
		vista = new Vista(this);
		modelo = new Modelo();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if (comando.equals(vista.getCOMANDO_DAO_ARREGLO())) {
			vista.getPanelArreglo().setVisible(true);
			vista.getPanelBinario().setVisible(false);
			vista.getPanelSql().setVisible(false);
		}
		if (comando.equals(vista.getCOMANDO_DAO_BINARIO())) {
			vista.getPanelBinario().setVisible(true);
			vista.getPanelArreglo().setVisible(false);
			vista.getPanelSql().setVisible(false);
		}
		if (comando.equals(vista.getCOMANDO_DAO_RELACIONAL())) {
			vista.getPanelBinario().setVisible(false);
			vista.getPanelArreglo().setVisible(false);
			vista.getPanelSql().setVisible(true);
		}
		if (comando.equals(vista.getCOMANDO_DAO_NORELACIONAL())) {

		}
		
		
		if (comando.equals(vista.getPanelSql().getCOMANDO_AGREGAR_PERSONA())) {
			vista.getPanelSql().getSplitPane().setRightComponent(vista.getPanelSql().getPanelAgregar());
		}
		
		if (comando.equals(vista.getPanelSql().getCOMANDO_VER_INFORMACION())) {
			vista.getPanelSql().getSplitPane().setRightComponent(vista.getPanelSql().getPanelConsulta());
		}

		if (comando.equals(vista.getPanelArreglo().getCOMANDO_AGREGAR_PERSONA())) {
			vista.getPanelArreglo().getSplitPane().setRightComponent(vista.getPanelArreglo().getPanelAgregar());
		}
		
		if (comando.equals(vista.getPanelArreglo().getCOMANDO_VER_INFORMACION())) {
			vista.getPanelArreglo().getSplitPane().setRightComponent(vista.getPanelArreglo().getPanelConsulta());
		}


		if (comando.equals(vista.getPanelBinario().getCOMANDO_AGREGAR_PERSONA())) {
			vista.getPanelBinario().getSplitPane().setRightComponent(vista.getPanelBinario().getPanelAgregar());
		}

		if (comando.equals(vista.getPanelBinario().getCOMANDO_VER_INFORMACION())) {
			vista.getPanelBinario().getSplitPane().setRightComponent(vista.getPanelBinario().getPanelConsulta());
		}

		if (comando.equals(vista.getPanelArreglo().getCOMANDO_VER_INFORMACION())) {
			vista.getPanelArreglo().getSplitPane().setRightComponent(vista.getPanelArreglo().getPanelConsulta());
			vista.getPanelArreglo().getPanelConsulta().getPanelTablas().limpiarPanel();
			String[][] info = modelo.mostarInfoPersonas(modelo.getPersonaArreglo().getListaPersona());
			vista.getPanelArreglo().getPanelConsulta().getPanelTablas().limpiarPanel();
			vista.getPanelArreglo().getPanelConsulta().getPanelTablas().mostrarTablaClientes(info);

		}
		
		if (comando.equals(vista.getPanelBinario().getCOMANDO_VER_INFORMACION())) {
			vista.getPanelBinario().getSplitPane().setRightComponent(vista.getPanelBinario().getPanelConsulta());
			vista.getPanelBinario().getPanelConsulta().getPanelTablas().limpiarPanel();
			String[][] info = modelo.mostarInfoPersonas(modelo.getPersonaBin().getListaPersonas());
			vista.getPanelBinario().getPanelConsulta().getPanelTablas().limpiarPanel();
			vista.getPanelBinario().getPanelConsulta().getPanelTablas().mostrarTablaPersonas2(info);
		}
		
		if (comando.equals(vista.getPanelSql().getCOMANDO_VER_INFORMACION())) {
			vista.getPanelSql().getSplitPane().setRightComponent(vista.getPanelSql().getPanelConsulta());
			vista.getPanelSql().getPanelConsulta().getPanelTablas().limpiarPanel();
			String[][] info = modelo.mostarInfoPersonas(modelo.getPersonaSql().buscarPersonas());
			vista.getPanelSql().getPanelConsulta().getPanelTablas().limpiarPanel();
			vista.getPanelSql().getPanelConsulta().getPanelTablas().mostrarTablaPersonas2(info);
		}

		if (comando.equals(vista.getPanelArreglo().getPanelAgregar().getCOMANDO_CREAR())) {
			String[] entradas = vista.getPanelArreglo().getPanelAgregar().verificarEntradas();
			if (entradas[0].equals("0")) {
				if (modelo.getPersonaArreglo().agregarPersona(entradas[1], entradas[2], entradas[6], entradas[3],
						entradas[4], entradas[5])) {
					vista.mostrarMensajeInformacion("Persona creada correctamente");
					vista.getPanelArreglo().getPanelAgregar().limpiarPanel();
				} else {
					vista.mostrarMensajeInformacion("La persona ya se encuentra registrada");
				}
			} else {
				vista.mostrarMensajeInformacion(entradas[1]);
			}
		}

		if (comando.equals(vista.getPanelBinario().getPanelAgregar().getCOMANDO_CREAR())) {
			String[] entradas = vista.getPanelBinario().getPanelAgregar().verificarEntradas();
			if (entradas[0].equals("0")) {
				if (modelo.getPersonaBin().agregarPersona(entradas[1], entradas[2], entradas[6], entradas[3],
						entradas[4], entradas[5])) {
					vista.mostrarMensajeInformacion("Persona creada correctamente");
					vista.getPanelBinario().getPanelAgregar().limpiarPanel();
				} else {
					vista.mostrarMensajeInformacion("La persona ya se encuentra reistrada");
				}

			} else {
				vista.mostrarMensajeInformacion(entradas[1]);
			}
		}
		
		if (comando.equals(vista.getPanelSql().getPanelAgregar().getCOMANDO_CREAR())) {
			String[] entradas = vista.getPanelSql().getPanelAgregar().verificarEntradas();
			if (entradas[0].equals("0")) {
				PersonaDTO persona = new PersonaDTO(entradas[1], entradas[2], entradas[6], entradas[3],
						entradas[4], entradas[5]);
				if (modelo.getPersonaSql().insertarPersonaDB(persona)) {
					vista.mostrarMensajeInformacion("Persona creada correctamente");
					vista.getPanelSql().getPanelAgregar().limpiarPanel();
				} else {
					vista.mostrarMensajeInformacion("La persona ya se encuentra registrada");
				}
			} else {
				vista.mostrarMensajeInformacion(entradas[1]);
			}
		}

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}
