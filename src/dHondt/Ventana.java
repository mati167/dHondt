package dHondt;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JToolBar;

import javax.swing.JTextArea;
import javax.swing.JTable;
import java.awt.GridLayout;
import java.awt.Image;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.SpringLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana {

	JFrame frame;
	private ArrayList <Candidato> candidatos= new ArrayList<Candidato>();
	private JTable tabla;
	private static int bancas;
	private DefaultTableModel tableModel;
	
	public static int getBancas() {
		return bancas;
	}
	public static void setBancas(int renueva) {
		bancas = renueva;
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana ventana = new Ventana();
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
		new Cargar(candidatos);
		frame = new JFrame ("prueba");
		frame.setSize(568,424);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
				

		
/****************************************************************************************************************************************************/		
/*****************************************************************IMAGENES**************************************************************************/
/**************************************************************************************************************************************************/	
		
		Image iconRefresh = new ImageIcon("resources/refresh.png").getImage().getScaledInstance(45, 45,//Nuevo icono de iumagen//Hago un resize de la imagen antes de agregarla
		java.awt.Image.SCALE_SMOOTH);
	
		Image iconbsas = new ImageIcon("resources/buenosaires.png").getImage().getScaledInstance(70,70,//Nuevo icono de iumagen//Hago un resize de la imagen antes de agregarla
		java.awt.Image.SCALE_SMOOTH);
		
		Image iconbsasEscudo = new ImageIcon("resources/buenosairesEscudo.png").getImage().getScaledInstance(35,40,//Nuevo icono de iumagen//Hago un resize de la imagen antes de agregarla
		java.awt.Image.SCALE_SMOOTH);
		
		Image iconArgentina = new ImageIcon("resources/Argentina.png").getImage().getScaledInstance(65, 45,//Nuevo icono de iumagen//Hago un resize de la imagen antes de agregarla
		java.awt.Image.SCALE_SMOOTH);
		
		Image iconbsasFlag = new ImageIcon("resources/buenosairesbandera.png").getImage().getScaledInstance(66, 45,//Nuevo icono de iumagen//Hago un resize de la imagen antes de agregarla
		java.awt.Image.SCALE_SMOOTH);

/****************************************************************************************************************************************************/		
/*****************************************************************LABELS****************************************************************************/
/**************************************************************************************************************************************************/	
		
		JLabel lblTitulo = new JLabel("Elecciones Legislativas 2019");
		lblTitulo.setBounds(89, 11, 299, 45);
		frame.getContentPane().add(lblTitulo);
		
		JLabel lblProvincia = new JLabel("");
		lblProvincia.setBounds(474, 219, 70, 70);
		lblProvincia.setIcon(new ImageIcon(iconbsas));//seteo el icono segun imagen pasada//Nuevo icono de iumagen
		frame.getContentPane().add(lblProvincia);//agrego elementos jswing al panel
				
		JLabel lblNombreProvincia = new JLabel("BUENOS AIRES");
		lblNombreProvincia.setBounds(115, 322, 371, 52);
		frame.getContentPane().add(lblNombreProvincia);
		
		JLabel lblEscudoProvincia = new JLabel("");
		lblEscudoProvincia.setBounds(34, 322, 56, 52);
		lblEscudoProvincia.setIcon(new ImageIcon(iconbsasEscudo));//seteo el icono segun imagen pasada//Nuevo icono de iumagen
		frame.getContentPane().add(lblEscudoProvincia);//agrego elementos jswing al panel
		
		JLabel lblBanderaPais = new JLabel("");
		lblBanderaPais.setBounds(10, 11, 80, 45);
		lblBanderaPais.setIcon(new ImageIcon(iconArgentina));//seteo el icono segun imagen pasada//Nuevo icono de iumagen
		frame.getContentPane().add(lblBanderaPais);//agrego elementos jswing al panel
		
		JLabel lblBanderaProvincia = new JLabel("");
		lblBanderaProvincia.setBounds(477, 11, 66, 45);
		lblBanderaProvincia.setIcon(new ImageIcon(iconbsasFlag));//seteo el icono segun imagen pasada//Nuevo icono de iumagen
		frame.getContentPane().add(lblBanderaProvincia);//agrego elementos jswing al panel
		
		JLabel lblBancas = new JLabel("BANCAS");
		lblBancas.setBounds(398, 11, 69, 14);
		frame.getContentPane().add(lblBancas);
		
		JLabel lblTotal = new JLabel();
		lblTotal.setBounds(398, 26, 69, 30);
		frame.getContentPane().add(lblTotal);
		
		JButton btnRefresh = new JButton("");
		btnRefresh.setIcon(new ImageIcon(iconRefresh));
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRefresh.setBounds(489, 93, 55, 45);
		frame.getContentPane().add(btnRefresh);
		
		new Dhondt(candidatos);
		
		cargarTabla();
		
		tabla = new JTable(tableModel);
		tabla.setBounds(30, 67, 449, 244);
		frame.getContentPane().add(tabla);
		
	}
	
	private void cargarTabla() {
		tableModel = new DefaultTableModel(0,5);
		Object[] objs;
		// tableModel.addRow(columnas);//Agrego a la tabla

		for (Candidato candidato : candidatos) {
			objs = new Object[] { candidato.getPartido(), candidato.getVotos(), candidato.getEscaños()};
			tableModel.addRow(objs);//Agrego a la tabla
		}
	}
	
}