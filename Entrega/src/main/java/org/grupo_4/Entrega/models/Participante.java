package org.grupo_4.Entrega.models;

public class Participante {
	private String nombre;
	private int id;
	private Pronostico pronosticos[];
	
	public Participante(String nombre, int id) {
		this.setNombre(nombre);
		this.setId(id);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Pronostico[] getPronosticos() {
		return pronosticos;
	}

	public void setPronosticos(Pronostico[] pronosticos) {
		this.pronosticos = pronosticos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
