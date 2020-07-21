package vistas;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import entidades.Lugar;
import exceptions.ServiceErrorDeConexionBDException;
import exceptions.ServiceErrorEjecucionSentenciaException;
import servicios.LugarService;
import tablemodels.LugarTableModel;

public class FormLugarAdministrar extends AbstractFormTable {

	private LugarTableModel LugarTableModel;

	public FormLugarAdministrar(PanelManager panelManager) {

		super(panelManager);

	}

	public void armarFormLugarAdministrar() {

		LugarTableModel = new LugarTableModel(contenidoTable);
		tabla = new JTable(LugarTableModel);
		scrollTabla = new JScrollPane(tabla);
		this.add(scrollTabla);

	}

	public void setLugares(List<Lugar> lugares) {

		LugarTableModel.setContenido(lugares);
		LugarTableModel.fireTableDataChanged();
		addBotonesAdministrar();
		addBotonVolver();

	}

	public void actionPerformed(ActionEvent accion) {

		if (accion.getSource() == botonBorrar) {

			int filaSeleccionada = this.tabla.getSelectedRow();
			Lugar lugar = this.LugarTableModel.getContenido().get(filaSeleccionada);

			try {
				LugarService servicio = new LugarService();
				servicio.borrarLugar(lugar);
				LugarTableModel.fireTableDataChanged();
			} catch (ServiceErrorDeConexionBDException | ServiceErrorEjecucionSentenciaException e) {
				JOptionPane.showMessageDialog(this, "Error", "Hubo un error de conexión a la base de datos",
						JOptionPane.ERROR_MESSAGE);
			}

			JOptionPane.showMessageDialog(this, "El lugar se ha borrado correctamente");

		} else if (accion.getSource() == botonModificar) {

			int filaSeleccionada = this.tabla.getSelectedRow();
			Lugar lugar = this.LugarTableModel.getContenido().get(filaSeleccionada);
			panelManager.mostrarFormModificarLugar(lugar);

		} else if (accion.getSource() == botonVisualizar) {

			int filaSeleccionada = this.tabla.getSelectedRow();
			Lugar lugar = this.LugarTableModel.getContenido().get(filaSeleccionada);
			panelManager.mostrarFormLugarVisualizar(lugar);

		} else if (accion.getSource() == botonVolver) {

			panelManager.mostrarFormHomeAdmin(null);

		}

	}

}
