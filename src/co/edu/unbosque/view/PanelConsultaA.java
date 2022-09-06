package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

import co.edu.unbosque.controller.Controller;

public class PanelConsultaA extends JPanel{
	
	private final String COMANDO_ELIMINAR = "ELIMINAR";
	private final String COMANDO_EDITAR = "EDITAR";
	private final String COMANDO_BUSCAR = "BUSCAR";

	
	private PanelTablas panelTablas;
	private PanelEditarPersonaA panelEditar;
	private JLabel labelNombre;
	private JTextField txtNombre;
	private JButton btnEliminar;
	private JButton btnEditar;
	private JButton btnBuscar;
	private JPanel panel;
	private JSplitPane splitPane;
	private JPanel panelBotones;
	private JPanel panel2;
	
	public PanelConsultaA(Controller controller) {
		setLayout(new GridLayout(1, 1));
		panelTablas = new PanelTablas();
		panelEditar = new PanelEditarPersonaA();
		labelNombre = new JLabel("Ingrese la cédula a buscar");
		txtNombre = new JTextField();
		txtNombre.addKeyListener(controller);
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setActionCommand(COMANDO_ELIMINAR);
		btnEditar = new JButton("Editar");
		btnEditar.setActionCommand(COMANDO_EDITAR);
		btnBuscar = new JButton("Buscar");
		btnBuscar.setActionCommand(COMANDO_BUSCAR);
		panel = new JPanel();
		panel.setLayout(new GridLayout(1, 3));
		panel.add(labelNombre);
		panel.add(txtNombre);
		panel.add(btnBuscar);
		panelBotones = new JPanel();
		panelBotones.setLayout(new GridLayout(1, 2));
		panelBotones.add(btnEliminar);
		panelBotones.add(btnEditar);
		panel2 = new JPanel();
		panel2.setLayout(new BorderLayout());
		panel2.add(panelTablas, BorderLayout.CENTER);
		panel2.add(panelBotones, BorderLayout.PAGE_END);
		splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitPane.setDividerLocation(50);
		splitPane.setTopComponent(panel);
		splitPane.setBottomComponent(panel2);
		add(splitPane);
	}

	/**
	 * @return the panelTablas
	 */
	public PanelTablas getPanelTablas() {
		return panelTablas;
	}

	/**
	 * @param panelTablas the panelTablas to set
	 */
	public void setPanelTablas(PanelTablas panelTablas) {
		this.panelTablas = panelTablas;
	}

	/**
	 * @return the labelNombre
	 */
	public JLabel getLabelNombre() {
		return labelNombre;
	}

	/**
	 * @param labelNombre the labelNombre to set
	 */
	public void setLabelNombre(JLabel labelNombre) {
		this.labelNombre = labelNombre;
	}

	/**
	 * @return the txtNombre
	 */
	public JTextField getTxtNombre() {
		return txtNombre;
	}

	/**
	 * @param txtNombre the txtNombre to set
	 */
	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	/**
	 * @return the panel
	 */
	public JPanel getPanel() {
		return panel;
	}

	/**
	 * @param panel the panel to set
	 */
	public void setPanel(JPanel panel) {
		this.panel = panel;
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
	 * @return the btnEliminar
	 */
	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	/**
	 * @param btnEliminar the btnEliminar to set
	 */
	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}

	/**
	 * @return the btnEditar
	 */
	public JButton getBtnEditar() {
		return btnEditar;
	}

	/**
	 * @param btnEditar the btnEditar to set
	 */
	public void setBtnEditar(JButton btnEditar) {
		this.btnEditar = btnEditar;
	}

	/**
	 * @return the cOMANDO_ELIMINAR
	 */
	public String getCOMANDO_ELIMINAR() {
		return COMANDO_ELIMINAR;
	}

	/**
	 * @return the cOMANDO_EDITAR
	 */
	public String getCOMANDO_EDITAR() {
		return COMANDO_EDITAR;
	}

	/**
	 * @return the panelEditar
	 */
	public PanelEditarPersonaA getPanelEditar() {
		return panelEditar;
	}

	/**
	 * @param panelEditar the panelEditar to set
	 */
	public void setPanelEditar(PanelEditarPersonaA panelEditar) {
		this.panelEditar = panelEditar;
	}

	/**
	 * @return the cOMANDO_BUSCAR
	 */
	public String getCOMANDO_BUSCAR() {
		return COMANDO_BUSCAR;
	}

	/**
	 * @return the btnBuscar
	 */
	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	/**
	 * @param btnBuscar the btnBuscar to set
	 */
	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}
	
}
