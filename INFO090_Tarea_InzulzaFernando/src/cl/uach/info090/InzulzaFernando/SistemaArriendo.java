package cl.uach.info090.InzulzaFernando;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.NumberFormat.Style;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicBorders;
import javax.swing.text.StyleConstants;

public class SistemaArriendo extends JFrame implements ActionListener{
	
	private static SistemaArriendo sistema = new SistemaArriendo();
	
	private JButton botonesArriendo[] = new JButton[16]; //ARREGLO DE BOTONES PARA ARRENDAR 
	
	private JPanel mainPanel = new JPanel();
	private JPanel panelArriendo = new JPanel();
	private JPanel panelInfo = new JPanel();
	private JPanel panelBoletas = new JPanel();
	private JPanel panelExport_Exit = new JPanel();
	
	private JList lista = new JList();
	
	private JTextArea campoTexto = new JTextArea(10,40);
	
	private CreadorBoletaCL C_Boleta = new CreadorBoletaCL();
	
	private JLabel textBoletas = new JLabel();
	
	public void creandoVentana() {
		//-----VENTANA-----
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1170, 700);
		setLocationRelativeTo(sistema);
		setResizable(false);
	}
	
	
	public void creacionMainPanel() {
		mainPanel.setLayout(new FlowLayout(SwingConstants.CENTER,15,15));
		
		creaPanelBotones(); // PANEL BOTONES AL PRINCIPIO
		
		mainPanel.add(panelInfo); 
		
		creaPanelBoletas();
		
		creaPanelExp_Exit();
		
		this.getContentPane().add(mainPanel); //AGREGAMOS EL PANEL A LA PANTALLA
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
				parts = linea.split(",");
				if(parts[1].equalsIgnoreCase("kayak")) {					
					botonesArriendo[i] = new Kayak(parts[0],parts[2],Double.parseDouble(parts[3]),Double.parseDouble(parts[4]),C_Boleta);	
				} else if(parts[1].equalsIgnoreCase("segway")) {
					botonesArriendo[i] = new Segway(parts[0],parts[2],Double.parseDouble(parts[3]),Double.parseDouble(parts[4]),C_Boleta);	
				} else {
					botonesArriendo[i] = new Bicicleta(parts[0],parts[2],Double.parseDouble(parts[3]),Double.parseDouble(parts[4]),C_Boleta);	
				}
				botonesArriendo[i].setText(parts[0]);
				botonesArriendo[i].setFocusPainted(false);
				botonesArriendo[i].addActionListener(this);
				botonesArriendo[i].setFont(new Font("Default",0,20));
				//botonesArriendo[i].setBorder(new RoundedBorder());
				botonesArriendo[i].setBackground(Color.decode("#D9EAD3")); //#FCE5CD
				botonesArriendo[i].setPreferredSize(new Dimension(130,95));
				
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
		panelBoletas.setLayout(new BorderLayout());
		
		textBoletas.setText("Últimas boletas");
		textBoletas.setFont(new Font("Default",Font.ITALIC,20));
		panelBoletas.add(textBoletas,BorderLayout.NORTH);
		
		campoTexto.setBorder(new LineBorder(Color.black));
		campoTexto.setEditable(false);
		panelBoletas.add(campoTexto, BorderLayout.SOUTH);
		
		
		mainPanel.add(panelBoletas);
	}
	
	public void mostrarDetallesItem(Item s) {
		panelInfo.setLayout(new GridLayout(7,1,5,5));
		panelInfo.setBorder(new LineBorder(Color.gray));
		panelInfo.setBackground(Color.decode("#B9BDB9"));
		
		panelInfo.add(new JLabel("Serie"));
		panelInfo.add(new JLabel(":"));
		panelInfo.add(new JTextField(s.itemId,10));
		
		panelInfo.add(new JLabel("Desc "));
		panelInfo.add(new JLabel(":"));
		panelInfo.add(new JTextField(s.itemDescription,10));
		
		panelInfo.add(new JLabel("Valor base "));
		panelInfo.add(new JLabel(":"));
		panelInfo.add(new JTextField(String.valueOf(s.valorBase),10));
		
		panelInfo.add(new JLabel("Valor Hora "));
		panelInfo.add(new JLabel(":"));
		panelInfo.add(new JTextField(String.valueOf(s.valorHora),10));
		
		panelInfo.add(new JLabel("Estado "));
		panelInfo.add(new JLabel(":"));
		
		JPanel arrendar = new JPanel();
		arrendar.setLayout(new GridLayout(1,2,10,10));
		JLabel estado = new JLabel("Disponible");
		estado.setForeground(Color.green);
		arrendar.add(estado);
		JButton botonArriendo = new JButton("Arrendar");
		botonArriendo.setForeground(Color.WHITE);
		botonArriendo.setBackground(Color.green);
		botonArriendo.setFocusable(false);
		arrendar.add(botonArriendo);
		panelInfo.add(arrendar);
		
		panelInfo.add(new JLabel("Cliente "));
		panelInfo.add(new JLabel(":"));
		panelInfo.add(new JTextField(10));
		
		panelInfo.add(new JLabel("Inicio "));
		panelInfo.add(new JLabel(":"));
		panelInfo.add(new JTextField(10));
		
		panelInfo.setFont(new Font("Default",0,20));
		
		panelInfo.setVisible(true);
	}
	
	public void creaPanelExp_Exit() {
		new JButton();
	}
	
	private SistemaArriendo() {
		super("Sistema Arriendo");
		creandoVentana();
		creacionMainPanel();
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof Item) {
			Item boton = (Item)e.getSource();
			panelInfo.removeAll();
			mostrarDetallesItem(boton);
		}
	}
	
	public static SistemaArriendo getInstance() {
		return sistema;
	}
		
	public static void main(String[] args) {
		SistemaArriendo.getInstance().setVisible(true);
	}
	
}