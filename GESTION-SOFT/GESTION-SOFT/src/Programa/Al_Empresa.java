package Programa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Al_Empresa extends JInternalFrame {

	private JPanel contentPane;
	private JTextField textId;
	private JTextField textNombre;
	private JTextField textCuit;
	private JTextField textCat;
	private JTextField textDireccion;
	private JTextField textTelefono;
	private int pesp;
	Connection con=null;
	JTable tblEmp;
	DefaultTableModel dtmTitulos;
	String titulos []={"Id" , "Nombre de Empresa" , "CUIT" , "Categoria IVA" , "Direccion", "Telefono", "Sucursal"};
	public String seleccion;
	private JTextField textSim;
	private JTextField textField;
	private JTextField textSucursal;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Al_Empresa frame = new Al_Empresa();
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
	public Al_Empresa() {
		setFrameIcon(new ImageIcon(Al_Empresa.class.getResource("/Imagenes/GS.png")));
		setTitle("Alta de Empresa");
		setIconifiable(true);
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(150, 10, 850, 601);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNEmpresa = new JLabel("Nombre de Empresa");
		lblNEmpresa.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 14));
		lblNEmpresa.setBounds(43, 100, 172, 22);
		contentPane.add(lblNEmpresa);
		
		JLabel lblCuit = new JLabel("CUIT");
		lblCuit.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 14));
		lblCuit.setBounds(43, 140, 46, 22);
		contentPane.add(lblCuit);
		
		JLabel lblCatIva = new JLabel("Categoria IVA");
		lblCatIva.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 14));
		lblCatIva.setBounds(43, 180, 123, 22);
		contentPane.add(lblCatIva);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 14));
		lblDireccion.setBounds(43, 220, 92, 22);
		contentPane.add(lblDireccion);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 14));
		lblTelefono.setBounds(43, 260, 92, 22);
		contentPane.add(lblTelefono);
		
		textNombre = new JTextField();
		textNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
					textCuit.requestFocus();
				}
			}
		});
		textNombre.setHorizontalAlignment(SwingConstants.CENTER);
		textNombre.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 15));
		textNombre.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		textNombre.setBounds(271, 95, 224, 28);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textCuit = new JTextField();
		textCuit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
					textCat.requestFocus();
				}
			}
		});
		textCuit.setHorizontalAlignment(SwingConstants.CENTER);
		textCuit.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 15));
		textCuit.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		textCuit.setBounds(271, 135, 224, 28);
		contentPane.add(textCuit);
		textCuit.setColumns(10);
		
		textCat = new JTextField();
		textCat.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
					textDireccion.requestFocus();
				}
			}
		});
		textCat.setHorizontalAlignment(SwingConstants.CENTER);
		textCat.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 15));
		textCat.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		textCat.setBounds(271, 175, 224, 28);
		contentPane.add(textCat);
		textCat.setColumns(10);
		
		textDireccion = new JTextField();
		textDireccion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
					textTelefono.requestFocus();
				}
			}
		});
		textDireccion.setHorizontalAlignment(SwingConstants.CENTER);
		textDireccion.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 15));
		textDireccion.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		textDireccion.setBounds(271, 215, 224, 28);
		contentPane.add(textDireccion);
		textDireccion.setColumns(10);
		
		textTelefono = new JTextField();
		textTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
					textSucursal.requestFocus();
				}
			}
		});
		textTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		textTelefono.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 15));
		textTelefono.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		textTelefono.setBounds(271, 255, 224, 28);
		contentPane.add(textTelefono);
		textTelefono.setColumns(10);
		
		tblEmp =new JTable(dtmTitulos);
		tblEmp.setBackground(new Color(102, 204, 153));
		tblEmp.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 11));
		
		JScrollPane jspVisible = new JScrollPane(tblEmp);
		jspVisible.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		jspVisible.setBounds(10, 351, 814, 200);
		contentPane.add(jspVisible);
		
mostrar();
		
		tblEmp.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent evt){
				tblEmpMouseClicked(evt);
				
			}

			private void tblEmpMouseClicked(MouseEvent evt) {
				try{
				int fila = tblEmp.rowAtPoint(evt.getPoint());
				textField.setText(tblEmp.getValueAt(fila, 0).toString());
				textNombre.setText(tblEmp.getValueAt(fila, 1).toString());
				textCuit.setText(tblEmp.getValueAt(fila, 2).toString());
				textCat.setText(tblEmp.getValueAt(fila, 3).toString());
				textDireccion.setText(tblEmp.getValueAt(fila, 4).toString());
				textTelefono.setText(tblEmp.getValueAt(fila, 5).toString());
				textSucursal.setText(tblEmp.getValueAt(fila, 6).toString());
				}catch (Exception ex){
					System.out.println("ERROR AL SELECCIONAR UN REGISTRO : " + ex.getMessage());
				}
			}
		});
		
		JScrollPane jspPrueba = new JScrollPane();
		
		JButton btnAgregar = new JButton("Registrar");
		btnAgregar.setIcon(new ImageIcon(Al_Empresa.class.getResource("/Imagenes/agregar_empresa.png")));
		btnAgregar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		btnAgregar.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 13));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					    String sql= "insert into Empresa (Nombre_Empresa, CUIT, Categoria_IVA, Direccion_Empresa, Telefono_Empresa, Sucursal_Emp) values (?,?,?,?,?,?)";
					    con=Conexion.obtenerconexion();
						PreparedStatement pst=con.prepareStatement(sql);
						pst.setString(1, textNombre.getText());
						pst.setString(2, textCuit.getText());
						pst.setString(3, textCat.getText());
						pst.setString(4, textDireccion.getText());
						pst.setString(5, textTelefono.getText());
						pst.setString(6, textSucursal.getText());
						int n = pst.executeUpdate();
						if(n>0){
							JOptionPane.showMessageDialog(rootPane, "Se registró de forma correcta!");
						}
					
						
				}catch(Exception ex){
					ex.printStackTrace();
				}
				mostrar();
				textNombre.setText("");
				textCuit.setText("");
				textCat.setText("");
				textDireccion.setText("");
				textTelefono.setText("");
				textSucursal.setText("");
				
			}
		});
		btnAgregar.setBounds(538, 100, 145, 60);
		contentPane.add(btnAgregar);
		
		JButton btnLCam = new JButton("Limpiar");
		btnLCam.setIcon(new ImageIcon(Al_Empresa.class.getResource("/Imagenes/limpiar.png")));
		btnLCam.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		btnLCam.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 13));
		btnLCam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnEditarActionPerformed(evt);
			}
		});
		btnLCam.setBounds(538, 190, 145, 60);
		contentPane.add(btnLCam);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(Al_Empresa.class.getResource("/Imagenes/eliminar_empr.png")));
		btnEliminar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		btnEliminar.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 14));
		btnEliminar.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent evt){
		    	  btnEliminarActionPerformed(evt);
		  		mostrar();
			}

			
		});
		btnEliminar.setBounds(538, 280, 145, 60);
		contentPane.add(btnEliminar);
		
		textField = new JTextField();
		textField.setVisible(false);
		textField.setBounds(225, 11, 1, 1);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCantidadDeSucursales = new JLabel("Sucursal");
		lblCantidadDeSucursales.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 14));
		lblCantidadDeSucursales.setBounds(43, 300, 134, 22);
		contentPane.add(lblCantidadDeSucursales);
		
		textSucursal = new JTextField();
		textSucursal.setHorizontalAlignment(SwingConstants.CENTER);
		textSucursal.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 15));
		textSucursal.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		textSucursal.setBounds(271, 295, 224, 28);
		contentPane.add(textSucursal);
		textSucursal.setColumns(10);
		
		JLabel lblAltaDeEmpresa = new JLabel("Alta de Empresa");
		lblAltaDeEmpresa.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 25));
		lblAltaDeEmpresa.setBounds(271, 37, 245, 35);
		contentPane.add(lblAltaDeEmpresa);
		
		JLabel imagen = new JLabel("");
		imagen.setIcon(new ImageIcon(Al_Empresa.class.getResource("/Imagenes/empresa (1).png")));
		imagen.setBounds(693, 11, 131, 128);
		contentPane.add(imagen);
		
		
		
		}

protected void btnEditarActionPerformed(ActionEvent evt) {
	textField.setText("");
	textNombre.setText("");
	textCuit.setText("");
	textCat.setText("");
	textDireccion.setText("");
	textTelefono.setText("");
	textSucursal.setText("");
		
	}

protected void btnEliminarActionPerformed(ActionEvent evt) {
	int eli=tblEmp.getSelectedRow();
	if(eli>=0) { 
		int resp=JOptionPane.showConfirmDialog(null, "Está seguro de eliminar el registro?",
			null, JOptionPane.YES_NO_OPTION, pesp);
		if (JOptionPane.OK_OPTION==resp){
			try {
				Connection con = null;
	            con = Conexion.obtenerconexion();
	            String sql = "delete from Empresa where Id_Emp = ?";
	            PreparedStatement pst = con.prepareStatement(sql);
	            pst.setInt(1, Integer.parseInt(textField.getText()));
	            int n = pst.executeUpdate();
	            if (n > 0){
	            JOptionPane.showMessageDialog(rootPane, "Datos eliminados correctamente!");
	            
	            mostrar();
				textField.setText("");
				textNombre.setText("");
				textCuit.setText("");
				textCat.setText("");
				textDireccion.setText("");
				textTelefono.setText("");
				textSucursal.setText("");
	            }
	        } catch (SQLException ex){
	            JOptionPane.showMessageDialog(rootPane, "Datos no eliminados de forma correcta!"+ ex.getMessage());
	        }

			}
			} else {
				JOptionPane.showMessageDialog(rootPane, "No hay registros para eliminar!");
			}
		
	}

public void mostrar(){
		try{
			con =Conexion.obtenerconexion();
			DefaultTableModel dtmTitulos = new DefaultTableModel(null, titulos);
			String dts []=new String [7];
			String sql="select * from Empresa";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				dts[0]=rs.getString("Id_Emp");
				dts[1]=rs.getString("Nombre_Empresa");
				dts[2]=rs.getString("CUIT");
				dts[3]=rs.getString("Categoria_IVA");
				dts[4]=rs.getString("Direccion_Empresa");
				dts[5]=rs.getString("Telefono_Empresa");
				dts[6]=rs.getString("Sucursal_Emp");
				
				dtmTitulos.addRow(dts);
			}
			tblEmp.setModel(dtmTitulos);
			tblEmp.getColumnModel().getColumn(0).setMaxWidth(0);
			tblEmp.getColumnModel().getColumn(0).setMinWidth(0);
			tblEmp.getColumnModel().getColumn(0).setPreferredWidth(0);
			
		} catch(Exception ex){
   		 ex.printStackTrace();
   		 con=null;
			}
	}
}
