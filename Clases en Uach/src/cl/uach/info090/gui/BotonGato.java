package cl.uach.info090.gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class BotonGato extends JButton{
	private char marca;
	public BotonGato() {
		super();
		marca  = ' ';
		this.setBackground(new Color(230,230,230));
		this.setForeground(new Color(255,255,255));
		this.setFont(new Font("SansSerif", Font.BOLD, 24));
	}
	
	public void cambiarMarca() {
		if(marca == ' ') {
			marca = 'X';
			this.setBackground(new Color(255,0,0));
		}
		else
			if(marca == 'X') {
				marca = '0';
				this.setBackground(new Color(0,0,255));
			}
			else
				if(marca == '0') {
					marca = ' ';
					this.setBackground(new Color(230,230,230));
				}
		setText(marca+"");
	}
	
}
