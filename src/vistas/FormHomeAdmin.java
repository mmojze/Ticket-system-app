package vistas;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import entidades.Lugar;
import entidades.Usuario;

public class FormHomeAdmin extends AbstractFormHome {

	private JButton botonCrearLugar, botonAdministrarLugares, botonListarLugares;

	public FormHomeAdmin(PanelManager panelManager) {

		super(panelManager);

	}

	public void armarFormHomeAdmin() {

		botonCrearLugar = new JButton("Crear lugar");
		botonAdministrarLugares = new JButton("Administrar lugares");
		botonListarLugares = new JButton("Listar lugares");

		this.add(botonCrearLugar);
		this.add(botonAdministrarLugares);
		this.add(botonListarLugares);

		botonCrearLugar.addActionListener(this);
		botonAdministrarLugares.addActionListener(this);
		botonListarLugares.addActionListener(this);

	}

	public void actionPerformed(ActionEvent accion) {

		if (accion.getSource() == botonCrearLugar) {

			panelManager.mostrarFormLugarCrear();

		} else if (accion.getSource() == botonAdministrarLugares) {

			Lugar lugar = new Lugar();
			List<Lugar> lugaresListados = lugar.listarLugares();
			panelManager.mostrarFormLugarAdministrar(lugaresListados);

		} else if (accion.getSource() == botonListarLugares) {

			Lugar lugar = new Lugar();
			List<Lugar> lugaresListados = lugar.listarLugares();
			panelManager.mostrarFormLugarListar(lugaresListados);

		}

	}

}
