package dHondt;

import java.util.ArrayList;

public class Carga {
		
	public Carga(ArrayList<Candidato> cand) {
			cargar(cand);
	}

	public void cargar(ArrayList<Candidato> candidatos) {
		Candidato c1 = new Candidato("Cambiemos",3930406);
		Candidato c2 = new Candidato("Unidad Ciudadana",3383114);
		Candidato c3 = new Candidato("1Pais",1028385 );
		Candidato c4 = new Candidato("Frente de Izquierda y de los Trabajadores",497665);
		Candidato c5 = new Candidato("Frente Justicialista",485138);
		candidatos.add(c1);
		candidatos.add(c2);
		candidatos.add(c3);
		candidatos.add(c4);
		candidatos.add(c5);
		Ventana.setBancas(35);	
	}
	
	public void actualizar(ArrayList<Candidato> candidatos) {
		for(Candidato candidato:candidatos) {
			candidato.setEscaños(0);
		}
		
		
	}
}

