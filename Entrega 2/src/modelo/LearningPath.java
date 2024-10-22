package modelo;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import modelo.usuario.Profesor;
import modelo.usuario.Estudiante;

public class LearningPath {
	private String ID;
	private String titulo;
	private String descripcion;
	private String objetivo;
	private double duracionEsperada;
	private int nivelDificultad;
	private double rating;
	private int raters;
	private List<Actividad> actividades;
	private List<Resenha> resenhas;
	private List<Profesor> copias;
	private List<Estudiante> inscripciones;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private double version;
	
	public LearningPath(String ID, String titulo, String descripcion, String objetivo, List<Actividad> actividades) {
		this.ID = ID;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.objetivo = objetivo;
		this.duracionEsperada = 0;
		this.nivelDificultad = 0;
		this.rating = 0;
		this.raters = 0;
		for (Actividad actividad: actividades) {
			actividad.setID(generarIDActividad());
			this.actividades.add(actividad);
		}
		resenhas = new ArrayList<Resenha>();
		copias = new ArrayList<Profesor>();
		inscripciones = new ArrayList<Estudiante>();
		//fechaCreacion = new Date();
		//fechaModificacion = fechaCreacion;
		version = 1;
	}
	
	public String getID() {
		return ID;
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
		System.out.println("entra duracion");
		System.out.println(actividades.size());
		if (actividades.size() > 0) {
			System.out.println("entra duracion if");
			duracionEsperada = 0;
			for (Actividad actividad: actividades) {
				duracionEsperada += actividad.getDuracionEsperada();
			}
		}
		System.out.println("Se acaba");
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
	
	public int getCantidadActivdades() {
		return actividades.size();
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
	
	public void agregarResenha(Resenha resenha) {
		resenhas.add(resenha);
		ratePath(resenha.getCalificaicon());
	}
	
	public double getVersion() {
		return version;
	}
	
	public LearningPath copy() {
		LearningPath camino = new LearningPath(ID, titulo, descripcion, objetivo, actividades);
		camino.cambiarDuracionEsperada();
		camino.cambiarNivelDificultad();
		for (int i = 0; i < raters; i++) {
			camino.ratePath(rating);
		}
		return camino;
	}
	
	public void cambiarVersion() {
		version += 0.1;
	}
	
	public LearningPath copiarCamino(Profesor profesor) {
		copias.add(profesor);
		return copy();
	}
	
	public LearningPath inscribirCamino(Estudiante estudiante) {
		inscripciones.add(estudiante);
		return copy();
	}
	
	private String generarIDActividad() {
		return ID + "." +String.valueOf(actividades.size() + 1);
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