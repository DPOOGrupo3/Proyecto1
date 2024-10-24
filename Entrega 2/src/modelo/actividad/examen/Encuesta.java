package modelo.actividad.examen;

import java.util.List;

import modelo.actividad.Actividad;

public class Encuesta extends Examen {
	public Encuesta(String descripcion, String objetivo, String tipo, int nivelDificultad, double duracionEsperada, List<Actividad> preRequisitos, List<String> preguntas) {
		super(descripcion, objetivo, tipo, nivelDificultad, duracionEsperada, preRequisitos, preguntas);
	}
}