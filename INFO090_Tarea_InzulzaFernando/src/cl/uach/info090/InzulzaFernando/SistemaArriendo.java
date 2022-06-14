	package cl.uach.info090.InzulzaFernando;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;

public class SistemaArriendo extends JFrame implements ActionListener{
	
	public static void rellenaDatoBoton() {
		
	}
	
	private static SistemaArriendo sistema = new SistemaArriendo();
	
	private SistemaArriendo() {
		super("Ventana Genial");
		
		//-----VENTANA-----
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Sistema Arriendo");
		setSize(1000, 700);
		setLocationRelativeTo(sistema);
		setResizable(false);
		
		//-----BOTONES-----
		JButton botonesArriendo[] = new JButton[16]; //ARREGLO DE BOTONES PARA ARRENDAR 
		
		//-----PANEL ARRIENDO-----
		JPanel panel_Arriendo = new JPanel(); //Creacion de Panel
		panel_Arriendo.setBackground(Color.GREEN);//Establecemos color al panel
		panel_Arriendo.setLayout(new GridLayout(4,4,10,10)); 	
		this.getContentPane().add(panel_Arriendo);//Agregamos el panel a la pantalla
		
		for (int i = 0; i < botonesArriendo.length; i++) {
			botonesArriendo[i] = new JButton("Boton "+(i+1));
//			botonesArriendo[i].addActionListener();
			panel_Arriendo.add(botonesArriendo[i]);
		}
		
		JPanel panel_Info = new JPanel();
		JPanel panel_Boletas = new JPanel();
		
		
		
		panel_Info.setLayout(new GridLayout(2,7,10,5));
		//this.add(panel_Info);
		//this.add(panel_Boletas);
		
		JTextField JTextField = new JTextField();
		JLabel label = new JLabel("Últimas boletas");
		JList lista = new JList();
		CreadorBoletaCL C_Boleta = new CreadorBoletaCL();
	}	
	
	public static SistemaArriendo getInstance() {
		return sistema;
	}
		
	public static void main(String[] args) {
		SistemaArriendo.getInstance().setVisible(true);
	}

}
