package cl.uach.info090.semana08;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MiEscuchador implements ActionListener{
	
	public boolean c = true;
	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println("Hola!");
		if(e.getSource() instanceof JButton) {
			
			JButton boton = (JButton)e.getSource();
			boton.setText("");
		}
	}

}
