package co.edu.unbosque.view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import co.edu.unbosque.controller.Controller;

public class Vista extends JFrame{


	
	private final String COMANDO_DAO_ARREGLO = "CREARCLIENTE";
	private final String COMANDO_DAO_BINARIO = "MOSTRARCLIENTE";
	private final String COMANDO_DAO_RELACIONAL = "INSERTARDWH";
	private final String COMANDO_DAO_NORELACIONAL = "INSERTARDWH";



	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem menuItem1, menuItem2, menuItem3, menuItem4;
	private JPanel panelPrincipal;
	private PanelArreglo panelArreglo;
	private PanelBinario panelBinario;
	private PanelSql panelSql;


	public Vista(Controller controller) {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(700, 430);
		this.setTitle("Estructura DAO");
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		panelPrincipal = new JPanel();
		panelPrincipal.setSize(700, 430);
		panelPrincipal.setLayout(null);
		menuBar = new JMenuBar();
		menu = new JMenu("Opciones");
		menuBar.add(menu);
		menuItem1 = new JMenuItem("Arreglo");
		menuItem1.setActionCommand(this.COMANDO_DAO_ARREGLO);
		menuItem2 = new JMenuItem("Archivo Binario");
		menuItem2.setActionCommand(this.COMANDO_DAO_BINARIO);
		menuItem3 = new JMenuItem("Base Relacional");
		menuItem3.setActionCommand(this.COMANDO_DAO_RELACIONAL);
		menuItem4 = new JMenuItem("Base No Relacional");
		menuItem4.setActionCommand(this.COMANDO_DAO_NORELACIONAL);
		menu.add(menuItem1);
		menu.add(menuItem2);
		menu.add(menuItem3);
		menu.add(menuItem4);
		
		panelArreglo = new PanelArreglo(controller);
		panelArreglo.setVisible(false);
		panelArreglo.setBounds(0, 0, 690, 370);
		
		panelBinario = new PanelBinario(controller);
		panelBinario.setVisible(false);
		panelBinario.setBounds(0, 0, 690, 370);
		
		panelSql = new PanelSql(controller);
		panelSql.setVisible(false);
		panelSql.setBounds(0, 0, 690, 370);
		
		panelPrincipal.add(panelArreglo);
		panelPrincipal.add(panelBinario);
		panelPrincipal.add(panelSql);
	
		setJMenuBar(menuBar);
		add(panelPrincipal);
		
		asignarOyentes(controller);
		repaint();
		revalidate();
	}

	public void asignarOyentes(Controller controller) {
		menuItem1.addActionListener(controller);
		menuItem2.addActionListener(controller);
		menuItem3.addActionListener(controller);
		menuItem4.addActionListener(controller);
		panelArreglo.getBtnAgregarPersona().addActionListener(controller);
		panelArreglo.getBtnVerInfo().addActionListener(controller);
		panelArreglo.getPanelAgregar().getBtnCrear().addActionListener(controller);
		panelBinario.getBtnAgregarPersona().addActionListener(controller);
		panelBinario.getBtnVerInfo().addActionListener(controller);
		panelBinario.getPanelAgregar().getBtnCrear().addActionListener(controller);
		panelSql.getBtnAgregarPersona().addActionListener(controller);
		panelSql.getBtnVerInfo().addActionListener(controller);
		panelSql.getPanelAgregar().getBtnCrear().addActionListener(controller);
	}
	
	/**
	 * Método encargado de mostrar un mensaje de advertencia.
	 * 
	 * @param mensaje
	 */
	public void mostrarMensajeAdvertencia(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Mensaje de advertencia", JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Método encargado de mostrar un mensaje informativo.
	 * 
	 * @param mensaje
	 */
	public void mostrarMensajeInformacion(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Método encargado de mostrar un mensaje de error.
	 * 
	 * @param mensaje
	 */
	public void mostrarMensajeError(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public String pedirDato(String mensaje) {
		String n = JOptionPane.showInputDialog(mensaje);
		if (n == null) {
			n = "Accion Cancelada";
		} else if ("".equals(n)) {
			n = "Por favor digite un valor";
		}
		return n;
	}

	/**
	 * @return the cOMANDO_DAO_ARREGLO
	 */
	public String getCOMANDO_DAO_ARREGLO() {
		return COMANDO_DAO_ARREGLO;
	}

	/**
	 * @return the cOMANDO_DAO_BINARIO
	 */
	public String getCOMANDO_DAO_BINARIO() {
		return COMANDO_DAO_BINARIO;
	}

	/**
	 * @return the cOMANDO_DAO_RELACIONAL
	 */
	public String getCOMANDO_DAO_RELACIONAL() {
		return COMANDO_DAO_RELACIONAL;
	}

	/**
	 * @return the cOMANDO_DAO_NORELACIONAL
	 */
	public String getCOMANDO_DAO_NORELACIONAL() {
		return COMANDO_DAO_NORELACIONAL;
	}

	/**
	 * @return the panelPrincipal
	 */
	public JPanel getPanelPrincipal() {
		return panelPrincipal;
	}

	/**
	 * @param panelPrincipal the panelPrincipal to set
	 */
	public void setPanelPrincipal(JPanel panelPrincipal) {
		this.panelPrincipal = panelPrincipal;
	}

	/**
	 * @return the panelArreglo
	 */
	public PanelArreglo getPanelArreglo() {
		return panelArreglo;
	}

	/**
	 * @param panelArreglo the panelArreglo to set
	 */
	public void setPanelArreglo(PanelArreglo panelArreglo) {
		this.panelArreglo = panelArreglo;
	}

	/**
	 * @return the panelBinario
	 */
	public PanelBinario getPanelBinario() {
		return panelBinario;
	}

	/**
	 * @param panelBinario the panelBinario to set
	 */
	public void setPanelBinario(PanelBinario panelBinario) {
		this.panelBinario = panelBinario;
	}

	/**
	 * @return the panelSql
	 */
	public PanelSql getPanelSql() {
		return panelSql;
	}

	/**
	 * @param panelSql the panelSql to set
	 */
	public void setPanelSql(PanelSql panelSql) {
		this.panelSql = panelSql;
	}
	
}
