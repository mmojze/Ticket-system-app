package vistas;

import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import entidades.Lugar;
import entidades.Usuario;

public class PanelManager {
	
	private JFrame frame;
	private FormLogin FormLogin; 
	private FormHome FormHome; 
	private FormVisualizarLugar FormVisualizarLugar;
	private FormModificarLugar FormModificarLugar;
	private FormCrearLugar FormCrearLugar;
	private FormAdministrarLugares FormAdministrarLugares;
	private FormListarLugares FormListarLugares;
	
	public PanelManager() { 
		
		
	}
	
	public void armarManager() { 
		
		frame = new JFrame(); 
		frame.setBounds(200, 200, 500, 500);
		
		FormLogin = new FormLogin(this);
		FormLogin.armarFormLogin();
		
		FormHome = new FormHome(this);
		FormHome.armarFormHome();
		
		FormVisualizarLugar = new FormVisualizarLugar(this);
		FormVisualizarLugar.armarFormVisualizarLugar();
		
		FormCrearLugar = new FormCrearLugar(this);
		FormCrearLugar.armarFormCrearLugar();
		
		FormModificarLugar = new FormModificarLugar(this);
		FormModificarLugar.armarFormModificarLugar();
		
		FormAdministrarLugares = new FormAdministrarLugares(this);
		FormAdministrarLugares.armarFormAdministrarLugares();
		
		FormListarLugares = new FormListarLugares(this);
		FormListarLugares.armarFormListarLugaresList();
	}
	
	public void showFrame() {
		frame.setVisible(true);
	}
	
	public void mostrarFormLogin() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(FormLogin);
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
		}
	
	public void mostrarFormHome(Usuario user) {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(FormHome);
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
		}
	
	public void mostrarFormVisualizarLugar(Lugar lugar) {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(FormVisualizarLugar);
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
	}
	
	public void mostrarFormCrearLugar() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(FormCrearLugar);
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
	}
	
	public void mostrarFormModificarLugar(Lugar lugar) {
		
		frame.getContentPane().removeAll();
		frame.getContentPane().add(FormModificarLugar);
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
		
	}
	
	public void mostrarFormAdministrarLugar(List<Lugar> lugares) {
		
		FormAdministrarLugares.setLugares(lugares);
		frame.getContentPane().removeAll();
		frame.getContentPane().add(FormAdministrarLugares);
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
		
	}
	
	public void mostrarFormListarLugares(List<Lugar> lugares) {
		
		FormListarLugares.setLugares(lugares);
		frame.getContentPane().removeAll();
		frame.getContentPane().add(FormListarLugares);
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
		
	}
	
	
	
}
