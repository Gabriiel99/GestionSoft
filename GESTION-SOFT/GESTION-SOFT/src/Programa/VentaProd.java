package Programa;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;



import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;

public class VentaProd extends JInternalFrame {

	private JPanel contentPane;
	private JTable table;
	public static JTextField textField;
	public static JTextField textField_1;
	public static JTextField textField_2;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	public static JLabel lblNewLabel_2;
	DefaultTableModel model = new DefaultTableModel();
	public static JTextField textField_3;
	private JLabel lblNewLabel_3;
	public static JTextField textField_4;
	public static JTextField textField_5;
	public static JTextField textField_6;
	public static JLabel lblNewLabel_4 ;
	Connection con=null;
	private JLabel lblSeleccionarCliente;
	public static JTextField textField_7;
	public static JTextField textField_8;
	public static JTextField textField_9;
	public static JTextField textField_10;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentaProd frame = new VentaProd();
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
	public VentaProd() {
		setIconifiable(true);
		setClosable(true);
		setResizable(false);
		setTitle("Facturacion- Venta Mostrador");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(250, 100, 638, 482);
		//setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 96, 570, 170);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Detalle", "Precio U.", "Cantidad", "Total"
			}
		));
		
		model.addColumn("Detalle");
		model.addColumn("Cantidad");
		model.addColumn("Precio");
		model.addColumn("Total");
		table.setModel(model);
		
		table.getColumnModel().getColumn(0).setMinWidth(320);
		table.getColumnModel().getColumn(1).setMinWidth(20);
		table.getColumnModel().getColumn(2).setMinWidth(20);
		table.getColumnModel().getColumn(2).setMinWidth(40);
		
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 13));
		btnNewButton.setBackground(new Color(153, 102, 204));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ConsultaProductos consulta= new ConsultaProductos();
				consulta.setVisible(true);
				//setLocationRelativeTo(null);
			}
		});
		btnNewButton.setBounds(339, 362, 125, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Agregar");
		btnNewButton_1.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 13));
		btnNewButton_1.setBackground(new Color(51, 204, 102));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_1.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Debe agregar la Cantidad!");
				}else {
				String Registros[]= new String[5];
				String Total=null, Precio=null, Codigo, Cantidad=null, Detalle = null;
				Double TOTAL,PRECIO,CANTIDAD;
				
				Detalle=textField.getText();
				Cantidad=textField_1.getText();
				CANTIDAD=Double.parseDouble(Cantidad);

				Precio=textField_2.getText();
				PRECIO=Double.parseDouble(Precio);
				
				TOTAL=PRECIO*CANTIDAD;
				//Acumular+=TOTAL;
				//ACUMULAR=Integer.toString(Acumular);
				Total=TOTAL.toString();
				
				Registros[0]=Detalle;
				Registros[1]=Cantidad;
				Registros[2]=Precio;
				Registros[3]=Total;
				
				model.addRow(Registros);
				textField_3.setText("$"+Total);
				//textField_4.setText(ACUMULAR);
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				
				Total();
				}	
			}
		});
		btnNewButton_1.setBounds(339, 403, 125, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cancelar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 13));
		btnNewButton_2.setBackground(new Color(255, 102, 102));
		btnNewButton_2.setBounds(474, 403, 125, 23);
		contentPane.add(btnNewButton_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		textField.setBounds(29, 362, 274, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		textField_1.setBounds(29, 406, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		textField_2.setBounds(138, 406, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		
		lblNewLabel = new JLabel("Ingrese el Producto");
		lblNewLabel.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 15));
		lblNewLabel.setBounds(29, 342, 180, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Cantidad");
		lblNewLabel_1.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 15));
		lblNewLabel_1.setBounds(29, 393, 99, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Precio");
		lblNewLabel_2.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 15));
		lblNewLabel_2.setBounds(138, 393, 99, 14);
		contentPane.add(lblNewLabel_2);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setFont(new Font("DS-Digital", Font.BOLD, 44));
		textField_3.setBackground(new Color(255, 255, 255));
		textField_3.setEditable(false);
		textField_3.setVisible(false);
		textField_3.setBounds(278, 397, 37, 45);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		lblNewLabel_3 = new JLabel("TOTAL:");
		lblNewLabel_3.setFont(new Font("Superstar M54", Font.BOLD, 35));
		lblNewLabel_3.setBounds(272, 285, 139, 30);
		contentPane.add(lblNewLabel_3);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("DS-Digital", Font.PLAIN, 44));
		textField_5.setEditable(false);
		textField_5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {				
			}
		});
		textField_5.setBounds(411, 277, 188, 45);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Facturar");
		btnNewButton_3.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			/////////////////////77777777
				///FACTURA////////
			
				try{
					String sql="insert into Factura (Fecha_Factura,Total_Factura) values (?,?)";
					con=Conexion.obtenerconexion();
					PreparedStatement pst=con.prepareStatement(sql);
					pst.setString(1, textField_6.getText());
					pst.setString(2, textField_5.getText());
					//pst.setString(3, textField_5.getText());
					
					int n=pst.executeUpdate();
						if(n>0){
								JOptionPane.showMessageDialog(rootPane, "Se registró la Venta de forma correcta!");
								
								while(model.getRowCount()>0) 
								{
									for(int i=0;i<model.getRowCount();i++) {
										model.removeRow(i);
									}
									
								}
								
								
								
							}
								
							}catch(Exception ex){
								ex.printStackTrace();
							}
			
				////////////FIN FACTURA/////////////////////7777
				////////////////////////////////////////////////
				///////DETALLE FACTURA///////////////////////////
				
			/*	try{
					String sql="insert into DetalleFactura (Cantidad_Factura,Precio_Unitario_Factura,Subtotal,Iva_Factura,Id_Factura,Cod_Cliente, Id_prod) values (?,?,?,?,?,?,?)";
					con=ConexionJava.obtenerConexion();
					PreparedStatement pst=con.prepareStatement(sql);
					
					
					
					
					
					int n=pst.executeUpdate();
						if(n>0){
								//JOptionPane.showMessageDialog(rootPane, "Se registró la Venta de forma correcta!");
								
							}
								
							}catch(Exception ex){
								ex.printStackTrace();
							}*/

				
				////////////FIN DETALLE FACTURA////////////////////
				
				/////////////////////Actualizar Stock/////777
				
				
				
				
				
				
				
				
				
				////fin Stock 
				textField_5.setText("");
				textField_7.setText("");
				textField_8.setText("");
				textField_9.setText("");
				textField_10.setText("");
			}
		});
		btnNewButton_3.setBounds(29, 279, 148, 52);
		contentPane.add(btnNewButton_3);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setBounds(478, 362, 121, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 15));
		lblFecha.setBounds(478, 342, 99, 14);
		contentPane.add(lblFecha);
		textField_6.setText(fechaActual());
		
		lblSeleccionarCliente = new JLabel("Nombre Cliente");
		lblSeleccionarCliente.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 15));
		lblSeleccionarCliente.setBounds(29, 11, 148, 14);
		contentPane.add(lblSeleccionarCliente);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setEnabled(false);
		lblNewLabel_4.setVisible(false);
		lblNewLabel_4.setBounds(216, 299, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		
		////////////////////////Recibe Datos de ConsultaProductos/////////
		ConsultaProductos ventana= new ConsultaProductos();
		textField.setText(ventana.envio1);
		textField_2.setText(ventana.envio2);
		lblNewLabel_4.setText(ventana.envio);
		//////////////////////Datos Consulta Clientes
		
		ConClientes CCLi= new ConClientes();
		
		
		
		JButton button = new JButton("Buscar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ConClientes clientecon= new ConClientes();
				clientecon.setVisible(true);
				//setLocationRelativeTo(null);
			}
		});
		button.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 13));
		button.setBackground(new Color(51, 204, 102));
		button.setBounds(474, 62, 125, 23);
		contentPane.add(button);
		
		textField_7 = new JTextField();
		textField_7.setText("");
		textField_7.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		textField_7.setColumns(10);
		textField_7.setBounds(29, 25, 274, 20);
		contentPane.add(textField_7);
		
		JLabel lblApellidoCliente = new JLabel("Apellido Cliente");
		lblApellidoCliente.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 15));
		lblApellidoCliente.setBounds(325, 11, 148, 14);
		contentPane.add(lblApellidoCliente);
		
		textField_8 = new JTextField();
		textField_8.setText("");
		textField_8.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		textField_8.setColumns(10);
		textField_8.setBounds(325, 25, 274, 20);
		contentPane.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setText("");
		textField_9.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		textField_9.setColumns(10);
		textField_9.setBounds(254, 65, 180, 20);
		contentPane.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setText("");
		textField_10.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		textField_10.setColumns(10);
		textField_10.setBounds(29, 65, 168, 20);
		contentPane.add(textField_10);
		
		JLabel lblCuit = new JLabel("C.U.I.T");
		lblCuit.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 15));
		lblCuit.setBounds(29, 51, 148, 14);
		contentPane.add(lblCuit);
		
		JLabel lblCategoriaIva = new JLabel("Categoria IVA");
		lblCategoriaIva.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 15));
		lblCategoriaIva.setBounds(263, 52, 148, 14);
		contentPane.add(lblCategoriaIva);
		
		//////finRecibeDAtos/////
		
		
		Total();
		
	}
	//////////Obtener FechaActual///
	public static String fechaActual() 
	{
		Date fecha= new Date();
		SimpleDateFormat formatoFecha= new SimpleDateFormat("dd/MM/YYYY");
		return formatoFecha.format(fecha);
		
	}
	////////Calculo del Total, Acumulador///////77
	public void Total() 
	{
		
		Double Total1=0.0;
		Double Acumular=0.0;
		if(table.getRowCount()>=0) {
			
			for(int i=0;i<table.getRowCount();i++) 
			{
				
				Acumular=Double.parseDouble(table.getValueAt(i, 3).toString());
				Total1 =Total1+Acumular;
				//System.out.print(Total1);
				
				textField_5.setText("$"+Total1.toString()+"0");
				
			}
			
			
		}
		
		
	}
	
	public void Consulta() 
	{
		
	}
}