package vistas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import entidades.Lugar;
import entidades.Ubicacion;
import tablemodels.LugarTableModel;

public class FormAdministrarLugares extends JPanel implements ActionListener {

	protected PanelManager panelManager;
	protected LugarTableModel LugarTableModel;
	private List<Lugar> lugares;
	private JTable tablaLugares;
	private JScrollPane scrollPaneParaTabla;
	private JButton botonBorrar, botonModificar, botonVisualizar, botonVolver;
	private JFrame popupLugar; 
	
	
	public FormAdministrarLugares(PanelManager panelManager) {
		
		this.panelManager = panelManager;
		lugares = new ArrayList<>();
		
	}
	
	public void armarFormAdministrarLugares() { 
		
		GridLayout grid = new GridLayout(5, 6, 5, 5);
		this.setLayout(grid);
		this.setSize(1000, 1000);
		
		LugarTableModel = new LugarTableModel(lugares);
		tablaLugares = new JTable(LugarTableModel);
		scrollPaneParaTabla = new JScrollPane(tablaLugares);
		this.add(scrollPaneParaTabla);
		
		botonBorrar = new JButton("Borrar");
		botonModificar = new JButton("Modificar");
		botonVisualizar = new JButton("Visualizar");
		botonVolver = new JButton("Volver");
		
		botonBorrar.addActionListener(this);
		botonModificar.addActionListener(this);
		botonVisualizar.addActionListener(this);
		botonVolver.addActionListener(this);
		
		this.add(botonBorrar);
		this.add(botonModificar);
		this.add(botonVisualizar);
		this.add(botonVolver);
	}
	
	public void setLugares(List<Lugar> lugares) { 
		
		LugarTableModel.setContenido(lugares);
		LugarTableModel.fireTableDataChanged();
		
	}
	
	public void actionPerformed(ActionEvent accion) { 
		
		if (accion.getSource() == botonBorrar) { 
			
			int filaSeleccionada = this.tablaLugares.getSelectedRow();
			Lugar lugar = this.LugarTableModel.getContenido().get(filaSeleccionada);
			System.out.println(lugar.getIdLugar());
			lugar.borrarLugar(lugar);
			
			JOptionPane.showMessageDialog(popupLugar,
					"El lugar se ha borrado correctamente");
			
			
		} else if (accion.getSource() == botonModificar) { 
			
			int filaSeleccionada = this.tablaLugares.getSelectedRow();
			Lugar lugar = this.LugarTableModel.getContenido().get(filaSeleccionada);
			panelManager.mostrarFormModificarLugar(lugar);
			
		} else if (accion.getSource() == botonVisualizar) { 
			
			int filaSeleccionada = this.tablaLugares.getSelectedRow();
			Lugar lugar = this.LugarTableModel.getContenido().get(filaSeleccionada);
			panelManager.mostrarFormVisualizarLugar(lugar);
			
			
		} else if (accion.getSource() == botonVolver) {
			
			panelManager.mostrarFormHome(null);
			
		}
		
		
		
	}

}
