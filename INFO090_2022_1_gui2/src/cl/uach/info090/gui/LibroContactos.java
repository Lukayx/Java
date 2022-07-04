package cl.uach.info090.gui;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;


public class LibroContactos extends JFrame implements ActionListener{

	private JList<Contacto> list;
	private DefaultListModel<Contacto> listModel;
	private JButton btnAgregar;
	
	public LibroContactos() {
		super("Contactos");
		setBounds(100,100,600,240);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		listModel = new DefaultListModel<Contacto>();
		list = new JList<Contacto>(listModel);
		//list.setLayoutOrientation(JList.VERTICAL);
		
		JScrollPane listScroller = new JScrollPane(list);
		listScroller.setPreferredSize(new Dimension(240, 120));
		listScroller.setBounds(10, 10, 300, 200);
	
		add(listScroller);
		
		btnAgregar = new JButton("Agregar contacto");
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(260,20,120,30);
		add(btnAgregar);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String nombre = JOptionPane.showInputDialog("Ingresa el nombre del contacto");
		if(nombre != null) {
			String telefono = JOptionPane.showInputDialog("Ingresa el telefono del contacto");
			if(telefono != null) {
				listModel.addElement(new Contacto(nombre,telefono));
			}
		}
			
			
		
		
		
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
		} catch (Exception e) {
			e.printStackTrace();
		}
		LibroContactos lc = new LibroContactos();
		lc.setVisible(true);

	}

}
