package Programa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Consulta_Cli extends JInternalFrame {

	private JPanel contentPane;
	private JTable table;
	
	
	Connection con;
	Statement st;
	DefaultTableModel model = new DefaultTableModel();
	private JTextField textBuscar;
	String titulos [] = {"Id_Cliente","Nombre","Apellido","Dirección","Prov_Localidad","DNI_CUIT","Tel_Fax","Categoria_Iva"};
	public int Cod_Cli;
	private String cod;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Consulta_Cli frame = new Consulta_Cli();
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
	public Consulta_Cli() {
		setFrameIcon(new ImageIcon(Consulta_Cli.class.getResource("/Imagenes/GS.png")));
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		//setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/IMAGENES/users_clients_group_16774.png")));
		setTitle("Consulta de Clientes");
		setBackground(new Color(0, 100, 0));
		
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 80, 1000, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(0, 0, 990, 420);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		scrollPane.setBounds(10, 192, 964, 216);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					int fila = table.getSelectedRow();
					cod=(table.getValueAt(fila, 0).toString());
					
				}catch (Exception e) {
					
				}
			}
		});
		table.setForeground(new Color(0, 0, 0));
		table.setBackground(new Color(102, 204, 153));
		table.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		scrollPane.setViewportView(table);
		
		
		model.addColumn("Id");
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("Dirección");
		model.addColumn("Prov_Localidad");
		model.addColumn("DNI_CUIT");
		model.addColumn("Tel_Fax");
		model.addColumn("Categoria_Iva");
		this.table.setModel(model);
		
		JLabel user = new JLabel("");
		user.setVisible(false);
		user.setForeground(Color.BLACK);
		user.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 23));
		user.setBounds(937, 12, 37, 13);
		user.setText(Logeo.usuario);
		panel.add(user);
		
		JLabel lbl_icon = new JLabel("");
		lbl_icon.setIcon(new ImageIcon(Consulta_Cli.class.getResource("/Imagenes/frame-cli.png")));
		//lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/IMAGENES/customer_person_people_man_user_client_1629.png")));
		lbl_icon.setBounds(662, 41, 163, 151);
		panel.add(lbl_icon);
		
		JLabel lblsistemasGestionY = new JLabel("Consulta de Clientes");
		lblsistemasGestionY.setForeground(new Color(0, 0, 0));
		lblsistemasGestionY.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 35));
		lblsistemasGestionY.setBounds(234, 56, 434, 48);
		panel.add(lblsistemasGestionY);
		
		JLabel label = new JLabel("Id:");
		label.setBounds(61, 0, -61, 28);
		panel.add(label);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		
		JLabel lblBuscar = new JLabel("Buscar por Apellido:");
		lblBuscar.setForeground(new Color(0, 0, 0));
		lblBuscar.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 16));
		lblBuscar.setBounds(10, 143, 188, 38);
		panel.add(lblBuscar);
		
		textBuscar = new JTextField("");
		textBuscar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		textBuscar.setToolTipText("");
		textBuscar.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent arg0) {
				Consulta(textBuscar.getText());
			}
		});
		textBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		textBuscar.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 15));
		textBuscar.setColumns(10);
		textBuscar.setBounds(185, 148, 199, 30);
		panel.add(textBuscar);
		
		JLabel lbl_icon2 = new JLabel("");
		lbl_icon2.setIcon(new ImageIcon(Consulta_Cli.class.getResource("/Imagenes/frame-cli-1.png")));
		lbl_icon2.setBounds(61, 11, 139, 122);
		panel.add(lbl_icon2);
		
		Consulta("");
	}
public void Consulta(String Buscar) {  
		
		try {
			con = Conexion.obtenerconexion();
			String datos[] = new String[8];
			model  = new DefaultTableModel(null,titulos);
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
				Cod_Cli = Rs.getInt(1);
			}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Error al cargar los Datos\n" + ex);
			}
		this.table.setModel(model);
	}
}
