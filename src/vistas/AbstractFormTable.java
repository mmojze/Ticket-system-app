package vistas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public abstract class AbstractFormTable extends JPanel implements ActionListener {

	protected PanelManager panelManager;
	protected List<?> contenidoTable;
	protected JTable tabla;
	protected JScrollPane scrollTabla;
	protected JButton botonBorrar, botonModificar, botonVisualizar, botonVolver;

	public AbstractFormTable(PanelManager panelManager) {

		this.panelManager = panelManager;
		armarFormTable();

	}

	public void armarFormTable() {

		GridLayout grid = new GridLayout(5, 6, 5, 5);
		this.setLayout(grid);
		this.setSize(1000, 1000);

		botonBorrar = new JButton("Borrar");
		botonModificar = new JButton("Modificar");
		botonVisualizar = new JButton("Visualizar");
		botonVolver = new JButton("Volver");

		botonBorrar.addActionListener(this);
		botonModificar.addActionListener(this);
		botonVisualizar.addActionListener(this);
		botonVolver.addActionListener(this);

	}

	public void addBotonesAdministrar() {

		this.add(botonBorrar);
		this.add(botonModificar);
		this.add(botonVisualizar);

	}

	public void addBotonVolver() {

		this.add(botonVolver);

	}

	public abstract void actionPerformed(ActionEvent accion);

}
