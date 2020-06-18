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
import utilidades.OperacionesImagenes;

public class FormModificarLugar extends AbstractFormLugar {

	private JButton botonCargarImagen;
	private JButton botonBorrarImagen;
	private String nombreImagen;
	
	public FormModificarLugar(PanelManager panelManager) {
		super(panelManager);
	}
	
	public void armarFormModificarLugar() { 
		
		botonCargarImagen = new JButton("Cargar imagen");
		botonCargarImagen.addActionListener(this);

		botonBorrarImagen = new JButton("Borrar imagen");
		botonBorrarImagen.addActionListener(this);
		
		this.add(botonCargarImagen);
		this.add(botonBorrarImagen);
		
	}
	
	@Override
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

				Lugar nuevoLugar = new Lugar(tNombreEstadio.getText(), tDireccion.getText(), capacidad, nombreImagen);

				LugarDAO altaLugar = new LugarDAOH2();
				
				// Insertar modificacion
				
				int idLugar = altaLugar.crearLugar(nuevoLugar);

				nuevoLugar.setIdLugar(idLugar);

				//panelManager.mostrarFormUbicacion(nuevoLugar);
				
				// Insertar modificación 
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


