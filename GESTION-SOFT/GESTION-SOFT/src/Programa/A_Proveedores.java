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
import java.awt.Toolkit;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableRowSorter;
import javax.swing.UIManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class A_Proveedores extends JInternalFrame {

	Connection con = null;
	Statement st = null;
	private JPanel contentPane;
	private JTextField textNombreProv;
	private JTextField textDireccion;
	private JTextField textLocalidad;
	private JTextField textEmail;
	private JLabel lbltipodeproducto;
	private JTextField textTipoProd;
	private JTextField textTelefono;
	private JLabel lblNewLabel;
	private JButton btnAñadir;
	private JLabel imagen;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					A_Proveedores frame = new A_Proveedores();
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
	public A_Proveedores() {
		setFrameIcon(new ImageIcon(A_Proveedores.class.getResource("/Imagenes/GS.png")));
		setTitle("Alta de Proveedores");
		setIconifiable(true);
		setClosable(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(250, 100, 650, 450);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblnombreprov = new JLabel("Nombre_Prov:");
		lblnombreprov.setForeground(new Color(0, 0, 0));
		lblnombreprov.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 14));
		lblnombreprov.setBounds(96, 115, 130, 22);
		contentPane.add(lblnombreprov);
		
		JLabel lbldireccion = new JLabel("Direcci\u00F3n:");
		lbldireccion.setForeground(new Color(0, 0, 0));
		lbldireccion.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 14));
		lbldireccion.setBounds(96, 160, 123, 22);
		contentPane.add(lbldireccion);
		
		JLabel lbllocalidad = new JLabel("Localidad:");
		lbllocalidad.setForeground(new Color(0, 0, 0));
		lbllocalidad.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 14));
		lbllocalidad.setBounds(96, 205, 123, 22);
		contentPane.add(lbllocalidad);
		
		JLabel lblemail = new JLabel("Email:");
		lblemail.setForeground(new Color(0, 0, 0));
		lblemail.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 14));
		lblemail.setBounds(96, 250, 86, 22);
		contentPane.add(lblemail);
		
		textNombreProv = new JTextField();
		textNombreProv.setHorizontalAlignment(SwingConstants.CENTER);
		textNombreProv.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		textNombreProv.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 15));
		textNombreProv.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char cTeclaPresionada = e.getKeyChar();

				if(cTeclaPresionada==KeyEvent.VK_ENTER){
					textDireccion.requestFocus();				}
			}
		});
		textNombreProv.setColumns(10);
		textNombreProv.setBounds(250, 110, 186, 28);
		contentPane.add(textNombreProv);
		
		textDireccion = new JTextField();
		textDireccion.setHorizontalAlignment(SwingConstants.CENTER);
		textDireccion.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		textDireccion.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 15));
		textDireccion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char cTeclaPresionada = e.getKeyChar();

				if(cTeclaPresionada==KeyEvent.VK_ENTER){
					textLocalidad.requestFocus();
				
			}
				
				
			}
		});
		textDireccion.setColumns(10);
		textDireccion.setBounds(250, 155, 186, 28);
		contentPane.add(textDireccion);
		
		textLocalidad = new JTextField();
		textLocalidad.setHorizontalAlignment(SwingConstants.CENTER);
		textLocalidad.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		textLocalidad.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 15));
		textLocalidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char cTeclaPresionada = e.getKeyChar();

				if(cTeclaPresionada==KeyEvent.VK_ENTER){
					textEmail.requestFocus();
					
				}
			}
		});
		textLocalidad.setColumns(10);
		textLocalidad.setBounds(250, 200, 186, 28);
		contentPane.add(textLocalidad);
		
		textEmail = new JTextField();
		textEmail.setHorizontalAlignment(SwingConstants.CENTER);
		textEmail.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		textEmail.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 15));
		textEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char cTeclaPresionada = e.getKeyChar();

				if(cTeclaPresionada==KeyEvent.VK_ENTER){
					textTelefono.requestFocus();
					
				}
			}
		});
		textEmail.setColumns(10);
		textEmail.setBounds(250, 245, 186, 28);
		contentPane.add(textEmail);
		
		JLabel lbltelefono = new JLabel("Tel\u00E9fono:");
		lbltelefono.setForeground(new Color(0, 0, 0));
		lbltelefono.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 14));
		lbltelefono.setBounds(96, 295, 123, 22);
		contentPane.add(lbltelefono);
		
		textTelefono = new JTextField();
		textTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		textTelefono.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		textTelefono.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 15));
		textTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char cTeclaPresionada = e.getKeyChar();

				if(cTeclaPresionada==KeyEvent.VK_ENTER){
					textTipoProd.requestFocus();
					
				}
			}
		});
		textTelefono.setColumns(10);
		textTelefono.setBounds(250, 290, 186, 28);
		contentPane.add(textTelefono);
		
		lbltipodeproducto = new JLabel("Tipo de Producto:");
		lbltipodeproducto.setForeground(new Color(0, 0, 0));
		lbltipodeproducto.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 14));
		lbltipodeproducto.setBounds(96, 340, 158, 22);
		contentPane.add(lbltipodeproducto);
		
		textTipoProd = new JTextField();
		textTipoProd.setHorizontalAlignment(SwingConstants.CENTER);
		textTipoProd.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		textTipoProd.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 15));
		textTipoProd.setColumns(10);
		textTipoProd.setBounds(250, 335, 186, 28);
		contentPane.add(textTipoProd);
		
		lblNewLabel = new JLabel("Alta de Proveedores\r\n");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel.setBounds(155, 34, 326, 39);
		contentPane.add(lblNewLabel);
		
		JButton btnVolver = new JButton("Salir");
		btnVolver.setIcon(new ImageIcon(A_Proveedores.class.getResource("/Imagenes/salir_cli.png")));
		btnVolver.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 14));
		btnVolver.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			dispose();
			}	
		});
		btnVolver.setBounds(495, 247, 110, 85);
		contentPane.add(btnVolver);
		
		
		
		JButton btnAñadir = new JButton("A\u00F1adir");
		btnAñadir.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAñadir.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnAñadir.setVerticalAlignment(SwingConstants.BOTTOM);
		btnAñadir.setIcon(new ImageIcon(A_Proveedores.class.getResource("/Imagenes/alta_Prov.png")));
		btnAñadir.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		btnAñadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Nombre_prov,Direccion_prov,Localidad_prov,Email_prov,TipoProd_prov, Telefono;
				Nombre_prov = textNombreProv.getText();
				Direccion_prov = textDireccion.getText();
				Localidad_prov = textLocalidad.getText();
				Email_prov = textEmail.getText();
				TipoProd_prov = textTipoProd.getText();
				Telefono = textTelefono.getText();
				
				try {
					con = Conexion.obtenerconexion();
					String sql = "Insert Into Proveedores(Nombre_prov,Direccion_prov,Localidad_prov,Email_prov,Telefono_prov,TipoProd_prov)"
							+ "Values('"+Nombre_prov+"','"+Direccion_prov+"','"+Localidad_prov+"','"+Email_prov+"','"+Telefono+"','"+TipoProd_prov+"')";
					st = con.createStatement();
					st.executeUpdate(sql);
					JOptionPane.showMessageDialog(null, "Registro Añadido");
					Object opciones [] = {"Si","No"};
					int eleccion = JOptionPane.showOptionDialog(rootPane, "¿Desea agregar otro Proveedor?", "ALERTA", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, "Si"); 
					if (eleccion==JOptionPane.YES_OPTION) {	
						textNombreProv.setText("");
						textDireccion.setText("");
						textLocalidad.setText("");
						textEmail.setText("");
						textTipoProd.setText("");
						textTelefono.setText("");
					}else {
						/*MenuPrincipal MP = new MenuPrincipal();
						MP.setVisible(true);
						Agregar.this.dispose();*/
					}

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "No Se Cargaron Los Registros. "+ex);}
				
				textNombreProv.setText("");
				textDireccion.setText("");
				textLocalidad.setText("");
				textEmail.setText("");
				textTipoProd.setText("");
				textTelefono.setText("");
			}
		});
			
		btnAñadir.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 13));
		btnAñadir.setBounds(495, 138, 110, 85);
		contentPane.add(btnAñadir);
		
		imagen = new JLabel("");
		imagen.setIcon(new ImageIcon(A_Proveedores.class.getResource("/Imagenes/prov (2).png")));
		imagen.setBounds(86, 0, 96, 111);
		contentPane.add(imagen);
	}
}
