package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import co.edu.unbosque.model.ExceptionNumero;
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
			vista.getPanelBinario().getPanelConsulta().getPanelTablas().mostrarTablaClientes(info);
		}

		if (comando.equals(vista.getPanelSql().getCOMANDO_VER_INFORMACION())) {
			vista.getPanelSql().getSplitPane().setRightComponent(vista.getPanelSql().getPanelConsulta());
			vista.getPanelSql().getPanelConsulta().getPanelTablas().limpiarPanel();
			String[][] info = modelo.mostarInfoPersonas(modelo.getPersonaSql().buscarPersonas());
			vista.getPanelSql().getPanelConsulta().getPanelTablas().limpiarPanel();
			vista.getPanelSql().getPanelConsulta().getPanelTablas().mostrarTablaClientes(info);
		}

		if (comando.equals(vista.getPanelArreglo().getPanelAgregar().getCOMANDO_CREAR())) {
			try {
				String[] entradas = vista.getPanelArreglo().getPanelAgregar().verificarEntradas();
				if (entradas[0].equals("0")) {
					modelo.verificarNumero(entradas[3]);
					modelo.verificarNumero(entradas[4]);
					modelo.verificarNumero(entradas[5]);
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
			} catch (ExceptionNumero e1) {
				vista.mostrarMensajeAdvertencia(e1.getMessage());
			}

		}

		if (comando.equals(vista.getPanelBinario().getPanelAgregar().getCOMANDO_CREAR())) {
			try {
				String[] entradas = vista.getPanelBinario().getPanelAgregar().verificarEntradas();
				modelo.verificarNumero(entradas[3]);
				modelo.verificarNumero(entradas[4]);
				modelo.verificarNumero(entradas[5]);
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
			} catch (ExceptionNumero e1) {
				vista.mostrarMensajeAdvertencia(e1.getMessage());
			}
		}

		if (comando.equals(vista.getPanelSql().getPanelAgregar().getCOMANDO_CREAR())) {
			try {
				String[] entradas = vista.getPanelSql().getPanelAgregar().verificarEntradas();
				if (entradas[0].equals("0")) {
					modelo.verificarNumero(entradas[3]);
					modelo.verificarNumero(entradas[4]);
					modelo.verificarNumero(entradas[5]);
					PersonaDTO persona = new PersonaDTO(entradas[1], entradas[2], entradas[6], entradas[3], entradas[4],
							entradas[5]);
					if (modelo.getPersonaSql().insertarPersonaDB(persona)) {
						vista.mostrarMensajeInformacion("Persona creada correctamente");
						vista.getPanelSql().getPanelAgregar().limpiarPanel();
					} else {
						vista.mostrarMensajeInformacion("La persona ya se encuentra registrada");
					}
				} else {
					vista.mostrarMensajeInformacion(entradas[1]);
				}
			} catch (ExceptionNumero e1) {
				vista.mostrarMensajeAdvertencia(e1.getMessage());
			}
		}

		if (comando.equals(vista.getPanelArreglo().getPanelConsulta().getCOMANDO_ELIMINAR())) {
			if (vista.getPanelArreglo().getPanelConsulta().getPanelTablas().verificarDatosTabla() == 1) {
				String[] entradas = vista.getPanelArreglo().getPanelConsulta().getPanelTablas().obtenerDatosTabla();
				int confirmar = vista.mostarMensajeConfirmar("Seguro desea eliminar a esta persona");
				if (confirmar == 0) {
					if (modelo.getPersonaArreglo().eliminarPersona(entradas[6])) {
						String[][] info = modelo.mostarInfoPersonas(modelo.getPersonaArreglo().getListaPersona());
						vista.getPanelArreglo().getPanelConsulta().getPanelTablas().limpiarPanel();
						vista.getPanelArreglo().getPanelConsulta().getPanelTablas().mostrarTablaClientes(info);
						vista.mostrarMensajeInformacion(entradas[2]);
					} else {
						vista.mostrarMensajeInformacion("No se ha podido eliminar a la persona seleccionada");
					}
				} else if (confirmar == 1) {
					vista.mostrarMensajeInformacion("Gracias por confirmar");
				} else {
					vista.mostrarMensajeInformacion("Gracias");
				}
			} else {
				vista.mostrarMensajeInformacion("Seleccione al menos un dato");
			}
		}

		if (comando.equals(vista.getPanelBinario().getPanelConsulta().getCOMANDO_ELIMINAR())) {
			if (vista.getPanelBinario().getPanelConsulta().getPanelTablas().verificarDatosTabla() == 1) {
				String[] entradas = vista.getPanelBinario().getPanelConsulta().getPanelTablas().obtenerDatosTabla();
				int confirmar = vista.mostarMensajeConfirmar("Seguro desea eliminar a esta persona");
				if (confirmar == 0) {
					if (modelo.getPersonaBin().eliminarPersona(entradas[6])) {
						String[][] info = modelo.mostarInfoPersonas(modelo.getPersonaBin().getListaPersonas());
						vista.getPanelBinario().getPanelConsulta().getPanelTablas().limpiarPanel();
						vista.getPanelBinario().getPanelConsulta().getPanelTablas().mostrarTablaClientes(info);
						vista.mostrarMensajeInformacion(entradas[2]);
					} else {
						vista.mostrarMensajeInformacion("No se ha podido eliminar a la persona seleccionada");
					}
				} else if (confirmar == 1) {
					vista.mostrarMensajeInformacion("Gracias por confirmar");
				} else {
					vista.mostrarMensajeInformacion("Gracias");
				}
			} else {
				vista.mostrarMensajeInformacion("Seleccione al menos un dato");
			}
		}

		if (comando.equals(vista.getPanelSql().getPanelConsulta().getCOMANDO_ELIMINAR())) {
			if (vista.getPanelSql().getPanelConsulta().getPanelTablas().verificarDatosTabla() == 1) {
				String[] entradas = vista.getPanelSql().getPanelConsulta().getPanelTablas().obtenerDatosTabla();
				int confirmar = vista.mostarMensajeConfirmar("Seguro desea eliminar a esta persona");
				if (confirmar == 0) {
					if (modelo.getPersonaSql().deleteDB(entradas[6])) {
						String[][] info = modelo.mostarInfoPersonas(modelo.getPersonaSql().buscarPersonas());
						vista.getPanelSql().getPanelConsulta().getPanelTablas().limpiarPanel();
						vista.getPanelSql().getPanelConsulta().getPanelTablas().mostrarTablaClientes(info);
						vista.mostrarMensajeInformacion(entradas[2]);
					} else {
						vista.mostrarMensajeInformacion("No se ha podido eliminar a la persona seleccionada");
					}
				} else if (confirmar == 1) {
					vista.mostrarMensajeInformacion("Gracias por confirmar");
				} else {
					vista.mostrarMensajeInformacion("Gracias");
				}
			} else {
				vista.mostrarMensajeInformacion("Seleccione al menos un dato");
			}
		}

		if (comando.equals(vista.getPanelArreglo().getPanelConsulta().getCOMANDO_EDITAR())) {
			if (vista.getPanelArreglo().getPanelConsulta().getPanelTablas().verificarDatosTabla() == 1) {
				String[] entradas = vista.getPanelArreglo().getPanelConsulta().getPanelTablas().obtenerDatosTabla();
				vista.getPanelArreglo().getSplitPane()
						.setRightComponent(vista.getPanelArreglo().getPanelConsulta().getPanelEditar());
				vista.getPanelArreglo().getPanelConsulta().getPanelEditar().obtenerDatos(entradas);
			} else {
				vista.mostrarMensajeInformacion("Seleccione al menos un dato");
			}
		}

		if (comando.equals(vista.getPanelBinario().getPanelConsulta().getCOMANDO_EDITAR())) {
			if (vista.getPanelBinario().getPanelConsulta().getPanelTablas().verificarDatosTabla() == 1) {
				String[] entradas = vista.getPanelBinario().getPanelConsulta().getPanelTablas().obtenerDatosTabla();
				vista.getPanelBinario().getSplitPane()
						.setRightComponent(vista.getPanelBinario().getPanelConsulta().getPanelEditar());
				vista.getPanelBinario().getPanelConsulta().getPanelEditar().obtenerDatos(entradas);
			} else {
				vista.mostrarMensajeInformacion("Seleccione al menos un dato");
			}
		}

		if (comando.equals(vista.getPanelSql().getPanelConsulta().getCOMANDO_EDITAR())) {
			if (vista.getPanelSql().getPanelConsulta().getPanelTablas().verificarDatosTabla() == 1) {
				String[] entradas = vista.getPanelSql().getPanelConsulta().getPanelTablas().obtenerDatosTabla();
				vista.getPanelSql().getSplitPane()
						.setRightComponent(vista.getPanelSql().getPanelConsulta().getPanelEditar());
				vista.getPanelSql().getPanelConsulta().getPanelEditar().obtenerDatos(entradas);
			} else {
				vista.mostrarMensajeInformacion("Seleccione al menos un dato");
			}
		}

		if (comando.equals(vista.getPanelArreglo().getPanelConsulta().getPanelEditar().getCOMANDO_CREAR())) {
			try {
				String[] entradas = vista.getPanelArreglo().getPanelConsulta().getPanelEditar().verificarEntradas();
				if (entradas[0].equals("0")) {
					modelo.verificarNumero(entradas[3]);
					modelo.verificarNumero(entradas[4]);
					modelo.verificarNumero(entradas[5]);
					if (modelo.getPersonaArreglo().editarPersona(entradas[1], entradas[2], entradas[6], entradas[3],
							entradas[4], entradas[5])) {
						vista.mostrarMensajeInformacion("Persona editada correctamente");
						vista.getPanelArreglo().getPanelConsulta().getPanelEditar().limpiarPanel();
					} else {
						vista.mostrarMensajeInformacion("La persona ya se encuentra registrada");
					}
				} else {
					vista.mostrarMensajeInformacion(entradas[1]);
				}
			} catch (ExceptionNumero e1) {
				vista.mostrarMensajeAdvertencia(e1.getMessage());
			}

		}

		if (comando.equals(vista.getPanelBinario().getPanelConsulta().getPanelEditar().getCOMANDO_CREAR())) {
			try {
				String[] entradas = vista.getPanelBinario().getPanelConsulta().getPanelEditar().verificarEntradas();
				if (entradas[0].equals("0")) {
					modelo.verificarNumero(entradas[3]);
					modelo.verificarNumero(entradas[4]);
					modelo.verificarNumero(entradas[5]);
					if (modelo.getPersonaBin().editarPersona(entradas[1], entradas[2], entradas[6], entradas[3],
							entradas[4], entradas[5])) {
						vista.mostrarMensajeInformacion("Persona editada correctamente");
						vista.getPanelBinario().getPanelConsulta().getPanelEditar().limpiarPanel();
					} else {
						vista.mostrarMensajeInformacion("La persona ya se encuentra registrada");
					}
				} else {
					vista.mostrarMensajeInformacion(entradas[1]);
				}
			} catch (ExceptionNumero e1) {
				vista.mostrarMensajeAdvertencia(e1.getMessage());
			}

		}

		if (comando.equals(vista.getPanelSql().getPanelConsulta().getPanelEditar().getCOMANDO_CREAR())) {
			try {
				String[] entradas = vista.getPanelSql().getPanelConsulta().getPanelEditar().verificarEntradas();
				if (entradas[0].equals("0")) {
					modelo.verificarNumero(entradas[3]);
					modelo.verificarNumero(entradas[4]);
					modelo.verificarNumero(entradas[5]);
					PersonaDTO persona = new PersonaDTO(entradas[1], entradas[2], entradas[6], entradas[3], entradas[4],
							entradas[5]);
					if (modelo.getPersonaSql().modificarPersona(persona)) {
						vista.mostrarMensajeInformacion("Persona editada correctamente");
						vista.getPanelSql().getPanelConsulta().getPanelEditar().limpiarPanel();
					} else {
						vista.mostrarMensajeInformacion("La persona ya se encuentra registrada");
					}
				} else {
					vista.mostrarMensajeInformacion(entradas[1]);
				}

			} catch (ExceptionNumero e1) {
				vista.mostrarMensajeAdvertencia(e1.getMessage());
			}

		}

		if (comando.equals(vista.getPanelArreglo().getPanelConsulta().getPanelEditar().getCOMANDO_VOLVER())) {
			vista.getPanelArreglo().getSplitPane().setRightComponent(vista.getPanelArreglo().getPanelConsulta());
			vista.getPanelArreglo().getPanelConsulta().getPanelTablas().limpiarPanel();
			String[][] info = modelo.mostarInfoPersonas(modelo.getPersonaArreglo().getListaPersona());
			vista.getPanelArreglo().getPanelConsulta().getPanelTablas().limpiarPanel();
			vista.getPanelArreglo().getPanelConsulta().getPanelTablas().mostrarTablaClientes(info);
		}

		if (comando.equals(vista.getPanelBinario().getPanelConsulta().getPanelEditar().getCOMANDO_VOLVER())) {
			vista.getPanelBinario().getSplitPane().setRightComponent(vista.getPanelBinario().getPanelConsulta());
			vista.getPanelBinario().getPanelConsulta().getPanelTablas().limpiarPanel();
			String[][] info = modelo.mostarInfoPersonas(modelo.getPersonaBin().getListaPersonas());
			vista.getPanelBinario().getPanelConsulta().getPanelTablas().limpiarPanel();
			vista.getPanelBinario().getPanelConsulta().getPanelTablas().mostrarTablaClientes(info);
		}

		if (comando.equals(vista.getPanelSql().getPanelConsulta().getPanelEditar().getCOMANDO_VOLVER())) {
			vista.getPanelSql().getSplitPane().setRightComponent(vista.getPanelSql().getPanelConsulta());
			vista.getPanelSql().getPanelConsulta().getPanelTablas().limpiarPanel();
			String[][] info = modelo.mostarInfoPersonas(modelo.getPersonaSql().buscarPersonas());
			vista.getPanelSql().getPanelConsulta().getPanelTablas().limpiarPanel();
			vista.getPanelSql().getPanelConsulta().getPanelTablas().mostrarTablaClientes(info);
		}
		
		if(comando.equals(vista.getPanelArreglo().getPanelConsulta().getCOMANDO_BUSCAR())) {
			String cedula = vista.getPanelArreglo().getPanelConsulta().getTxtNombre().getText();
			if(!cedula.equals("")) {
				vista.getPanelArreglo().getSplitPane().setRightComponent(vista.getPanelArreglo().getPanelConsulta());
				vista.getPanelArreglo().getPanelConsulta().getPanelTablas().limpiarPanel();
				String[][] info = modelo.mostarInfoPersonas(modelo.getPersonaArreglo().buscarPersonasPorCedula(cedula));
				vista.getPanelArreglo().getPanelConsulta().getPanelTablas().limpiarPanel();
				vista.getPanelArreglo().getPanelConsulta().getPanelTablas().mostrarTablaClientes(info);
			}else {
				vista.mostrarMensajeInformacion("Ingrese la cédula a buscar");
			}
		}
		
		if(comando.equals(vista.getPanelBinario().getPanelConsulta().getCOMANDO_BUSCAR())) {
			String cedula = vista.getPanelBinario().getPanelConsulta().getTxtNombre().getText();
			if(!cedula.equals("")) {
				vista.getPanelBinario().getSplitPane().setRightComponent(vista.getPanelBinario().getPanelConsulta());
				vista.getPanelBinario().getPanelConsulta().getPanelTablas().limpiarPanel();
				String[][] info = modelo.mostarInfoPersonas(modelo.getPersonaBin().buscarPersonaPorCedula(cedula));
				vista.getPanelBinario().getPanelConsulta().getPanelTablas().limpiarPanel();
				vista.getPanelBinario().getPanelConsulta().getPanelTablas().mostrarTablaClientes(info);
			}else {
				vista.mostrarMensajeInformacion("Ingrese la cédula a buscar");
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
		if (!vista.getPanelSql().getPanelConsulta().getTxtNombre().getText().equals("")) {
			ArrayList<PersonaDTO> listaUsuarios = modelo.getPersonaSql()
					.consultarPersonas(vista.getPanelSql().getPanelConsulta().getTxtNombre().getText());
			String[][] infoUsuarios = modelo.mostarInfoPersonas(listaUsuarios);
			vista.getPanelSql().getPanelConsulta().getPanelTablas().limpiarPanel();
			vista.getPanelSql().getPanelConsulta().getPanelTablas().mostrarTablaClientes(infoUsuarios);
		} else if (vista.getPanelSql().getPanelConsulta().getTxtNombre().getText().equals("")) {
			ArrayList<PersonaDTO> listaUsuarios = modelo.getPersonaSql().buscarPersonas();
			String[][] infoUsuarios = modelo.mostarInfoPersonas(listaUsuarios);
			vista.getPanelSql().getPanelConsulta().getPanelTablas().limpiarPanel();
			vista.getPanelSql().getPanelConsulta().getPanelTablas().mostrarTablaClientes(infoUsuarios);
		}
	}
}
