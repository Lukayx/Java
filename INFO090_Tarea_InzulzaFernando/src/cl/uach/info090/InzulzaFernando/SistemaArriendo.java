	package cl.uach.info090.InzulzaFernando;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class SistemaArriendo extends JFrame implements ActionListener{
	
	private static SistemaArriendo sistema = new SistemaArriendo();
	private JButton botonesArriendo[] = new JButton[16]; //ARREGLO DE BOTONES PARA ARRENDAR 
	private JPanel panel_Arriendo = new JPanel(); //Creacion de Panel
	private JTextField JTextField = new JTextField();
	private JLabel label = new JLabel("Últimas boletas");
	private JList lista = new JList();
	private CreadorBoletaCL C_Boleta = new CreadorBoletaCL();
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			JButton boton = (JButton)e.getSource();
			if(boton.getBackground().equals(Color.decode("#A6E7BA"))) {
				boton.setBackground(Color.decode("#E1AD86"));
			} else {
				boton.setBackground(Color.decode("#A6E7BA"));			
			}
		}
	}
	
	private SistemaArriendo() {
		super("Ventana Genial");
		//-----VENTANA-----
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Sistema Arriendo");
		setSize(1000, 700);
		setLocationRelativeTo(sistema);
		setResizable(false);
		
		//-----BOTONES-----
		
		for (int i = 0; i < botonesArriendo.length; i++) {
			botonesArriendo[i] = new JButton("Boton "+(i+1));
			botonesArriendo[i].addActionListener(this);
			botonesArriendo[i].setBackground(Color.decode("#A6E7BA"));
			panel_Arriendo.add(botonesArriendo[i]);
		}
		
		//-----PANEL ARRIENDO-----
		
		this.panel_Arriendo.setBackground(Color.GREEN); //Establecemos color al panel
		this.panel_Arriendo.setLayout(new GridLayout(4,4,10,10)); 	
		this.getContentPane().add(panel_Arriendo); //Agregamos el panel a la pantalla
	}	
	
	public static SistemaArriendo getInstance() {
		return sistema;
	}
		
	public static void main(String[] args) {
		SistemaArriendo.getInstance().setVisible(true);
	}

	

}
