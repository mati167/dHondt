package dHondt;

public class Candidato {
	private String partido;
	private long votos;
	private int escaños;
	private String porcentaje;
	
	public Candidato(String p,long v) {
		this.partido = p;
		this.votos= v;
		this.escaños=0;
		this.porcentaje="0.00";
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
	public void setVotos(long votos) {
		this.votos = votos;
	}
	public int getEscaños() {
		return escaños;
	}
	public void setEscaños(int bancas) {
		escaños = bancas;
	}
	public String getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(String string) {
		this.porcentaje = string;
	}

}
