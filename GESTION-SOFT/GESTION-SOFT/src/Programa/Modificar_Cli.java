package Programa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;


public class Modificar_Cli extends JInternalFrame {

	private JPanel contentPane;
	private JTable table;
	Connection con;
	Statement st;
	DefaultTableModel model = new DefaultTableModel();
	String titulos [] = {"Id_Cliente","Nombre","Apellido","Dirección","Prov_Localidad","DNI_CUIT","Tel_Fax","Categoria_Iva"};
	
	private JTextField textNomCliente;
	private JTextField textApCliente;
	private JTextField textDir;
	private JTextField textProv;
	private JTextField textDni;
	private JTextField textTel;
	private JTextField textId;
	private JTextField textBuscar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Modificar_Cli frame = new Modificar_Cli();
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
	public Modificar_Cli() {
		setFrameIcon(new ImageIcon(Modificar_Cli.class.getResource("/Imagenes/GS.png")));
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setForeground(Color.DARK_GRAY);
		setTitle("Modificar Clientes");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(150, 20, 910, 550);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(0, 0, 900, 517);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JComboBox comboiva = new JComboBox();
		comboiva.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		comboiva.setForeground(new Color(0, 0, 0));
		comboiva.setModel(new DefaultComboBoxModel(new String[] {"Seleccione:", "Monotributista", "Resp_Inscripto", "Exento", "Cons_Final"}));
		comboiva.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 15));
		comboiva.setBounds(550, 470, 170, 33);
		panel.add(comboiva);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		scrollPane.setBounds(10, 60, 876, 157);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int Filas = table.getSelectedRow();
				if (Filas>= 0) {
					textId.setText(table.getValueAt(Filas, 0).toString());
					textNomCliente.setText(table.getValueAt(Filas, 1).toString());
					textApCliente.setText(table.getValueAt(Filas, 2).toString());
					textDir.setText(table.getValueAt(Filas, 3).toString());
					textProv.setText(table.getValueAt(Filas, 4).toString());
					textDni.setText(table.getValueAt(Filas, 5).toString());
					textTel.setText(table.getValueAt(Filas, 6).toString());
					comboiva.setSelectedItem((String) table.getValueAt(Filas, 7).toString());
				}else {
					JOptionPane.showMessageDialog(null, "¡Seleccione una Fila!");
				}
			}
		});
		table.setForeground(new Color(0, 0, 0));
		table.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 12));
		table.setBackground(new Color(102, 204, 153));
		table.setModel(new DefaultTableModel(null, titulos));
		
		scrollPane.setViewportView(table);
		
		model.addColumn("Id_Cliente");
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("Dirección");
		model.addColumn("Prov_Localidad");
		model.addColumn("DNI_CUIT");
		model.addColumn("Tel_Fax");
		model.addColumn("Categoria_Iva");
		this.table.setModel(model);
		
		TableColumnModel model = table.getColumnModel();
		model.getColumn(0).setPreferredWidth(10);
		model.getColumn(1).setPreferredWidth(80);
		model.getColumn(2).setPreferredWidth(80);
		model.getColumn(3).setPreferredWidth(80);
		model.getColumn(4).setPreferredWidth(80);
		model.getColumn(5).setPreferredWidth(0);
		model.getColumn(6).setPreferredWidth(0);
		model.getColumn(7).setPreferredWidth(0);
		this.table.setColumnModel(model);
		
		JLabel lblSeleccionParaModificar = new JLabel("Seleccione Para Modificar:");
		lblSeleccionParaModificar.setHorizontalAlignment(SwingConstants.LEFT);
		lblSeleccionParaModificar.setForeground(Color.BLACK);
		lblSeleccionParaModificar.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 20));
		lblSeleccionParaModificar.setBackground(new Color(0, 0, 128));
		lblSeleccionParaModificar.setBounds(10, 0, 326, 51);
		panel.add(lblSeleccionParaModificar);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setForeground(new Color(0, 0, 0));
		lblId.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 15));
		lblId.setBounds(93, 225, 54, 33);
		panel.add(lblId);
		
		JLabel label = new JLabel("Nombre_Cliente:");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setForeground(new Color(0, 0, 0));
		label.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 15));
		label.setBounds(350, 230, 148, 33);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Apellido_Cliente:");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setForeground(new Color(0, 0, 0));
		label_1.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 15));
		label_1.setBounds(350, 270, 148, 33);
		panel.add(label_1);
		
		JLabel label_3 = new JLabel("Direccion:");
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setForeground(new Color(0, 0, 0));
		label_3.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 15));
		label_3.setBounds(350, 310, 137, 33);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Prov/Localidad:");
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_4.setForeground(new Color(0, 0, 0));
		label_4.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 15));
		label_4.setBounds(350, 350, 137, 33);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("DNI/CUIT:");
		label_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_5.setForeground(new Color(0, 0, 0));
		label_5.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 15));
		label_5.setBounds(350, 390, 137, 33);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("Tel/Fax:");
		label_6.setHorizontalAlignment(SwingConstants.LEFT);
		label_6.setForeground(new Color(0, 0, 0));
		label_6.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 15));
		label_6.setBounds(350, 430, 137, 33);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("CategoriaIva:");
		label_7.setHorizontalAlignment(SwingConstants.LEFT);
		label_7.setForeground(new Color(0, 0, 0));
		label_7.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 15));
		label_7.setBounds(350, 470, 137, 33);
		panel.add(label_7);
		
		textId = new JTextField();
		textId.setEditable(false);
		textId.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		textId.setHorizontalAlignment(SwingConstants.CENTER);
		textId.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 15));
		textId.setColumns(10);
		textId.setBounds(149, 225, 67, 29);
		panel.add(textId);
		
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
		textNomCliente.setBounds(550, 230, 170, 29);
		panel.add(textNomCliente);
		
		textApCliente = new JTextField();
		textApCliente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
					textDir.requestFocus();
				}
			}
		});
		textApCliente.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		textApCliente.setHorizontalAlignment(SwingConstants.CENTER);
		textApCliente.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 15));
		textApCliente.setColumns(10);
		textApCliente.setBounds(550, 270, 170, 29);
		panel.add(textApCliente);
		
		textDir = new JTextField();
		textDir.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
					textProv.requestFocus();
				}
			}
		});
		textDir.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		textDir.setHorizontalAlignment(SwingConstants.CENTER);
		textDir.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 15));
		textDir.setColumns(10);
		textDir.setBounds(550, 310, 170, 29);
		panel.add(textDir);
		
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
		textProv.setBounds(550, 350, 170, 29);
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
		textDni.setBounds(550, 390, 170, 29);
		panel.add(textDni);
		
		textTel = new JTextField();
		textTel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		textTel.setHorizontalAlignment(SwingConstants.CENTER);
		textTel.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 15));
		textTel.setColumns(10);
		textTel.setBounds(550, 430, 170, 29);
		panel.add(textTel);
		
		JButton Modificar = new JButton("MODIFICAR");
		Modificar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		Modificar.setIcon(new ImageIcon(Modificar_Cli.class.getResource("/Imagenes/mod_clientes.png")));
		Modificar.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 13));
		Modificar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				
				String NomCliente = textNomCliente.getText();
				String ApCliente = textApCliente.getText();
				String Dir = textDir.getText();
				String Prov = textProv.getText();
				String Dni = textDni.getText();
				String Tel = textTel.getText();
				String Iva = (String)comboiva.getSelectedItem();
				try {
					con = Conexion.obtenerconexion();
					Statement st = con.createStatement();
					String sql = "Update Clientes set Nombre_Cli = ?, Apellido_Cli = ?,Direccion_Cli = ?,Prov_Localidad_Cli = ?,Dni_Cuit_Cli = ?,Tel_Fax_Cli = ?,Categoria_Iva_Cli = ? where Cod_Cli = ?";
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1, NomCliente);
					ps.setString(2, ApCliente);
					ps.setString(3, Dir);
					ps.setString(4, Prov);
					ps.setString(5, Dni);
					ps.setString(6, Tel);
					ps.setString(7, Iva);
					ps.setInt(8, Integer.parseInt(textId.getText()));
					ps.executeUpdate();
					Modificar.setVisible(true);
					JOptionPane.showMessageDialog(null, "Registro Actualizado");
					Consulta("");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "No Pudo Actualizar Registro "+ex);
				}
				Object opciones [] = {"Si", "No"};
				int eleccion = JOptionPane.showOptionDialog(rootPane, "¿Desea modificar otro Cliente?", "ALERTA", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, "Si"); 
				if (eleccion==JOptionPane.YES_OPTION) {	
					Modificar.setVisible(true);
					textId.setText("");
					textNomCliente.setText("");
					textApCliente.setText("");
					textDir.setText("");
					textProv.setText("");
					textDni.setText("");
					textTel.setText("");
					comboiva.setSelectedItem("Seleccione:");
				}else {
					/*Principal p = new Principal();
					p.setVisible(true);
					Modificar.this.dispose();*/
				}
				
				
			}
		});
		Modificar.setVerticalTextPosition(SwingConstants.BOTTOM);
		Modificar.setHorizontalTextPosition(SwingConstants.CENTER);
		//Modificar.setIcon(new ImageIcon(Modificar.class.getResource("/IMAGENES/Modificar 96x96.png")));
		Modificar.setBounds(10, 282, 125, 100);
		panel.add(Modificar);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.setIcon(new ImageIcon(Modificar_Cli.class.getResource("/Imagenes/exit (2).png")));
		btnSalir.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		btnSalir.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 13));
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
		btnSalir.setVerticalTextPosition(SwingConstants.TOP);
		btnSalir.setHorizontalTextPosition(SwingConstants.CENTER);
		//btnSalir.setIcon(new ImageIcon(Modificar.class.getResource("/IMAGENES/Salir 64x64.png")));
		btnSalir.setBounds(77, 394, 125, 100);
		panel.add(btnSalir);
		
		textBuscar = new JTextField();
		textBuscar.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 15));
		textBuscar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		textBuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				Consulta(textBuscar.getText());
			}
		});
		textBuscar.setBounds(537, 13, 148, 29);
		panel.add(textBuscar);
		textBuscar.setColumns(10);
		
		JLabel lblBusqueda = new JLabel("Buscar por Apellido:");
		lblBusqueda.setHorizontalAlignment(SwingConstants.CENTER);
		lblBusqueda.setForeground(new Color(0, 0, 0));
		lblBusqueda.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 13));
		lblBusqueda.setBounds(370, 11, 172, 33);
		panel.add(lblBusqueda);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setIcon(new ImageIcon(Modificar_Cli.class.getResource("/Imagenes/elim_cli.png")));
		btnEliminar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int filas = table.getSelectedRow();
				if (filas>=0) {
				int confirmar = JOptionPane.showConfirmDialog(null, "¿Desea Eliminar el Registro?","ALERTA",JOptionPane.YES_NO_OPTION);
				
				if (JOptionPane.YES_OPTION==confirmar) {
					try {
						String sql = "Delete From Clientes "
								+ 	 "where Cod_Cli ="+textId.getText();
						st = con.createStatement();
						int n = st.executeUpdate(sql);
						if(n>=0) {
							JOptionPane.showMessageDialog(null, "¡Registro Eliminado!");
							Consulta("");
						}
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "¡Registro No Eliminado!"+ex);
					}
				}
			}
				else {
					JOptionPane.showMessageDialog(null, "¡Seleccione un Registro!");
				}
			}
		});
		btnEliminar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnEliminar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEliminar.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 13));
		btnEliminar.setBounds(146, 282, 125, 100);
		panel.add(btnEliminar);
		
		Consulta("");
	}
public void Consulta(String Buscar) {  
		
		try {
			con = Conexion.obtenerconexion();
			String datos[] = new String[9];
			model = new DefaultTableModel(null, titulos);
			String sql = "Select * From Clientes where Apellido_Cli like '"+Buscar+"%'";
			Statement st = con.createStatement();
			ResultSet Rs = st.executeQuery(sql);
			while(Rs.next()) {
				datos [0] = Rs.getString("Cod_Cli");
				datos [1] = Rs.getString("Nombre_Cli");
				datos [2] = Rs.getString("Apellido_Cli");
				datos [3] = Rs.getString("Direccion_Cli");
				datos [4] = Rs.getString("Prov_Localidad_Cli");
				datos [5] = Rs.getString("Dni_Cuit_Cli");
				datos [6] = Rs.getString("Tel_Fax_Cli");
				datos [7] = Rs.getString("Categoria_Iva_Cli");
				this.model.addRow(datos);
			}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Error al cargar los Datos\n" + ex);
			}
		this.table.setModel(model);
	}
}