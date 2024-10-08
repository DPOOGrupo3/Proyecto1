package modelo;

import java.util.List;

public class LearningPath {
	private String titulo;
	private String descripcion;
	private String objetivo;
	private int duracionEsperada;
	private String nivelDificultad;
	private double rating;
	private List<Actividad> activdades;
	
	public LearningPath(String titulo, String descripcion, String objetivo, int duracionEsperada, String nivelDificultad, double rating, List<Actividad> activdades) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.objetivo = objetivo;
		this.duracionEsperada = duracionEsperada;
		this.nivelDificultad = nivelDificultad;
		this.rating = rating;
		this.activdades = activdades;
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

	public String getNivelDificultad() {
		return nivelDificultad;
	}

	public void cambiarNivelDificultad(String nivelDificultad) {
		this.nivelDificultad = nivelDificultad;
	}

	public double getRating() {
		return rating;
	}

	public List<Actividad> getActivdad() {
		return activdades;
	}

	public void agregarActivdad(Actividad activdad) {
		activdades.add(activdad);
	}
}