package vistas;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import entidades.Lugar;

public class FormHome extends JPanel implements ActionListener {

	private JButton botonCrearLugar, botonAdministrarLugares, botonListarLugares;

	private PanelManager panelManager;

	public FormHome(PanelManager m) {

		this.panelManager = m;

	}

	public void armarFormHome() {

		this.setLayout((new BoxLayout(this, BoxLayout.Y_AXIS)));

		botonCrearLugar = new JButton("Crear lugar");
		botonAdministrarLugares = new JButton("Administrar lugares");
		botonListarLugares = new JButton("Listar lugares");

		this.add(botonCrearLugar);
		this.add(botonAdministrarLugares);
		this.add(botonListarLugares);

		botonCrearLugar.addActionListener(this);
		botonAdministrarLugares.addActionListener(this);
		botonListarLugares.addActionListener(this);

		setVisible(true);

	}

	public void actionPerformed(ActionEvent accion) {

		if (accion.getSource() == botonCrearLugar) {

			panelManager.mostrarFormCrearLugar();

		} else if (accion.getSource() == botonAdministrarLugares) {
			
			Lugar lugar = new Lugar();
			List<Lugar> lugaresListados = lugar.listarLugares();
			panelManager.mostrarFormAdministrarLugar(lugaresListados);

		} else if (accion.getSource() == botonListarLugares) {

			Lugar lugar = new Lugar();
			List<Lugar> lugaresListados = lugar.listarLugares();
			panelManager.mostrarFormListarLugares(lugaresListados);

		}

	}

}
