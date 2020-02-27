package Programa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.border.BevelBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class A_Clientes extends JInternalFrame {

	private JPanel contentPane;
	private JTextField textApCliente;
	private JTextField textNomCliente;
	private JTextField textDireccion;
	private JTextField textProv;
	private JTextField textDni;
	private JTextField textTel;
	public static JButton Insertar;
	
	Connection con ;
	Statement st;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					A_Clientes frame = new A_Clientes();
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
	public A_Clientes() {
		setFrameIcon(new ImageIcon(A_Clientes.class.getResource("/Imagenes/GS.png")));
		setIconifiable(true);
		setClosable(true);
		setTitle("Alta de Clientes");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(250, 50, 700, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(0, 0, 690, 456);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel user = new JLabel("");
		user.setVisible(false);
		user.setBounds(0, 0, 46, 14);
		user.setText(Logeo.usuario);
		panel.add(user);
		
		JLabel lblCargarLosCampos = new JLabel("Cargar los campos requeridos, para el alta de un nuevo cliente!");
		lblCargarLosCampos.setHorizontalAlignment(SwingConstants.CENTER);
		lblCargarLosCampos.setForeground(new Color(0, 0, 0));
		lblCargarLosCampos.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 17));
		lblCargarLosCampos.setBounds(20, 11, 647, 51);
		panel.add(lblCargarLosCampos);
		
		JLabel label = new JLabel("Nombre_Cliente:");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(0, 0, 0));
		label.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 14));
		label.setBounds(86, 90, 180, 33);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Apellido_Cliente:");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(new Color(0, 0, 0));
		label_1.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 14));
		label_1.setBounds(86, 140, 180, 33);
		panel.add(label_1);
		
		JLabel label_3 = new JLabel("Direccion:");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(new Color(0, 0, 0));
		label_3.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 14));
		label_3.setBounds(86, 190, 180, 33);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Prov/Localidad:");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(new Color(0, 0, 0));
		label_4.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 14));
		label_4.setBounds(86, 240, 180, 33);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("DNI/CUIT:");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(new Color(0, 0, 0));
		label_5.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 14));
		label_5.setBounds(86, 290, 180, 33);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("Tel/Fax:");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(new Color(0, 0, 0));
		label_6.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 14));
		label_6.setBounds(86, 340, 180, 33);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("CategoriaIva:");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setForeground(new Color(0, 0, 0));
		label_7.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 14));
		label_7.setBounds(86, 390, 180, 33);
		panel.add(label_7);
		
		textNomCliente = new JTextField();
		textNomCliente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
					textApCliente.requestFocus();
				}
			}
		});
		textNomCliente.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		textNomCliente.setHorizontalAlignment(SwingConstants.CENTER);
		textNomCliente.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 15));
		textNomCliente.setColumns(10);
		textNomCliente.setBounds(279, 90, 148, 33);
		panel.add(textNomCliente);
		
		textApCliente = new JTextField();
		textApCliente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
					textDireccion.requestFocus();
				}
			}
		});
		textApCliente.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		textApCliente.setHorizontalAlignment(SwingConstants.CENTER);
		textApCliente.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 15));
		textApCliente.setColumns(10);
		textApCliente.setBounds(279, 140, 148, 33);
		panel.add(textApCliente);
		
		textDireccion = new JTextField();
		textDireccion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
					textProv.requestFocus();
				}
			}
		});
		textDireccion.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		textDireccion.setHorizontalAlignment(SwingConstants.CENTER);
		textDireccion.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 15));
		textDireccion.setColumns(10);
		textDireccion.setBounds(279, 190, 148, 33);
		panel.add(textDireccion);
		
		textProv = new JTextField();
		textProv.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
					textDni.requestFocus();
				}
			}
		});
		textProv.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		textProv.setHorizontalAlignment(SwingConstants.CENTER);
		textProv.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 15));
		textProv.setColumns(10);
		textProv.setBounds(279, 240, 148, 33);
		panel.add(textProv);
		
		textDni = new JTextField();
		textDni.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
					textTel.requestFocus();
				}
			}
		});
		textDni.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		textDni.setHorizontalAlignment(SwingConstants.CENTER);
		textDni.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 15));
		textDni.setColumns(10);
		textDni.setBounds(279, 290, 148, 33);
		panel.add(textDni);
		
		textTel = new JTextField();
		textTel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		textTel.setHorizontalAlignment(SwingConstants.CENTER);
		textTel.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 15));
		textTel.setColumns(10);
		textTel.setBounds(279, 340, 148, 33);
		panel.add(textTel);
		
		JComboBox comboIva = new JComboBox();
		comboIva.setForeground(new Color(0, 0, 0));
		comboIva.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		comboIva.setModel(new DefaultComboBoxModel(new String[] {"Seleccione:", "Monotributista", "Resp_Inscripto", "Exento", "Cons_Final"}));
		comboIva.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		comboIva.setBounds(276, 390, 151, 33);
		panel.add(comboIva);
		
		JButton Insertar = new JButton();
		Insertar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		Insertar.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 15));
		Insertar.setIcon(new ImageIcon(A_Clientes.class.getResource("/Imagenes/agregar_cli.png")));
		Insertar.setVerticalAlignment(SwingConstants.BOTTOM);
		Insertar.setVerticalTextPosition(SwingConstants.BOTTOM);
		Insertar.setHorizontalTextPosition(SwingConstants.CENTER);
		Insertar.setText("AGREGAR");
		//Insertar.setIcon(new ImageIcon(A_Clientes.class.getResource("/IMAGENES/Agregar 96x96.png")));
		Insertar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				
				String NomCliente, ApCliente,Dir,Prov,Dni,Tel,Iva;
				NomCliente = textNomCliente.getText();
				ApCliente = textApCliente.getText();
				Dir = textDireccion.getText();
				Prov = textProv.getText();
				Dni = textDni.getText();
				Tel = textTel.getText();
				Iva = (String)comboIva.getSelectedItem();
				if (NomCliente.isEmpty() || ApCliente.isEmpty() ||
						Dir.isEmpty() || Prov.isEmpty() || Dni.isEmpty() || Tel.isEmpty() || Iva.isEmpty()) {
					JOptionPane.showMessageDialog(null, "¡Rellene Todos los Campos!", "Error", JOptionPane.ERROR_MESSAGE);
					}
				else {
					try {
						con = Conexion.obtenerconexion();
						String sql = "Insert Into Clientes(Nombre_Cli,Apellido_Cli,Direccion_Cli,Prov_Localidad_Cli,Dni_Cuit_Cli,Tel_Fax_Cli,Categoria_Iva_Cli)"
								+ "Values('"+NomCliente+"','"+ApCliente+"','"+Dir+"','"+Prov+"','"+Dni+"','"+Tel+"','"+Iva+"')";
						st = con.createStatement();
						st.executeUpdate(sql);
						JOptionPane.showMessageDialog(null, "Registro Añadido");
						Object opciones [] = {"Si", "No"};
						int eleccion = JOptionPane.showOptionDialog(rootPane, "¿Desea agregar otro Cliente?", "ALERTA", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, "Si"); 
						if (eleccion==JOptionPane.YES_OPTION) {	
							Insertar.setVisible(true);
							textNomCliente.setText("");
							textApCliente.setText("");
							textDireccion.setText("");
							textProv.setText("");
							textDni.setText("");
							textTel.setText("");
							comboIva.setSelectedItem("Seleccione:");
						}else {
							textNomCliente.setText("");
							textApCliente.setText("");
							textDireccion.setText("");
							textProv.setText("");
							textDni.setText("");
							textTel.setText("");
							comboIva.setSelectedItem("Seleccione:");
						}
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "No Se Cargaron Los Registros. "+ex);
					}
				}
			}
			
		});
		Insertar.setBounds(476, 114, 126, 128);
		panel.add(Insertar);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.setIcon(new ImageIcon(A_Clientes.class.getResource("/Imagenes/exit (2).png")));
		btnSalir.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		btnSalir.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 15));
		btnSalir.setOpaque(true);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object [] opciones = { "Si","No"};
				int eleccion = JOptionPane.showOptionDialog(rootPane, "¿Desea Salir?", "ALERTA", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, "ACEPTAR");
				if (eleccion==JOptionPane.YES_OPTION) {
					dispose();
				}
			}
		});
		btnSalir.setOpaque(true);
		btnSalir.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSalir.setVerticalTextPosition(SwingConstants.TOP);
		//btnSalir.setIcon(new ImageIcon(A_Clientes.class.getResource("/IMAGENES/Salir 64x64.png")));
		btnSalir.setBounds(476, 277, 126, 128);
		panel.add(btnSalir);
	
		//----------------------------------------------------------------------------------------//
		/*String restr;
		restr = user.getText();
		if (restr.equals("ADMIN")) {
			
		} else {
			Insertar.setEnabled(false);
		}*/
		//----------------------------------------------------------------------------------------//
	}
}