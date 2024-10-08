package modelo.examen;

import java.util.List;

public class Quiz extends Examen {
	private List<String> opciones; //lista de todas las opciones
	private List<String> respuestas; //lista de ints del index de las correctas
	private float calificacionMin;
	
	public Quiz() {
	}
}