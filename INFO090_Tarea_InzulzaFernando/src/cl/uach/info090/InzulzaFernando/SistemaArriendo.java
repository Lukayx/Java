package cl.uach.info090.InzulzaFernando;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.*;

public class SistemaArriendo extends JFrame implements ActionListener{
	
	private static SistemaArriendo sistema = new SistemaArriendo();
	private JButton botonesArriendo[] = new JButton[16]; //ARREGLO DE BOTONES PARA ARRENDAR 
	private JPanel mainPanel = new JPanel();
	private JPanel panelArriendo = new JPanel();
	private JPanel panelInfo = new JPanel();
	private JPanel panelBoletas = new JPanel();
	private JPanel panelExport_Exit = new JPanel();
	private JList lista = new JList();
	private JTextField campoTexto = new JTextField("",40);
	private CreadorBoletaCL C_Boleta = new CreadorBoletaCL();
	private JLabel textBoletas = new JLabel("Últimas boletas", 10);
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			JButton boton = (JButton)e.getSource();
		}
	}
	
	public void creandoVentana() {
		//-----VENTANA-----
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 700);
		setLocationRelativeTo(sistema);
		setResizable(false);
	}
	
	
	public void creacionMainPanel() {
		mainPanel.setLayout(new GridLayout(2,2,20,20));
		
		creaPanelBotones();
		muestraPanelInfo();
		creaPanelBoletas();
		creaPanelExp_Exit();
		this.getContentPane().add(mainPanel); //Agregamos el panel a la pantalla
	}
	
	public String[] separaLineas(String lineToParse) {
		String[] parts = lineToParse.split(",");
		return parts;
	}
	
	public void creaPanelBotones() {
		panelArriendo.setLayout(new GridLayout(4,4,10,10));
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader("Archivos/Datos");
			br = new BufferedReader(fr);
			String linea = "";	
			int i = 0;
			String[] parts;
			while((linea = br.readLine()) != null) {
				parts = separaLineas(linea);
				if(parts[1].equalsIgnoreCase("kayak")) {					
					botonesArriendo[i] = new Kayak(parts[0],parts[2],Double.parseDouble(parts[3]),Double.parseDouble(parts[4]),C_Boleta);	
				} else if(parts[1].equalsIgnoreCase("segway")) {
					botonesArriendo[i] = new Segway(parts[0],parts[2],Double.parseDouble(parts[3]),Double.parseDouble(parts[4]),C_Boleta);	
				} else {
					botonesArriendo[i] = new Bicicleta(parts[0],parts[2],Double.parseDouble(parts[3]),Double.parseDouble(parts[4]),C_Boleta);	
				}
				botonesArriendo[i].addActionListener(this);
				if(((Item) botonesArriendo[i]).enArriendo()) {					
					botonesArriendo[i].setBackground(Color.decode("#A6E7BA"));
				} else {
					botonesArriendo[i].setBackground(Color.decode("#E1AD86"));
				}
				botonesArriendo[i].setText(parts[0]);
				this.panelArriendo.add(botonesArriendo[i]);
				i++;
			}
			br.close();
			fr.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		mainPanel.add(panelArriendo);
	}
	
	public void creaPanelBoletas() {
		panelBoletas.setLayout(new GridLayout(2,1));
		panelBoletas.add(textBoletas);
		panelBoletas.add(campoTexto);
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