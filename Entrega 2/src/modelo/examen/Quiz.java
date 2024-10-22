package modelo.examen;

import java.util.List;

public class Quiz extends Examen {
	private List<String> opciones; //lista de todas las opciones
	private List<String> respuestas; //lista de ints del index de las correctas
	private float calificacionMin;
	
	public Quiz(List<String> preguntas, List<String> opciones, List<String> respuestas, float calificacionMin) {
		super(preguntas);
		this.opciones = opciones;
		this.respuestas = respuestas;
		this.calificacionMin = calificacionMin;
	}
	
	public List<String> getOpciones() {
		return opciones;
	}

	public void editarOpciones(List<String> opciones) {
		this.opciones = opciones;
	}

	public List<String> getRespuestas() {
		return respuestas;
	}

	public void editarRespuestas(List<String> respuestas) {
		this.respuestas = respuestas;
	}

	public float getCalificacionMin() {
		return calificacionMin;
	}
	
	public void cambiarCalificacionMinima(float calificacionMin) {
		this.calificacionMin = calificacionMin;
	}
}