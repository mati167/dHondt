package dHondt;

import java.util.ArrayList;

public class Dhondt {

	private ArrayList<Candidato> cand;
	private double[][] matriz;
	private int mayor = 0;
	private static final int VOTOS = 0;
	private static final int BANCAS = 1;
	
	public Dhondt (int bancas, ArrayList<Candidato> c) {
		matriz = new double[bancas+2][c.size()];
		cand = c;
		System.out.println(cand.size());
		System.out.println(matriz.length);
		System.out.println(matriz[0].length);
		AsignarBancas();
		MostrarBancas();
		
		
	}
	
	public void AsignarBancas () {
		for (int i = 0; i < cand.size(); i++) {
			matriz[VOTOS][i] = cand.get(i).getVotos(); 
			matriz[BANCAS][i] = cand.get(i).getBancas()+1;
			System.out.println(matriz[VOTOS][i]);
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
			cand.get(i).setBancas((int)matriz[BANCAS][i]-1);
		}
	}
	
	public void MostrarBancas() {
		for(int i=0; i < cand.size(); i++) {
			System.out.println(cand.get(i).getPartido() + "\t" + cand.get(i).getBancas());
		}
	}
	 
}
