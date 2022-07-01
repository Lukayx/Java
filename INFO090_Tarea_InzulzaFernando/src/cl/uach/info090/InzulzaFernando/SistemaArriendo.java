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
import java.util.Iterator;

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
	
	private JFrame ventanaEmergente = new JFrame();
	
	private CreadorBoletaCL C_Boleta = new CreadorBoletaCL();
	
	private JTextArea campoTexto = new JTextArea(10,50);
	
	private JTextField cliente = new JTextField(10);
	private JTextField camposTextoInfo[] = new JTextField[6];
	
	private JLabel textoArriendo = new JLabel();
	private JLabel labelsInfo[] = new JLabel[7];
	private JLabel dosPuntos[] = new JLabel[7];
	private JLabel labelVentanaEmergente = new JLabel();
	
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
	
	public void creaVentanaEmergente() {		
		ventanaEmergente.setSize(280,170);
		ventanaEmergente.setLocationRelativeTo(sistema);
		ventanaEmergente.setResizable(false);
		ventanaEmergente.setLayout(new FlowLayout(SwingConstants.CENTER,15,15));
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new GridLayout(3,1,0,10));
		panelPrincipal.add(labelVentanaEmergente);
		
		JPanel aux = new JPanel();
		aux.setLayout(new GridLayout(1,2,10,0));
		aux.add(new JLabel("Cliente: "));
		aux.add(cliente);
		panelPrincipal.add(aux);
		
		JPanel aux2 = new JPanel();
		aux2.setLayout(new GridLayout(1,2,10,0));
		
		
		JButton boton1 = new JButton("Cancelar");
		boton1.setFocusPainted(false);
		boton1.addActionListener(e->ventanaEmergente.dispose());
		boton1.setBackground(Color.decode("#B7B7B7"));
		//boton.setPreferredSize(new Dimension(370,60));
		aux2.add(boton1);
		
		JButton boton2 = new JButton("Ok");
		boton2.setFocusPainted(false);
		boton2.addActionListener(this);
		boton2.setMnemonic('\n');
		boton2.setBackground(Color.decode("#B7B7B7"));
		aux2.add(boton2);
		panelPrincipal.add(aux2);
		
		ventanaEmergente.add(panelPrincipal);
		ventanaEmergente.setVisible(false);		
	}
	
	public void muestraVentanaEmergente(Item s) {
		labelVentanaEmergente.setText("Arrendar item "+s.itemId);
		cliente.setText("");
		ventanaEmergente.setVisible(true);
	}
	
	public void creacionMainPanel() {
		mainPanel.setLayout(new FlowLayout(SwingConstants.CENTER,15,15));
		
		creaPanelBotones(); // PANEL BOTONES AL PRINCIPIO
		botonArrendar.addActionListener(this);
		
		creaPanelInfo();
		
		itemActual = (Item)botonesArriendo[0];
		itemActual.setBorder(new LineBorder(Color.decode("#595959"),4));
		
		actualizaPanel_Info(itemActual);
		
		creaPanelBoletas();
		
		creaPanelExp_Exit();
		
		creaVentanaEmergente();
		
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
				botonesArriendo[i].setBorder(new RoundedBorder(Color.BLACK, 5));
				
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
		
		campoTexto.setBorder(new RoundedBorder(Color.BLACK, 5));
		campoTexto.setEditable(false);
		panelBoletas.add(campoTexto, BorderLayout.SOUTH);
		
		
		mainPanel.add(panelBoletas);
	}
	
	public void creaTresColumnas(JLabel label1, String txt1,  JLabel label2, JTextField campoTexto) {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout());
		panel.setOpaque(false);
		
		label1.setText(txt1);
		
		panel.add(label1);
		
		panel.add(label2);
		
		panel.add(campoTexto);
		
		panelInfo.add(panel);
	}
	
	public void creaPanelInfo() {
		JPanel panelInfoFlow = new JPanel();
		panelInfoFlow.setLayout(new FlowLayout(SwingConstants.CENTER,10,69));
		panelInfoFlow.setBorder(new RoundedBorder(Color.BLACK, 5));
		panelInfoFlow.add(panelInfo);
		
		panelInfoFlow.setBackground(Color.decode("#F3F3F3"));
		
		panelInfo.setLayout(new GridLayout(7,1,0,10));
		panelInfo.setOpaque(false);
		
		for (int i = 0; i<camposTextoInfo.length;i++) {
			camposTextoInfo[i] = new JTextField(10);
			camposTextoInfo[i].setEditable(false);
			camposTextoInfo[i].setBorder(new RoundedBorder(Color.BLACK, 5));
			camposTextoInfo[i].setFont(new Font("Default",0,15));
		}
		
		for (int i = 0; i<labelsInfo.length;i++) {
			labelsInfo[i] = new JLabel();
			dosPuntos[i] = new JLabel(":");
			labelsInfo[i].setFont(new Font("Default",1,15));
			//labelsInfo[i].
			dosPuntos[i].setFont(new Font("Default",1,15));
		}
		
		creaTresColumnas(labelsInfo[0],"Serie",dosPuntos[0],camposTextoInfo[0]);
		
		creaTresColumnas(labelsInfo[1],"Desc",dosPuntos[1],camposTextoInfo[1]);
		
		creaTresColumnas(labelsInfo[2],"Valor base",dosPuntos[2],camposTextoInfo[2]);
		
		creaTresColumnas(labelsInfo[3],"Valor hora",dosPuntos[3],camposTextoInfo[3]);
		
		labelsInfo[4].setText("Estado");
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout());
		panel.setOpaque(false);
				
		panel.add(labelsInfo[4]);
		panel.add(dosPuntos[4]);
		
		//AQUI SE CREA EL PANEL CON EL BOTON DE ARRENDAR Y SU LABEL DE COLOR
		//------------------------------------------------------------------
		JPanel arrendar = new JPanel();
		arrendar.setLayout(new GridLayout(1,2,10,10));
		
		
		botonArrendar.setFocusable(false);
		botonArrendar.setPreferredSize(new Dimension(70,30));;
		botonArrendar.setBorder(new RoundedBorder(Color.BLACK, 6));
		botonArrendar.setForeground(Color.decode("#FFFFF4"));
		
		textoArriendo.setFont(new Font("Default",1,15));
		arrendar.add(textoArriendo);
		arrendar.add(botonArrendar);
		
		arrendar.setBackground(Color.decode("#F3F3F3"));
		
		panel.add(arrendar)
		;
		
		panelInfo.add(panel);
		//------------------------------------------------------------------
		
		creaTresColumnas(labelsInfo[5],"Cliente",dosPuntos[5],camposTextoInfo[4]);
		
		creaTresColumnas(labelsInfo[6],"Inicio",dosPuntos[6],camposTextoInfo[5]);
		
		panelInfo.setVisible(true);
		
		mainPanel.add(panelInfoFlow); 
	}
	
	public void  actualizaPanel_Info(Item s) {
		camposTextoInfo[0].setText(s.itemId);
		camposTextoInfo[1].setText(s.itemDescription);
		camposTextoInfo[2].setText(String.valueOf(s.valorBase).substring(0, 4));
		camposTextoInfo[3].setText(String.valueOf(s.valorHora).substring(0, 4));
		camposTextoInfo[4].setText(s.cliente);
		camposTextoInfo[5].setText(s.fechaArriendo);
		
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
	}
	
	public void creaPanelExp_Exit() {
		panelExport_Exit.setLayout(new BorderLayout());
		
		JPanel cuartoPanel= new JPanel();
		cuartoPanel.setLayout(new FlowLayout(3));
		
		JButton exportar = new JButton("Exportar boletas");
		exportar.setFocusPainted(false);
		exportar.setBorder(new RoundedBorder(Color.BLACK,20));
		exportar.addActionListener(this);
		exportar.setBackground(Color.decode("#B7B7B7"));
		exportar.setPreferredSize(new Dimension(370,60));
		
		JButton salir = new JButton("Salir");
		salir.setFocusPainted(false);
		salir.setBorder(new RoundedBorder(Color.BLACK,20));
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
				itemActual.setBorder(new LineBorder(Color.decode("#595959"),4));
				actualizaPanel_Info(itemActual);
			} else {
				JButton boton = (JButton)e.getSource();
				
				if(boton.getText().equals("Salir")) System.exit(0);
				
				if(boton.getText().equals("Arrendar")) {	

					muestraVentanaEmergente(itemActual);					
					
				} else if(boton.getText().equals("Ok") && cliente.getText().length()>0) {
					itemActual.cliente = cliente.getText();
					
					itemActual.arrendar(itemActual.cliente);
					itemActual.setBackground(Color.decode("#FCE5CD"));
					
					actualizaPanel_Info(itemActual);
					
					ventanaEmergente.setVisible(false);
					
				} else if(boton.getText().equals("Finalizar")) {
					itemActual.cliente="";
					itemActual.fechaArriendo="";
								
					actualizaPanel_Info(itemActual);
					
					itemActual.setBackground(Color.decode("#D9EAD3"));
				}
			}
		}
	}
	
	public static SistemaArriendo getInstance() {
		return sistema;
	}
		
	public static void main(String[] args) {
		SistemaArriendo.getInstance().setVisible(true);
	}
	
}