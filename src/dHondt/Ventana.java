package dHondt;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JToolBar;

import javax.swing.JTextArea;
import javax.swing.JTable;

public class Ventana {

	JFrame frame;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
					//window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Ventana() {
		initialize();
	}
	private void initialize() {
		JFrame frame = new JFrame ("prueba");
		frame.setSize(500,360);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		ArrayList <Candidato> candidatos= new ArrayList<Candidato>();
//		Candidato c1 = new Candidato("Cambiemos",3930406);
//		Candidato c2 = new Candidato("Unidad Ciudadana",3383114);
//		Candidato c3 = new Candidato("1Pais",1028385 );
//		Candidato c4 = new Candidato("Frente de Izquierda y de los Trabajadores",497665);
//		Candidato c5 = new Candidato("Frente Justicialista",485138);
//		candidatos.add(c1);
//		candidatos.add(c2);
//		candidatos.add(c3);
//		candidatos.add(c4);
//		candidatos.add(c5);
		new Cargar(candidatos);
		new Dhondt(35,candidatos);
		
	}

}