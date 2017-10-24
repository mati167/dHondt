package dhondt;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		ArrayList <Candidato> candidatos= new ArrayList<Candidato>();
		Candidato c1 = new Candidato("Cambiemos",3896150);
		Candidato c2 = new Candidato("Unidad Ciudadana",3348210);
		Candidato c3 = new Candidato("1Pais",1019090);
		Candidato c4 = new Candidato("Frente de Izquierda y de los Trabajadores",492627);
		Candidato c5 = new Candidato("Frente Justicialista",481533);
		candidatos.add(c1);
		candidatos.add(c2);
		candidatos.add(c3);
		candidatos.add(c4);
		candidatos.add(c5);
		new Dhondt(35,candidatos);
		
		
	}

}
