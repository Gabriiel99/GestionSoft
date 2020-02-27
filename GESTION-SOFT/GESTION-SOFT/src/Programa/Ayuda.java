package Programa;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class Ayuda extends JInternalFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ayuda frame = new Ayuda();
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
	public Ayuda() {
		setFrameIcon(new ImageIcon(Ayuda.class.getResource("/Imagenes/GS.png")));
		setIconifiable(true);
		setClosable(true);
		setTitle("\u00BFQuienes Somos?");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(300, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGestionSoft = new JLabel("Gestion Soft");
		lblGestionSoft.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionSoft.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 25));
		lblGestionSoft.setBounds(79, 11, 186, 27);
		contentPane.add(lblGestionSoft);
		
		JLabel lbl1 = new JLabel("Es un programa desarrollado por alumnos de 1er a\u00F1o\r\n");
		lbl1.setHorizontalAlignment(SwingConstants.LEFT);
		lbl1.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 12));
		lbl1.setBounds(10, 37, 386, 18);
		contentPane.add(lbl1);
		
		JLabel lbl2 = new JLabel("de la carrera \"T\u00E9cnico Superior en Desarrollo de Software\"");
		lbl2.setHorizontalAlignment(SwingConstants.LEFT);
		lbl2.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 12));
		lbl2.setBounds(10, 55, 432, 18);
		contentPane.add(lbl2);
		
		JLabel lblAlumnos = new JLabel("Autores:");
		lblAlumnos.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		lblAlumnos.setBounds(28, 115, 80, 16);
		contentPane.add(lblAlumnos);
		
		JLabel lblNahuelBenitez = new JLabel("* Benitez Nahuel");
		lblNahuelBenitez.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 12));
		lblNahuelBenitez.setBounds(10, 139, 127, 14);
		contentPane.add(lblNahuelBenitez);
		
		JLabel lblHerediaDaiana = new JLabel("* Heredia Daiana");
		lblHerediaDaiana.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 12));
		lblHerediaDaiana.setBounds(10, 164, 127, 14);
		contentPane.add(lblHerediaDaiana);
		
		JLabel lblJuarezEnzo = new JLabel("* Juarez Enzo");
		lblJuarezEnzo.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 12));
		lblJuarezEnzo.setBounds(10, 189, 127, 14);
		contentPane.add(lblJuarezEnzo);
		
		JLabel lblJuarezEsteban = new JLabel("* Juarez Esteban");
		lblJuarezEsteban.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 12));
		lblJuarezEsteban.setBounds(10, 214, 127, 14);
		contentPane.add(lblJuarezEsteban);
		
		JLabel lblLuquesGabriel = new JLabel("* Luques Gabriel");
		lblLuquesGabriel.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 12));
		lblLuquesGabriel.setBounds(10, 239, 127, 14);
		contentPane.add(lblLuquesGabriel);
		
		JLabel lblMontenegroMaximiliano = new JLabel("* Montenegro Angel");
		lblMontenegroMaximiliano.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 12));
		lblMontenegroMaximiliano.setBounds(10, 264, 174, 14);
		contentPane.add(lblMontenegroMaximiliano);
		
		JLabel lblNavarroCamila = new JLabel("* Navarro Camila");
		lblNavarroCamila.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 12));
		lblNavarroCamila.setBounds(10, 289, 127, 14);
		contentPane.add(lblNavarroCamila);
		
		JLabel lblPazLeonardo = new JLabel("* Paz Leonardo");
		lblPazLeonardo.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 12));
		lblPazLeonardo.setBounds(10, 314, 127, 14);
		contentPane.add(lblPazLeonardo);
		
		JLabel lblUrueaCesar = new JLabel("* Urue\u00F1a Cesar");
		lblUrueaCesar.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 12));
		lblUrueaCesar.setBounds(10, 339, 105, 14);
		contentPane.add(lblUrueaCesar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Ayuda.class.getResource("/Imagenes/log.png")));
		label.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 153), new Color(102, 204, 204), new Color(102, 204, 153), new Color(102, 204, 204)));
		label.setBounds(470, 11, 101, 80);
		contentPane.add(label);
		
		JLabel lblLaCualSe = new JLabel("la cual se dicta en el instituto C&P Soft.");
		lblLaCualSe.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 12));
		lblLaCualSe.setBounds(10, 73, 360, 18);
		contentPane.add(lblLaCualSe);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Ayuda.class.getResource("/Imagenes/foto.jpeg")));
		label_1.setBounds(171, 118, 400, 235);
		contentPane.add(label_1);
	}
}
