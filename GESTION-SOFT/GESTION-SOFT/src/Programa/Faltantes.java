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
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.MessageFormat;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class Faltantes extends JFrame {

	private JPanel contentPane;
	public JTable faltantes;
    DefaultTableModel Model = new DefaultTableModel();
	public int p,conta,contador;
	public String a;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Faltantes frame = new Faltantes();
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
	public Faltantes() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Faltantes.class.getResource("/Imagenes/GS.png")));
		setTitle("Faltantes");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(250, 300, 850, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(51, 204, 102), new Color(51, 204, 153), new Color(51, 204, 102), new Color(51, 204, 153)));
		scrollPane.setBounds(10, 68, 814, 135);
		contentPane.add(scrollPane);
		
		faltantes = new JTable();
		faltantes.setBackground(UIManager.getColor("CheckBox.darkShadow"));
		faltantes.setForeground(new Color(255, 51, 51));
		faltantes.setGridColor(new Color(128, 128, 128));
		faltantes.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 14));
		Model.addColumn("Producto");
		Model.addColumn("Stock");
		this.faltantes.setModel(Model);
		scrollPane.setViewportView(faltantes);
		
		faltantes.getColumnModel().getColumn(0).setMinWidth(650);
		//faltantes.getColumnModel().getColumn(1).setMinWidth(20);
		
		JLabel lblProductosConBajo = new JLabel("Productos con bajo stock");
		lblProductosConBajo.setForeground(new Color(0, 0, 0));
		lblProductosConBajo.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductosConBajo.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 22));
		lblProductosConBajo.setBounds(224, 26, 319, 30);
		contentPane.add(lblProductosConBajo);
		
		JButton btnEntendido = new JButton("Entendido!");
		btnEntendido.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(51, 204, 102), new Color(51, 204, 153), new Color(51, 204, 102), new Color(51, 204, 153)));
		btnEntendido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnEntendido.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 13));
		btnEntendido.setBounds(486, 214, 131, 36);
		btnEntendido.setIcon(new ImageIcon(Faltantes.class.getResource("/Imagenes/boton-Entendido-frame-faltantes.png")));
		contentPane.add(btnEntendido);
		
		JLabel lbl_Imagen = new JLabel("");
		lbl_Imagen.setBounds(553, 0, 64, 68);
		lbl_Imagen.setIcon(new ImageIcon(Faltantes.class.getResource("/Imagenes/frame-faltantes.png")));
		contentPane.add(lbl_Imagen);
		
		JButton btnNewButton = new JButton("IMPRIMIR");
		btnNewButton.setIcon(new ImageIcon(Faltantes.class.getResource("/Imagenes/impresora.png")));
		//btnNewButton.setIcon(new ImageIcon(Faltantes.class.getResource("/Imagenes_stock/print_46933 (2).png")));
		btnNewButton.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 13));
		btnNewButton.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(51, 204, 102), new Color(51, 204, 153), new Color(51, 204, 102), new Color(51, 204, 153)));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				MessageFormat header=new MessageFormat("Productos con bajo stock:");
				MessageFormat footer=new MessageFormat("Page{0,number,integer}");
				try{
					faltantes.print(JTable.PrintMode.FIT_WIDTH,  header, footer);
				}catch(java.awt.print.PrinterException e){
					System.err.format("Error de impresion ", e.getMessage());
				}
			}
		});
		btnNewButton.setBounds(203, 214, 127, 37);
		contentPane.add(btnNewButton);
	}
}

