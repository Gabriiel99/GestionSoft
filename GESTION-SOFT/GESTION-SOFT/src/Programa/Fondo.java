package Programa;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Fondo extends JPanel {
	ImageIcon Imagen;
	/**
	 * Create the panel.
	 */
	public Fondo(String nombre) {
		Imagen=new ImageIcon(getClass().getResource(nombre));
		setSize(Imagen.getIconWidth(),Imagen.getIconHeight());
	}
	protected void paintComponent(Graphics g){
		Dimension d=getSize();
		g.drawImage(Imagen.getImage(),0,0,d.width,d.height,null);
		this.setOpaque(false);
		super.paintComponent(g);
	}

}