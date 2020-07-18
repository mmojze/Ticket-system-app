package vistas;

import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import utilidades.OperacionesImagenes;

public class FormLugarVisualizar extends AbstractFormLugar {

	private JButton botonVolver;
	private JLabel vistaPrevia;
	private BufferedImage imagenEstadio;

	public FormLugarVisualizar(PanelManager panelManager) {
		super(panelManager);
	}

	public void armarFormLugarVisualizar() {

		this.tCapacidad.setEditable(false);
		this.tDireccion.setEditable(false);
		this.tNombreEstadio.setEditable(false);
		this.remove(siguiente);

		botonVolver = new JButton("Volver");
		botonVolver.addActionListener(this);
		this.add(botonVolver);

	}

	public void actionPerformed(ActionEvent accion) {

		if (accion.getSource() == botonVolver) {

			panelManager.mostrarFormHomeAdmin(null);

		}

	}

	public void setimagenEstadio() {

		try {
			BufferedImage imagenEstadio = ImageIO
					.read(new FileInputStream(OperacionesImagenes.DIR_IMG_LUGAR + "/" + lugar.getFotoLugar()));
			JLabel vistaPrevia = new JLabel(new ImageIcon(imagenEstadio));
			this.add(vistaPrevia);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
