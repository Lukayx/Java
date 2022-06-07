package cl.uach.info090.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MiEscuchador implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println("Hola!");
		if(e.getSource() instanceof JButton) {
			JButton boton = (JButton)e.getSource();
			boton.setText("apretado!");
		}
		
	}

}
