package vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entidades.Lugar;
import entidades.Ubicacion;

public abstract class AbstractFormUbicacion extends JPanel implements ActionListener {

	protected PanelManager panelManager;
	protected JTextField tCapacidad;
	protected JTextField tNombre;
	protected JLabel lNombre;
	protected JLabel lCapacidad;
	protected String imagenUbicacion;

	public AbstractFormUbicacion(PanelManager panelManager) {

		this.panelManager = panelManager;
		armarFormUbicacion();

	}
	
	public JTextField gettCapacidad() {
		return tCapacidad;
	}

	public void settCapacidad(JTextField tCapacidad) {
		this.tCapacidad = tCapacidad;
	}

	public JTextField gettNombre() {
		return tNombre;
	}

	public void settNombre(JTextField tNombre) {
		this.tNombre = tNombre;
	}

	public JLabel getlNombre() {
		return lNombre;
	}

	public void setlNombre(JLabel lNombre) {
		this.lNombre = lNombre;
	}

	public JLabel getlCapacidad() {
		return lCapacidad;
	}

	public void setlCapacidad(JLabel lCapacidad) {
		this.lCapacidad = lCapacidad;
	}

	public String getImagenUbicacion() {
		return imagenUbicacion;
	}

	public void setImagenUbicacion(String imagenUbicacion) {
		this.imagenUbicacion = imagenUbicacion;
	}
	
	public void armarFormUbicacion() {

		this.setLayout((new BoxLayout(this, BoxLayout.Y_AXIS)));
		this.setSize(1000, 1000);
		
		lCapacidad = new JLabel("Capacidad");
		this.add(lCapacidad);
		tCapacidad = new JTextField();
		tCapacidad.setSize(100, 50);
		this.add(tCapacidad);

		lNombre = new JLabel("Nombre");
		this.add(lNombre);
		tNombre = new JTextField();
		this.add(tNombre);
		
	}
	
	public void completarCamposUbicacion(Ubicacion ubicacion) { 
		
		this.tNombre.setText(ubicacion.getNombre());
		this.imagenUbicacion = ubicacion.getFotoUbicacion();
		this.tCapacidad.setText(Integer.toString(ubicacion.getCapacidad()));
		
	}

	public abstract void actionPerformed(ActionEvent accion);

}
