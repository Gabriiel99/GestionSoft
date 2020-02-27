package Programa;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
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
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFormattedTextField;

public class A_Prod extends JInternalFrame {
	DefaultComboBoxModel combo = new DefaultComboBoxModel();
	DefaultTableModel modelo = new DefaultTableModel();
	private JComboBox comboCodigo;
	private JPanel contentPane;
	private JTextField textArticulo;
	private JTextField textPrecio;
	private JTextField textStock;
	private JLabel lblArticulo;
	private JButton btnAgregar;
	Connection con=null;
	public static TableRowSorter trs;
	JTable tblProducto;
	JScrollPane jspProducto;
	private JButton btnGuardar;
	
	String titulos[]={"Id_Prod","Cod_Prod","Nom_Prod","Precio_Prod","Stock_Prod","Id_Rubro"};
	
	public int operacion;
	private int contador = 0;
	int p, pesp,a;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lbl_Imagen;
	private JLabel label_salir;
	private JLabel user;
	private String cod;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					A_Prod frame = new A_Prod();
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
	public A_Prod() {
		setFrameIcon(new ImageIcon(A_Prod.class.getResource("/Imagenes/GS.png")));
		
		setTitle("Alta de Producto");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(50, 20, 1100, 550);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	    
	    user = new JLabel("");
	    user.setVisible(false);
	    user.setBounds(0, 0, 46, 14);
	    user.setText(Logeo.usuario);
	    contentPane.add(user);
		
	    lblArticulo = new JLabel("");
	    lblArticulo.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 16));
		lblArticulo.setBounds(304, 50, 173, 25);
		contentPane.add(lblArticulo);
		
		comboCodigo = new JComboBox();
		comboCodigo.setModel(new DefaultComboBoxModel(new String[] {"SELECCIONAR C\u00D3DIGO"}));
		comboCodigo.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
			combo1ActionPerformed(evt);
			}
		});
		comboCodigo.setForeground(new Color(0, 0, 0));
		
	    comboCodigo.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 13));
		comboCodigo.setBounds(70, 30, 200, 28);
		combo();//LLAMO AL METODO COMBO, PARA QUE LO MUESTRE
		contentPane.add(comboCodigo);
		
		JLabel lblDescripcion = new JLabel("Producto");
		lblDescripcion.setForeground(new Color(0, 0, 0));
		lblDescripcion.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 20));
		lblDescripcion.setBounds(70, 80, 100, 20);
		contentPane.add(lblDescripcion);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setForeground(new Color(0, 0, 0));
		lblPrecio.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 20));
		lblPrecio.setBounds(70, 124, 73, 20);
		contentPane.add(lblPrecio);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setForeground(new Color(0, 0, 0));
		lblStock.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 20));
		lblStock.setBounds(70, 162, 75, 20);
		contentPane.add(lblStock);
		
		textArticulo = new JTextField();
		textArticulo.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 13));
		textArticulo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
					textPrecio.requestFocus();
				}
			}
		});
		textArticulo.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(51, 204, 153), new Color(51, 204, 204), new Color(51, 204, 153), new Color(51, 204, 204)));
		textArticulo.setBounds(175, 78, 461, 28);
		contentPane.add(textArticulo);
		textArticulo.setColumns(10);
		
		textPrecio = new JTextField();
		textPrecio.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 13));
		textPrecio.addKeyListener(new KeyAdapter() {
			/*@Override
			public void keyTyped(KeyEvent evt) {
				float c = evt.getKeyChar();
				if(c<'0' || c>'9') evt.consume();
			}*/
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
					textStock.requestFocus();
			}
		  }
		});
		textPrecio.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(51, 204, 153), new Color(51, 204, 204), new Color(51, 204, 153), new Color(51, 204, 204)));
		textPrecio.setBounds(175, 120, 86, 28);
		contentPane.add(textPrecio);
		textPrecio.setColumns(10);
		
		textStock = new JTextField();
		textStock.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 13));
		textStock.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if(c<'0' || c>'9') evt.consume();
			}
		});
		textStock.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(51, 204, 153), new Color(51, 204, 204), new Color(51, 204, 153), new Color(51, 204, 204)));
		textStock.setBounds(175, 160, 86, 28);
		contentPane.add(textStock);
		textStock.setColumns(10);

		modelo =new DefaultTableModel();
		modelo.addColumn("Id_Prod");
		modelo.addColumn("Código");
		modelo.addColumn("Descripción");
		modelo.addColumn("Precio *");
		modelo.addColumn("Stock");
		modelo.addColumn("Id_Rubro");
		tblProducto=new JTable(modelo);
		   
		tblProducto.setBackground(new Color(51, 204, 153));
		tblProducto.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 12));
		tblProducto.setForeground(new Color(0, 0, 0));
		tblProducto.addMouseListener(new MouseAdapter() {
		   	@Override
		   	public void mouseClicked(MouseEvent evt) {
		   		jTable1MouseClicked(evt);
		   	}
		   });
	    jspProducto=new JScrollPane(tblProducto);
	    jspProducto.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(51, 204, 153), new Color(51, 204, 204), new Color(51, 204, 153), new Color(51, 204, 204)));
		   
		getContentPane().add(jspProducto);
		jspProducto.setBounds(28,260,1025,193);
		   
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setIcon(new ImageIcon(A_Prod.class.getResource("/Imagenes/guardar.png")));
		btnAgregar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(51, 204, 153), new Color(51, 204, 204), new Color(51, 204, 153), new Color(51, 204, 204)));
		btnAgregar.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 12));
		
		mostrar();
		   
		   btnAgregar.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent arg0) {
		   		if (textArticulo.getText().isEmpty() || textPrecio.getText().isEmpty() 
						|| textStock.getText().isEmpty()){
							JOptionPane.showMessageDialog(null, "Debe completar todos los campos");
				} else {
		   		operacion = Integer.parseInt((String)comboCodigo.getSelectedItem().toString());
		   		operacion = operacion+1;
				for(int i=0;i<tblProducto.getRowCount();i++){
					p=Integer.parseInt((String) tblProducto.getValueAt(i, 0));
					for(int i1=operacion;i1==p;i1=operacion+1) {
					if(p<operacion||p==operacion){
						operacion=p+1;
					}else {
						operacion=p-1;}}}
				for(int i=0; i<tblProducto.getRowCount();i++) {
					a=Integer.parseInt((String)tblProducto.getValueAt(i, 1));
					if(a==operacion) {
						operacion=a+1;
						}
					}
						
				try{
				String sql="insert into Productos (Cod_Prod,Nom_Prod,Precio_Prod,Stock_Prod,Id_Rubro) values (?,?,?,?,?)";
				con=Conexion.obtenerconexion();
				PreparedStatement pst=con.prepareStatement(sql);
				pst.setString(1, (String.valueOf(operacion)));
				pst.setString(2, textArticulo.getText());
				pst.setString(3, textPrecio.getText());
				pst.setString(4, textStock.getText());
				pst.setString(5, textField_1.getText());
				int n=pst.executeUpdate();
					if(n>0){
							JOptionPane.showMessageDialog(rootPane, "Se registró de forma correcta!");
						}
							
						}catch(Exception ex){
							ex.printStackTrace();
						}
				textField.setText("");
				textArticulo.setText("");
				textPrecio.setText("");
				textStock.setText("");
				textField_1.setText("");
				lblArticulo.setText("");
				comboCodigo.setSelectedItem("SELECCIONAR CODIGO");
				
				mostrar();
				}
		   	}
		   });
		btnAgregar.setBounds(200, 195, 150, 60);
		contentPane.add(btnAgregar);
		
		textField = new JTextField();
		textField.setVisible(false);
		textField.setBounds(180, 259, 1, 1);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(A_Prod.class.getResource("/Imagenes/eliminar.png")));
		btnEliminar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(51, 204, 153), new Color(51, 204, 204), new Color(51, 204, 153), new Color(51, 204, 204)));
		btnEliminar.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 12));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnEliminarActionPerformed(evt);
				  
				mostrar();
			}
		});
		btnEliminar.setBounds(380, 195, 150, 60);
		contentPane.add(btnEliminar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setIcon(new ImageIcon(A_Prod.class.getResource("/Imagenes/mod_prod.png")));
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				int eli=tblProducto.getSelectedRow();
				if(eli>=0){
				try
		        {
				 
		            int fila = tblProducto.getSelectedRow();
		              //textField.setText(tblProducto.getValueAt(fila, 0).toString());
		            cod=(tblProducto.getValueAt(fila, 0).toString());
		            textArticulo.setText(tblProducto.getValueAt(fila, 2).toString());
		            textPrecio.setText(tblProducto.getValueAt(fila, 3).toString());
		            textStock.setText(tblProducto.getValueAt(fila, 4).toString());
		            btnAgregar.setEnabled(false);
					btnGuardar.setVisible(true);
					btnModificar.setVisible(false);
		           
		        } catch (Exception ex)
		        {
		            System.out.println("No Pudo Actualizar Registro: " + ex.getMessage());
		        }
				}else {
					JOptionPane.showMessageDialog(null, "Seleccione una fila para poder modificar");
				}
				
			}
		});
		btnModificar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		btnModificar.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 12));
		btnModificar.setBounds(558, 195, 150, 60);
		contentPane.add(btnModificar);

		
		textField_1 = new JTextField();
		textField_1.setVisible(false);
		textField_1.setBounds(180, 259, 1, 1);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		lbl_Imagen = new JLabel("");
		lbl_Imagen.setIcon(new ImageIcon(A_Prod.class.getResource("/Imagenes/frame-alta_prod.png")));
		lbl_Imagen.setBounds(754, 11, 330, 258);
		contentPane.add(lbl_Imagen);
		
		label_salir = new JLabel("");
		label_salir.setIcon(new ImageIcon(A_Prod.class.getResource("/Imagenes/salir_cli.png")));
		label_salir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Object [] opciones = { "Si","No"};
				int eleccion = JOptionPane.showOptionDialog(rootPane, "¿Está seguro?", "Cerrar Alta de Productos!", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, "ACEPTAR");
				if (eleccion==JOptionPane.YES_OPTION) {
					dispose();
				}
			}
		});
		label_salir.setToolTipText("Cerrar");
		label_salir.setBounds(1029, 459, 55, 50);
		contentPane.add(label_salir);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setIcon(new ImageIcon(A_Prod.class.getResource("/Imagenes/mod_prod.png")));
		btnGuardar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(51, 204, 153), new Color(51, 204, 204), new Color(51, 204, 153), new Color(51, 204, 204)));
		btnGuardar.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 12));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					con = Conexion.obtenerconexion();
					Statement st = con.createStatement();
					String sql = "Update Productos set Nom_Prod = ?, Precio_Prod = ?,Stock_Prod = ? where Id_Prod = ?";
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1, textArticulo.getText());
					ps.setString(2, textPrecio.getText());
					ps.setString(3, textStock.getText());
					ps.setInt(4, Integer.parseInt(cod));
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Registro Actualizado");
					
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "No Pudo Actualizar Productos "+e);
			}
				textField.setText("");
				textArticulo.setText("");
				textPrecio.setText("");
				textStock.setText("");
				textField_1.setText("");
				lblArticulo.setText("");
				
		    btnAgregar.setEnabled(true);
			mostrar();
			
			btnGuardar.setVisible(false);
			btnModificar.setVisible(true);
			}
		});
		btnGuardar.setBounds(558, 195, 150, 60);
		btnGuardar.setVisible(false);
		contentPane.add(btnGuardar);

		
		
		JLabel lbllosValoresEstn = new JLabel("*Los valores est\u00E1n expresados en Pesos Argentinos");
		lbllosValoresEstn.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 12));
		lbllosValoresEstn.setBounds(28, 459, 502, 14);
		contentPane.add(lbllosValoresEstn);
		
		//----------------------------------------------------------------------------------------//
				String restr;
				restr = user.getText();
				if (restr.equals("ADMIN")) {
					
				} else if ((restr.equals("admin"))){
					
				} else {
					btnEliminar.setEnabled(false);
				}
		//----------------------------------------------------------------------------------------//
		
	}
	protected void jTable1MouseClicked(MouseEvent evt) {
		 try
	        {
	           
			 int fila = tblProducto.getSelectedRow();
			 cod=(tblProducto.getValueAt(fila, 0).toString());
	           /* textField.setText(tblProducto.getValueAt(fila, 0).toString());
	            textArticulo.setText(tblProducto.getValueAt(fila, 2).toString());
	            textPrecio.setText(tblProducto.getValueAt(fila, 3).toString());
	            textStock.setText(tblProducto.getValueAt(fila, 4).toString());*/
	            
	        } catch (Exception ex){
	            System.out.println("Error al seleccionar un registro! : " + ex.getMessage());
	        }
		}

	protected void btnEliminarActionPerformed(ActionEvent evt) {
		
		int eli=tblProducto.getSelectedRow();
		if(eli>=0) { 
			int resp=JOptionPane.showConfirmDialog(null, "Está seguro de eliminar?",
				null, JOptionPane.YES_NO_OPTION, pesp);
			if (JOptionPane.OK_OPTION==resp){
				try {
		            Connection con = null;
		            Conexion conect = new Conexion();
		            con = conect.obtenerconexion();
		            Statement st = con.createStatement();
		            String sql = "delete from Productos where Id_Prod = ?";
		            PreparedStatement pst = con.prepareStatement(sql);
		            pst.setInt(1, Integer.parseInt(cod));
		           // pst.setInt(1, Integer.parseInt(textField.getText()));
		            int n = pst.executeUpdate();
		            if (n > 0){
		            JOptionPane.showMessageDialog(this, "DATOS ELIMINADOS CORRECTAMENTE");
		            textField_1.setText("");
		            textField.setText("");
		            textArticulo.setText("");
					textPrecio.setText("");
					textStock.setText("");
		            }
		        } catch (SQLException ex){
		            JOptionPane.showMessageDialog(this, "DATOS NO ELIMINADOS CORRECTAMENTE" + ex.getMessage());
		        }

				}
				} else {
					JOptionPane.showMessageDialog(null, "No hay datos para eliminar");
				}
	}

	protected void combo1ActionPerformed(ActionEvent evt) {
		try{
			if(this.contador>0){
                ResultSet rs = null;
                Connection con2 = null;
                Conexion conect2 = new Conexion();
                con2 = conect2.obtenerconexion();
                Statement Sent = con2.createStatement();
                ResultSet rs1 = Sent.executeQuery("select * from Rubros where Cod_Rubro= '" + this.comboCodigo.getSelectedItem().toString() + "'");
                rs1.next();
               
                this.lblArticulo.setText(String.valueOf(rs1.getString("Nom_Rubro")));
                this.textField_1.setText(String.valueOf(rs1.getString("Id_Rubro")));
          }
           
        }catch(SQLException e){
        	
           //JOptionPane.showMessageDialog(null, e);
        }
	}

	public void combo(){
		this.comboCodigo.removeAllItems();
        this.comboCodigo.addItem("SELECCIONAR CÓDIGO");
        try{
            ResultSet rs1 = null;
           
            Conexion conect3 = new Conexion();
            con = conect3.obtenerconexion();
            Statement Sent = con.createStatement();
            rs1 = Sent.executeQuery("select * from Rubros");
            while(rs1.next()){
            this.comboCodigo.addItem(rs1.getString("Cod_Rubro"));
            }
            contador++;
        }catch (SQLException e){
        }
	}

	public void mostrar(){
		try{
			con=Conexion.obtenerconexion();
			int filas = modelo.getRowCount();
			for (int i = filas - 1; i >= 0; i--) {
			    modelo.removeRow(i);
			}
			String dts []=new String [6];
			String sql="select * from Productos";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				dts[0]=rs.getString("Id_Prod");
				dts[1]=rs.getString("Cod_Prod");
				dts[2]=rs.getString("Nom_Prod");
				dts[3]=rs.getString("Precio_Prod");
				dts[4]=rs.getString("Stock_Prod");
				dts[5]=rs.getString("Id_Rubro");
				
				modelo.addRow(dts);
				trs = new TableRowSorter(modelo);
				tblProducto.setRowSorter(trs);
			}
			tblProducto.setModel(modelo);
			tblProducto.getColumnModel().getColumn(0).setMaxWidth(0);
			tblProducto.getColumnModel().getColumn(0).setMinWidth(0);
			tblProducto.getColumnModel().getColumn(0).setPreferredWidth(0);
			tblProducto.getColumnModel().getColumn(5).setMaxWidth(0);
			tblProducto.getColumnModel().getColumn(5).setMinWidth(0);
			tblProducto.getColumnModel().getColumn(5).setPreferredWidth(0);
			tblProducto.getColumnModel().getColumn(1).setMinWidth(120);
			tblProducto.getColumnModel().getColumn(2).setMinWidth(665);
			tblProducto.getColumnModel().getColumn(3).setMinWidth(120);
			tblProducto.getColumnModel().getColumn(4).setMinWidth(120);
		}catch(Exception ex){
			
			JOptionPane.showMessageDialog(rootPane, "Error al cargar");
			ex.printStackTrace();
		}
		
	}
}
