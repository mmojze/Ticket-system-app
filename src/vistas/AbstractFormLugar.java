package vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import entidades.Lugar;

public abstract class AbstractFormLugar extends JPanel implements ActionListener {

	protected PanelManager panelManager;
	protected JButton siguiente;
	protected JLabel lNombreEstadio;
	protected JTextField tNombreEstadio;
	protected JLabel lCapacidad;
	protected JSpinner tCapacidad;
	protected JLabel lDireccion;
	protected JTextField tDireccion;
	protected JFrame popupEstadio;
	protected Lugar lugar;
	protected String nombreImagen;

	public AbstractFormLugar(PanelManager panelManager) {

		this.panelManager = panelManager;
		armarFormLugar();

	}

	public void armarFormLugar() {

		this.setLayout((new BoxLayout(this, BoxLayout.Y_AXIS)));

		this.setSize(1000, 1000);

		lNombreEstadio = new JLabel("Nombre del estadio");
		this.add(lNombreEstadio);
		tNombreEstadio = new JTextField();
		this.add(lNombreEstadio);

		lCapacidad = new JLabel("Capacidad total");
		tCapacidad = new JSpinner();
		
		SpinnerNumberModel capacidadModel = new SpinnerNumberModel();
		capacidadModel.setStepSize(1);
		capacidadModel.setMinimum(1);
		tCapacidad.setModel(capacidadModel);
		
		lDireccion = new JLabel("Dirección");
		tDireccion = new JTextField();
		siguiente = new JButton("Siguiente");
		siguiente.setLocation(50, 50);
		siguiente.addActionListener(this);

		this.add(tNombreEstadio);
		this.add(lCapacidad);
		this.add(tCapacidad);
		this.add(lDireccion);
		this.add(tDireccion);
		this.add(siguiente);

		setVisible(true);

	}

	public abstract void actionPerformed(ActionEvent accion);

	public void completarCamposLugar() {
		
		tNombreEstadio.setText(this.lugar.getNombre());
		tDireccion.setText(this.lugar.getDireccion());
		tCapacidad.setValue(this.lugar.getCapacidadTotal());
		this.nombreImagen = this.lugar.getFotoLugar();

	}

	public void setLugar(Lugar lugar) {

		this.lugar = lugar;
		completarCamposLugar();
	}
}
