package vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import dao.LugarDAO;
import dao.LugarDAOH2;
import entidades.Lugar;
import entidades.Ubicacion;
import exceptions.ServiceException;
import servicios.LugarService;
import servicios.UbicacionService;

public class FormLugarModificar extends AbstractFormLugar {

	private JButton botonCargarImagen;
	private JButton botonBorrarImagen;
	private int capacidadOriginal;

	public FormLugarModificar(PanelManager panelManager) {
		super(panelManager);
	}

	public int getCapacidadOriginal() {
		return capacidadOriginal;
	}

	public void setCapacidadOriginal(int capacidadOriginal) {
		this.capacidadOriginal = capacidadOriginal;
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

		/*
		 * 
		 * if (accion.getSource() == botonCargarImagen) {
		 * 
		 * //File archivo =
		 * OperacionesImagenes.cargarImagen(OperacionesImagenes.DIR_IMG_LUGAR);
		 * //nombreImagen = archivo.getName();
		 * 
		 * } else if (accion.getSource() == siguiente) {
		 * 
		 * if (tNombreEstadio.getText().isEmpty() == true ||
		 * tDireccion.getText().isEmpty() == true || tCapacidad.getText().isEmpty() ==
		 * true) {
		 * 
		 * JOptionPane.showMessageDialog(popupEstadio,
		 * "Por favor, complete todos los datos obligatorios");
		 * 
		 * } else if (nombreImagen == null) {
		 * 
		 * JOptionPane.showMessageDialog(popupEstadio, "Por favor, cargue una imagen");
		 * 
		 * } else {
		 * 
		 * int capacidad = Integer.parseInt(tCapacidad.getText());
		 * 
		 * Lugar lugarModificado = new Lugar(tNombreEstadio.getText(),
		 * tDireccion.getText(), capacidad, nombreImagen, this.lugar.getIdLugar());
		 * 
		 * LugarService servicio = new LugarService();
		 * 
		 * try { servicio.modificarLugar(lugarModificado);
		 * JOptionPane.showMessageDialog(popupEstadio, "Lugar modificado con éxito");
		 * UbicacionService servicioUbicacion = new UbicacionService(); List<Ubicacion>
		 * ubicaciones = servicioUbicacion.listarUbicacionesPorLugar(lugarModificado);
		 * lugarModificado.setUbicacionesDeLugar(ubicaciones);
		 * lugarModificado.setCapacidadUtilizada(this.capacidadOriginal);
		 * panelManager.mostrarFormUbicacionABM(lugarModificado); } catch
		 * (ServiceException e) { JOptionPane.showMessageDialog(this, "Error",
		 * "No hay ubicaciones para éste lugar", JOptionPane.ERROR_MESSAGE); }
		 * 
		 * }
		 * 
		 * } else if (accion.getSource() == botonBorrarImagen) {
		 * 
		 * 
		 * try { OperacionesImagenes.borrarImagen(this.nombreImagen,
		 * OperacionesImagenes.DIR_IMG_LUGAR); } catch (ArchivoNoExisteException e) {
		 * JOptionPane.showMessageDialog(popupEstadio,
		 * "El archivo no existe o ninguna imagen fue cargada"); }
		 * 
		 * this.nombreImagen = null; JOptionPane.showMessageDialog(popupEstadio,
		 * "Imagen borrada");
		 * 
		 * 
		 * }
		 * 
		 */

	}

}
