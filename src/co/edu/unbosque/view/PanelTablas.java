package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

public class PanelTablas extends JPanel {

	private JTable tableClientes;

	public PanelTablas() {
		setLayout(new GridLayout(1, 1));
		setBackground(new Color(255, 255, 255));
		tableClientes = new JTable();
	}

	public void limpiarPanel() {
		this.removeAll();
		this.repaint();
	}

	public void mostrarTablaClientes(String[][] infoPersonas) {
		setBorder(new TitledBorder("Información de personas"));
		String[] titulos = { "Nombres", "Apellidos", "Telefono", "Edad", "Cédula", "Sexo" };
		tableClientes = new JTable(infoPersonas, titulos);
		JScrollPane sp = new JScrollPane(tableClientes);
		tableClientes.setDefaultEditor(tableClientes.getColumnClass(0), null);
		tableClientes.setRowHeight(20);
		tableClientes.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		sp.setViewportView(tableClientes);
		tableClientes.getTableHeader().setForeground(Color.black);
		tableClientes.getTableHeader().isBackgroundSet();
		tableClientes.getTableHeader().setEnabled(false);
		Font font = new Font("SansSerif", Font.BOLD, 12);
		tableClientes.setFont(font);
		tableClientes.getTableHeader().setFont(font);
		tableClientes.setGridColor(Color.white);
		add(sp);
		validate();
		tableClientes.repaint();
		sp.repaint();
	}
	
	public int verificarDatosTabla() {
		if (tableClientes.getSelectedRows().length == 1) {
			String[] cont = String.valueOf(tableClientes.getValueAt(tableClientes.getSelectedRow(), 3)).split("-");
			System.out.println(cont.length);
			if (cont.length == 1) {
				return 1;
			} else {
				return 0;
			}
		} else {
			return -1;
		}
	}
	
	public String[] obtenerDatosTabla() {
		String[] salida = new String[8];
		salida[0] = "0";
		if (tableClientes.getSelectedRows().length == 1) {
			salida[1] = String.valueOf(this.tableClientes.getValueAt(this.tableClientes.getSelectedRow(), 3));
			salida[2] = "La persona se ha borrado exitosamente ";
			salida[3] = String.valueOf(this.tableClientes.getValueAt(this.tableClientes.getSelectedRow(), 0));
			salida[4] = String.valueOf(this.tableClientes.getValueAt(this.tableClientes.getSelectedRow(), 1));
			salida[5] = String.valueOf(this.tableClientes.getValueAt(this.tableClientes.getSelectedRow(), 2));
			salida[6] = String.valueOf(this.tableClientes.getValueAt(this.tableClientes.getSelectedRow(), 4));
			salida[7] = String.valueOf(this.tableClientes.getValueAt(this.tableClientes.getSelectedRow(), 5));
		} else {
			salida[0] = "1";
			salida[1] = "Seleccione a una sola persona";
		}
		return salida;
	}

	public JTable getTableClientes() {
		return tableClientes;
	}

	public void setTableClientes(JTable tableClientes) {
		this.tableClientes = tableClientes;
	}

}
