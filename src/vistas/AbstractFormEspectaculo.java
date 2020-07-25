package vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entidades.Lugar;

public abstract class AbstractFormEspectaculo extends JPanel implements ActionListener {

	protected PanelManager panelManager;
	protected JLabel lNombre;
	protected JLabel lLugar;
	protected JLabel lFecha;
	protected JTextField tNombre;

	public void armarFormEspectaculo() {

		this.setLayout((new BoxLayout(this, BoxLayout.Y_AXIS)));

		this.setSize(1000, 1000);

	}
	
	public abstract void actionPerformed(ActionEvent accion);
	
	public void completarCampos() { 
		
		
		
	}
}
