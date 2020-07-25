package vistas;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import entidades.Ubicacion;
import tablemodels.UbicacionTableModel;

public class FormUbicacionListar extends AbstractFormTable {

	private UbicacionTableModel UbicacionTableModel;
	
	public UbicacionTableModel getUbicacionTableModel() {
		return UbicacionTableModel;
	}

	public void setUbicacionTableModel(UbicacionTableModel ubicacionTableModel) {
		UbicacionTableModel = ubicacionTableModel;
	}

	private JButton botonVer;

	public FormUbicacionListar(PanelManager panelManager) {
		super(panelManager);
	}

	public void armarUbicacionListar() {
		
		contenidoTable = new ArrayList<>();

		UbicacionTableModel = new UbicacionTableModel(contenidoTable);
		tabla = new JTable(UbicacionTableModel);
		scrollTabla = new JScrollPane(tabla);
		
		botonVer = new JButton("Ver");
		
		this.add(botonVer);
		botonVer.addActionListener(this);
		
		
		this.add(scrollTabla);
		addBotonVolver();

	}

	public void actionPerformed(ActionEvent accion) {
		
		if (accion.getSource() == botonVer) { 
			
			int filaSeleccionada = this.tabla.getSelectedRow();
			Ubicacion ubicacion = this.UbicacionTableModel.getContenido().get(filaSeleccionada);
			panelManager.mostrarFormUbicacionVisualizar(ubicacion);
			
			
		}
		
	}

}
