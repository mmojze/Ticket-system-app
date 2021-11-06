package vistas;

import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FormUbicacionVisualizar extends AbstractFormUbicacion {

	public FormUbicacionVisualizar(PanelManager panelManager) {
		super(panelManager);
	}
	
	public void armarFormUbicacionVisualizar() { 
		
		this.tCapacidad.setEditable(false);
		this.tNombre.setEditable(false);
		
	}
	
	public void setImagenUbicacion() {
		
		/*
		try {
			BufferedImage imagenUbicacion = ImageIO
					.read(new FileInputStream(OperacionesImagenes.DIR_IMG_UBICACION + "/" + this.imagenUbicacion));
			JLabel vistaPrevia = new JLabel(new ImageIcon(imagenUbicacion));
			this.add(vistaPrevia);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "Error", "No se encontró la imagen",
					JOptionPane.ERROR_MESSAGE);
		}
		*/

	}

	public void actionPerformed(ActionEvent accion) {

	}

}
