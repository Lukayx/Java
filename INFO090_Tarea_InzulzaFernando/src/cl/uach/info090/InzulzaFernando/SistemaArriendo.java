package cl.uach.info090.InzulzaFernando;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SistemaArriendo extends JFrame implements ActionListener{

private static SistemaArriendo sistema = new SistemaArriendo();
private JButton botonesArriendo[] = new JButton[16]; //ARREGLO DE BOTONES PARA ARRENDAR 
private JPanel mainPanel = new JPanel();
private JPanel panelArriendo = new JPanel();
private JPanel panelInfo = new JPanel();
private JPanel panelBoletas = new JPanel();
private JPanel panelExport_Exit = new JPanel();
private JTextField JTextField = new JTextField();
private JLabel textBoletas = new JLabel("�ltimas boletas");
private JList lista = new JList();
private CreadorBoletaCL C_Boleta = new CreadorBoletaCL();

@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource() instanceof JButton) {
		JButton boton = (JButton)e.getSource();		
		boton.setBorder();
		if(boton.getBackground().equals(Color.decode("#C0E4B7"))) {
			boton.setBackground(Color.decode("#F7E2BD"));
		} else {
			boton.setBackground(Color.decode("#C0E4B7"));			
		}
	}
}

public void creandoVentana() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(1000, 700);
	setLocationRelativeTo(sistema);
	setResizable(false);
}

public void creacionMainPanel() {
	mainPanel.setLayout(new GridLayout(2,2,20,20));
	
	creaPanelBotones();
	
	this.getContentPane().add(mainPanel); //Agregamos el panel a la pantalla
}

public void creaPanelBotones() {
	panelArriendo.setLayout(new GridLayout(4,4,10,10));
	for (int i = 0; i < botonesArriendo.length; i++) {
		botonesArriendo[i] = new JButton("Boton "+(i+1));	
		botonesArriendo[i].addActionListener(this);
		botonesArriendo[i].setBackground(Color.decode("#C0E4B7"));
		//botonesArriendo[i].add();
		this.panelArriendo.add(botonesArriendo[i]);
	}
	mainPanel.add(panelArriendo);
}

public void creaPanelBoletas() {
	panelBoletas.add(textBoletas);
	textBoletas.setAlignmentX(LEFT_ALIGNMENT);
	textBoletas.setAlignmentY(TOP_ALIGNMENT);
	mainPanel.add(panelBoletas);
}

public void muestraPanelInfo() {
	panelInfo.setLayout(new GridLayout(2,7,20,10));
	mainPanel.add(panelInfo);
}

public void creaPanelExp_Exit() {
	
}

private SistemaArriendo() {
	super("Sistema Arriendo");
	creandoVentana();
	creacionMainPanel();
}	

public static SistemaArriendo getInstance() {
	return sistema;
}
	
public static void main(String[] args) {
	SistemaArriendo.getInstance().setVisible(true);
}



}

