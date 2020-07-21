package vistas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import entidades.Lugar;
import tablemodels.ListarLugaresTableModel;

public class FormLugarListar extends AbstractFormTable {

	private ListarLugaresTableModel ListarLugaresTableModel;

	public FormLugarListar(PanelManager panelManager) {

		super(panelManager);

	}

	public void armarFormLugarListar() {

		ListarLugaresTableModel = new ListarLugaresTableModel(contenidoTable);
		tabla = new JTable(ListarLugaresTableModel);
		scrollTabla = new JScrollPane(tabla);
		this.add(scrollTabla);
		addBotonVolver();

	}

	public void setLugares(List<Lugar> lugaresObtenidos) {

		ListarLugaresTableModel.setContenido(lugaresObtenidos);
		ListarLugaresTableModel.fireTableDataChanged();

	}

	public void actionPerformed(ActionEvent accion) {

		if (accion.getSource() == botonVolver) {

			panelManager.mostrarFormHomeAdmin(null);

		}

	}

}
