package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelAgregarPersonaA extends JPanel{
	
	private final String COMANDO_CREAR = "CREAR21";
	private final String COMANDO_VOLVER = "VOLVER20";
	private JLabel labelNombre;
	private JLabel labelApellido;
	private JLabel labelTelefono;
	private JLabel labelEdad;
	private JLabel labelCedula;
	private JLabel labelSexo;
	
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JTextField txtEdad;
	private JTextField txtCedula;
	private JComboBox<String> comboSexo;
	private JButton btnCrear;
	private JButton btnVolver;
	private JPanel panel;
	private JPanel panelBotones;
	
	public PanelAgregarPersonaA() {
		setBorder(new TitledBorder("Registro de persona a arreglo"));
		setLayout(new BorderLayout());
		this.labelNombre = new JLabel("Nombre: ");
		this.labelApellido = new JLabel("Apellido: ");
		this.labelTelefono = new JLabel("Telefono: ");
		this.labelEdad = new JLabel("Edad: ");
		this.labelCedula = new JLabel("Cédula: ");
		this.labelSexo = new JLabel("Sexo: ");
		this.txtNombre = new JTextField();
		this.txtApellido = new JTextField();
		this.txtTelefono = new JTextField();
		this.txtEdad = new JTextField();
		this.txtCedula = new JTextField();
		this.comboSexo = new JComboBox<String>();
		this.comboSexo.addItem("Seleccione");
		this.comboSexo.addItem("M");
		this.comboSexo.addItem("F");
		this.btnVolver = new JButton("Volver");
		this.btnCrear = new JButton("Crear persona");
		this.btnCrear.setActionCommand(COMANDO_CREAR);
		panel = new JPanel();
		panel.setLayout(new GridLayout(6, 6));
		panel.add(labelNombre);
		panel.add(txtNombre);
		panel.add(labelApellido);
		panel.add(txtApellido);
		panel.add(labelTelefono);
		panel.add(txtTelefono);
		panel.add(labelEdad);
		panel.add(txtEdad);
		panel.add(labelCedula);
		panel.add(txtCedula);
		panel.add(labelSexo);
		panel.add(comboSexo);
		panelBotones = new JPanel();
		panelBotones.setLayout(new GridLayout(1, 2));
		panelBotones.add(btnCrear);
		panelBotones.add(btnVolver);
		add(panel, BorderLayout.CENTER);
		add(panelBotones, BorderLayout.PAGE_END);
	}
	
	
	public void limpiarPanel() {
		txtNombre.setText("");
		txtApellido.setText("");
		txtTelefono.setText("");
		txtEdad.setText("");
		txtCedula.setText("");
		comboSexo.setSelectedIndex(0);
	}
	
	public String[] verificarEntradas() {
		String[] entradas = new String[7];
		entradas[0] = "0";
		if (!"".equals(txtNombre.getText()) && !"".equals(txtCedula.getText()) && !"".equals(txtApellido.getText())
				&& !"".equals(txtEdad.getText())
				&& !"Seleccione".equals(comboSexo.getSelectedItem().toString()) && !"".equals(txtTelefono.getText())) {
			entradas[1] = txtNombre.getText();
			entradas[2] = txtApellido.getText();
			entradas[3] = txtTelefono.getText();
			entradas[4] = txtEdad.getText();
			entradas[5] = txtCedula.getText();
			entradas[6] = comboSexo.getSelectedItem().toString();
		} else {
			entradas[0] = "1";
			entradas[1] = "Por favor complete todos los campos";
		}
		return entradas;
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
	 * @return the labelApellido
	 */
	public JLabel getLabelApellido() {
		return labelApellido;
	}

	/**
	 * @param labelApellido the labelApellido to set
	 */
	public void setLabelApellido(JLabel labelApellido) {
		this.labelApellido = labelApellido;
	}

	/**
	 * @return the labelTelefono
	 */
	public JLabel getLabelTelefono() {
		return labelTelefono;
	}

	/**
	 * @param labelTelefono the labelTelefono to set
	 */
	public void setLabelTelefono(JLabel labelTelefono) {
		this.labelTelefono = labelTelefono;
	}

	/**
	 * @return the labelEdad
	 */
	public JLabel getLabelEdad() {
		return labelEdad;
	}

	/**
	 * @param labelEdad the labelEdad to set
	 */
	public void setLabelEdad(JLabel labelEdad) {
		this.labelEdad = labelEdad;
	}

	/**
	 * @return the labelCedula
	 */
	public JLabel getLabelCedula() {
		return labelCedula;
	}

	/**
	 * @param labelCedula the labelCedula to set
	 */
	public void setLabelCedula(JLabel labelCedula) {
		this.labelCedula = labelCedula;
	}

	/**
	 * @return the labelSexo
	 */
	public JLabel getLabelSexo() {
		return labelSexo;
	}

	/**
	 * @param labelSexo the labelSexo to set
	 */
	public void setLabelSexo(JLabel labelSexo) {
		this.labelSexo = labelSexo;
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
	 * @return the txtApellido
	 */
	public JTextField getTxtApellido() {
		return txtApellido;
	}

	/**
	 * @param txtApellido the txtApellido to set
	 */
	public void setTxtApellido(JTextField txtApellido) {
		this.txtApellido = txtApellido;
	}

	/**
	 * @return the txtTelefono
	 */
	public JTextField getTxtTelefono() {
		return txtTelefono;
	}

	/**
	 * @param txtTelefono the txtTelefono to set
	 */
	public void setTxtTelefono(JTextField txtTelefono) {
		this.txtTelefono = txtTelefono;
	}

	/**
	 * @return the txtEdad
	 */
	public JTextField getTxtEdad() {
		return txtEdad;
	}

	/**
	 * @param txtEdad the txtEdad to set
	 */
	public void setTxtEdad(JTextField txtEdad) {
		this.txtEdad = txtEdad;
	}

	/**
	 * @return the txtCedula
	 */
	public JTextField getTxtCedula() {
		return txtCedula;
	}

	/**
	 * @param txtCedula the txtCedula to set
	 */
	public void setTxtCedula(JTextField txtCedula) {
		this.txtCedula = txtCedula;
	}

	/**
	 * @return the comboSexo
	 */
	public JComboBox<String> getComboSexo() {
		return comboSexo;
	}

	/**
	 * @param comboSexo the comboSexo to set
	 */
	public void setComboSexo(JComboBox<String> comboSexo) {
		this.comboSexo = comboSexo;
	}

	/**
	 * @return the btnCrear
	 */
	public JButton getBtnCrear() {
		return btnCrear;
	}

	/**
	 * @param btnCrear the btnCrear to set
	 */
	public void setBtnCrear(JButton btnCrear) {
		this.btnCrear = btnCrear;
	}

	/**
	 * @return the btnVolver
	 */
	public JButton getBtnVolver() {
		return btnVolver;
	}

	/**
	 * @param btnVolver the btnVolver to set
	 */
	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
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
	 * @return the cOMANDO_CREAR
	 */
	public String getCOMANDO_CREAR() {
		return COMANDO_CREAR;
	}

	/**
	 * @return the cOMANDO_VOLVER
	 */
	public String getCOMANDO_VOLVER() {
		return COMANDO_VOLVER;
	}
	
}
