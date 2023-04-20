package org.grupo_4.Entrega.models;

public class Pronostico {
	private int partido;
	private int ronda;
	private int ganador;
// se cambiara para la siguiente entrega
	public Pronostico(int partido, String equipo1, String empate, String equipo2, int equipo1Id, int equipo2Id){
		this.setRonda(1);
		this.setPartido(partido);
		if(equipo1.equals("X"))
			this.setGanador(equipo1Id);
		else if(equipo2.equals("X"))
			this.setGanador(equipo2Id);
		else
			this.ganador = 0;
		
	}
	
	public int getPartido() {
		return partido;
	}
	public void setPartido(int ronda) {
		this.partido = ronda;
	}
	public int getGanador() {
		return ganador;
	}
	private void setGanador(int ganador) {
		this.ganador = ganador;
	}

	public int getRonda() {
		return ronda;
	}

	public void setRonda(int ronda) {
		this.ronda = ronda;
	}
	
	
}
