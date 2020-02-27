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

public class ConClientes extends JFrame {

	private JPanel contentPane;
	
	public static String envioCodCli="";
	public static String envioNombCli="";
	public static String envioApeCli="";
	public static String categoriaCli="";
	public static String cuitCli="";
	public static JTextField textField;
	public static JTextField textField_1;
	public static JTextField textField_2;
	DefaultTableModel Model = new DefaultTableModel();
	Connection con = null;
	public static JTable tableCli;
	public static TableRowSorter trs;
	public static JTextField textField_3;
	public static JTextField textField_4;
	//public static JTable table;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConClientes frame = new ConClientes();
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
	public ConClientes() {
		setTitle("Facturacion- Consulta de Clientes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 675, 322);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(20, 207, 72, 20);
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
			
				envioCodCli=textField.getText();
				envioNombCli=textField_1.getText();
				envioApeCli=textField_2.getText();
				cuitCli=textField_3.getText();
				categoriaCli=textField_4.getText();
				VentaProd.textField_7.setText(envioNombCli);
				VentaProd.textField_8.setText(envioApeCli);
				VentaProd.textField_9.setText(cuitCli);
				VentaProd.textField_10.setText(categoriaCli);
				dispose();
			}
		});
		btnNewButton.setBounds(167, 160, 89, 23);
		contentPane.add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setBounds(153, 207, 192, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(398, 207, 178, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Codigo");
		lblNewLabel.setBounds(21, 194, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre Cliente");
		lblNewLabel_1.setBounds(153, 194, 116, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido Cliente");
		lblNewLabel_2.setBounds(398, 194, 134, 14);
		contentPane.add(lblNewLabel_2);
		
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(51, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		scrollPane.setBounds(33, 29, 595, 120);
		contentPane.add(scrollPane);
		
		Model = new DefaultTableModel();
		Model.addColumn("Cod Cliente");
		Model.addColumn("Nombre");
		Model.addColumn("Apellido");
		Model.addColumn("Cat. IVA");
		Model.addColumn("D.N.I/C.U.I.T");
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
		
		tableCli.getColumnModel().getColumn(0).setMinWidth(30);
		tableCli.getColumnModel().getColumn(1).setMinWidth(120);
		tableCli.getColumnModel().getColumn(2).setMinWidth(120);
		tableCli.getColumnModel().getColumn(3).setMinWidth(120);
		scrollPane.setViewportView(tableCli);
	
		
		
		
		
		
		
		
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBackground(new Color(255, 102, 102));
		btnNewButton_1.setBounds(367, 160, 89, 23);
		contentPane.add(btnNewButton_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(313, 252, 192, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(33, 252, 192, 20);
		contentPane.add(textField_4);
		
		JLabel lblDnicuit = new JLabel("D.N.I/C.U.I.T");
		lblDnicuit.setBounds(64, 238, 116, 14);
		contentPane.add(lblDnicuit);
		
		JLabel lblCategoriaIva = new JLabel("Categoria IVA");
		lblCategoriaIva.setBounds(313, 238, 116, 14);
		contentPane.add(lblCategoriaIva);
		
		Mostrar();
	}

	protected void tableCMouseClicked(MouseEvent evt) {
		// TODO Auto-generated method stub
		try {
			int fila = tableCli.getSelectedRow();
            textField.setText(tableCli.getValueAt(fila, 0).toString());
            textField_1.setText(tableCli.getValueAt(fila, 1).toString());
            textField_2.setText(tableCli.getValueAt(fila, 2).toString());
            textField_3.setText(tableCli.getValueAt(fila, 3).toString());
            textField_4.setText(tableCli.getValueAt(fila, 4).toString());
			
			
		}catch(Exception ex){
			   System.out.println("Error al seleccionar un registro! : " + ex.getMessage());
		}
		
		
	}
	
	public void Mostrar() 
	{
		try {
			con = Conexion.obtenerconexion();
			String dts[]= new String[5];
			String sql = "select * from Clientes";
			Statement st= con.createStatement();
			ResultSet rs= st.executeQuery(sql);
			while(rs.next()) {
				dts[0]=rs.getString("Cod_Cli");
				dts[1]=rs.getString("Nombre_Cli");
				dts[2]=rs.getString("Apellido_Cli");
				dts[3]=rs.getString("Categoria_Iva_Cli");
				dts[4]=rs.getString("Dni_Cuit_Cli");
				
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