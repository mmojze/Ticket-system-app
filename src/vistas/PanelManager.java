package vistas;

import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import entidades.Lugar;
import entidades.Ubicacion;
import entidades.Usuario;

public class PanelManager {

	private JFrame frame;
	private FormLogin FormLogin;
	private FormHomeAdmin FormHomeAdmin;
	private FormHomeVendedor FormHomeVendedor;
	private FormLugarVisualizar FormLugarVisualizar;
	private FormLugarModificar FormLugarModificar;
	private FormLugarListar FormLugarListar;
	private FormLugarCrear FormLugarCrear;
	private FormLugarAdministrar FormLugarAdministrar;
	private FormUbicacionABM FormUbicacionABM;
	private FormUbicacionListar FormUbicacionListar;
	private FormUbicacionVisualizar FormUbicacionVisualizar;

	public PanelManager() {

	}

	public void armarManager() {

		frame = new JFrame();
		frame.setBounds(200, 200, 500, 500);

		FormLogin = new FormLogin(this);
		FormLogin.armarFormLogin();

		FormHomeAdmin = new FormHomeAdmin(this);
		FormHomeAdmin.armarFormHomeAdmin();

		FormHomeVendedor = new FormHomeVendedor(this);
		FormHomeVendedor.armarFormHomeVendedor();

		FormLugarVisualizar = new FormLugarVisualizar(this);
		FormLugarVisualizar.armarFormLugarVisualizar();

		FormLugarCrear = new FormLugarCrear(this);
		FormLugarCrear.armarFormLugarCrear();

		FormLugarModificar = new FormLugarModificar(this);
		FormLugarModificar.armarFormLugarModificar();

		FormLugarAdministrar = new FormLugarAdministrar(this);
		FormLugarAdministrar.armarFormLugarAdministrar();

		FormLugarListar = new FormLugarListar(this);
		FormLugarListar.armarFormLugarListar();

		FormUbicacionABM = new FormUbicacionABM(this);
		FormUbicacionABM.armarFormUbicacionABM();

		FormUbicacionListar = new FormUbicacionListar(this);
		FormUbicacionListar.armarUbicacionListar();

		FormUbicacionVisualizar = new FormUbicacionVisualizar(this);
		FormUbicacionVisualizar.armarFormUbicacionVisualizar();

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

	public void mostrarFormHomeAdmin() {

		frame.getContentPane().removeAll();
		frame.getContentPane().add(FormHomeAdmin);
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
	}

	public void mostrarFormLugarVisualizar(Lugar lugar) {

		FormLugarVisualizar.setLugar(lugar);
		FormLugarVisualizar.setimagenEstadio();
		frame.getContentPane().removeAll();
		frame.getContentPane().add(FormLugarVisualizar);
		frame.getContentPane().validate();
		frame.getContentPane().repaint();

	}

	public void mostrarFormLugarCrear() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(FormLugarCrear);
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
	}

	public void mostrarFormModificarLugar(Lugar lugar) {

		FormLugarModificar.setLugar(lugar);
		FormLugarModificar.setCapacidadOriginal(lugar.getCapacidadTotal());
		frame.getContentPane().removeAll();
		frame.getContentPane().add(FormLugarModificar);
		frame.getContentPane().validate();
		frame.getContentPane().repaint();

	}

	public void mostrarFormLugarAdministrar(List<Lugar> lugares) {

		FormLugarAdministrar.setLugares(lugares);
		frame.getContentPane().removeAll();
		frame.getContentPane().add(FormLugarAdministrar);
		frame.getContentPane().validate();
		frame.getContentPane().repaint();

	}

	public void mostrarFormLugarListar(List<Lugar> lugares) {

		FormLugarListar.setLugares(lugares);
		frame.getContentPane().removeAll();
		frame.getContentPane().add(FormLugarListar);
		frame.getContentPane().validate();
		frame.getContentPane().repaint();

	}

	public void mostrarFormHomeVendedor() {

		frame.getContentPane().removeAll();
		frame.getContentPane().add(FormHomeVendedor);
		frame.getContentPane().validate();
		frame.getContentPane().repaint();

	}

	public void mostrarFormUbicacionABM(Lugar lugar) {
		
		FormUbicacionABM.setLugar(lugar);
		FormUbicacionABM.setTotalCapacidadUbicaciones(lugar.getCapacidadUtilizada());
		FormUbicacionABM.getUbicacionTableModel().setContenido(lugar.getUbicacionesLugar());
		frame.getContentPane().removeAll();
		frame.getContentPane().add(FormUbicacionABM);
		frame.getContentPane().validate();
		frame.getContentPane().repaint();

	}

	public void mostrarFormUbicacionVisualizar(Ubicacion ubicacion) {
		FormUbicacionVisualizar.completarCamposUbicacion(ubicacion);
		FormUbicacionVisualizar.setImagenUbicacion();
		frame.getContentPane().removeAll();
		frame.getContentPane().add(FormUbicacionVisualizar);
		frame.getContentPane().validate();
		frame.getContentPane().repaint();

	}

	public void mostrarFormUbicacionListar(List<Ubicacion> ubicaciones) {
		FormUbicacionListar.getUbicacionTableModel().setContenido(ubicaciones);
		frame.getContentPane().removeAll();
		frame.getContentPane().add(FormUbicacionListar);
		frame.getContentPane().validate();
		frame.getContentPane().repaint();

	}

}
