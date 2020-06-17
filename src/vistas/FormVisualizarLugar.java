package vistas;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

public class FormVisualizarLugar extends AbstractFormLugar {
	
	public FormVisualizarLugar(PanelManager panelManager) {
		super(panelManager);
	}

	public void armarFormVisualizarLugar() { 
		
		this.tCapacidad.setEditable(false);
		this.tDireccion.setEditable(false);
		this.tNombreEstadio.setEditable(false);
		
	}

	public void actionPerformed(ActionEvent accion) {
		
		if (accion.getSource() == siguiente) {
			
			// Mostrar ubicaciones
			
		}
		
	}
	
}
