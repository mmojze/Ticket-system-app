package vistas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import entidades.Lugar;
import entidades.Ubicacion;
import exceptions.ServiceException;
import servicios.UbicacionService;
import tablemodels.ListarLugaresTableModel;

public class FormLugarListar extends AbstractFormTable {

	private ListarLugaresTableModel ListarLugaresTableModel;
	private JButton botonListarUbicaciones;

	public FormLugarListar(PanelManager panelManager) {

		super(panelManager);

	}

	public void armarFormLugarListar() {

		ListarLugaresTableModel = new ListarLugaresTableModel(contenidoTable);
		tabla = new JTable(ListarLugaresTableModel);
		scrollTabla = new JScrollPane(tabla);
		this.add(scrollTabla);
		addBotonVolver();

		botonListarUbicaciones = new JButton("Listar ubicaciones");
		this.add(botonListarUbicaciones);
		botonListarUbicaciones.addActionListener(this);

	}

	public void setLugares(List<Lugar> lugaresObtenidos) {

		ListarLugaresTableModel.setContenido(lugaresObtenidos);
		ListarLugaresTableModel.fireTableDataChanged();

	}

	public void actionPerformed(ActionEvent accion) {

		if (accion.getSource() == botonVolver) {

			panelManager.mostrarFormHomeAdmin();

		} else if (accion.getSource() == botonListarUbicaciones) {
			
			int filaSeleccionada = this.tabla.getSelectedRow();
			Lugar lugar = this.ListarLugaresTableModel.getContenido().get(filaSeleccionada);
			UbicacionService servicio = new UbicacionService();
			
			try {
				List<Ubicacion> ubicaciones = servicio.listarUbicacionesPorLugar(lugar);
				panelManager.mostrarFormUbicacionListar(ubicaciones);
			} catch (ServiceException e) {
				JOptionPane.showMessageDialog(this, "Error", "No hay datos de ubicación para este lugar",
						JOptionPane.ERROR_MESSAGE);
			}
			
			
		}

	}

}
