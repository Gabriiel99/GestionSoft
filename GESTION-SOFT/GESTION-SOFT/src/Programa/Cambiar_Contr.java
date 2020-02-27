package Programa;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Cambiar_Contr extends JInternalFrame {

	Connection con = null;
	private JPanel contentPane;
	public static String pass = "", pass1 = "";
	private JTextField textNombre;
	private JPasswordField passActual;
	private JPasswordField passNu;
	public static String usuario="",usuario1="";
	static Cambiar_Contr cambiar = new Cambiar_Contr();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cambiar_Contr frame = new Cambiar_Contr();
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
	public Cambiar_Contr() {
		setFrameIcon(new ImageIcon(Cambiar_Contr.class.getResource("/Imagenes/GS.png")));
		setTitle("Cambiar Datos");
		setIconifiable(true);
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(350, 150, 500, 275);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel user = new JLabel("");
		user.setVisible(false);
		user.setBounds(10, 23, 71, 20);
		user.setText(Logeo.usuario);
		contentPane.add(user);
		
		JLabel lblCambiarContrasea = new JLabel("Cambiar datos de Acceso");
		lblCambiarContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblCambiarContrasea.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 22));
		lblCambiarContrasea.setBounds(56, 11, 368, 26);
		contentPane.add(lblCambiarContrasea);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de Usuario:");
		lblNombreDeUsuario.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 13));
		lblNombreDeUsuario.setBounds(114, 67, 160, 20);
		contentPane.add(lblNombreDeUsuario);
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		textNombre.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 12));
		textNombre.setBounds(284, 66, 140, 24);
		textNombre.setText(Logeo.usuario);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblContraseaActual = new JLabel("Contrase\u00F1a Actual:");
		lblContraseaActual.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 13));
		lblContraseaActual.setBounds(114, 106, 136, 20);
		contentPane.add(lblContraseaActual);
		
		passActual = new JPasswordField();
		passActual.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		passActual.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 12));
		passActual.setBounds(284, 105, 140, 24);
		contentPane.add(passActual);
		
		JLabel lblNuevaContrasea = new JLabel("Nueva Contrase\u00F1a:");
		lblNuevaContrasea.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 13));
		lblNuevaContrasea.setBounds(114, 147, 136, 20);
		contentPane.add(lblNuevaContrasea);
		
		passNu = new JPasswordField();
		passNu.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		passNu.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 12));
		passNu.setBounds(284, 146, 140, 24);
		contentPane.add(passNu);
		
		JButton btnCambiar = new JButton("Cambiar");
		btnCambiar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		btnCambiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pass = passActual.getText();
				pass1 = passNu.getText();
				if (pass.equals(pass1)) {
					
					JOptionPane.showMessageDialog(rootPane, "Las contraseñas son iguales!");
					passNu.setText("");
					
				} else {
					try {
						con = Conexion.obtenerconexion();
						Statement st = con.createStatement();
						String sql = "update Usuario set Clave_U = ? where Nom_U = ?";
						PreparedStatement pst = con.prepareStatement(sql);
						pst.setString(1, passNu.getText());
						pst.setString(2, Logeo.usuario);
						int n =pst.executeUpdate();
						if (n>0) {
							JOptionPane.showMessageDialog(rootPane, "Se guardó de forma correcta!");
							textNombre.setText("");
							passActual.setText("");
							passNu.setText("");
							//cambiar.confirmar();
						}
					}catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
		btnCambiar.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 11));
		btnCambiar.setBounds(165, 178, 140, 44);
		contentPane.add(btnCambiar);
		
		JLabel lblPorFavorCompletar = new JLabel("Por favor completar todos los campos!");
		lblPorFavorCompletar.setForeground(SystemColor.textHighlight);
		lblPorFavorCompletar.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 11));
		lblPorFavorCompletar.setBounds(193, 40, 267, 14);
		contentPane.add(lblPorFavorCompletar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Cambiar_Contr.class.getResource("/Imagenes/contrase\u00F1a.png")));
		label.setBounds(20, 77, 81, 93);
		contentPane.add(label);
		
		
	}
	
	private void confirmar(){
		Object []opciones={"Aceptar","Cancelar"};
		int elecciones=JOptionPane.showOptionDialog(rootPane,"Desea guardar los cambios? ","Mensaje de confirmación",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE,null,opciones,"Aceptar");
		if(elecciones==JOptionPane.YES_NO_OPTION){
			JOptionPane.showMessageDialog(null, "Los datos fueron guardados exitosamente. "
					+ "Reinicie el programa por favor para efectuar los cambios");
	
		}
		else if(elecciones==JOptionPane.NO_OPTION){
			textNombre.setText("");
			passActual.setText("");
			passNu.setText("");
			textNombre.requestFocus();
		}}
}
