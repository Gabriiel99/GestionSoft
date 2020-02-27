package Programa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URISyntaxException;
import java.awt.Desktop;
import java.net.URI;
import java.util.Scanner;
import javax.swing.JLabel;
import java.awt.Window.Type;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Toolkit;

public class Menu extends JFrame {


	private JPanel contentPane;
	public static JDesktopPane desk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/Programa/fondo.jpg")));
		setResizable(false);
		setTitle("Gestion Soft");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 700);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desk = new JDesktopPane();
		desk.setBorder(new LineBorder(new Color(153, 180, 209), 5));
		desk.setBackground(SystemColor.control);
		desk.setBounds(0, 36, 1194, 635);
		contentPane.add(desk);
		
		JLabel lblUser = new JLabel("User:");
		lblUser.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 20));
		lblUser.setBounds(1003, 11, 67, 30);
		desk.add(lblUser);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setForeground(SystemColor.textHighlight);
		label.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 22));
		label.setText(Logeo.usuario);
		label.setBounds(1068, 11, 105, 30);
		desk.add(label);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(Menu.class.getResource("/Imagenes/opaca png.png")));
		fondo.setBounds(73, 11, 1084, 603);
		desk.add(fondo);
		
		JButton btnCerrar = new JButton("");
		btnCerrar.setToolTipText("Cerrar Sesi\u00F3n!");
		btnCerrar.setIcon(new ImageIcon(Menu.class.getResource("/Imagenes/boton-salir-1.png")));
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object [] opciones = { "Si","No"};
				int eleccion = JOptionPane.showOptionDialog(rootPane, "¿Está seguro?", "Cerrar Sesión!", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, "ACEPTAR");
				if (eleccion==JOptionPane.YES_OPTION) {
					dispose();
					Logeo log = new Logeo();
					log.show();
				}
				
			}
		});
		btnCerrar.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 13));
		btnCerrar.setBounds(1114, 567, 61, 51);
		desk.add(btnCerrar);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.activeCaption);
		menuBar.setBounds(0, 6, 1362, 32);
		contentPane.add(menuBar);
		
		JMenu mnArchivos = new JMenu("Archivos");
		mnArchivos.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 14));
		menuBar.add(mnArchivos);
		
		JMenu mnClientes_1 = new JMenu("Clientes");
		mnClientes_1.setIcon(new ImageIcon(Menu.class.getResource("/Imagenes/cli 1.png")));
		mnClientes_1.setBorder(new LineBorder(new Color(153, 180, 209)));
		mnClientes_1.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 14));
		mnArchivos.add(mnClientes_1);
		
		JMenuItem ItemAlta_Cli = new JMenuItem("Alta de Clientes");
		ItemAlta_Cli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				A_Clientes ac = new A_Clientes();
				desk.add(ac);
				ac.show();
			}
		});
		ItemAlta_Cli.setIcon(new ImageIcon(Menu.class.getResource("/Imagenes/alta_cliente.png")));
		ItemAlta_Cli.setBorder(new LineBorder(new Color(153, 180, 209), 2));
		ItemAlta_Cli.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 12));
		mnClientes_1.add(ItemAlta_Cli);
		
		JMenuItem mntmModificarClientes = new JMenuItem("Modificar de Clientes");
		mntmModificarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Modificar_Cli mod = new  Modificar_Cli();
				desk.add(mod);
				mod.show();
			}
		});
		mntmModificarClientes.setIcon(new ImageIcon(Menu.class.getResource("/Imagenes/mod_cliente.png")));
		mntmModificarClientes.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 12));
		mnClientes_1.add(mntmModificarClientes);
		
		JMenuItem mntmConsulta_Cli = new JMenuItem("Consulta de Clientes");
		mntmConsulta_Cli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Consulta_Cli con = new Consulta_Cli();
				desk.add(con);
				con.show();
			}
		});
		mntmConsulta_Cli.setIcon(new ImageIcon(Menu.class.getResource("/Imagenes/consulta_cli.png")));
		mntmConsulta_Cli.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 12));
		mnClientes_1.add(mntmConsulta_Cli);
		
		JMenu mnProveedores = new JMenu("Proveedores");
		mnProveedores.setIcon(new ImageIcon(Menu.class.getResource("/Imagenes/prov (4).png")));
		mnProveedores.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 14));
		mnArchivos.add(mnProveedores);
		
		JMenuItem mntmAltaDeProveedor = new JMenuItem("Alta de Proveedores");
		mntmAltaDeProveedor.setIcon(new ImageIcon(Menu.class.getResource("/Imagenes/frame alta provee.png")));
		mntmAltaDeProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				A_Proveedores a_Prov = new A_Proveedores();
				desk.add(a_Prov);
				a_Prov.show();
			}
		});
		mntmAltaDeProveedor.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 12));
		mnProveedores.add(mntmAltaDeProveedor);
		
		JMenuItem mntmModificarProveedores = new JMenuItem("Modificar Proveedores");
		mntmModificarProveedores.setIcon(new ImageIcon(Menu.class.getResource("/Imagenes/frame mod provee.png")));
		mntmModificarProveedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Modificar_Proveedores mod_Prov = new Modificar_Proveedores();
				desk.add(mod_Prov);
				mod_Prov.show();
			}
		});
		mntmModificarProveedores.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 12));
		mnProveedores.add(mntmModificarProveedores);
		
		JMenuItem mntmConsultaDeProveedores = new JMenuItem("Consulta de Proveedores");
		mntmConsultaDeProveedores.setIcon(new ImageIcon(Menu.class.getResource("/Imagenes/frame consulta provee.png")));
		mntmConsultaDeProveedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Consulta_Proveedores con_Prov = new Consulta_Proveedores();
				desk.add(con_Prov);
				con_Prov.show();
			}
		});
		mntmConsultaDeProveedores.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 12));
		mnProveedores.add(mntmConsultaDeProveedores);
		
		JMenu mnArticulos = new JMenu("Art\u00EDculos");
		mnArticulos.setIcon(new ImageIcon(Menu.class.getResource("/Imagenes/prod 1.png")));
		mnArticulos.setBorder(new LineBorder(SystemColor.activeCaption));
		mnArticulos.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 14));
		mnArchivos.add(mnArticulos);
		
		JMenuItem mntmAltaDeProd = new JMenuItem("Alta de Productos");
		mntmAltaDeProd.setIcon(new ImageIcon(Menu.class.getResource("/Imagenes/alta_Producto.png")));
		mntmAltaDeProd.setBorder(new LineBorder(new Color(153, 180, 209)));
		mntmAltaDeProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				A_Prod p = new A_Prod();
				desk.add(p);
				p.show();
			}
		});
		
		JMenuItem mntmAltaDeRubros = new JMenuItem("Alta de Rubros");
		mntmAltaDeRubros.setIcon(new ImageIcon(Menu.class.getResource("/Imagenes/alta_Rubro.png")));
		mntmAltaDeRubros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				A_Rubro r = new A_Rubro();
				desk.add(r);
				r.show();
			}
		});
		mntmAltaDeRubros.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 12));
		mnArticulos.add(mntmAltaDeRubros);
		mntmAltaDeProd.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 12));
		mnArticulos.add(mntmAltaDeProd);
		
		JMenuItem mntmConsultaProd = new JMenuItem("Consulta");
		mntmConsultaProd.setIcon(new ImageIcon(Menu.class.getResource("/Imagenes/consult.png")));
		mntmConsultaProd.setBorder(new LineBorder(new Color(153, 180, 209), 2));
		mntmConsultaProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Consulta_Prod c = new Consulta_Prod();
				desk.add(c);
				c.show();
			}
		});
		mntmConsultaProd.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 12));
		mnArticulos.add(mntmConsultaProd);
		
		JMenu mnFacturacion = new JMenu("Facturaci\u00F3n");
		mnFacturacion.setIcon(new ImageIcon(Menu.class.getResource("/Imagenes/fac 1.png")));
		mnFacturacion.setBorder(new LineBorder(new Color(153, 180, 209)));
		mnFacturacion.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 14));
		mnArchivos.add(mnFacturacion);
		
		JMenuItem ItemFac = new JMenuItem("Venta de Productos");
		ItemFac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentaProd v = new VentaProd();
				desk.add(v);
				v.show();
			}
		});
		ItemFac.setIcon(new ImageIcon("C:\\Imagenes\\factura.png"));
		ItemFac.setBorder(new LineBorder(new Color(153, 180, 209), 2));
		ItemFac.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 12));
		mnFacturacion.add(ItemFac);
		
		JMenuItem mntmConsultaDeVentas = new JMenuItem("Consulta de Ventas");
		mntmConsultaDeVentas.setIcon(new ImageIcon(Menu.class.getResource("/Imagenes/consulta-fac.png")));
		mntmConsultaDeVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaVentas cv = new ConsultaVentas();
				desk.add(cv);
				cv.show();
			}
		});
		mntmConsultaDeVentas.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 12));
		mnFacturacion.add(mntmConsultaDeVentas);
		
		JMenu mnEmpresa = new JMenu("Empresa");
		mnEmpresa.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 14));
		menuBar.add(mnEmpresa);
		
		JMenuItem mntmAltaDeEmpresa = new JMenuItem("Alta de Empresa");
		mntmAltaDeEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Al_Empresa empresa = new  Al_Empresa();
				desk.add(empresa);
				empresa.show();
			}
		});
		mntmAltaDeEmpresa.setIcon(new ImageIcon(Menu.class.getResource("/Imagenes/empresa.png")));
		mntmAltaDeEmpresa.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 14));
		mnEmpresa.add(mntmAltaDeEmpresa);
		
		JMenu mnUsuario = new JMenu("Usuario");
		mnUsuario.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 14));
		menuBar.add(mnUsuario);
		
		JMenuItem mntmCambiarContrasea = new JMenuItem("Cambiar Contrase\u00F1a");
		mntmCambiarContrasea.setIcon(new ImageIcon(Menu.class.getResource("/Imagenes/cambiar_contr.png")));
		mntmCambiarContrasea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cambiar_Contr CC = new Cambiar_Contr();
				desk.add(CC);
				CC.show();
			}
		});
		
		JMenuItem mntmRegistrarNuevoUsuario = new JMenuItem("Registrar nuevo Usuario");
		mntmRegistrarNuevoUsuario.setIcon(new ImageIcon(Menu.class.getResource("/Imagenes/nuevo_user.png")));
		mntmRegistrarNuevoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Registro_Usuarios r = new Registro_Usuarios();
				desk.add(r);
				r.show();
			}
		});
		mntmRegistrarNuevoUsuario.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 12));
		mnUsuario.add(mntmRegistrarNuevoUsuario);
		mntmCambiarContrasea.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 12));
		mnUsuario.add(mntmCambiarContrasea);
		
		JMenuItem mntmControlDeUsuarios = new JMenuItem("Control de Usuarios");
		mntmControlDeUsuarios.setIcon(new ImageIcon(Menu.class.getResource("/Imagenes/control_user.png")));
		mntmControlDeUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Control_Usuarios c_u = new Control_Usuarios();
				desk.add(c_u);
				c_u.show();
			}
		});
		mntmControlDeUsuarios.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 12));
		mnUsuario.add(mntmControlDeUsuarios);
		
		JMenu mnContacto = new JMenu("Contacto");
		mnContacto.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 14));
		menuBar.add(mnContacto);
		
		JMenuItem mntmFacebook = new JMenuItem("Facebook");
		mntmFacebook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(java.awt.Desktop.isDesktopSupported()){
					java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
				
				if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
					try {
						java.net.URI uri=new java.net.URI("https://www.facebook.com");
						desktop.browse(uri);
					} catch (URISyntaxException | IOException ex) {}
				}
				}
			}
		});
		mntmFacebook.setIcon(new ImageIcon(Menu.class.getResource("/Imagenes/facebook.png")));
		mntmFacebook.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 12));
		mnContacto.add(mntmFacebook);
		
		JMenuItem mntmInstagram = new JMenuItem("Instagram");
		mntmInstagram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(java.awt.Desktop.isDesktopSupported()){
					java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
				
				if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
					try {
						java.net.URI uri=new java.net.URI("https://www.instagram.com");
						desktop.browse(uri);
					} catch (URISyntaxException | IOException ex) {}
				}
				}
			}
		});
		mntmInstagram.setIcon(new ImageIcon(Menu.class.getResource("/Imagenes/instagram.png")));
		mntmInstagram.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 12));
		mnContacto.add(mntmInstagram);
		
		JMenuItem mntmGmail = new JMenuItem("Gmail");
		mntmGmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(java.awt.Desktop.isDesktopSupported()){
					java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
				
				if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
					try {
						java.net.URI uri=new java.net.URI("https://www.google.com/intl/es/gmail/about/");
						desktop.browse(uri);
					} catch (URISyntaxException | IOException ex) {}
				}
				}
			}
		});
		mntmGmail.setIcon(new ImageIcon(Menu.class.getResource("/Imagenes/gmail.png")));
		mntmGmail.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 12));
		mnContacto.add(mntmGmail);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		mnAyuda.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 14));
		menuBar.add(mnAyuda);
		
		JMenuItem mntmquienesSomos = new JMenuItem("\u00BFQuienes somos?");
		mntmquienesSomos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ayuda ayu = new Ayuda();
				desk.add(ayu);
				ayu.show();
			}
		});
		mntmquienesSomos.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 12));
		mnAyuda.add(mntmquienesSomos);
		
		//----------------------------------------------------------------------------------------//
				String restr;
				restr = label.getText();
				if (restr.equals("ADMIN")) {
					
				} else if ((restr.equals("admin"))){
					
				} else {
					mntmModificarClientes.setEnabled(false);
					mntmModificarProveedores.setEnabled(false);
					mntmAltaDeRubros.setEnabled(false);
					mntmRegistrarNuevoUsuario.setEnabled(false);
					mntmControlDeUsuarios.setEnabled(false);
					mntmAltaDeEmpresa.setEnabled(false);
				}
				//-----------------------------------------------------------------------------------------//
	}
}
