package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

import co.edu.unbosque.controller.Controller;

public class PanelConsultaS extends JPanel{
	
	private PanelTablas panelTablas;
	private JLabel labelNombre;
	private JTextField txtNombre;
	private JPanel panel;
	private JSplitPane splitPane;
	
	public PanelConsultaS(Controller controller) {
		setLayout(new GridLayout(1, 1));
		panelTablas = new PanelTablas();
		labelNombre = new JLabel("Ingrese el nombre que desa buscar");
		txtNombre = new JTextField();
		txtNombre.addKeyListener(controller);
		panel = new JPanel();
		panel.setLayout(new GridLayout(1, 2));
		panel.add(labelNombre);
		panel.add(txtNombre);
		splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitPane.setDividerLocation(50);
		splitPane.setTopComponent(panel);
		splitPane.setBottomComponent(panelTablas);
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
}
