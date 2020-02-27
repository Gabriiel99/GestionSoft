package Programa;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Registro_Usuarios extends JInternalFrame {

	Connection con = null;
	Statement st = null;
	private JPanel contentPane;
	private JTextField textNombre;
	private JPasswordField textRepContr;
	private JPasswordField textContr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro_Usuarios frame = new Registro_Usuarios();
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
	public Registro_Usuarios() {
		setFrameIcon(new ImageIcon(Registro_Usuarios.class.getResource("/Imagenes/GS.png")));
		setTitle("Nuevo Usuario");
		setIconifiable(true);
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(350, 150, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistrarNuevoUsuario = new JLabel("Registrar Nuevo Usuario");
		lblRegistrarNuevoUsuario.setForeground(SystemColor.textHighlight);
		lblRegistrarNuevoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrarNuevoUsuario.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 22));
		lblRegistrarNuevoUsuario.setBounds(52, 11, 325, 39);
		contentPane.add(lblRegistrarNuevoUsuario);
		
		JLabel lblEscribaElNombre = new JLabel("Escriba el nombre:");
		lblEscribaElNombre.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 13));
		lblEscribaElNombre.setBounds(52, 87, 130, 20);
		contentPane.add(lblEscribaElNombre);
		
		textNombre = new JTextField();
		textNombre.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 11));
		textNombre.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		textNombre.setBounds(224, 85, 141, 24);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblEscribaLaContrasea = new JLabel("Escriba la Contrase\u00F1a:");
		lblEscribaLaContrasea.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 13));
		lblEscribaLaContrasea.setBounds(52, 131, 155, 20);
		contentPane.add(lblEscribaLaContrasea);
		
		JLabel lblRepitaLaContrasea = new JLabel("Repita la Contrase\u00F1a:");
		lblRepitaLaContrasea.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 13));
		lblRepitaLaContrasea.setBounds(52, 172, 155, 20);
		contentPane.add(lblRepitaLaContrasea);
		
		textRepContr = new JPasswordField();
		textRepContr.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 12));
		textRepContr.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		textRepContr.setBounds(224, 171, 141, 24);
		contentPane.add(textRepContr);
		
		textContr = new JPasswordField();
		textContr.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 12));
		textContr.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		textContr.setBounds(224, 130, 141, 24);
		contentPane.add(textContr);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		btnRegistrar.setForeground(new Color(0, 0, 0));
		btnRegistrar.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 13));
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			String a, b;
			a = textContr.getText();
			b = textRepContr.getText();
			
				if (a.equals(b)) {
				try {
					String sql = "insert into Usuario (Nom_U, Clave_U) values (?,?)";
					con = Conexion.obtenerconexion();
					PreparedStatement pst=con.prepareStatement(sql);
					pst.setString(1, textNombre.getText());
					pst.setString(2, (String.valueOf(a)));
					int n=pst.executeUpdate();
					if(n>0){
							JOptionPane.showMessageDialog(rootPane, "Se registró de forma correcta!");
						}
					
				}catch (Exception e) {
					e.printStackTrace();
				}
				textNombre.setText("");
				textContr.setText("");
				textRepContr.setText("");
			} else {
				JOptionPane.showMessageDialog(rootPane, "Las contraseñas no coinciden!");
				textContr.setText("");
				textRepContr.setText("");
			}
			}
		});
		btnRegistrar.setBounds(143, 213, 141, 46);
		contentPane.add(btnRegistrar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Registro_Usuarios.class.getResource("/Imagenes/alta_Prov.png")));
		label.setBounds(10, 25, 73, 69);
		contentPane.add(label);
	}
}
