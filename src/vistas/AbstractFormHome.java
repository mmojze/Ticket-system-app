package vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import entidades.Usuario;

public abstract class AbstractFormHome extends JPanel implements ActionListener {

	protected PanelManager panelManager;
	protected Usuario usuario;

	public AbstractFormHome(PanelManager panelManager) {

		this.panelManager = panelManager;
		armarFormHome();

	}

	public void setUsuario(Usuario usuario) {

		this.usuario = usuario;

	}

	public void armarFormHome() {

		this.setLayout((new BoxLayout(this, BoxLayout.Y_AXIS)));

	}

	public abstract void actionPerformed(ActionEvent accion);

}
