package dhondt;

public class Candidato {
	private String partido;
	
	public Candidato(String p,long v) {
		this.partido = p;
		this.votos= v;
		this.Bancas=0;
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
	public int getBancas() {
		return Bancas;
	}
	public void setBancas(int bancas) {
		Bancas = bancas;
	}
	private long votos;
	private int Bancas;
}
