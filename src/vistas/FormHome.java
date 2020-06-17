package vistas;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class FormHome extends JPanel implements ActionListener {
	
	private JButton crearEstadio, modificarEstadio, eliminarEstadio, visualizarEstadio;

	private PanelManager panelManager;

	public FormHome(PanelManager m) {

		this.panelManager = m;

	}

	public void armarFormHome() {
		
		this.setLayout((new BoxLayout(this, BoxLayout.Y_AXIS)));
		crearEstadio = new JButton("Crear estadio");
		modificarEstadio = new JButton("Modificar estadio");
		eliminarEstadio = new JButton("Eliminar estadio");
		visualizarEstadio = new JButton("Visualizar estadio");
		this.add(crearEstadio);
		this.add(modificarEstadio);
		this.add(eliminarEstadio);
		this.add(visualizarEstadio);
		setVisible(true);
		crearEstadio.addActionListener(this);
		modificarEstadio.addActionListener(this);
		eliminarEstadio.addActionListener(this);
		visualizarEstadio.addActionListener(this);
		
	}

	public void actionPerformed(ActionEvent accion) {		
	
		if (accion.getSource() == crearEstadio) {
			
			panelManager.mostrarFormCrearLugar();
			
		} else if (accion.getSource() == visualizarEstadio) { 
			
			panelManager.mostrarFormVisualizarLugar();
			
		}
		
		
	}

}
