package Programa;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Logeo extends JFrame {

	private JPanel contentPane;
	public JTextField textUsuario;
	public JPasswordField textPassword;
	public static String usuario, pass;
	public static int error=0;
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;
	String query;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Logeo frame = new Logeo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Logeo() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Logeo.class.getResource("/Imagenes/GS.png")));
		setTitle("Usuarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 262);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 20));
		lblLogin.setBounds(178, 23, 89, 22);
		contentPane.add(lblLogin);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 16));
		lblUsuario.setBounds(87, 90, 75, 20);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 16));
		lblContrasea.setBounds(54, 135, 108, 20);
		contentPane.add(lblContrasea);
		
		textUsuario = new JTextField();
		textUsuario.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		textUsuario.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 13));
		textUsuario.setBounds(172, 90, 178, 25);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);
		
		textPassword = new JPasswordField();
		textPassword.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		textPassword.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 13));
		textPassword.setBounds(172, 135, 178, 25);
		contentPane.add(textPassword);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		btnCancelar.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 14));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Inicio d=new Inicio();
				d.setVisible(true);
				Logeo.this.dispose();

			}
		});
		btnCancelar.setBounds(243, 171, 125, 35);
		contentPane.add(btnCancelar);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		btnIngresar.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 14));
		btnIngresar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				usuario = textUsuario.getText();
				pass = textPassword.getText();
				if (consulta(usuario, pass)) {
					JOptionPane.showMessageDialog(rootPane, "Bienvenido al sistema!");
					Menu m = new Menu();
					m.setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(rootPane, "Clave y/o Usuario incorrecto!");
					textUsuario.setText("");
					textPassword.setText("");
					textUsuario.requestFocus();
					
					error=error+1;
					if(error==3) {
						JOptionPane.showMessageDialog(null, "Comuníquese con el administrador!","Error!!",
							JOptionPane.ERROR_MESSAGE);
						dispose();
						}
				}
				}
		});
		btnIngresar.setBounds(77, 171, 125, 35);
		contentPane.add(btnIngresar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Logeo.class.getResource("/Imagenes/login.png")));
		label.setBounds(93, 11, 75, 81);
		contentPane.add(label);
	}
	
	public boolean consulta(String user, String clave){
		int sw=0;
		query = "select * from Usuario where Nom_U = '"+user+"' and Clave_U = '"+clave+"'";
		try {
			con = Conexion.obtenerconexion();
			st = con.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				if (rs.getString(1)==null) {
					sw = 0;
				} else {
					sw = 1;
				}
			}

		}catch (Exception ex){
			JOptionPane.showMessageDialog(null, "Error sql"+ ex);
		}
		if (sw == 1) {
			return true;
		} else {
			return false;
		}
    }
	
/*public void ValidarUsuario() {
		
		String pass=String.valueOf(textPassword.getPassword());
		String usuario=textUsuario.getText();
		try{
			con = Conexion.obtenerconexion();
			String sql="select * from Usuario";
			String Datos [] = new String [2];
			st = con.createStatement();
			ResultSet resultado= st.executeQuery(sql);
			while (resultado.next()) {
				//Datos [0] = resultado.getString(1) ;
				if(usuario.equals(resultado.getString(1)) && pass.equals(resultado.getString(2))) {
					JOptionPane.showMessageDialog(null, "Bienvenido Al Sistema");
					Menu m = new Menu();
					m.show();
					
				}else {}
			}
			}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Error al conectar");
		} 
		
	}*/
	
}