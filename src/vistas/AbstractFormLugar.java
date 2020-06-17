package vistas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.LugarDAO;
import dao.LugarDAOH2;
import entidades.Lugar;
import exceptions.ArchivoNoExisteException;
import utilidades.OperacionesImagenes;

public abstract class AbstractFormLugar extends JPanel implements ActionListener {

	protected PanelManager panelManager;
	protected JButton siguiente;
	protected JLabel lNombreEstadio;
	protected JTextField tNombreEstadio;
	protected JLabel lCapacidad;
	protected JTextField tCapacidad;
	protected JLabel lDireccion;
	protected JTextField tDireccion;
	//protected JButton cargarImagen;
	//protected String nombreImagen;
	protected JFrame popupEstadio;
	//protected JButton botonBorrarImagen;

	public AbstractFormLugar(PanelManager panelManager) {

		this.panelManager = panelManager;
		armarFormLugar();

	}

	public void armarFormLugar() {

		GridLayout grid = new GridLayout(2, 2);
		this.setLayout(grid);
		this.setSize(1000, 1000);

		lNombreEstadio = new JLabel("Nombre del estadio");
		this.add(lNombreEstadio);
		tNombreEstadio = new JTextField();
		this.add(lNombreEstadio);

		lCapacidad = new JLabel("Capacidad total");
		tCapacidad = new JTextField();
		lDireccion = new JLabel("Dirección");
		tDireccion = new JTextField();
		siguiente = new JButton("Siguiente");
		siguiente.setLocation(50, 50);
		siguiente.addActionListener(this);
		
		//cargarImagen = new JButton("Cargar imagen");
		//cargarImagen.addActionListener(this);
		

		
		//botonBorrarImagen = new JButton("Borrar imagen");
		//botonBorrarImagen.addActionListener(this);

		this.add(tNombreEstadio);
		this.add(lCapacidad);
		this.add(tCapacidad);
		this.add(lDireccion);
		this.add(tDireccion);
		this.add(siguiente);
		
		//this.add(cargarImagen);
		//this.add(botonBorrarImagen);


		setVisible(true);

	}

	public abstract void actionPerformed(ActionEvent accion);

}
