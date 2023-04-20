package org.grupo_4.Entrega.models.LectorCSV;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.grupo_4.Entrega.models.Participante;
import org.grupo_4.Entrega.models.Partido;
import org.grupo_4.Entrega.models.Pronostico;

import com.opencsv.bean.CsvToBeanBuilder;

public class LectorCSV {
	private List<resultadosCSV> resultados;
	private List<pronosticosCSV> pronosticos;
	public final String ubicacionRecursos = "src\\main\\java\\recursos\\";	
	
	public LectorCSV(){
		this.Armador(ubicacionRecursos + "resultados.csv", ubicacionRecursos + "pronostico.csv");
	}
	public LectorCSV(String ubiResultado, String ubiPronosticos){		
        this.Armador(ubiResultado, ubiPronosticos);
	}
	private void Armador(String ubiResultado, String ubiPronosticos) {
		try {
            this.setResultados(new CsvToBeanBuilder(new FileReader(ubiResultado)).withSkipLines(1).withSeparator(';').withType(resultadosCSV.class).build().parse());
        } catch (IOException e) {
        e.printStackTrace();
        }
        try {
            this.setPronosticos(new CsvToBeanBuilder(new FileReader(ubiPronosticos)).withSkipLines(1).withSeparator(';').withType(pronosticosCSV.class).build().parse());
        } catch (IOException e) {
        e.printStackTrace();
        }
	}
	
	public Map<Integer, String> listaEquipos(){
		Map<Integer, String> lista = new HashMap<Integer, String>();
		
		for(resultadosCSV aux : this.getResultados()) {
			lista.put(aux.getEquipo1Id(), aux.getNombreEquipo1());
			lista.put(aux.getEquipo2Id(), aux.getNombreEquipo2());
		}
		return lista;	
	}
	
	public Map<Integer, Partido> listaPartidos(){
		Map<Integer, Partido> lista = new HashMap<Integer, Partido>();
		int contador = 0;
		for(resultadosCSV aux : this.getResultados()) {
			contador++;
			lista.put(contador, new Partido(aux.getEquipo1Id(), aux.getGolesEquipo1(), aux.getGolesEquipo2(),  aux.getEquipo2Id(), aux.getRondaId()));
		}
		return lista;
	}
	
	public int rondaMax() {
		int max = 0;
		for(resultadosCSV aux : this.getResultados()) {
			int aux2 = aux.getRondaNr();
			if(max < aux2)
				max = aux2;
		}
		return max;
	}
	
	public Participante[] todosLosParticipantes() {
		//limipia cuantos participantes hay
		Map<Integer, String> participantes = new HashMap<Integer, String>();
		List<Pronostico> pronosticos = new ArrayList<Pronostico>();
		int contador = 0;
		for(pronosticosCSV aux : this.getPronosticos()) {
			participantes.put(aux.getParticipanteId(), aux.getNombre());
			contador++;
			pronosticos.add(new Pronostico(contador, aux.getGana1(), aux.getEmpate(), aux.getGana2(), aux.getEquipo1Id(), aux.getEquipo2Id()));//genera pronosticos
		}
		//setea el array donde va a ir los participantes
		Participante[] aux = new Participante[participantes.size()];
		//setea donde va a ir los pronosticos
		int numeroPartidoPronosticados = (pronosticos.size() / participantes.size());//numero de pronosticos sobre el numero de participantes	
		Pronostico[] pronoAux = new Pronostico[numeroPartidoPronosticados];
		//para cada array
		contador = 0;
		//usa los nombres para iterar
		for(String nombre: participantes.values()) {
			aux[contador] = new Participante(nombre, contador + 1);
			for(int fr = 0; fr < numeroPartidoPronosticados; fr++) {
				pronosticos.get(fr + (contador * numeroPartidoPronosticados)).setPartido(fr + 1);
				pronoAux[fr] = pronosticos.get(fr + (contador * numeroPartidoPronosticados));
			}
			aux[contador].setPronosticos(pronoAux.clone());
			contador++;
		}		
		return aux;
	}
	
	public List<resultadosCSV> getResultados() {
		return resultados;
	}

	public void setResultados(List<resultadosCSV> resultados) {
		this.resultados = resultados;
	}

	public List<pronosticosCSV> getPronosticos() {
		return pronosticos;
	}

	public void setPronosticos(List<pronosticosCSV> pronosticos) {
		this.pronosticos = pronosticos;
	}
}
