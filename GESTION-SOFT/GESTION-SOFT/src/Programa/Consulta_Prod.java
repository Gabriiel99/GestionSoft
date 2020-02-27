package Programa;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Consulta_Prod extends JInternalFrame {
	DefaultTableModel Model = new DefaultTableModel();
	Faltantes fal = new Faltantes();
	Connection con = null;
	private JPanel contentPane;
	private JTextField textField;
	public static JTable tableC;
	public static TableRowSorter trs;
	//String titulos[]={"Producto","Precio","Stock"};
	private JLabel lbl_Imagen;
	public int p,conta,contador;
	public String a;
	private JButton btnFaltantes;
	private JLabel imagen2;
	private JButton btnSalir;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Consulta_Prod frame = new Consulta_Prod();
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
	public Consulta_Prod() {
		setFrameIcon(new ImageIcon(Consulta_Prod.class.getResource("/Imagenes/GS.png")));
		setTitle("Consulta de Productos");
		setIconifiable(true);
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(160, 100, 850, 430);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(51, 204, 153), new Color(51, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBuscar = new JLabel("Buscar Productos");
		lblBuscar.setForeground(new Color(0, 0, 0));
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 25));
		lblBuscar.setBounds(288, 42, 255, 34);
		contentPane.add(lblBuscar);
		
		textField = new JTextField();
		textField.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		textField.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				textField.addKeyListener(new KeyAdapter() {

					@SuppressWarnings("unchecked")
					@Override
					public void keyReleased(KeyEvent e) {
						trs.setRowFilter(RowFilter.regexFilter("(?i)"+textField.getText(), 0));
						}
						});
			}
		});
		textField.setBounds(304, 87, 218, 37);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(51, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		scrollPane.setBounds(10, 135, 814, 199);
		contentPane.add(scrollPane);
		
		Model = new DefaultTableModel();
		Model.addColumn("Producto");
		Model.addColumn("Precio");
		Model.addColumn("Stock");
		tableC = new JTable(Model);
		tableC.setBackground(new Color(51, 204, 153));
		tableC.setForeground(Color.BLACK);
		tableC.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 14));
		tableC.getColumnModel().getColumn(0).setMinWidth(620);
		tableC.getColumnModel().getColumn(1).setMinWidth(20);
		tableC.getColumnModel().getColumn(2).setMinWidth(20);
		scrollPane.setViewportView(tableC);
		
		lbl_Imagen = new JLabel("");
		lbl_Imagen.setIcon(new ImageIcon(Consulta_Prod.class.getResource("/Imagenes/consulta (1).png")));
		lbl_Imagen.setBounds(544, 0, 139, 138);
		contentPane.add(lbl_Imagen);
		
		btnFaltantes = new JButton("Faltantes");
		btnFaltantes.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		btnFaltantes.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 14));
		btnFaltantes.setForeground(new Color(0, 0, 0));
		btnFaltantes.setBounds(97, 342, 160, 50);
		btnFaltantes.setIcon(new ImageIcon(Consulta_Prod.class.getResource("/Imagenes/boton-faltantes.png")));
		contentPane.add(btnFaltantes);
		
		imagen2 = new JLabel("");
		imagen2.setIcon(new ImageIcon(Consulta_Prod.class.getResource("/Imagenes/consulta(3).png")));
		imagen2.setBounds(10, 51, 108, 87);
		contentPane.add(imagen2);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		btnSalir.setIcon(new ImageIcon(Consulta_Prod.class.getResource("/Imagenes/salir_cli.png")));
		btnSalir.setForeground(new Color(0, 0, 0));
		btnSalir.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 14));
		btnSalir.setBounds(544, 342, 160, 50);
		contentPane.add(btnSalir);
		
		btnFaltantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 if(conta<1){
						JOptionPane.showMessageDialog(null,"No Tiene Productos faltantes");
					   }else{
						   fal.setVisible(true);
					   }
			}
		});
		
		mostrar();
	}
	
	public void faltante(){
		
		fal.setVisible(false);
		
		 for(int i=0;i<tableC.getRowCount();i++){
				a=(String) tableC.getValueAt(i, 0);
				p=Integer.parseInt((String) tableC.getValueAt(i, 2));
				
				if(p<=5){
					 conta=+1;
					String []Agregar = new String[2];
					Agregar[0]=(String.valueOf(a));
					Agregar[1]=(String.valueOf(p));
				   fal.Model.addRow(Agregar);
				
				}
			}
		 }
	
	public void mostrar(){
		try{
			con=Conexion.obtenerconexion();
			String dts []=new String [3];
			String sql="select * from Productos";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				dts[0]=rs.getString("Nom_Prod");
				dts[1]=rs.getString("Precio_Prod");
				dts[2]=rs.getString("Stock_Prod");
				Model.addRow(dts);
				
				trs = new TableRowSorter(Model);
				tableC.setRowSorter(trs);
			}
			tableC.setModel(Model);
			faltante();
		}catch(Exception ex){
			
			JOptionPane.showMessageDialog(rootPane, "Error al cargar");
			ex.printStackTrace();
		}
		
	}
}

