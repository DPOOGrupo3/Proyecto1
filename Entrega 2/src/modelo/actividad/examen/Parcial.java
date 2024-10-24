package modelo.actividad.examen;

import java.util.List;

import modelo.actividad.Actividad;

public class Parcial extends Examen {
	public Parcial(String descripcion, String objetivo, String tipo, int nivelDificultad, double duracionEsperada, List<Actividad> preRequisitos, List<String> preguntas) {
		super(descripcion, objetivo, tipo, nivelDificultad, duracionEsperada, preRequisitos, preguntas);
	}
}