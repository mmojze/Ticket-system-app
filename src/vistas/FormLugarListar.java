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

public class FormLugarListar extends JPanel implements ActionListener {

	private PanelManager panelManager;
	private ListarLugaresTableModel ListarLugaresTableModel;
	private List<Lugar> lugares;
	private JTable tablaLugares;
	private JScrollPane scrollPaneParaTabla;
	private JButton botonVolver;

	public FormLugarListar(PanelManager panelManager) {

		this.panelManager = panelManager;

	}

	public void armarFormLugarListar() {

		GridLayout grid = new GridLayout(5, 6, 5, 5);
		this.setLayout(grid);
		this.setSize(1000, 1000);

		ListarLugaresTableModel = new ListarLugaresTableModel(lugares);
		tablaLugares = new JTable(ListarLugaresTableModel);
		scrollPaneParaTabla = new JScrollPane(tablaLugares);
		this.add(scrollPaneParaTabla);

		botonVolver = new JButton("Volver");
		botonVolver.addActionListener(this);
		this.add(botonVolver);

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
