package cl.uach.info090.InzulzaFernando;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;

import javax.swing.*;
import javax.swing.border.LineBorder;

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
	
	private JDialog ventanaEmergente = new JDialog(this,"asdad",true);
	
	private CreadorBoletaCL C_Boleta = new CreadorBoletaCL();
	
	private JTextField cliente = new JTextField(17);
	private JTextField camposTextoInfo[] = new JTextField[6];
	
	private JLabel textoArriendo = new JLabel();
	private JLabel textoBoletas = new JLabel();
	private JLabel labelsInfo[] = new JLabel[7];
	private JLabel dosPuntos[] = new JLabel[7];
	private JLabel labelVentanaEmergente = new JLabel();
	
	private DefaultListModel<Boleta> listModel = new DefaultListModel<Boleta>();
	private JList<Boleta> ultimasBoletas = new JList<Boleta>(listModel);
	
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
		mainPanel.setLayout(new FlowLayout(0,15,15));
		mainPanel.setBackground(Color.WHITE);
		
		creaPanelBotones(); // PANEL BOTONES AL PRINCIPIO
		
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
		panelArriendo.setBackground(Color.WHITE);

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
	
	public void creaTresColumnas(JLabel label1, String txt1,  JLabel label2, JTextField campoTexto) {
		label1.setText(txt1);
		
		panelInfo.add(label1);
		
		panelInfo.add(label2);
		
		panelInfo.add(campoTexto);
	}
	
	public void creaPanelInfo() {
		JPanel panelInfoFlow = new JPanel();
		panelInfoFlow.setLayout(new FlowLayout(SwingConstants.CENTER,10,17));
		panelInfoFlow.setBorder(new RoundedBorder(Color.BLACK, 5));
		panelInfoFlow.setBackground(Color.decode("#F3F3F3"));
		panelInfoFlow.add(panelInfo,0);
		
		panelInfo.setLayout(new GridLayout(7,3,-177,15));
		panelInfo.setOpaque(false);
		
		for (int i = 0; i<camposTextoInfo.length;i++) {
			camposTextoInfo[i] = new JTextField(20);
			camposTextoInfo[i].setEditable(false);
			camposTextoInfo[i].setBorder(new RoundedBorder(Color.BLACK, 16));
			camposTextoInfo[i].setPreferredSize(new Dimension(40,40));
			camposTextoInfo[i].setFont(new Font("Default",100,18));
		}
		
		for (int i = 0; i<labelsInfo.length;i++) {
			labelsInfo[i] = new JLabel();
			dosPuntos[i] = new JLabel(":");
			labelsInfo[i].setFont(new Font("Default",1,18));
			dosPuntos[i].setFont(new Font("Default",1,18));
		}
		
		creaTresColumnas(labelsInfo[0],"Serie",dosPuntos[0],camposTextoInfo[0]);
		
		creaTresColumnas(labelsInfo[1],"Desc",dosPuntos[1],camposTextoInfo[1]);
		
		creaTresColumnas(labelsInfo[2],"Valor base",dosPuntos[2],camposTextoInfo[2]);
		
		creaTresColumnas(labelsInfo[3],"Valor hora",dosPuntos[3],camposTextoInfo[3]);
		
		labelsInfo[4].setText("Estado");
				
		panelInfo.add(labelsInfo[4]);
		panelInfo.add(dosPuntos[4]);
		
		//AQUI SE CREA EL PANEL CON EL BOTON DE ARRENDAR Y SU LABEL DE COLOR
		
		//------------------------------------------------------------------
		JPanel arrendar = new JPanel();
		arrendar.setLayout(new GridLayout(1,2,0,0));
		
		botonArrendar.setFocusable(false);
		botonArrendar.addActionListener(this);
		botonArrendar.setBorder(new RoundedBorder(Color.BLACK, 6));
		botonArrendar.setPreferredSize(new Dimension(105,30));
		botonArrendar.setForeground(Color.decode("#FFFFF4"));
		botonArrendar.setFont(new Font("Default",1,18));
		
		textoArriendo.setFont(new Font("Default",1,18));
		arrendar.add(textoArriendo);
		arrendar.add(botonArrendar);
		arrendar.setOpaque(false);
		
		panelInfo.add(arrendar);
		
		//------------------------------------------------------------------
		
		creaTresColumnas(labelsInfo[5],"Cliente",dosPuntos[5],camposTextoInfo[4]);
		
		creaTresColumnas(labelsInfo[6],"Inicio",dosPuntos[6],camposTextoInfo[5]);
		
		panelInfo.setVisible(true);
		
		mainPanel.add(panelInfoFlow); 
	}
	
	public void  actualizaPanel_Info(Item s) {
		camposTextoInfo[0].setText(" "+s.getItemId());
		camposTextoInfo[1].setText(" "+s.getItemDescription());
		camposTextoInfo[2].setText(" "+String.valueOf((int)s.getValorBase()));
		camposTextoInfo[3].setText(" "+String.valueOf((int)s.getValorHora()));
		camposTextoInfo[4].setText(" "+s.getCliente());
		camposTextoInfo[5].setText(" "+s.getFechaArriendo());
		
		if(s.enArriendo()) {
			textoArriendo.setText("Arrendado");
			textoArriendo.setForeground(Color.decode("#E06666"));
			botonArrendar.setBackground(Color.decode("#E06666"));
			botonArrendar.setText("Finalizar");
		} else {			
			textoArriendo.setText("Disponible");
			textoArriendo.setForeground(Color.decode("#6AA84F"));
			botonArrendar.setBackground(Color.decode("#6AA84F"));
			botonArrendar.setText("Arrendar");
		}
	}
	
	public void creaPanelBoletas() {
		panelBoletas.setLayout(new BorderLayout());
		panelBoletas.setBackground(Color.WHITE);
		
		ultimasBoletas.setLayoutOrientation(JList.VERTICAL);
		ultimasBoletas.setFont(new Font("Default",Font.ITALIC,20));
		
		JScrollPane listScroller = new JScrollPane(ultimasBoletas);
		listScroller.setBorder(new RoundedBorder(Color.BLACK, 10));
		listScroller.setPreferredSize(new Dimension(550,170));	
		listScroller.setBackground(Color.WHITE);
		
		textoBoletas.setText("Últimas boletas");
		textoBoletas.setFont(new Font("Default",Font.ITALIC,20));
		
		panelBoletas.add(textoBoletas,BorderLayout.NORTH);
		panelBoletas.add(listScroller, BorderLayout.SOUTH);
		
		mainPanel.add(panelBoletas);
	}
	
	public void actualizaPanelBoletas(){
		listModel.addElement(itemActual.devolver());
	}
	
	public void creaPanelExp_Exit() {
		panelExport_Exit.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelExport_Exit.setOpaque(false);
		
		JButton exportar = new JButton("Exportar boletas");
		exportar.setFocusPainted(false);
		exportar.addActionListener(this);
//		exportar.setBorder(new RoundedBorder(Color.BLACK,10));
		exportar.setBackground(Color.decode("#B7B7B7"));
		exportar.setFont(new Font("Default",0,20));
		exportar.setPreferredSize(new Dimension(370,60));
		
		JButton salir = new JButton("Salir");
		salir.setFocusPainted(false);
		salir.addActionListener(this);
//		salir.setBorder(new RoundedBorder(Color.BLACK,10));
		salir.setBackground(Color.decode("#B7B7B7"));
		salir.setFont(new Font("Default",0,20));
		salir.setPreferredSize(new Dimension(170,60));
		
		panelExport_Exit.add(exportar);
		panelExport_Exit.add(salir);
		panelExport_Exit.setVisible(true);
		
		mainPanel.add(panelExport_Exit);
	}
	
	public void exportarBoletas() {
		Boleta boleta;		
		String nombreArchivo;
		int indiceSubString;
		for (int i = 0; i < listModel.getSize();i++) {
			boleta = listModel.getElementAt(i);
			FileWriter fw;
			BufferedWriter bw;
			nombreArchivo = boleta.toString();
			indiceSubString = nombreArchivo.indexOf(" ");
			nombreArchivo = nombreArchivo.substring(0,nombreArchivo.indexOf(':')-2);
			nombreArchivo =  nombreArchivo.replaceAll("/","-");
			nombreArchivo = nombreArchivo.replaceAll(" ","");
			try{
				fw = new FileWriter("./Boletas/" + nombreArchivo + ".txt");
				bw = new BufferedWriter(fw);
				for(int j = 0; j < boleta.detalle().length(); j++) {
					bw.write(boleta.detalle().charAt(j));
				}
				bw.close();
				fw.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public void creaVentanaEmergente() {		
		ventanaEmergente.setSize(300,200);
		ventanaEmergente.setLocationRelativeTo(sistema);
		ventanaEmergente.setResizable(false);
		ventanaEmergente.setLayout(new FlowLayout(SwingConstants.CENTER,15,15));
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new GridLayout(3,1,0,20));
		labelVentanaEmergente.setFont(new Font("Default",1,15));
		panelPrincipal.add(labelVentanaEmergente);
		
		JPanel aux = new JPanel();
		aux.setLayout(new GridLayout(1,2,-126,0));
		JLabel textoCliente = new JLabel("Cliente: ");
		textoCliente.setFont(new Font("Default",1,15));
		aux.add(textoCliente);
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
		labelVentanaEmergente.setText("Arrendar item "+s.getItemId());
		ventanaEmergente.setVisible(true);
		cliente.setText("");
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
					itemActual.arrendar(cliente.getText());
					itemActual.setBackground(Color.decode("#FCE5CD"));
					
					actualizaPanel_Info(itemActual);
					
					ventanaEmergente.setVisible(false);
					
				} else if(boton.getText().equals("Finalizar")) {
					actualizaPanelBoletas();
								
					itemActual.arrendar("");
					actualizaPanel_Info(itemActual);
					
					itemActual.setBackground(Color.decode("#D9EAD3"));
				} else if(boton.getText().equals("Exportar boletas")) {
					exportarBoletas();
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