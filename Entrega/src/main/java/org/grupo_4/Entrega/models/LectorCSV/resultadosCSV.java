package org.grupo_4.Entrega.models.LectorCSV;


import com.opencsv.bean.CsvBindByPosition;

public class resultadosCSV {
	@CsvBindByPosition(position = 0)
    private Integer rondaId;
	@CsvBindByPosition(position = 1)
    private Integer rondaNr;
    @CsvBindByPosition(position = 2)
    private Integer equipo1Id;
    @CsvBindByPosition(position = 3)
    private String nombreEquipo1;
    @CsvBindByPosition(position = 4)
    private String descripcionEquipo1;
    @CsvBindByPosition(position = 5)
    private Integer golesEquipo1;
    @CsvBindByPosition(position = 6)
    private Integer golesEquipo2;
    @CsvBindByPosition(position = 7)
    private  Integer equipo2Id;
    @CsvBindByPosition(position = 8)
    private  String nombreEquipo2;
    @CsvBindByPosition(position = 9)
    private  String descripcionEquipo2;
    
    public int getRondaId() {
		return rondaId;
	}
	public void setRondaId(int rondaId) {
		this.rondaId = rondaId;
	}
	public int getRondaNr() {
		return rondaNr;
	}
	public void setRondaNr(int rondaNr) {
		this.rondaNr = rondaNr;
	}
	public int getEquipo1Id() {
		return equipo1Id;
	}
	public void setEquipo1Id(int equipo1Id) {
		this.equipo1Id = equipo1Id;
	}
	public String getNombreEquipo1() {
		return nombreEquipo1;
	}
	public void setNombreEquipo1(String nombreEquipo1) {
		this.nombreEquipo1 = nombreEquipo1;
	}
	public String getDescripcionEquipo1() {
		return descripcionEquipo1;
	}
	public void setDescripcionEquipo1(String descripcionEquipo1) {
		this.descripcionEquipo1 = descripcionEquipo1;
	}
	public int getGolesEquipo1() {
		return golesEquipo1;
	}
	public void setGolesEquipo1(int golesEquipo1) {
		this.golesEquipo1 = golesEquipo1;
	}
	public int getGolesEquipo2() {
		return golesEquipo2;
	}
	public void setGolesEquipo2(int golesEquipo2) {
		this.golesEquipo2 = golesEquipo2;
	}
	public int getEquipo2Id() {
		return equipo2Id;
	}
	public void setEquipo2Id(int equipo2Id) {
		this.equipo2Id = equipo2Id;
	}
	public String getNombreEquipo2() {
		return nombreEquipo2;
	}
	public void setNombreEquipo2(String nombreEquipo2) {
		this.nombreEquipo2 = nombreEquipo2;
	}
	public String getDescripcionEquipo2() {
		return descripcionEquipo2;
	}
	public void setDescripcionEquipo2(String descripcionEquipo2) {
		this.descripcionEquipo2 = descripcionEquipo2;
	}   
    
}
