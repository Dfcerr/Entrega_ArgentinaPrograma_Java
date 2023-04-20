package org.grupo_4.Entrega;


import java.util.Map;

import org.grupo_4.Entrega.models.Participante;
import org.grupo_4.Entrega.models.Partido;
import org.grupo_4.Entrega.models.Ronda;
import org.grupo_4.Entrega.models.LectorCSV.LectorCSV;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class LectorCSVTest {
	@DisplayName("test lectura")
	@Test
	public void pronosticoCSVTest() {
		String ubicacionRecursos = "src\\main\\java\\recursos\\";
		LectorCSV prueba = new LectorCSV(ubicacionRecursos + "resultados.csv", ubicacionRecursos + "pronostico.csv");
		
		Assertions.assertEquals(prueba.getPronosticos().get(0).getNombre(), "Mariana");
		Assertions.assertEquals(prueba.getResultados().get(0).getNombreEquipo1(), "Argentina");
	}
	@DisplayName("test resultado")
	@Test
	public void rondaTestCSV() {
		String ubicacionRecursos = "src\\main\\java\\recursos\\";
		LectorCSV prueba = new LectorCSV(ubicacionRecursos + "resultados.csv", ubicacionRecursos + "pronostico.csv");
		
		Map<Integer, Partido> equipos = prueba.listaPartidos();
		Ronda ronda = new Ronda(1, equipos);
		
		Participante[] participantes = prueba.todosLosParticipantes();
		
		Assertions.assertEquals(ronda.puntosRonda(participantes[0]), 2);
		Assertions.assertEquals(ronda.puntosRonda(participantes[1]), -2);
	}

}
