package vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import dao.LugarDAO;
import dao.LugarDAOH2;
import entidades.Lugar;
import exceptions.ArchivoNoExisteException;
import exceptions.ServiceErrorDeConexionBDException;
import exceptions.ServiceErrorEjecucionSentenciaException;
import exceptions.ServiceNoHayDatosException;
import servicios.LugarService;
import utilidades.OperacionesImagenes;

public class FormLugarModificar extends AbstractFormLugar {

	private JButton botonCargarImagen;
	private JButton botonBorrarImagen;

	public FormLugarModificar(PanelManager panelManager) {
		super(panelManager);
	}

	public void armarFormLugarModificar() {

		botonCargarImagen = new JButton("Cargar imagen");
		botonCargarImagen.addActionListener(this);

		botonBorrarImagen = new JButton("Borrar imagen");
		botonBorrarImagen.addActionListener(this);

		this.add(botonCargarImagen);
		this.add(botonBorrarImagen);

	}

	public void actionPerformed(ActionEvent accion) {

		if (accion.getSource() == botonCargarImagen) {

			File archivo = OperacionesImagenes.cargarImagen(OperacionesImagenes.DIR_IMG_LUGAR);
			nombreImagen = archivo.getName();

		} else if (accion.getSource() == siguiente) {

			if (tNombreEstadio.getText().isEmpty() == true || tDireccion.getText().isEmpty() == true
					|| tCapacidad.getText().isEmpty() == true) {

				JOptionPane.showMessageDialog(popupEstadio, "Por favor, complete todos los datos obligatorios");

			} else if (nombreImagen == null) {

				JOptionPane.showMessageDialog(popupEstadio, "Por favor, cargue una imagen");

			} else {

				int capacidad = Integer.parseInt(tCapacidad.getText());

				Lugar lugarModificado = new Lugar(tNombreEstadio.getText(), tDireccion.getText(), capacidad,
						nombreImagen, this.lugar.getIdLugar());

				LugarService servicio = new LugarService();

				try {
					servicio.modificarLugar(lugarModificado);
				} catch (ServiceErrorDeConexionBDException e) {
					JOptionPane.showMessageDialog(this, "Error", "Hubo un error de conexión a la base de datos",
							JOptionPane.ERROR_MESSAGE);
				} catch (ServiceErrorEjecucionSentenciaException e) {
					JOptionPane.showMessageDialog(this, "Error", "No se pudo modificar el lugar",
							JOptionPane.ERROR_MESSAGE);
				}

				JOptionPane.showMessageDialog(popupEstadio, "Lugar modificado con éxito");

				panelManager.mostrarFormHomeAdmin(null);

			}

		} else if (accion.getSource() == botonBorrarImagen) {

			try {
				OperacionesImagenes.borrarImagen(this.nombreImagen, OperacionesImagenes.DIR_IMG_LUGAR);
			} catch (ArchivoNoExisteException e) {
				JOptionPane.showMessageDialog(popupEstadio, "El archivo no existe o ninguna imagen fue cargada");
			}

			this.nombreImagen = null;
			JOptionPane.showMessageDialog(popupEstadio, "Imagen borrada");

		}

	}

}
