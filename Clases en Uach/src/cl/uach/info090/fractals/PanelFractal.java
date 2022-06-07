package cl.uach.info090.fractals;
import javax.swing.*;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

/**
 * Muestra un dibujo fractal
 * Basado en el ejemplo de estos videos
 * https://youtu.be/-wiverLQl1Q 
 * https://youtu.be/s3Facu6ZVeA
 * (video muestra código en processing)
 * 
 * @author J. D. Guerra
 *
 */
public class PanelFractal extends JPanel{
	private static final long serialVersionUID = 1L;
	private boolean incluirRamas;
	private boolean incluirCirculos;
	
	public PanelFractal(boolean incluirRamas, boolean incluirCirculos){
		super();
		this.incluirRamas = incluirRamas;
		this.incluirCirculos = incluirCirculos;
	}

	public void dibujarCirculo(int x, int y, int r, Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		Shape circulo = new Ellipse2D.Double(x - r, y - r, 2.0 * r, 2.0 * r);
		g2d.setColor(Color.RED);
		g2d.draw(circulo);
		if(r>1) {
			dibujarCirculo(x+r, y, r/2, g);
			dibujarCirculo(x-r, y, r/2, g);
			dibujarCirculo(x, y+r, r/2, g);
			
		}
	}
	
	public void dibujarRama(Point inicio, int length, double angle, Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		Point p1 = new Point(
				(int) (inicio.x + length*Math.sin(Math.toRadians(angle))),
				(int) (inicio.y - length*Math.cos(Math.toRadians(angle))));
		
		Line2D linea = new Line2D.Double(inicio.x,inicio.y,p1.x,p1.y);
		g2d.setColor(Color.RED);
		g2d.draw(linea);
		
		if(length>10){
			dibujarRama(p1, 3*length/4, angle+25, g);
			dibujarRama(p1, 3*length/4, angle-25, g);
		}
	}
	

	@Override
	public void paint(Graphics g){
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
			    RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0,0,getWidth(),getHeight());

		
		if(this.incluirRamas) dibujarRama(new Point(240,430), 80, 0, g);
		if(this.incluirCirculos) dibujarCirculo(240, 200, 100, g);
		
	}

	public void redibujar(){
		repaint();
	}

}