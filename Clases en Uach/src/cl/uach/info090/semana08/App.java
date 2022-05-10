package cl.uach.info090.semana08;

import javax.swing.*;

public class App {
		
	private JFrame ventana;
	private JButton boton;
	private JCheckBox caja;
	private JSlider slider;
	
	
	public App() {
		ventana = new JFrame("Mi Aplicación");
		
		ventana.setBounds(300, 300, 500, 600);
		
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ventana.setResizable(false);
		
		boton = new JButton("Aceptar");
		boton.setBounds(10,10,150,50);
		ventana.add(boton);
		
		slider = new JSlider(JSlider.HORIZONTAL,-10,10,0);
		slider.setBounds(180,20,110,40);
		ventana.add(slider);
		
		ventana.setLayout(null);
		
		ventana.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		App miApp = new App();

	}

}
