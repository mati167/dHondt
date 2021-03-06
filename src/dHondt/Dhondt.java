package dHondt;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Dhondt {

	private ArrayList<Candidato> cand;
	private double[][] matriz;
	private int mayor = 0;
	private int bancas;
	private static final int VOTOS = 0;
	private static final int BANCAS = 1;
	private DecimalFormat df = new DecimalFormat("####0.00");
	
	public Dhondt (ArrayList<Candidato> c) {
		bancas = Ventana.getBancas();
		matriz = new double[bancas+2][c.size()];
		cand = c;
		AsignarBancas();
		MostrarBancas();
		
		
	}
	
	public void AsignarBancas () {
		for (int i = 0; i < cand.size(); i++) {
			matriz[VOTOS][i] = cand.get(i).getVotos(); 
			matriz[BANCAS][i] = cand.get(i).getEscaņos()+1;
		}
		
		for (int i = 2; i < matriz.length; i++) {
			for(int j = 0; j < matriz[VOTOS].length;j++) {
				matriz[i][j] = matriz[VOTOS][j]/matriz[BANCAS][j];
				if( j > 0 && matriz[i][j] >matriz[i][j-1]) {
					mayor = j;
				}
			}
			matriz[BANCAS][mayor]++;
			mayor=0;
		}
		for (int i = 0; i < cand.size(); i++) {
			cand.get(i).setEscaņos((int)matriz[BANCAS][i]-1);
			cand.get(i).setPorcentaje(df.format((matriz[BANCAS][i]-1)*100/bancas));
		}
	}
	
	public void MostrarBancas() {
		for(int i=0; i < cand.size(); i++) {
			System.out.println(cand.get(i).getPartido() + "\t" + cand.get(i).getEscaņos() + "\t" + (cand.get(i).getPorcentaje()));
		}
	}
	 
}
