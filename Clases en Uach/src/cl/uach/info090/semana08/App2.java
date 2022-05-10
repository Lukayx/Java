package cl.uach.info090.semana08;

import java.awt.BorderLayout;

import javax.swing.*;

public class App2 {
			
		private JFrame ventana;
		private JButton boton1;
		private JButton boton2;
		private JButton boton3;
		private JButton boton4;
		private JSlider slider;
		
		
		public App2() {
			ventana = new JFrame("Mi Aplicación");
			boton1 = new JButton("Boton 1");
			boton1 = new JButton("Boton 2");
			boton1 = new JButton("Boton 3");
			boton1 = new JButton("Boton 4");
			slider = new JSlider(JSlider.HORIZONTAL,-10,10,0);
			
			ventana.setBounds(300, 300, 500, 600);
			
			ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			ventana.setResizable(true);
			
			ventana.setLayout(new BorderLayout());
			
			
			//boton.setBounds(10,10,150,50);
			
			ventana.add(slider,BorderLayout.CENTER);
			ventana.add(boton1,BorderLayout.PAGE_START);
			ventana.add(boton2,BorderLayout.LINE_START);
			ventana.add(boton3,BorderLayout.LINE_END);
			ventana.add(boton4,BorderLayout.PAGE_END);
			
			//slider.setBounds(180,20,110,40);
			ventana.add(slider);
			
			ventana.setVisible(true);
			
		}
		
		public static void main(String[] args) {
			App2 miApp = new App2();
	
		}
	
	}

