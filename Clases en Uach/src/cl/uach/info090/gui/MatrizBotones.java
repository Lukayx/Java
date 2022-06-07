package cl.uach.info090.gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


/**
 * Esta clase es un ejemplo de una ventana con botones 
 * simulando un juego del <b>gato</b> (tic tac toe en inglés)
 * <hr />
 * El ejemplo corresponde a parte de una clase de la 
 * <a href="https://drive.google.com/drive/folders/1xlv04K-9bh2Wi6oYnk99vKJLD31IFIbO">semana 9</a> 
 * @author JG
 * @version 1.0
 * @date 2020-06-02
 *
 */
public class MatrizBotones extends JFrame implements ActionListener{

	private BotonGato[] botones;
	private JPanel panel;
	private JButton salir;
	
	/**
	 * Constructor muy bonito!
	 */
	public MatrizBotones() {
		super("Matriz Botones");
		setBounds(100,100,600,600);
		//setResizable(false);
		setLayout(new BorderLayout());
		panel = new JPanel();
		
		panel.setLayout(new GridLayout(3,3));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		botones = new BotonGato[9];
		
		//MiEscuchador escuchador = new MiEscuchador();
		
		for(int i=0;i<9;i++) {
			botones[i] = new BotonGato();
			botones[i].addActionListener(this);
			panel.add(botones[i]);
		}
		
		add(panel,BorderLayout.CENTER);
		
		salir = new JButton("Salir");
		salir.addActionListener(this);
		add(salir,BorderLayout.SOUTH);
		
	}
	
	@Override
	/**
	 * @param e : evento que originó 
	 */
	public void actionPerformed(ActionEvent e) {
		//System.out.println("Hola!");
		if(e.getSource() instanceof BotonGato) {
			BotonGato boton = (BotonGato)e.getSource();
			boton.cambiarMarca();
		}else {
			if(e.getSource() instanceof JButton) {
				int i = JOptionPane.showConfirmDialog(
						this, 
						"Desea salir?", "Salir de la app", 
						JOptionPane.OK_CANCEL_OPTION);
				if (i==0) System.exit(0);
			}
		}
		
	}
	/**
	 * este metodo es dummy!
	 * @param s corresponde al nombre
	 * @return el largo del string s
	 */
	public int dummy(String s) {
		return s.length();
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
		} catch (Exception e) {
			e.printStackTrace();
		}
		MatrizBotones mb = new MatrizBotones();
		mb.setVisible(true);

	}

}
