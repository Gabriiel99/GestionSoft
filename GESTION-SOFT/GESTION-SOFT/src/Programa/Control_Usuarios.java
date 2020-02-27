package Programa;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Control_Usuarios extends JInternalFrame {

	Connection con = null;
	Statement st = null;
	private JPanel contentPane;
	private JTable table;
	public DefaultTableModel model = new DefaultTableModel();
	private JLabel lblModificarDatosDe;
	private JTextField textUsuario;
	private JLabel lblUsuario;
	private JTextField textContraseña;
	private JLabel lblContrasea;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JTextField textId;
	private JButton btnSalir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Control_Usuarios frame = new Control_Usuarios();
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
	public Control_Usuarios() {
		setFrameIcon(new ImageIcon(Control_Usuarios.class.getResource("/Imagenes/GS.png")));
		setTitle("Control de Usuarios");
		setClosable(true);
		setIconifiable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(300, 80, 600, 498);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblControlDeUsuarios = new JLabel("Control de Usuarios");
		lblControlDeUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblControlDeUsuarios.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 25));
		lblControlDeUsuarios.setBounds(80, 11, 418, 32);
		contentPane.add(lblControlDeUsuarios);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		scrollPane.setBounds(10, 54, 564, 139);
		contentPane.add(scrollPane);
		
		model = new DefaultTableModel();
		table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int fila = table.getSelectedRow();
				if (fila>= 0) {
		            textId.setText(table.getValueAt(fila, 0).toString());
		            textUsuario.setText(table.getValueAt(fila, 1).toString());
		            textContraseña.setText(table.getValueAt(fila, 2).toString());
		           }else {
						JOptionPane.showMessageDialog(null, "¡Seleccione una Fila!");
					} 
			}
		});
		table.setBackground(new Color(102, 204, 153));
		table.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 13));
		scrollPane.setViewportView(table);
		
		lblModificarDatosDe = new JLabel("Seleccione para Modificar datos de Usuarios:");
		lblModificarDatosDe.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 13));
		lblModificarDatosDe.setBounds(10, 204, 359, 24);
		contentPane.add(lblModificarDatosDe);
		
		textUsuario = new JTextField();
		textUsuario.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		textUsuario.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 13));
		textUsuario.setBounds(277, 255, 160, 25);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);
		
		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsuario.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 16));
		lblUsuario.setBounds(128, 254, 91, 24);
		contentPane.add(lblUsuario);
		
		textContraseña = new JTextField();
		textContraseña.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 13));
		textContraseña.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		textContraseña.setBounds(277, 311, 160, 25);
		contentPane.add(textContraseña);
		textContraseña.setColumns(10);
		
		lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 16));
		lblContrasea.setBounds(128, 312, 119, 21);
		contentPane.add(lblContrasea);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					con = Conexion.obtenerconexion();
					Statement st = con.createStatement();
					String sql = "Update Usuario set Nom_U = ?, Clave_U = ? where Id_U = ?";
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1, textUsuario.getText());
					ps.setString(2, textContraseña.getText());
					ps.setInt(3, Integer.parseInt(textId.getText()));
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Registro Actualizado");
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "No se pudo Actualizar Registro "+ex);
			}
				consulta();
				tabla();
				textUsuario.setText("");
				textContraseña.setText("");
			}
		});
		btnModificar.setIcon(new ImageIcon(Control_Usuarios.class.getResource("/Imagenes/mod_prov.png")));
		btnModificar.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 13));
		btnModificar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		btnModificar.setBounds(37, 373, 150, 75);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int filas = table.getSelectedRow();
				if (filas>=0) {
				int confirmar = JOptionPane.showConfirmDialog(null, "¿Desea Eliminar el Registro?","ALERTA",JOptionPane.YES_NO_OPTION);
				
				if (JOptionPane.YES_OPTION==confirmar) {
				try {
					con = Conexion.obtenerconexion();
					String sql = "Delete From Usuario where Id_U = ?";
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setInt(1, Integer.parseInt(textId.getText()));
					int n = ps.executeUpdate();
					if(n>0) {
						JOptionPane.showMessageDialog(null, "¡Usuario Eliminado! ");
						consulta();
						tabla();
						textUsuario.setText("");
						textContraseña.setText("");
						}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "¡Usuario No Eliminado! "+ex);
					}
				}
				}
					else {
						JOptionPane.showMessageDialog(null, "¡Seleccione un Registro!");
					}
			}
		});
		btnEliminar.setIcon(new ImageIcon(Control_Usuarios.class.getResource("/Imagenes/eliminar_Us.png")));
		btnEliminar.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 13));
		btnEliminar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		btnEliminar.setBounds(219, 373, 150, 75);
		contentPane.add(btnEliminar);
		
		textId = new JTextField();
		textId.setVisible(false);
		textId.setBounds(10, 242, 0, 20);
		contentPane.add(textId);
		textId.setColumns(10);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setIcon(new ImageIcon(Control_Usuarios.class.getResource("/Imagenes/exit (2).png")));
		btnSalir.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		btnSalir.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 13));
		btnSalir.setBounds(397, 374, 150, 75);
		contentPane.add(btnSalir);
		
		model.addColumn("Código");
		model.addColumn("Usuario");
		model.addColumn("Clave");
		
		
		consulta();
		tabla();
	}
	
	public void consulta() {
		try{
			int filas = model.getRowCount();
			for (int i = filas - 1; i >= 0; i--) {
			    model.removeRow(i);
			}
			con=Conexion.obtenerconexion();
			String dts []=new String [3];
			String sql="select * from Usuario";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				dts[0]=rs.getString("Id_U");
				dts[1]=rs.getString("Nom_U");
				dts[2]=rs.getString("Clave_U");
				model.addRow(dts);
			}
			table.setModel(model);
		}catch(Exception e) {
				
			}
	}
	public void tabla() {
		table.getColumnModel().getColumn(0).setMaxWidth(0);
		table.getColumnModel().getColumn(0).setMinWidth(0);
		table.getColumnModel().getColumn(0).setPreferredWidth(0);
	}
}
