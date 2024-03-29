package vistas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import dao.LugarDAO;
import dao.LugarDAOH2;
import entidades.Lugar;
import entidades.Ubicacion;
import exceptions.ArchivoNoExisteException;
import exceptions.ServiceErrorDeConexionBDException;
import exceptions.ServiceErrorEjecucionSentenciaException;
import exceptions.ServiceNoHayDatosException;
import servicios.LugarService;
import utilidades.OperacionesImagenes;

public class FormLugarCrear extends AbstractFormLugar {

	private JButton botonCargarImagen;
	private JButton botonBorrarImagen;
	private String nombreImagen;
	private JButton botonVolver;

	public FormLugarCrear(PanelManager panelManager) {
		super(panelManager);

	}

	public void armarFormLugarCrear() {

		GridLayout grid = new GridLayout(5, 6, 5, 5);
		this.setLayout(grid);

		botonCargarImagen = new JButton("Cargar imagen");
		botonCargarImagen.addActionListener(this);

		botonBorrarImagen = new JButton("Borrar imagen");
		botonBorrarImagen.addActionListener(this);

		botonVolver = new JButton("Volver");
		botonVolver.addActionListener(this);

		this.add(botonCargarImagen);
		this.add(botonBorrarImagen);
		this.add(botonVolver);

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
				List<Ubicacion> ubicaciones = new ArrayList<Ubicacion>(); 
				Lugar nuevoLugar = new Lugar(tNombreEstadio.getText(), tDireccion.getText(), capacidad, nombreImagen, ubicaciones, 0);
				LugarService servicio = new LugarService();

				try {
					int idGenerado = servicio.crearLugar(nuevoLugar);
					nuevoLugar.setIdLugar(idGenerado);
				} catch (ServiceErrorDeConexionBDException e) {
					JOptionPane.showMessageDialog(this, "Error", "Hubo un error de conexi�n a la base de datos",
							JOptionPane.ERROR_MESSAGE);
				} catch (ServiceErrorEjecucionSentenciaException e) {
					JOptionPane.showMessageDialog(this, "Error", "No se pudo crear el lugar",
							JOptionPane.ERROR_MESSAGE);
				}

				JOptionPane.showMessageDialog(popupEstadio, "Lugar creado con �xito");

				panelManager.mostrarFormUbicacionABM(nuevoLugar);

			}

		} else if (accion.getSource() == botonBorrarImagen) {

			try {
				OperacionesImagenes.borrarImagen(this.nombreImagen, OperacionesImagenes.DIR_IMG_LUGAR);
			} catch (ArchivoNoExisteException e) {
				JOptionPane.showMessageDialog(popupEstadio, "El archivo no existe o ninguna imagen fue cargada");
			}

			this.nombreImagen = null;
			JOptionPane.showMessageDialog(popupEstadio, "Imagen borrada");

		} else if (accion.getSource() == botonVolver) {

			panelManager.mostrarFormHomeAdmin();

		}

	}

}
