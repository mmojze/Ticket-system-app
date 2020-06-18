package vistas;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import entidades.Usuario;
import exceptions.NoSeEncontroUsuarioException;

import javax.swing.*;

public class FormLogin extends JPanel implements ActionListener {

	private JLabel lUsuario;
	private JTextField tUsuario;
	private JLabel lContraseña;
	private JPasswordField tContraseña;
	private JButton login;
	private JFrame popupLogin;
	private PanelManager panelManager;

	public FormLogin(PanelManager m) {

		this.panelManager = m;

	}

	public void armarFormLogin() {

		this.setLayout(null);
		this.setBounds(300, 90, 500, 600);

		lUsuario = new JLabel("Usuario");
		lUsuario.setFont(new Font("Arial", Font.PLAIN, 15));
		lUsuario.setSize(100, 20);
		lUsuario.setLocation(130, 200);
		this.add(lUsuario);

		tUsuario = new JTextField();
		tUsuario.setFont(new Font("Arial", Font.PLAIN, 15));
		tUsuario.setSize(150, 20);
		tUsuario.setLocation(200, 200);
		this.add(tUsuario);

		lContraseña = new JLabel("Contraseña");
		lContraseña.setFont(new Font("Arial", Font.PLAIN, 15));
		lContraseña.setSize(100, 20);
		lContraseña.setLocation(110, 250);
		this.add(lContraseña);

		tContraseña = new JPasswordField();
		tContraseña.setFont(new Font("Arial", Font.PLAIN, 15));
		tContraseña.setSize(150, 20);
		tContraseña.setLocation(200, 250);
		this.add(tContraseña);

		login = new JButton("Login");
		login.setFont(new Font("Arial", Font.PLAIN, 15));
		login.setSize(120, 20);
		login.setLocation(190, 300);
		login.addActionListener(this);
		this.add(login);

		popupLogin = new JFrame();

		setVisible(true);

	}

	public void actionPerformed(ActionEvent accion) {

		if (accion.getSource() == login) {

			String contraseña = new String(tContraseña.getPassword());
			String usuario = tUsuario.getText();

			try {

				Usuario usuarioLogeado = new Usuario();
				
				usuarioLogeado = usuarioLogeado.logearse(tUsuario.getText(), contraseña);

				String tipoUsuario = usuarioLogeado.getTipoUsuario();

				switch (tipoUsuario) {

				case "Administrador":
					panelManager.mostrarFormHome(usuarioLogeado);
					break;
				case "Vendedor":
					JOptionPane.showMessageDialog(popupLogin, "En construcción");
				}

			} catch (NoSeEncontroUsuarioException e) {
				JOptionPane.showMessageDialog(popupLogin,
						"El usuario no existe o la contraseña es incorrecta, por favor revise los datos");
			}

		}

	}
}
