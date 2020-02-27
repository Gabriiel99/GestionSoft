package Programa;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;

public class Consulta_Proveedores extends JInternalFrame {
	
	private JPanel contentPane;
	private JTable table;
	DefaultTableModel model = new DefaultTableModel();
	String titulos[] = {"Código", "Nombre","Direccion","Localidad","Email","Teléfono","Tipo_Prod"};
	
	Connection con;
	Statement st;
	private JTextField textid;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Consulta_Proveedores frame = new Consulta_Proveedores();
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
	public Consulta_Proveedores() {
		setFrameIcon(new ImageIcon(Consulta_Proveedores.class.getResource("/Imagenes/GS.png")));
		setIconifiable(true);
		setClosable(true);
		setTitle("Consulta de Proveedores");
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(200, 80, 855, 480);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Tahoma", Font.PLAIN, 11));
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(51, 204, 153), new Color(51, 204, 204), new Color(51, 204, 153), new Color(51, 204, 204)));
		scrollPane.setBounds(10, 165, 819, 206);
		contentPane.add(scrollPane);
		
		
		model = new DefaultTableModel();
		model.addColumn("Código");
		model.addColumn("Nombre");
		model.addColumn("Dirección");
		model.addColumn("Localidad");
		model.addColumn("Email");
		model.addColumn("Teléfono");
		model.addColumn("Tipo_Prod");
		table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				int filas = table.getSelectedRow();
				if (filas >=0) {
					textid.setText(table.getValueAt(filas, 0).toString());
				}
			}
		});
		
		table.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 14));
		table.setBackground(new Color(51, 204, 153));
		scrollPane.setViewportView(table);
		
		JTextField textBuscar;
		textBuscar = new JTextField();
		textBuscar.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent arg0) {
			Consulta(textBuscar.getText());
			}
		});
		textBuscar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(51, 204, 153), new Color(51, 204, 204), new Color(51, 204, 153), new Color(51, 204, 204)));
		textBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		textBuscar.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 15));
		textBuscar.setBounds(179, 130, 210, 26);
		contentPane.add(textBuscar);
		textBuscar.setColumns(10);
		
		JLabel lblNombre = new JLabel("Consulta de Proveedores");
		lblNombre.setForeground(new Color(0, 0, 0));
		lblNombre.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 28));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(201, 44, 410, 46);
		contentPane.add(lblNombre);
		Consulta("");
		
		JButton btnEliminar;
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(Consulta_Proveedores.class.getResource("/Imagenes/eliminar_prov.png")));
		btnEliminar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(51, 204, 153), new Color(51, 204, 204), new Color(51, 204, 153), new Color(51, 204, 204)));
		btnEliminar.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 12));
		btnEliminar.setBounds(218, 382, 132, 60);
		contentPane.add(btnEliminar);
		
		JLabel lblNewLabel = new JLabel("Buscar por Nombre:");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 16));
		lblNewLabel.setBounds(10, 130, 175, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 12));
		lblId.setBounds(721, 131, 32, 26);
		contentPane.add(lblId);
		
		textid = new JTextField();
		textid.setHorizontalAlignment(SwingConstants.CENTER);
		textid.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 15));
		textid.setColumns(10);
		textid.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(51, 204, 153), new Color(51, 204, 204), new Color(51, 204, 153), new Color(51, 204, 204)));
		textid.setBounds(753, 128, 76, 26);
		contentPane.add(textid);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setIcon(new ImageIcon(Consulta_Proveedores.class.getResource("/Imagenes/salir_cli.png")));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSalir.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		btnSalir.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 12));
		btnSalir.setBounds(522, 382, 132, 60);
		contentPane.add(btnSalir);
		
		JLabel imagen = new JLabel("");
		imagen.setIcon(new ImageIcon(Consulta_Proveedores.class.getResource("/Imagenes/prov.png")));
		imagen.setBounds(0, 0, 139, 130);
		contentPane.add(imagen);
		
		JLabel imagen2 = new JLabel("");
		imagen2.setIcon(new ImageIcon(Consulta_Proveedores.class.getResource("/Imagenes/prov (3).png")));
		imagen2.setBounds(621, 44, 99, 69);
		contentPane.add(imagen2);
		
		JLabel user = new JLabel("");
		user.setVisible(false);
		user.setBounds(10, 426, 46, 14);
		user.setText(Logeo.usuario);
		contentPane.add(user);
		
		//----------------------------------------------------------------------------------------//
				String restr;
				restr = user.getText();
				if (restr.equals("ADMIN")) {
					
				} else if ((restr.equals("admin"))){
					
				} else {
					btnEliminar.setEnabled(false);
				}
		//-----------------------------------------------------------------------------------------//

		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				int filas = table.getSelectedRow();
				if (filas>=0) {
				int confirmar = JOptionPane.showConfirmDialog(null, "¿Desea Eliminar el Registro?","ALERTA",JOptionPane.YES_NO_OPTION);
				
				if (JOptionPane.YES_OPTION==confirmar) {
				try {
					con = Conexion.obtenerconexion();
					String sql = "Delete From Proveedores where Cod_Prov = ?";
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setInt(1, Integer.parseInt(textid.getText()));
					int n = ps.executeUpdate();
					if(n>0) {
						JOptionPane.showMessageDialog(null, "¡Proveedor Eliminado! ");
						Consulta("");
						}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "¡Proveedor No Eliminado! "+ex);
					}
				}
				}
					else {
						JOptionPane.showMessageDialog(null, "¡Seleccione un Registro!");
					}
				Consulta("");
			}
		}); 
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