package Programa;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import java.awt.Color;

public class Inicio extends JFrame {

	private Fondo contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
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
	public Inicio() {
		setTitle("Gestion Soft");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\ac\\a\\fondo1.jpg"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		this.setLocationRelativeTo(null);
		contentPane = new Fondo("fondo.jpg");
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnAceptar = new JButton("");
		btnAceptar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		btnAceptar.setToolTipText("Ingresar");
		btnAceptar.setIcon(new ImageIcon(Inicio.class.getResource("/Imagenes/enter.png")));
		btnAceptar.setForeground(SystemColor.textHighlight);
		btnAceptar.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 15));
		btnAceptar.setBounds(10, 315, 53, 44);
		contentPane.add(btnAceptar);
		
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					 Logeo l=new Logeo();
			         l.setVisible(true);
				     Inicio.this.dispose();					
			}
		});
		
		JButton btnSalir = new JButton("");
		btnSalir.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		btnSalir.setToolTipText("Salir");
		btnSalir.setForeground(SystemColor.textHighlight);
		btnSalir.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 15));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Inicio.this.dispose();
			}
		});
		btnSalir.setBounds(381, 315, 53, 44);
		btnSalir.setIcon(new ImageIcon(Inicio.class.getResource("/Imagenes/exit.png")));
		contentPane.add(btnSalir);
	}
}
