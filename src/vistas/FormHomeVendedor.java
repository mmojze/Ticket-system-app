package vistas;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

public class FormHomeVendedor extends AbstractFormHome {
	
	private JButton botonRegistrarVenta;
	private JButton botonGestionarVentas;
	private JButton botonReporteVentas;

	public FormHomeVendedor(PanelManager panelManager) {
		super(panelManager);
	}
	
	public void armarFormHomeVendedor() { 
		
		botonRegistrarVenta = new JButton("Registrar venta");
		botonGestionarVentas = new JButton("Gestionar ventas");
		botonReporteVentas = new JButton("Reporte de ventas");
		
		this.add(botonRegistrarVenta);
		this.add(botonGestionarVentas);
		this.add(botonReporteVentas);
		
		botonRegistrarVenta.addActionListener(this);
		botonGestionarVentas.addActionListener(this);
		botonReporteVentas.addActionListener(this);
		
	}

	public void actionPerformed(ActionEvent accion) {

	}

}
