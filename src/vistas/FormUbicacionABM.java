package vistas;

import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import entidades.Lugar;
import entidades.Ubicacion;
import exceptions.ArchivoNoExisteException;
import exceptions.ServiceErrorDeConexionBDException;
import exceptions.ServiceErrorEjecucionSentenciaException;
import servicios.UbicacionService;
import tablemodels.UbicacionTableModel;
import utilidades.OperacionesImagenes;

public class FormUbicacionABM extends AbstractFormTable {

	private JButton botonAgregar;
	private JButton botonBorrar;
	private JButton botonBorrarImagen;
	private JButton botonModificar;
	private JButton botonFinalizar;
	private JTextField tCapacidad;
	private JTextField tNombre;
	private JLabel lNombre;
	private JLabel lCapacidad;
	private JButton botonCargarImagen;
	private UbicacionTableModel UbicacionTableModel;
	private Lugar lugar;
	private int totalCapacidadUbicaciones;
	private String fotoUbicacion;
	private List<Ubicacion> ubicaciones;
	private boolean modificarUbicacion;
	private int idUbicacionModificar;

	public FormUbicacionABM(PanelManager panelManager) {
		super(panelManager);
	}

	public void setLugar(Lugar lugar) {

		this.lugar = lugar;

	}

	public Lugar getLugar() {

		return this.lugar;

	}

	public List<Ubicacion> getUbicaciones() {
		return ubicaciones;
	}

	public void setUbicaciones(List<Ubicacion> ubicaciones) {
		this.ubicaciones = ubicaciones;
	}

	public UbicacionTableModel getUbicacionTableModel() {
		return UbicacionTableModel;
	}

	public void setUbicacionTableModel(UbicacionTableModel ubicacionTableModel) {
		UbicacionTableModel = ubicacionTableModel;
	}

	public int getTotalCapacidadUbicaciones() {
		return totalCapacidadUbicaciones;
	}

	public void setTotalCapacidadUbicaciones(int totalCapacidadUbicaciones) {
		this.totalCapacidadUbicaciones = totalCapacidadUbicaciones;
	}

	public void armarFormUbicacionABM() {

		ubicaciones = new ArrayList<Ubicacion>();
		
		lNombre = new JLabel("Nombre");
		this.add(lNombre);
		tNombre = new JTextField();
		this.add(tNombre);

		lCapacidad = new JLabel("Capacidad");
		this.add(lCapacidad);
		tCapacidad = new JTextField();
		this.add(tCapacidad);

		botonAgregar = new JButton("Agregar ubicacion");
		botonAgregar.addActionListener(this);
		this.add(botonAgregar);

		botonCargarImagen = new JButton("Cargar imagen");
		botonCargarImagen.addActionListener(this);
		this.add(botonCargarImagen);

		botonBorrarImagen = new JButton("Borrar Imagen");
		botonBorrarImagen.addActionListener(this);
		this.add(botonBorrarImagen);

		UbicacionTableModel = new UbicacionTableModel(ubicaciones);
		tabla = new JTable(UbicacionTableModel);
		scrollTabla = new JScrollPane(tabla);
		this.add(scrollTabla);

		botonModificar = new JButton("Modificar ubicacion");
		botonModificar.addActionListener(this);
		this.add(botonModificar);

		botonBorrar = new JButton("Borrar ubicacion");
		botonBorrar.addActionListener(this);
		this.add(botonBorrar);

		botonFinalizar = new JButton("Finalizar");
		botonFinalizar.addActionListener(this);
		this.add(botonFinalizar);

		this.totalCapacidadUbicaciones = 0;

	}

	public void actionPerformed(ActionEvent accion) {

		if (accion.getSource() == botonAgregar) {

			if (tCapacidad.getText().isEmpty() == true || tNombre.getText().isEmpty() == true) {

				JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos");

			} else if (this.fotoUbicacion == null) {

				JOptionPane.showMessageDialog(this, "Por favor, cargue una foto a la ubicación");

			} else {

				Integer capacidad = Integer.parseInt(tCapacidad.getText());
				Ubicacion ubicacion = new Ubicacion(this.lugar, tNombre.getText(), capacidad, this.fotoUbicacion,
						this.idUbicacionModificar);
				totalCapacidadUbicaciones = totalCapacidadUbicaciones + capacidad;

				if (this.totalCapacidadUbicaciones > lugar.getCapacidadTotal()) {

					this.totalCapacidadUbicaciones = this.totalCapacidadUbicaciones - capacidad;
					JOptionPane.showMessageDialog(this,
							"Se excedio de la capacidad total del estadio, por favor revise las capacidad de la ubicación");
					System.out.println(this.totalCapacidadUbicaciones);
				} else {

					UbicacionService servicio = new UbicacionService();

					try {
						if (this.modificarUbicacion == true) {
							servicio.modificarUbicacion(ubicacion);
							this.modificarUbicacion = false;
							this.idUbicacionModificar = 0;
						} else {
							int idGenerado = servicio.crearUbicacion(ubicacion, this.lugar);
							ubicacion.setIdUbicacion(idGenerado);
						}

						UbicacionTableModel.getContenido().add(ubicacion);
						UbicacionTableModel.fireTableDataChanged();

						this.tCapacidad.setText(null);
						this.tNombre.setText(null);
						this.fotoUbicacion = null;

					} catch (ServiceErrorDeConexionBDException e) {
						JOptionPane.showMessageDialog(this, "Error", "Hubo un error de conexión a la base de datos",
								JOptionPane.ERROR_MESSAGE);
					} catch (ServiceErrorEjecucionSentenciaException e) {
						JOptionPane.showMessageDialog(this, "Error", "Hubo un error al crear o modificar la ubicación",
								JOptionPane.ERROR_MESSAGE);
					}

				}

			}

		} else if (accion.getSource() == botonCargarImagen) {

			File imagenCargada = OperacionesImagenes.cargarImagen(OperacionesImagenes.DIR_IMG_UBICACION);
			this.fotoUbicacion = imagenCargada.getName();

		} else if (accion.getSource() == botonModificar) {

			int filaSeleccionada = this.tabla.getSelectedRow();
			Ubicacion ubicacion = this.UbicacionTableModel.getContenido().get(filaSeleccionada);
			this.fotoUbicacion = ubicacion.getFotoUbicacion();
			this.tNombre.setText(ubicacion.getNombre());
			this.tCapacidad.setText(Integer.toString(ubicacion.getCapacidad()));
			this.idUbicacionModificar = ubicacion.getIdUbicacion();
			this.UbicacionTableModel.getContenido().remove(filaSeleccionada);
			this.modificarUbicacion = true;
			this.totalCapacidadUbicaciones = totalCapacidadUbicaciones - ubicacion.getCapacidad();

		} else if (accion.getSource() == botonBorrar) {

			int filaSeleccionada = this.tabla.getSelectedRow();
			Ubicacion ubicacion = this.UbicacionTableModel.getContenido().get(filaSeleccionada);
			UbicacionService servicio = new UbicacionService();

			try {
				servicio.borrarUbicacion(ubicacion);
				this.totalCapacidadUbicaciones = totalCapacidadUbicaciones - ubicacion.getCapacidad();
				this.UbicacionTableModel.getContenido().remove(filaSeleccionada);
				UbicacionTableModel.fireTableDataChanged();
				this.fotoUbicacion = null;
			} catch (ServiceErrorDeConexionBDException e) {
				JOptionPane.showMessageDialog(this, "Error", "Hubo un error de conexión a la base de datos",
						JOptionPane.ERROR_MESSAGE);
			} catch (ServiceErrorEjecucionSentenciaException e) {
				JOptionPane.showMessageDialog(this, "Error", "No se pudo crear el lugar", JOptionPane.ERROR_MESSAGE);
			}

		} else if (accion.getSource() == botonFinalizar) {

			if (totalCapacidadUbicaciones == lugar.getCapacidadTotal()) {
				JOptionPane.showMessageDialog(this, "Estadio y ubicaciones creado con éxito");
				System.out.println(this.totalCapacidadUbicaciones);
			} else if (this.totalCapacidadUbicaciones < lugar.getCapacidadTotal()) {
				JOptionPane.showMessageDialog(this,
						"Faltan agregar ubicaciones para completar la capacidad total del estadio");
				System.out.println(this.totalCapacidadUbicaciones);
			}

		} else if (accion.getSource() == botonBorrarImagen) {

			try {
				OperacionesImagenes.borrarImagen(this.fotoUbicacion, OperacionesImagenes.DIR_IMG_UBICACION);
				this.fotoUbicacion = null;
				JOptionPane.showMessageDialog(this, "Imagen borrada");
			} catch (ArchivoNoExisteException e) {
				JOptionPane.showMessageDialog(this, "El archivo no existe o ninguna imagen fue cargada");
			}

		}

	}

}
