package vistas;

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
	
	public PanelManager() { 
		
		
	}
	
	public void armarManager() { 
		
		frame = new JFrame(); 
		
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
	
	public void mostrarFormVisualizarLugar() {
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
	
	public void mostrarFormModificarLugar() {
		
		frame.getContentPane().removeAll();
		frame.getContentPane().add(FormModificarLugar);
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
		
	}
	
}
