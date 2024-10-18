package modelo;

import java.util.List;

public class LearningPath {
	private static int ID = 0;
	private String titulo;
	private String descripcion;
	private String objetivo;
	private int duracionEsperada;
	private int nivelDificultad;
	private double rating;
	private List<Actividad> activdades;
	
	public LearningPath(String titulo, String descripcion, String objetivo, int duracionEsperada, int nivelDificultad, double rating, List<Actividad> activdades) {
		ID = ID + 1;
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

	public int getNivelDificultad() {
		return nivelDificultad;
	}

	public void cambiarNivelDificultad(int nivelDificultad) {
		this.nivelDificultad = nivelDificultad;
	}

	public double getRating() {
		return rating;
	}

	public List<Actividad> getActivdades() {
		return activdades;
	}

	public void agregarActivdad(Actividad activdad) {
		activdades.add(activdad);
	}
	
	public void eliminarActivdad(Actividad activdad) {
		try {
			activdades.remove(activdad);
		} catch (Exception e){
			System.out.println("La actividad que se desea eliminar no ha sido encontrada en este Learning Path");
		}
	}
	
	public LearningPath copy() {
		return new LearningPath(titulo, descripcion, objetivo, duracionEsperada, nivelDificultad, rating, activdades);
	}
	
	@Override
	public String toString() {
		String cadenaActividades = "";
		for (Actividad actividad: activdades) {
			cadenaActividades += actividad.getTitulo() + "%";
		}
		return titulo + "/" + descripcion + "/" + objetivo + "/" + duracionEsperada + "/" + nivelDificultad + "/" + rating + "/" + cadenaActividades;
	}
}