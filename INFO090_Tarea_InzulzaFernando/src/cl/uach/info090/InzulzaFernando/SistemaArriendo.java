package cl.uach.info090.InzulzaFernando;

import java.awt.BorderLayout;

import javax.swing.*;
public class SistemaArriendo extends JFrame implements ActionListener{
	
	private static SistemaArriendo sistema = new SistemaArriendo();
	
	private SistemaArriendo() {
		super("Ventana Genial");
		setBounds(100, 100, 400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setLayout(new BorderLayout());
		JButton Boton = new JButton();
		JPanel panel = new JPanel();
		JTextField JTextField = new JTextField();
		JLabel label = new JLabel();
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
