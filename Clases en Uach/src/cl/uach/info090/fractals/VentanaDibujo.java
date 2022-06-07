package cl.uach.info090.fractals;

import java.awt.FlowLayout;

import javax.swing.*;

/**
 * Muestra una ventana con un panel que contiene un dibujo
 * 
 * 
 * @author J. D. Guerra
 *
 */
public class VentanaDibujo extends JFrame{
	private static final long serialVersionUID = 1L;
	private PanelFractal canvas1;
	private PanelFractal canvas2;

	public VentanaDibujo(){
		super("Ejemplo Fractal Recursivo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		setBounds(100,100,1000,500);
		setLayout(null);
		
		canvas1 = new PanelFractal(true,false);
		canvas2 = new PanelFractal(false,true);
		canvas1.setBounds(0,0,500,500);
		canvas2.setBounds(500,0,500,500);
		
		add(canvas1);
		add(canvas2);
	}

	public static void main(String[] args){
		VentanaDibujo m = new VentanaDibujo();
		m.setVisible(true);

	}



}