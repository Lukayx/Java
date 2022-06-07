package cl.uach.info090.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class App2 {

	private JFrame ventana;
	private JButton boton1;
	private JButton boton2;
	private JButton boton3;
	private JButton boton4;
	private JButton boton5;
	private JButton boton6;
	private JPanel panel;
	private JSlider slider;
	
	public App2() {
		ventana = new JFrame("Mi Aplicación");
		ventana.setBounds(100, 100, 400, 300);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(true);
		ventana.setLayout(new BorderLayout());

		panel = new JPanel();
		panel.setLayout(new GridLayout(3,1));
		
		boton1 = new JButton("Botón 1");
		boton2 = new JButton("Botón 2");
		boton3 = new JButton("Botón 3");
		boton4 = new JButton("Botón 4");
		boton5 = new JButton("Botón 5");
		boton6 = new JButton("Botón 6");
		
		
		ventana.add(boton1,BorderLayout.PAGE_START);
		ventana.add(boton2,BorderLayout.LINE_END);
		ventana.add(boton3,BorderLayout.PAGE_END);
		
		panel.add(boton4);
		panel.add(boton5);
		panel.add(boton6);
		ventana.add(panel,BorderLayout.LINE_START);
		
		slider = new JSlider(JSlider.HORIZONTAL,0,100,50);
		ventana.add(slider, BorderLayout.CENTER);
		
		ventana.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		App2 miApp = new App2();

	}

}
