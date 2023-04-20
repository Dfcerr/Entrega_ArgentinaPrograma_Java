package org.grupo_4.Entrega.models;

import java.util.HashMap;
import java.util.Map;

public class Ronda {
	private Map<Integer, Partido> partidos;
	private int numero;
	
	
	public Ronda(int numero, Map<Integer, Partido> partidos){
		this.setNumero(numero);
		
		Map<Integer, Partido> part = new HashMap<Integer, Partido>();
		int contador = 0;
		for(Partido partido : partidos.values()) {
			if(numero == partido.getRonda()) {
				contador++;
				part.put(contador, partido);
			}
		}
		this.setPartidos(part);
	}
	public String textoPuntosRonda(Participante participante) {
		
		return "El participante " + participante.getNombre() + " hizo un total de " +
		this.puntosRonda(participante) + "puntos accertando un numero de " + this.acciertosRonda(participante)+ " veces en la ronda " + this.getNumero();
	}
	public int puntosRonda(Participante participante) {
		Integer contador = 0;
		int puntuacion = 0;
		for(Pronostico comparador : participante.getPronosticos()) {
			contador++;
			if(comparador.getGanador() == this.getPartidos().get(contador).resultado())
				puntuacion++;
			else
				puntuacion--;
			
		}
		return puntuacion; 
		
	}
	public int acciertosRonda(Participante participante) {
		Integer contador = 0;
		int acciertos = 0;
		for(Pronostico comparador : participante.getPronosticos()) {
			contador++;
			if(comparador.getGanador() == this.getPartidos().get(contador).resultado()) 
				acciertos++;
		}
		return acciertos;
	}
	
	public Map<Integer, Partido> getPartidos() {
		return partidos;
	}
	private void setPartidos(Map<Integer, Partido> partidos2) {
		this.partidos = partidos2;
	}

	public int getNumero() {
		return numero;
	}

	private void setNumero(int numero) {
		this.numero = numero;
	}
	
	
}
