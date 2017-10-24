package dhondt;

import java.util.ArrayList;

public class Dhondt {

	private ArrayList<Candidato> cand;
	private double[][] matriz;
	
	public Dhondt (int bancas, ArrayList<Candidato> c) {
		matriz = new double[bancas][c.size()];
		cand = c;
		System.out.println(cand.size());
		
	}
	
	public void AsignarBancas () {
		for (int i = 0; i < cand.size(); i++) {
			matriz[0][i] = cand.get(i).getVotos();
		}
		
		for (int i = 0; i < matriz.length; i++) {
			
		}
	}
	
	
	 
}
