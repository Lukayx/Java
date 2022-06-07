package cl.uach.info090.gui;

import javax.swing.*;

public class App {

	private JFrame ventana;
	private JButton boton;
	private JSlider slider;
	
	public App() {
		ventana = new JFrame("Mi Aplicación");
		ventana.setBounds(100, 100, 400, 300);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(false);
		ventana.setLayout(null);
		boton = new JButton("ApriÃ©tame!");
		boton.setBounds(10,10,150,50);
		ventana.add(boton);
		slider = new JSlider(JSlider.HORIZONTAL,0,100,50);
		slider.setBounds(180,20,110,40);
		ventana.add(slider);
		
		ventana.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		App miApp = new App();

	}

}
