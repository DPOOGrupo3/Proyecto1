package modelo;

import java.util.List;

public class LearningPath {
	private static int ID = 0;
	private String titulo;
	private String descripcion;
	private String objetivo;
	private double duracionEsperada;
	private int nivelDificultad;
	private double rating;
	private int raters;
	private List<Actividad> actividades;
	
	public LearningPath(String titulo, String descripcion, String objetivo, List<Actividad> activdades) {
		ID = ID + 1;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.objetivo = objetivo;
		this.duracionEsperada = 0;
		this.nivelDificultad = 0;
		this.rating = 0;
		this.raters = 0;
		this.actividades = activdades;
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

	public double getDuracionEsperada() {
		return duracionEsperada;
	}

	public void cambiarDuracionEsperada() {
		if (actividades.size() > 0) {
			duracionEsperada = 0;
			for (Actividad actividad: actividades) {
				duracionEsperada += actividad.getDuracionEsperada();
			}
		}
	}

	public int getNivelDificultad() {
		return nivelDificultad;
	}

	public void cambiarNivelDificultad() {
		if (actividades.size() > 0) {
			nivelDificultad = 0;
			for (Actividad actividad: actividades) {
				nivelDificultad += actividad.getDuracionEsperada();
			}
			nivelDificultad = nivelDificultad / actividades.size();
		}
	}

	public double getRating() {
		return rating;
	}
	
	public void ratePath(double rate) {
		rating = ((rating * raters) + rate)/(++raters);
	}
	
	public double getRaters() {
		return rating;
	}

	public List<Actividad> getActivdades() {
		return actividades;
	}

	public void agregarActivdad(Actividad activdad) {
		actividades.add(activdad);
	}
	
	public void eliminarActivdad(Actividad activdad) {
		try {
			actividades.remove(activdad);
		} catch (Exception e){
			System.out.println("La actividad que se desea eliminar no ha sido encontrada en este Learning Path");
		}
	}
	
	public LearningPath copy() {
		return new LearningPath(titulo, descripcion, objetivo, actividades);
	}
	
	@Override
	public String toString() {
		String cadenaActividades = "";
		if (actividades.size() > 0) {
			for (Actividad actividad: actividades) {
				cadenaActividades += actividad.getID() + "%";
			}
		}else {
			cadenaActividades = "NA";
		}
		return ID + "/" +titulo + "/" + descripcion + "/" + objetivo + "/" + duracionEsperada + "/" + nivelDificultad + "/" + rating + "/" + raters + "/" + cadenaActividades;
	}
}