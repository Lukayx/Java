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
	
	private JButton botonesArriendo[] = new JButton[16]; //ARREGLO DE BOTONES(ITEMS)
	private JButton botonArrendar = new JButton(); //BOTÓN PARA ENVIAR DATOS Y ARENDAR ITEM
	
	private Item itemActual;//AYUDARÁ A SABER CUAL ITEM ESTA SELECCIONADO
	
	private JPanel mainPanel = new JPanel();
	private JPanel panelArriendo = new JPanel();
	private JPanel panelInfo = new JPanel();
	private JPanel panelBoletas = new JPanel();
	private JPanel panelExport_Exit = new JPanel();
	
	private CreadorBoletaCL C_Boleta = new CreadorBoletaCL();
	
	private JTextArea campoTexto = new JTextArea(10,50);
	
	private JTextField cliente = new JTextField(10);
	
	private JLabel textoArriendo = new JLabel();
	
	private JList lista = new JList();
	
	private SistemaArriendo() {
		super("Sistema Arriendo");
		creandoVentana();
		creacionMainPanel();
	}	
	
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
		
		itemActual = (Item)botonesArriendo[0];
		mostrarDetallesItem(itemActual);
		itemActual.setBorder(new LineBorder(Color.decode("#595959"),4));
		
		mainPanel.add(panelInfo); 
		
		panelInfo.setVisible(true);
		
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
			String[] parts;
			int i = 0;
			while((linea = br.readLine()) != null) {
				parts = linea.split(",");
				if(parts[1].equalsIgnoreCase("kayak")) 				
					botonesArriendo[i] = new Kayak(parts[0],parts[2],Double.parseDouble(parts[3]),Double.parseDouble(parts[4]),C_Boleta);	
				 else if(parts[1].equalsIgnoreCase("segway")) 
					botonesArriendo[i] = new Segway(parts[0],parts[2],Double.parseDouble(parts[3]),Double.parseDouble(parts[4]),C_Boleta);	
				 else 
					botonesArriendo[i] = new Bicicleta(parts[0],parts[2],Double.parseDouble(parts[3]),Double.parseDouble(parts[4]),C_Boleta);	
				
				botonesArriendo[i].setText(parts[0]);
				botonesArriendo[i].setFocusPainted(false);
				botonesArriendo[i].addActionListener(this);
				botonesArriendo[i].setFont(new Font("Default",0,20));
				botonesArriendo[i].setBackground(Color.decode("#D9EAD3"));
				botonesArriendo[i].setPreferredSize(new Dimension(130,95));
				botonesArriendo[i].setBorder(new LineBorder(Color.decode("#595959")));
				
				panelArriendo.add(botonesArriendo[i]);
				
				i++;
			}
			
			br.close();
			fr.close();
			itemActual = (Item)botonesArriendo[0];
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		mainPanel.add(panelArriendo);
		
	}
	
	public void creaPanelBoletas() {
		panelBoletas.setLayout(new BorderLayout());
		
		JLabel textBoletas = new JLabel("Últimas boletas");
		textBoletas.setFont(new Font("Default",Font.ITALIC,20));
		panelBoletas.add(textBoletas,BorderLayout.NORTH);
		
		campoTexto.setBorder(new LineBorder(Color.black));
		campoTexto.setEditable(false);
		panelBoletas.add(campoTexto, BorderLayout.SOUTH);
		
		
		mainPanel.add(panelBoletas);
	}
	
	public void creaTresColumnas(String uno, String dos) {
		panelInfo.add(new JLabel(uno));
		panelInfo.add(new JLabel(":"));
		JTextField aux = new JTextField(dos,10);
		aux.setEditable(false);
		panelInfo.add(aux);
	}
	
	public void mostrarDetallesItem(Item s) {
		
		panelInfo.setLayout(new GridLayout(7,1,5,5));
		panelInfo.setBorder(new LineBorder(Color.gray));
		panelInfo.setBackground(Color.decode("#F3F3F3"));
		
		creaTresColumnas("Serie", s.itemId);
		
		creaTresColumnas("Desc", s.itemDescription);
		
		creaTresColumnas("Valor base", String.valueOf(s.valorBase).substring(0, 4));
		
		creaTresColumnas("Valor Hora", String.valueOf(s.valorHora).substring(0, 4));
		
		panelInfo.add(new JLabel("Estado "));
		panelInfo.add(new JLabel(":"));
		
		JPanel arrendar = new JPanel();
		arrendar.setLayout(new GridLayout(1,2,10,10));
		
		botonArrendar.addActionListener(this);
		botonArrendar.setFocusable(false);
		botonArrendar.setForeground(Color.decode("#FFFFF4"));
		if(s.enArriendo()) {
			textoArriendo.setText("arrendado");
			textoArriendo.setForeground(Color.decode("#E06666"));
			botonArrendar.setBackground(Color.decode("#E06666"));
			botonArrendar.setText("Finalizar");
		} else {			
			textoArriendo.setText("disponible");
			textoArriendo.setForeground(Color.decode("#6AA84F"));
			botonArrendar.setBackground(Color.decode("#6AA84F"));
			botonArrendar.setText("Arrendar");
		}
		
		arrendar.add(textoArriendo);
		arrendar.add(botonArrendar);
		arrendar.setBackground(Color.decode("#F3F3F3"));
		panelInfo.add(arrendar);
		
		panelInfo.add(new JLabel("Cliente "));
		panelInfo.add(new JLabel(":"));
		cliente.setText(s.cliente); 
		panelInfo.add(cliente);
		
		creaTresColumnas("Inicio", s.fechaArriendo);
		
		panelInfo.setFont(new Font("Default",0,20));
	}
	
	public void creaPanelExp_Exit() {
		panelExport_Exit.setLayout(new BorderLayout());
		
		JPanel cuartoPanel= new JPanel();
		cuartoPanel.setLayout(new FlowLayout(3));
		
		JButton exportar = new JButton("Exportar boletas");
		exportar.setFocusPainted(false);
		exportar.addActionListener(this);
		exportar.setBackground(Color.decode("#B7B7B7"));
		exportar.setPreferredSize(new Dimension(370,60));
		
		JButton salir = new JButton("Salir");
		salir.setFocusPainted(false);
		salir.addActionListener(this);
		salir.setBackground(Color.decode("#B7B7B7"));
		salir.setPreferredSize(new Dimension(120,60));
		
		cuartoPanel.add(exportar);
		cuartoPanel.add(salir);
		
		panelExport_Exit.add(cuartoPanel,BorderLayout.SOUTH);
		panelExport_Exit.setVisible(true);
		mainPanel.add(panelExport_Exit);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			if(e.getSource() instanceof Item) {
				itemActual.setBorder(new LineBorder(Color.decode("#595959")));
				itemActual = (Item)e.getSource();
				panelInfo.removeAll();	
				mostrarDetallesItem(itemActual);
				itemActual.setBorder(new LineBorder(Color.decode("#595959"),4));
			} else {
				JButton boton = (JButton)e.getSource();
				if(boton.getText()=="Salir") System.exit(0);
				if(boton.getText()=="Arrendar" && cliente.getText().length()>0) {
					textoArriendo.setForeground(Color.decode("#E06666"));
					textoArriendo.setText("arrendado");
					boton.setBackground(Color.decode("#E06666"));
					boton.setText("Finalizar");
					cliente.setEditable(false);
					itemActual.arrendar(cliente.getText());
					itemActual.setBackground(Color.decode("#FCE5CD"));
				} else if(boton.getText()=="Finalizar") {
					textoArriendo.setForeground(Color.decode("#6AA84F"));
					textoArriendo.setText("disponible");
					boton.setBackground(Color.decode("#6AA84F"));
					boton.setText("Arrendar");
					cliente.setEditable(true);
					itemActual.arrendar("");
					itemActual.setBackground(Color.decode("#D9EAD3"));
				}
			}
			
		} else if(e.getSource() instanceof JTextField) {
			JTextField a = (JTextField)e.getSource();
			a.getText();
		}
	}
	
	public static SistemaArriendo getInstance() {
		return sistema;
	}
		
	public static void main(String[] args) {
		SistemaArriendo.getInstance().setVisible(true);
	}
	
}