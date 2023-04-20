package org.grupo_4.Entrega.models.LectorCSV;

import com.opencsv.bean.CsvBindByPosition;

public class pronosticosCSV {
	@CsvBindByPosition(position = 0)
    private int participanteId;
	@CsvBindByPosition(position = 1)
    private String nombre;
    @CsvBindByPosition(position = 2)
    private int equipo1Id;
    @CsvBindByPosition(position = 3)
    private String gana1;
    @CsvBindByPosition(position = 4)
    private String empate;
    @CsvBindByPosition(position = 5)
    private String gana2;
    @CsvBindByPosition(position = 6)
    private int Equipo2Id;
    
    public int getParticipanteId() {
		return participanteId;
	}
	public void setParticipanteId(int participanteId) {
		this.participanteId = participanteId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEquipo1Id() {
		return equipo1Id;
	}
	public void setEquipo1Id(int equipo1Id) {
		this.equipo1Id = equipo1Id;
	}
	public String getGana1() {
		return gana1;
	}
	public void setGana1(String gana1) {
		this.gana1 = gana1;
	}
	public String getEmpate() {
		return empate;
	}
	public void setEmpate(String empate) {
		this.empate = empate;
	}
	public String getGana2() {
		return gana2;
	}
	public void setGana2(String gana2) {
		this.gana2 = gana2;
	}
	public int getEquipo2Id() {
		return Equipo2Id;
	}
	public void setEquipo2Id(int equipo2Id) {
		Equipo2Id = equipo2Id;
	}
}
