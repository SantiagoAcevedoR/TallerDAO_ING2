package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import co.edu.unbosque.controller.Controller;

public class PanelBinario extends JPanel{
	
	private final String COMANDO_AGREGAR_PERSONA = "AGREGARPERSONA123";
	private final String COMANDO_VER_INFORMACION = "VERINFO123";
	
	private JButton btnAgregarPersona;
	private JButton btnVerInfo;
	private JSplitPane splitPane;
	private PanelAgregarPersonaB panelAgregar;
	private PanelConsultaB panelConsulta;
	private JPanel panelBotones;
	
	public PanelBinario(Controller controller) {
		setLayout(new BorderLayout());
		btnAgregarPersona = new JButton("Agregar Persona");
		btnAgregarPersona.setActionCommand(COMANDO_AGREGAR_PERSONA);
		btnVerInfo = new JButton("Ver información");
		btnVerInfo.setActionCommand(COMANDO_VER_INFORMACION);
		panelBotones = new JPanel();
		panelBotones.setLayout(new GridLayout(2, 1));
		panelBotones.add(btnAgregarPersona);
		panelBotones.add(btnVerInfo);
		panelAgregar = new PanelAgregarPersonaB();
		panelConsulta = new PanelConsultaB(controller);
		splitPane = new JSplitPane();
		splitPane.setLeftComponent(panelBotones);
		splitPane.setRightComponent(panelAgregar);
		add(splitPane);
	}

	/**
	 * @return the btnAgregarPersona
	 */
	public JButton getBtnAgregarPersona() {
		return btnAgregarPersona;
	}

	/**
	 * @param btnAgregarPersona the btnAgregarPersona to set
	 */
	public void setBtnAgregarPersona(JButton btnAgregarPersona) {
		this.btnAgregarPersona = btnAgregarPersona;
	}

	/**
	 * @return the btnVerInfo
	 */
	public JButton getBtnVerInfo() {
		return btnVerInfo;
	}

	/**
	 * @param btnVerInfo the btnVerInfo to set
	 */
	public void setBtnVerInfo(JButton btnVerInfo) {
		this.btnVerInfo = btnVerInfo;
	}

	/**
	 * @return the splitPane
	 */
	public JSplitPane getSplitPane() {
		return splitPane;
	}

	/**
	 * @param splitPane the splitPane to set
	 */
	public void setSplitPane(JSplitPane splitPane) {
		this.splitPane = splitPane;
	}

	/**
	 * @return the panelAgregar
	 */
	public PanelAgregarPersonaB getPanelAgregar() {
		return panelAgregar;
	}

	/**
	 * @param panelAgregar the panelAgregar to set
	 */
	public void setPanelAgregar(PanelAgregarPersonaB panelAgregar) {
		this.panelAgregar = panelAgregar;
	}

	/**
	 * @return the panelBotones
	 */
	public JPanel getPanelBotones() {
		return panelBotones;
	}

	/**
	 * @param panelBotones the panelBotones to set
	 */
	public void setPanelBotones(JPanel panelBotones) {
		this.panelBotones = panelBotones;
	}

	/**
	 * @return the cOMANDO_AGREGAR_PERSONA
	 */
	public String getCOMANDO_AGREGAR_PERSONA() {
		return COMANDO_AGREGAR_PERSONA;
	}

	/**
	 * @return the cOMANDO_VER_INFORMACION
	 */
	public String getCOMANDO_VER_INFORMACION() {
		return COMANDO_VER_INFORMACION;
	}

	/**
	 * @return the panelConsulta
	 */
	public PanelConsultaB getPanelConsulta() {
		return panelConsulta;
	}

	/**
	 * @param panelConsulta the panelConsulta to set
	 */
	public void setPanelConsulta(PanelConsultaB panelConsulta) {
		this.panelConsulta = panelConsulta;
	}

}
