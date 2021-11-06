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
import exceptions.ServiceException;
import servicios.LugarService;

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

		if (accion.getSource() == siguiente) {

			if (tNombreEstadio.getText().isEmpty() == true || tDireccion.getText().isEmpty() == true
					|| tCapacidad.getText().isEmpty() == true) {

				JOptionPane.showMessageDialog(popupEstadio, "Por favor, complete todos los datos obligatorios");

			} else {

				int capacidad = Integer.parseInt(tCapacidad.getText());
				List<Ubicacion> ubicaciones = new ArrayList<Ubicacion>(); 
				Lugar nuevoLugar = new Lugar(tNombreEstadio.getText(), tDireccion.getText(), capacidad, nombreImagen, ubicaciones, 0);
				LugarService servicio = new LugarService();

				try {
					nuevoLugar = servicio.crearLugar(nuevoLugar);
				} catch (ServiceException e) {
					JOptionPane.showMessageDialog(this, "Error", "No se pudo crear el lugar",
							JOptionPane.ERROR_MESSAGE);
				}

				JOptionPane.showMessageDialog(popupEstadio, "Lugar creado con éxito");

				panelManager.mostrarFormUbicacionABM(nuevoLugar);

			}

		} else if (accion.getSource() == botonVolver) {

			panelManager.mostrarFormHomeAdmin();

		}

	}

}
