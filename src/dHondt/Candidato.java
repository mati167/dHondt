package dHondt;

public class Candidato {
	private String partido;
	private long votos;
	private int escaños;
	
	public Candidato(String p,long v) {
		this.partido = p;
		this.votos= v;
		this.escaños=0;
	}
	
	public String getPartido() {
		return partido;
	}
	public void setPartido(String partido) {
		this.partido = partido;
	}
	public long getVotos() {
		return votos;
	}
	public void setVotos(int votos) {
		this.votos = votos;
	}
	public int getEscaños() {
		return escaños;
	}
	public void setEscaños(int bancas) {
		escaños = bancas;
	}
	
}
