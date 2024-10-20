package modelo;

import java.util.List;

import modelo.examen.*;

public class Actividad {
	private int ID;
	private String descripcion;
	private String objetivo;
	private Contenido contenido;
	private double nivelDificultad;
	private int duracionEsperada;
	private List<Actividad> preRequisitos;
	
	public Actividad(int ID, String descripcion, String objetivo, Contenido contenido, int nivelDificultad, int duracionEsperada, List<Actividad> preRequisitos) {
		this.ID = ID;
		this.descripcion = descripcion;
		this.objetivo = objetivo;
		this.contenido = contenido;
		this.nivelDificultad = nivelDificultad;
		this.duracionEsperada = duracionEsperada;
		this.preRequisitos = preRequisitos;
	}

	public int getID() {
		return ID;
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
	
	public void cambiarContenido(Contenido contenido) {
		this.contenido = contenido;
	}

	public Contenido getContenido() {
		return contenido;
	}

	public void cambiarDuracionEsperada(int duracionEsperada) {
		this.duracionEsperada = duracionEsperada;
	}

	public double getNivelDificultad() {
		return nivelDificultad;
	}

	public void cambiarNivelDificultad(int nivelDificultad) {
		this.nivelDificultad = nivelDificultad;
	}

	public void agregarPreRequisito(Actividad preRequisito) {
		preRequisitos.add(preRequisito);
	}
	
	public void eliminarPreRequisito(Actividad preRequisito) {
		preRequisitos.remove(preRequisito);
	}
	
	@Override
	public String toString() {
		String cadenaActividades = "";
		if (preRequisitos.size() > 0) {
			for (Actividad actividad: preRequisitos) {
				cadenaActividades += actividad.getID() + "%";
			}
		}else {
			cadenaActividades = "NA";
		}
		return ID + "/" + descripcion + "/" + objetivo + "/" + duracionEsperada + "/" + nivelDificultad + "/" + "/" + cadenaActividades;
	}
}