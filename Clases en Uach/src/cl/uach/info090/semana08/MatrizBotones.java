package cl.uach.info090.semana08;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

public class MatrizBotones extends JFrame implements ActionListener{
	
	private BotonGato[] botones;
	
	public MatrizBotones() {
		super("Matriz Botones");
		setBounds(100,100,600,600);
//		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(3,3));
		botones = new BotonGato[9];
		
//		MiEscuchador escuchador = new MiEscuchador();
		
//		for (int i = 0; i < botones.length; i++) {
//			botones[i] = new BotonGato("");
//			botones[i].addActionListener(escuchador);
//			this.add(botones[i]);
//		}
		
		for (int i = 0; i < botones.length; i++) {
			botones[i] = new BotonGato();
			botones[i].addActionListener(this);
			add(botones[i]);
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println("Hola!");
		if(e.getSource() instanceof BotonGato) {
			BotonGato boton = (BotonGato)e.getSource();
			if(boton.getText().length() == 0)
				boton.cambiarMarca();
		}
	}
	
	public static void main(String[] args) {
		MatrizBotones mb = new MatrizBotones();
		mb.setVisible(true);

	}

}
