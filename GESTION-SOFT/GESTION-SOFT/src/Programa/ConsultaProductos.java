package Programa;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

//import ConexionJava;

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

public class ConsultaProductos extends JFrame {

	private JPanel contentPane;
	
	public static String envio="";
	public static String envio1="";
	public static String envio2="";
	public static JTextField textField;
	public static JTextField textField_1;
	public static JTextField textField_2;
	DefaultTableModel Model = new DefaultTableModel();
	Connection con = null;
	public static JTable tableC;
	public static TableRowSorter trs;
	//public static JTable table;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaProductos frame = new ConsultaProductos();
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
	public ConsultaProductos() {
		setTitle("Facturacion- Consulta de Productos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 570, 310);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(20, 218, 89, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		////////////////////////////////7
		Dimension pantalla, cuadro;
		pantalla= Toolkit.getDefaultToolkit().getScreenSize();
		cuadro= this.getSize();
		
		this.setLocation(((pantalla.width - cuadro.width)/2),(pantalla.height - cuadro.height)/2);
		
		//////////////////////////////////////////////
		
		
		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.setBackground(new Color(51, 204, 102));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				envio= textField.getText();
				envio1=textField_1.getText();
				envio2=textField_2.getText();
				VentaProd.textField.setText(envio1);
				//VentaProductos.lblNewLabel_4.setText(envio);
				VentaProd.textField_2.setText(envio2);
			//	VentaProductos enviar= new VentaProductos();
				//enviar.setVisible(true);
				//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				dispose();
				
			}
		});
		btnNewButton.setBounds(110, 160, 89, 23);
		contentPane.add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setBounds(187, 218, 209, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(440, 218, 95, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Codigo");
		lblNewLabel.setBounds(21, 205, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Detalle");
		lblNewLabel_1.setBounds(190, 205, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Precio");
		lblNewLabel_2.setBounds(441, 205, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(51, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		scrollPane.setBounds(33, 29, 479, 120);
		contentPane.add(scrollPane);
		
		Model = new DefaultTableModel();
		Model.addColumn("Codigo");
		Model.addColumn("Detalle");
		Model.addColumn("Precio");
		tableC = new JTable(Model);
		tableC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				tableCMouseClicked(evt);
			}
		});
		tableC.setBackground(new Color(51, 204, 153));
		tableC.setForeground(Color.BLACK);
		tableC.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 14));
		
		tableC.getColumnModel().getColumn(0).setMinWidth(20);
		tableC.getColumnModel().getColumn(1).setMinWidth(320);
		tableC.getColumnModel().getColumn(2).setMinWidth(20);
		scrollPane.setViewportView(tableC);
	
		
		
		
		
		
		
		
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBackground(new Color(255, 102, 102));
		btnNewButton_1.setBounds(330, 160, 89, 23);
		contentPane.add(btnNewButton_1);
		
		
		
		
		
		
		Mostrar();
	}

	protected void tableCMouseClicked(MouseEvent evt) {
		// TODO Auto-generated method stub
		try {
			int fila = tableC.getSelectedRow();
            textField.setText(tableC.getValueAt(fila, 0).toString());
            textField_1.setText(tableC.getValueAt(fila, 1).toString());
            textField_2.setText(tableC.getValueAt(fila, 2).toString());
            
           
			
			
		}catch(Exception ex){
			   System.out.println("ERROR AL SELECCIONAR UN EQUIPO : " + ex.getMessage());
		}
		
		
	}
	
	public void Mostrar() 
	{
		try {
			con = Conexion.obtenerconexion();
			String dts[]= new String[3];
			String sql = "select * from Productos";
			Statement st= con.createStatement();
			ResultSet rs= st.executeQuery(sql);
			while(rs.next()) {
				dts[0]=rs.getString("Cod_Prod");
				dts[1]=rs.getString("Nom_Prod");
				dts[2]=rs.getString("Precio_Prod");
				Model.addRow(dts);
				
				trs = new TableRowSorter(Model);
				tableC.setRowSorter(trs);
				
			}
			
			
		}catch(Exception ex) 
		{
			JOptionPane.showMessageDialog(rootPane, "Error al Cargar");
			ex.printStackTrace();
			
		}
		
		
	}
	
}