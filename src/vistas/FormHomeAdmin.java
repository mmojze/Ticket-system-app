package vistas;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import entidades.Lugar;
import entidades.Usuario;
import exceptions.ServiceErrorDeConexionBDException;
import exceptions.ServiceErrorEjecucionSentenciaException;
import exceptions.ServiceNoHayDatosException;
import servicios.LugarService;

public class FormHomeAdmin extends AbstractFormHome {

	private JButton botonCrearLugar, botonAdministrarLugares, botonListarLugares, botonCrearEspectaculo, botonGestionarEspectaculos;

	public FormHomeAdmin(PanelManager panelManager) {

		super(panelManager);

	}

	public void armarFormHomeAdmin() {

		botonCrearLugar = new JButton("Crear lugar");
		botonAdministrarLugares = new JButton("Gestionar lugares");
		botonListarLugares = new JButton("Listar lugares (deprecado)");
		botonCrearEspectaculo = new JButton("Crear espectaculo");
		botonGestionarEspectaculos = new JButton("Gestionar espectaculos");
		
		this.add(botonCrearLugar);
		this.add(botonAdministrarLugares);
		this.add(botonListarLugares);
		this.add(botonCrearEspectaculo);
		this.add(botonGestionarEspectaculos);


		botonCrearLugar.addActionListener(this);
		botonAdministrarLugares.addActionListener(this);
		botonListarLugares.addActionListener(this);
		botonCrearEspectaculo.addActionListener(this);
		botonGestionarEspectaculos.addActionListener(this);


	}

	public void actionPerformed(ActionEvent accion) {

		if (accion.getSource() == botonCrearLugar) {

			panelManager.mostrarFormLugarCrear();

		} else if (accion.getSource() == botonAdministrarLugares) {

			LugarService servicio = new LugarService();
			List<Lugar> lugaresListados;

			try {
				lugaresListados = servicio.listarLugares();
				panelManager.mostrarFormLugarAdministrar(lugaresListados);
			} catch (ServiceErrorDeConexionBDException | ServiceErrorEjecucionSentenciaException e) {
				JOptionPane.showMessageDialog(this, "Error", "Hubo un error en la conexión a la base de datos",
						JOptionPane.ERROR_MESSAGE);
			} catch (ServiceNoHayDatosException e) {
				JOptionPane.showMessageDialog(this, "Error", "No hay lugares para listar", JOptionPane.ERROR_MESSAGE);
			}

		} else if (accion.getSource() == botonListarLugares) {

			LugarService servicio = new LugarService();
			List<Lugar> lugaresListados;

			try {
				lugaresListados = servicio.listarLugares();
				panelManager.mostrarFormLugarListar(lugaresListados);
			} catch (ServiceErrorDeConexionBDException | ServiceErrorEjecucionSentenciaException e) {
				JOptionPane.showMessageDialog(this, "Error", "Hubo un error en la conexión a la base de datos",
						JOptionPane.ERROR_MESSAGE);
			} catch (ServiceNoHayDatosException e) {
				JOptionPane.showMessageDialog(this, "Error", "No hay lugares para listar", JOptionPane.ERROR_MESSAGE);
			}

		}

	}

}
