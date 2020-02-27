package Programa;

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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;

public class A_Rubro extends JInternalFrame {

	Connection con = null;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	String [] titulo = {"Id_Rubro","Cod_Rubro", "Rubro"};
	DefaultTableModel model = new DefaultTableModel();
	int p,pesp;
	 PreparedStatement pst = null;
	 private JButton btnEliminar;
	 private JTextField textCod;
	 public static TableRowSorter trs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					A_Rubro frame = new A_Rubro();
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
	public A_Rubro() {
		setFrameIcon(new ImageIcon(A_Rubro.class.getResource("/Imagenes/GS.png")));
		setTitle("Alta de Rubro");
		setIconifiable(true);
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(300, 120, 484, 380);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(51, 204, 153), new Color(51, 204, 204), new Color(51, 204, 153), new Color(51, 204, 204)));
		scrollPane.setBounds(10, 195, 446, 144);
		contentPane.add(scrollPane);
		
		model = new DefaultTableModel();
		model.addColumn("Id_Rubro");
		model.addColumn("Código");
		model.addColumn("Rubro");
		table = new JTable(model);
		table.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 14));
		table.setBackground(new Color(51, 204, 153));
		
		table.getColumnModel().getColumn(0).setMaxWidth(0);
		table.getColumnModel().getColumn(0).setMinWidth(0);
		table.getColumnModel().getColumn(0).setPreferredWidth(0);

		scrollPane.setViewportView(table);
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				 tableMouseClicked(evt);
				
			}
		});
		
		textField = new JTextField();
		textField.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(51, 204, 153), new Color(51, 204, 204), new Color(51, 204, 153), new Color(51, 204, 204)));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 15));
		textField.setBounds(125, 71, 210, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textCod = new JTextField();
		textCod.setVisible(false);
		textCod.setBounds(10, 74, 86, 20);
		contentPane.add(textCod);
		textCod.setColumns(10);
		
		JLabel lblNombre = new JLabel("Ingrese un Rubro");
		lblNombre.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 22));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(26, 11, 410, 46);
		contentPane.add(lblNombre);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setIcon(new ImageIcon(A_Rubro.class.getResource("/Imagenes/guardar.png")));
		btnAgregar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(51, 204, 153), new Color(51, 204, 204), new Color(51, 204, 153), new Color(51, 204, 204)));
		btnAgregar.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 12));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int num = 1000;;
				for(int i=0;i<table.getRowCount();i++){
					p=Integer.parseInt((String) table.getValueAt(i, 1));
					if(p>num){
						num=num+1000;
						
					}if(p==num){
						num=num+1000;
					}
					
					}
				try {
						con = Conexion.obtenerconexion();
						Statement st = con.createStatement();
		                String sql = "insert into Rubros (Cod_Rubro,Nom_Rubro) values (?,?)";
		                PreparedStatement pst = con.prepareStatement(sql);
		                pst.setString(1, (String.valueOf(num)));
		                pst.setString(2, textField.getText());
		                int n = pst.executeUpdate();
		                if (n > 0) {
	                    JOptionPane.showMessageDialog(rootPane, "DATOS GUARDADOS CORRECTAMENTE");
	                    mostrar();
	                    //textCod.setText("");
	                    textField.setText("");
		                } 
					
	                }catch (Exception ex) {
						JOptionPane.showMessageDialog(rootPane, "Error al agregar");
					}
				table.getColumnModel().getColumn(0).setMaxWidth(0);
				table.getColumnModel().getColumn(0).setMinWidth(0);
				table.getColumnModel().getColumn(0).setPreferredWidth(0);
				
			}
		});
		btnAgregar.setBounds(66, 129, 132, 60);
		contentPane.add(btnAgregar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(51, 204, 153), new Color(51, 204, 204), new Color(51, 204, 153), new Color(51, 204, 204)));
		btnEliminar.setIcon(new ImageIcon(A_Rubro.class.getResource("/Imagenes/eliminar.png")));
		btnEliminar.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 12));
		btnEliminar.setBounds(261, 129, 132, 60);
		contentPane.add(btnEliminar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(A_Rubro.class.getResource("/Imagenes/alta_Rubro.png")));
		label.setBounds(339, 34, 76, 81);
		contentPane.add(label);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnEliminarActionPerformed(evt);
				mostrar();
				textField.setEditable(true);
			}
		});
		
		mostrar();
	}
	protected void tableMouseClicked(MouseEvent evt) {
		
		try{
            int fila = table.getSelectedRow();
            textCod .setText(table.getValueAt(fila, 0).toString());
            //.setText(tablaCodigos.getValueAt(fila, 1).toString());
            textField.setText(table.getValueAt(fila, 2).toString());
            textField.setEditable(true);
        } catch (Exception ex){
            System.out.println("ERROR AL SELECCIONAR UN EQUIPO : " + ex.getMessage());
        }
	}

	protected void btnEliminarActionPerformed(ActionEvent evt) {
		int eli=table.getSelectedRow();
		if(eli>=0) { 
			int resp=JOptionPane.showConfirmDialog(null, "Está seguro de eliminar?",
				null, JOptionPane.YES_NO_OPTION, pesp);
			if (JOptionPane.OK_OPTION==resp){
				try {
		            Connection con = null;
		            Conexion conect = new Conexion();
		            con = conect.obtenerconexion();
		            Statement st = con.createStatement();
		            String sql = "delete from Rubros where Id_Rubro = ?";
		            PreparedStatement pst = con.prepareStatement(sql);
		            pst.setInt(1, Integer.parseInt(textCod.getText()));
		            int n = pst.executeUpdate();
		            if (n > 0){
		                JOptionPane.showMessageDialog(this, "DATOS ELIMINADOS CORRECTAMENTE");
		                textField.setText("");
		                textCod.setText("");
		            }
		        } catch (SQLException ex){
		            JOptionPane.showMessageDialog(this, "DATOS NO ELIMINADOS CORRECTAMENTE" + ex.getMessage());
		        }
				}
			} else {
			JOptionPane.showMessageDialog(null, "No hay datos para eliminar");
		}
		table.getColumnModel().getColumn(0).setMaxWidth(0);
		table.getColumnModel().getColumn(0).setMinWidth(0);
		table.getColumnModel().getColumn(0).setPreferredWidth(0);
		
	}

	public void mostrar() {
		try {
			con = Conexion.obtenerconexion();
			int filas = model.getRowCount();
			for (int i = filas - 1; i >= 0; i--) {
			    model.removeRow(i);
			}
			//model = new DefaultTableModel(null,titulo);
	        String dts[] = new String[3];
	        String sql = "select * from Rubros";
	        Statement st = con.createStatement();
	        ResultSet rs = st.executeQuery(sql);
	        while(rs.next()){
	            dts[0] = rs.getString("Id_Rubro");
	            dts[1] = rs.getString("Cod_Rubro");
	            dts[2] = rs.getString("Nom_Rubro");
	            model.addRow(dts);
	           
	            trs = new TableRowSorter(model);
				table.setRowSorter(trs);
	        }
	        table.setModel(model);
		}catch (Exception ex) {
			JOptionPane.showMessageDialog(rootPane, "Error al cargar");
		}
		
	}
}