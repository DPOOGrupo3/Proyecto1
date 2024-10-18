package modelo;

import java.util.List;

public class Actividad {
	private String titulo;
	private String descripcion;
	private String objetivo;
	private Contenido contenido;
	private int nivelDificultad;
	private int duracionEsperada;
	private List<Actividad> preRequisitos;
	
	public Actividad(String titulo, String descripcion, String objetivo, Contenido contenido, int nivelDificultad, int duracionEsperada, List<Actividad> preRequisitos) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.objetivo = objetivo;
		this.contenido = contenido;
		this.nivelDificultad = nivelDificultad;
		this.duracionEsperada = duracionEsperada;
		this.preRequisitos = preRequisitos;
	}

	public String getTitulo() {
		return titulo;
	}

	public void cambiarTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void cambiarDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void cambiarObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public int getDuracionEsperada() {
		return duracionEsperada;
	}

	public void cambiarDuracionEsperada(int duracionEsperada) {
		this.duracionEsperada = duracionEsperada;
	}

	public int getNivelDificultad() {
		return nivelDificultad;
	}

	public void cambiarNivelDificultad(int nivelDificultad) {
		this.nivelDificultad = nivelDificultad;
	}

	public void agregarPreRequisitos(Actividad preRequisito) {
		preRequisitos.add(preRequisito);
	}
	
	public void eliminarPreRequisitos(Actividad preRequisito) {
		preRequisitos.remove(preRequisito);
	}
	
	@Override
	public String toString() {
		String actividad = titulo + "/" + descripcion + "/" + objetivo;
		return actividad;
	}
}