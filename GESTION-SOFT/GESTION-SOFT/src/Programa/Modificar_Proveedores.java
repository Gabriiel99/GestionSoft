package Programa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JScrollBar;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;



public class Modificar_Proveedores extends JInternalFrame {
	private JTable table;
	Connection con;
	DefaultTableModel model = new DefaultTableModel();
	private JTextField nombre;
	private JTextField direccion;
	private JTextField localidad;
	private JTextField email;
	private JTextField Tipo;
	private JTextField textId;
	


	private JPanel contentPane;
	String titulos [] = {"Código", "Nombre", "Dirección", "Localidad", "Email","Teléfono","Tipo_Producto"};
	private JTextField telefono;
	private JTextField textBuscar;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Modificar_Proveedores frame = new Modificar_Proveedores();
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
	public Modificar_Proveedores() {
		setFrameIcon(new ImageIcon(Modificar_Proveedores.class.getResource("/Imagenes/GS.png")));
		setIconifiable(true);
		setClosable(true);
		setForeground(Color.DARK_GRAY);
		setTitle("MODIFICAR");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(150, 10, 843, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(0, 0, 858, 570);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		scrollPane.setBounds(10, 55, 798, 157);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int Filas = table.getSelectedRow();
				if (Filas>=  0) {
					textId.setText(table.getValueAt(Filas, 0).toString());
					nombre.setText(table.getValueAt(Filas, 1).toString());
					direccion.setText(table.getValueAt(Filas, 2).toString());
					localidad.setText(table.getValueAt(Filas, 3).toString());
					email.setText(table.getValueAt(Filas, 4).toString());
					telefono.setText(table.getValueAt(Filas, 5).toString());
					Tipo.setText(table.getValueAt(Filas, 6).toString());
				}else {
					JOptionPane.showMessageDialog(null, "¡Seleccione una Fila!");
				}
			}
		});
		table.setForeground(Color.BLACK);
		table.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 14));
		table.setBackground(new Color(102, 204, 153));
		scrollPane.setViewportView(table);
		
		model.addColumn("Cod_prov");
		model.addColumn("NombreProveedor");
		model.addColumn("Direccion");
		model.addColumn("Localidad");
		model.addColumn("Email");
		model.addColumn("Teléfono");
		model.addColumn("Tipo_prov");
		this.table.setModel(model);
		
		JLabel lblSeleccionParaModificar = new JLabel("Seleccione Para Modificar:");
		lblSeleccionParaModificar.setHorizontalAlignment(SwingConstants.LEFT);
		lblSeleccionParaModificar.setForeground(SystemColor.activeCaptionText);
		lblSeleccionParaModificar.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 24));
		lblSeleccionParaModificar.setBackground(new Color(0, 0, 128));
		lblSeleccionParaModificar.setBounds(10, 0, 349, 51);
		panel.add(lblSeleccionParaModificar);
		
		JLabel lblNombreprov = new JLabel("Nombre_Prov");
		lblNombreprov.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreprov.setForeground(new Color(0, 0, 0));
		lblNombreprov.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNombreprov.setBounds(221, 250, 180, 33);
		panel.add(lblNombreprov);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n");
		lblDireccin.setHorizontalAlignment(SwingConstants.CENTER);
		lblDireccin.setForeground(new Color(0, 0, 0));
		lblDireccin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblDireccin.setBounds(221, 300, 180, 33);
		panel.add(lblDireccin);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblLocalidad.setForeground(new Color(0, 0, 0));
		lblLocalidad.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblLocalidad.setBounds(221, 350, 180, 33);
		panel.add(lblLocalidad);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setForeground(new Color(0, 0, 0));
		lblEmail.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblEmail.setBounds(221, 400, 180, 33);
		panel.add(lblEmail);
		
		JLabel lblTipoDeProveedor = new JLabel("Tipo de Proveedor");
		lblTipoDeProveedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoDeProveedor.setForeground(new Color(0, 0, 0));
		lblTipoDeProveedor.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblTipoDeProveedor.setBounds(221, 500, 180, 33);
		panel.add(lblTipoDeProveedor);
		
		nombre = new JTextField();
		nombre.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		nombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char cTeclaPresionada = evt.getKeyChar();

				if(cTeclaPresionada==KeyEvent.VK_ENTER){
				direccion.requestFocus();
				}
			}
		});
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono");
		lblTelfono.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelfono.setForeground(new Color(0, 0, 0));
		lblTelfono.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblTelfono.setBounds(221, 450, 180, 33);
		panel.add(lblTelfono);
			
		nombre.setHorizontalAlignment(SwingConstants.CENTER);
		nombre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		nombre.setColumns(10);
		nombre.setBounds(440, 250, 220, 29);
		panel.add(nombre);
		
		direccion = new JTextField();
		direccion.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		direccion.setHorizontalAlignment(SwingConstants.CENTER);
		direccion.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		direccion.setColumns(10);
		direccion.setBounds(440, 300, 220, 29);
		panel.add(direccion);
		
		localidad = new JTextField();
		localidad.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		localidad.setHorizontalAlignment(SwingConstants.CENTER);
		localidad.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		localidad.setColumns(10);
		localidad.setBounds(440, 350, 220, 29);
		panel.add(localidad);
		
		email = new JTextField();
		email.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		email.setHorizontalAlignment(SwingConstants.CENTER);
		email.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		email.setColumns(10);
		email.setBounds(440, 400, 220, 29);
		panel.add(email);
		
		telefono = new JTextField();
		telefono.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		telefono.setHorizontalAlignment(SwingConstants.CENTER);
		telefono.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		telefono.setColumns(10);
		telefono.setBounds(440, 450, 220, 29);
		panel.add(telefono);
		
		Tipo = new JTextField();
		Tipo.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		Tipo.setHorizontalAlignment(SwingConstants.CENTER);
		Tipo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		Tipo.setColumns(10);
		Tipo.setBounds(440, 500, 220, 29);
		panel.add(Tipo);
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.setIcon(new ImageIcon(Modificar_Proveedores.class.getResource("/Imagenes/mod_prov.png")));
		btnModificar.setVerticalAlignment(SwingConstants.BOTTOM);
		btnModificar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		
		
		btnModificar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnModificar.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
				
				String NombreProveedor = nombre.getText();
				String Direccion = direccion.getText();
				String Localidad = localidad.getText();
				String Email = email.getText();
				String Telefono = telefono.getText();
				String Tipo_prov = Tipo.getText();
			
				try {
					con = Conexion.obtenerconexion();
					Statement st = con.createStatement();
					String sql = "Update Proveedores set Nombre_prov = ?,Direccion_prov = ?,Localidad_prov = ?,Email_prov = ?,Telefono_prov = ?, TipoProd_Prov= ? where Cod_Prov = ?";
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1, NombreProveedor);
					ps.setString(2, Direccion);
					ps.setString(3, Localidad);
					ps.setString(4, Email);
					ps.setString(5, Telefono);
					ps.setString(6, Tipo_prov);
					ps.setInt(7, Integer.parseInt(textId.getText()));
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Registro Actualizado");
					Consulta("");
					
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error al Actualizar Registro "+ex);
					
				}
				
			}
		});
		btnModificar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnModificar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnModificar.setBounds(83, 287, 110, 100);
		panel.add(btnModificar);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.setIcon(new ImageIcon(Modificar_Proveedores.class.getResource("/Imagenes/exit (2).png")));
		btnSalir.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		btnSalir.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnSalir.setOpaque(true);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSalir.setVerticalTextPosition(SwingConstants.TOP);
		btnSalir.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSalir.setBounds(83, 405, 110, 100);
		panel.add(btnSalir);
		
		JLabel lblBuscar = new JLabel("Buscar por Apellido:");
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setForeground(new Color(0, 0, 0));
		lblBuscar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblBuscar.setBounds(416, 13, 172, 33);
		panel.add(lblBuscar);
		
		textBuscar = new JTextField();
		textBuscar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		textBuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Consulta(textBuscar.getText());

			}
		});
		textBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		textBuscar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		textBuscar.setColumns(10);
		textBuscar.setBounds(582, 15, 148, 29);
		panel.add(textBuscar);
		
		textId = new JTextField();
		textId.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		textId.setBounds(101, 223, 67, 29);
		panel.add(textId);
		textId.setHorizontalAlignment(SwingConstants.CENTER);
		textId.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		textId.setColumns(10);
		
		JLabel lblId = new JLabel("Id");
		lblId.setForeground(new Color(0, 0, 0));
		lblId.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 15));
		lblId.setBounds(57, 226, 36, 22);
		panel.add(lblId);
		
		JLabel imagen = new JLabel("");
		imagen.setIcon(new ImageIcon(Modificar_Proveedores.class.getResource("/Imagenes/prov.png")));
		imagen.setBounds(670, 223, 122, 141);
		panel.add(imagen);
		
		TableColumnModel model = table.getColumnModel();
		model.getColumn(0).setPreferredWidth(40);
		model.getColumn(1).setPreferredWidth(80);
		model.getColumn(2).setPreferredWidth(80);
		model.getColumn(3).setPreferredWidth(80);
		model.getColumn(4).setPreferredWidth(80);
		model.getColumn(5).setPreferredWidth(80);
		model.getColumn(6).setPreferredWidth(80);
		
		Consulta("");
	}
public void Consulta(String Buscar) {  
		
		try {
			con = Conexion.obtenerconexion();
			String datos[] = new String[7];
			model = new DefaultTableModel(null, titulos);
			String sql = "Select * From Proveedores where Nombre_Prov like '"+Buscar+"%'";
			Statement st = con.createStatement();
			ResultSet Rs = st.executeQuery(sql);
			while(Rs.next()) {
				datos [0] = Rs.getString("Cod_Prov");
				datos [1] = Rs.getString("Nombre_Prov");
				datos [2] = Rs.getString("Direccion_Prov");
				datos [3] = Rs.getString("Localidad_Prov");
				datos [4] = Rs.getString("Email_Prov");
				datos [5] = Rs.getString("Telefono_prov");
				datos [6] = Rs.getString("TipoProd_Prov");
				this.model.addRow(datos);
				table.setModel(model);
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Error al cargar los Datos\n" + ex);
			}
	}
}