package Programa;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;


public class ConsultaVentas extends JInternalFrame {

private JPanel contentPane;
	
	public static String envioCodCli="";
	public static String envioNombCli="";
	public static String envioApeCli="";
	public static String categoriaCli="";
	public static String cuitCli="";
	DefaultTableModel Model = new DefaultTableModel();
	Connection con = null;
	public static JTable tableCli;
	public static TableRowSorter trs;
	//public static JTable table;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaVentas frame = new ConsultaVentas();
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
	public ConsultaVentas() {
		setIconifiable(true);
		setClosable(true);
		setResizable(false);
		setTitle("Facturacion- Consulta de Venta");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		//setLocationRelativeTo(null);
		setBounds(300, 100, 594, 229);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		////////////////////////////////7
		/*Dimension pantalla, cuadro;
		pantalla= Toolkit.getDefaultToolkit().getScreenSize();
		cuadro= this.getSize();
		
		this.setLocation(((pantalla.width - cuadro.width)/2),(pantalla.height - cuadro.height)/2);*/
		
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(51, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		scrollPane.setBounds(33, 29, 520, 120);
		contentPane.add(scrollPane);
		
		Model = new DefaultTableModel();
		Model.addColumn("Cod. Factura");
		Model.addColumn("Fecha");
		Model.addColumn("Monto Vendido");
		tableCli = new JTable(Model);
		tableCli.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				tableCMouseClicked(evt);
			}
		});
		tableCli.setBackground(new Color(51, 204, 153));
		tableCli.setForeground(Color.BLACK);
		tableCli.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 14));
		
		tableCli.getColumnModel().getColumn(0).setMinWidth(40);
		tableCli.getColumnModel().getColumn(1).setMinWidth(80);
		tableCli.getColumnModel().getColumn(2).setMinWidth(80);
	
		scrollPane.setViewportView(tableCli);
	
		JButton btnNewButton_1 = new JButton("Cerrar");
		btnNewButton_1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			dispose();
				
			}
		});
		btnNewButton_1.setBounds(225, 166, 114, 25);
		contentPane.add(btnNewButton_1);
		
		Mostrar();
	}

	protected void tableCMouseClicked(MouseEvent evt) {
		// TODO Auto-generated method stub
		
	}
	
	public void Mostrar() 
	{
		try {
			con = Conexion.obtenerconexion();
			String dts[]= new String[4];
			String sql = "select * from Factura";
			Statement st= con.createStatement();
			ResultSet rs= st.executeQuery(sql);
			while(rs.next()) {
				dts[0]=rs.getString("Id_Factura");
				dts[1]=rs.getString("Fecha_Factura");
				dts[2]=rs.getString("Total_Factura");
				
				Model.addRow(dts);
				
				trs = new TableRowSorter(Model);
				tableCli.setRowSorter(trs);
				
			}
			
			
		}catch(Exception ex) 
		{
			JOptionPane.showMessageDialog(rootPane, "Error al Cargar");
			ex.printStackTrace();
			
		}
		
		
	}
	
}