package org.grupo_4.Entrega;

import java.util.Map;
import java.util.Scanner;

import org.grupo_4.Entrega.models.Participante;
import org.grupo_4.Entrega.models.Partido;
import org.grupo_4.Entrega.models.Ronda;
import org.grupo_4.Entrega.models.LectorCSV.LectorCSV;


public class App {

	public static void main(String[] args) {
		
		LectorCSV lector;
		System.out.println("Presione cualquier tecla para leer desde los archivos de recursos, si no coloco los archivos ahi presione 1 y ingrese su ruta manualmente");
		
		try (Scanner scn = new Scanner(System.in)) {
			if(scn.nextLine().equals("1")) {
				System.out.println("Ingrese la ruta con los resultados:");
				String resultado = scn.nextLine();
				System.out.println("Ahora ingrese la ruta de los pronosticos:");
				String pronostico = scn.nextLine();
				lector = new LectorCSV(resultado, pronostico);
			}
			else
				lector = new LectorCSV();
		}
		
		Map<Integer, Partido> equipos = lector.listaPartidos();
		//coloca las rondas que hay
		Ronda ronda[] = new Ronda[lector.rondaMax()];
		for(int aux = 0; aux < lector.rondaMax(); aux++) {
			ronda[aux] = new Ronda(aux + 1, equipos);
		}
		
		//da resultados
		Participante[] participantes = lector.todosLosParticipantes();
		System.out.println(ronda[0].textoPuntosRonda(participantes[0]));
		System.out.println(ronda[0].textoPuntosRonda(participantes[1]));
		
	}
}
	