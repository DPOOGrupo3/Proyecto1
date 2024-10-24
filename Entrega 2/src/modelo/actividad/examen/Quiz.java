package modelo.actividad.examen;

import java.util.List;

import modelo.actividad.Actividad;

public class Quiz extends Examen {
	private List<String> opciones; //lista de todas las opciones
	private List<Integer> respuestas; //lista de ints del index de las correctas
	private double calificacionMin;
	
	public Quiz(String descripcion, String objetivo, String tipo, int nivelDificultad, double duracionEsperada, List<Actividad> preRequisitos, List<String> preguntas, List<String> opciones, List<Integer> respuestas, double calificacionMin) {
		super(descripcion, objetivo, tipo, nivelDificultad, duracionEsperada, preRequisitos, preguntas);
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

	public List<Integer> getRespuestas() {
		return respuestas;
	}

	public void editarRespuestas(List<Integer> respuestas) {
		this.respuestas = respuestas;
	}

	public double getCalificacionMin() {
		return calificacionMin;
	}
	
	public void cambiarCalificacionMinima(double calificacionMin) {
		this.calificacionMin = calificacionMin;
	}
	
	@Override
	public Actividad copy() {
		Quiz copia = new Quiz(getDescripcion(), getObjetivo(), getTipo(), getNivelDificultad(), getDuracionEsperada(), getPreRequisitos(), getPreguntas(), opciones, respuestas, calificacionMin);
		copia.setID(this.getID());
		copia.cambiarResultado(this.getResultado());
		return copia;
	}
	
	@Override
	public String toString() {
		String cadenaOpciones = "";
		if (opciones.size() > 0) {
			for (String opcion: opciones) {
				cadenaOpciones += opcion + "//";
			}
			cadenaOpciones.substring(0, cadenaOpciones.length()-1);
		}else {
			cadenaOpciones = "NA";
		}
		String cadenaRespuestas = "";
		if (respuestas.size() > 0) {
			for (Integer respuesta: respuestas) {
				cadenaRespuestas += respuesta + "//";
			}
			cadenaRespuestas.substring(0, cadenaRespuestas.length()-1);
		}else {
			cadenaRespuestas = "NA";
		}
		return super.toString() + ":/:" + cadenaOpciones + ":/:" + cadenaRespuestas + ":/:"  + calificacionMin;
	}
}