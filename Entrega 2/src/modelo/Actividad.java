package modelo;

import java.util.List;

public class Actividad {
	private String titulo;
	private String descripcion;
	private String objetivo;
	private Contenido contenido;
	private String nivelDificultad;
	private int duracionEsperada;
	private List<Actividad> preRequisitos;
	
	public Actividad(String descripcion, String objetivo, Contenido contenido, String nivelDificultad, int duracionEsperada, List<Actividad> preRequisitos) {
		this.descripcion = descripcion;
		this.objetivo = objetivo;
		this.contenido = contenido;
		this.nivelDificultad = nivelDificultad;
		this.duracionEsperada = duracionEsperada;
		this.preRequisitos = preRequisitos;
	}
}