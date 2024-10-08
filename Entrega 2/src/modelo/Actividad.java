package modelo;

import java.util.List;

public class Actividad {
	private String descripcion;
	private String objetivo;
	private Contenido contenido;
	private String nivelDificultad;
	private int duracionEsperada;
	private List<Actividad> preRequisitos;
	
	public Actividad() {
	}
}