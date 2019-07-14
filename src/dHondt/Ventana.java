package dHondt;

import java.util.ArrayList;
import javax.swing.JFrame;
import java.awt.EventQueue;

import javax.swing.JButton;

import javax.swing.JTable;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

public class Ventana {


	JFrame frame;
	private ArrayList <Candidato> candidatos= new ArrayList<Candidato>();
	private JTable tabla;
	private static int bancas;
	private DefaultTableModel tableModel;
	private Carga carga;
	
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
		carga = new Carga(candidatos);
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
		lblBancas.setHorizontalAlignment(SwingConstants.CENTER);
		lblBancas.setBounds(398, 11, 69, 14);
		frame.getContentPane().add(lblBancas);
		
		JLabel lblTotal = new JLabel();
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal.setText(Integer.toString(bancas));
		lblTotal.setBounds(398, 26, 69, 30);
		frame.getContentPane().add(lblTotal);
		
		JButton btnRefresh = new JButton("");
		btnRefresh.setIcon(new ImageIcon(iconRefresh));
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				carga.actualizar(candidatos);
				new Dhondt(candidatos);
			}
		});
		btnRefresh.setBounds(489, 93, 55, 45);
		frame.getContentPane().add(btnRefresh);
		
		new Dhondt(candidatos);
		
		cargarTabla();
		alinearTabla();		
		
		
	}
	
	private void cargarTabla() {
		Object[] objs;
		tableModel = new DefaultTableModel(new Object[] { "Partido","Votos","Escaños","%"},0);
		for (Candidato candidato : candidatos) {
			objs = new Object[] { candidato.getPartido(), candidato.getVotos(), candidato.getEscaños(),candidato.getPorcentaje()};
			tableModel.addRow(objs);//Agrego a la tabla
		}
	}
	private void alinearTabla() {
		JPanel panel = new JPanel();
		panel.setBounds(20, 67, 445, 228);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		tabla = new JTable(tableModel);
		tabla.setSurrendersFocusOnKeystroke(true);
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabla.getColumnModel().getColumn(0).setPreferredWidth(230);
		tabla.getColumnModel().getColumn(1).setPreferredWidth(75);
		tabla.getColumnModel().getColumn(2).setPreferredWidth(70);
		tabla.getColumnModel().getColumn(3).setPreferredWidth(69);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		tabla.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
		tabla.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
		tabla.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
		tabla.setBounds(30, 67, 449, 244);
		
		JScrollPane scrollPane = new JScrollPane(tabla);
		scrollPane.setBounds(0, 0, 445, 228);
		panel.add(scrollPane);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
	}
	
}