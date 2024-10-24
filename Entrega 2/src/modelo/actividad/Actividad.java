package modelo.actividad;

import java.util.List;

public abstract class Actividad {
	private String ID;
	private String descripcion;
	private String objetivo;
	private String tipo;
	private int nivelDificultad;
	private double duracionEsperada;
	private List<Actividad> preRequisitos;
	private String resultado;
	
	public Actividad(String descripcion, String objetivo, String tipo, int nivelDificultad, double duracionEsperada, List<Actividad> preRequisitos) {
		this.ID = "";
		this.descripcion = descripcion;
		this.objetivo = objetivo;
		this.tipo = tipo;
		this.nivelDificultad = nivelDificultad;
		this.duracionEsperada = duracionEsperada;
		this.preRequisitos = preRequisitos;
		resultado = "Incompleto";
	}

	public String getID() {
		return ID;
	}
	
	public void setID(String ID) {
		this.ID = ID;
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
	
	public String getTipo() {
		return tipo;
	}

	public void cambiarTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public int getNivelDificultad() {
		return nivelDificultad;
	}

	public void cambiarDuracionEsperada(int duracionEsperada) {
		this.duracionEsperada = duracionEsperada;
	}
	
	public double getDuracionEsperada() {
		return duracionEsperada;
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
	
	public String getResultado() {
		return resultado;
	}
	
	public void cambiarResultado(String resultado) {
		this.resultado = resultado;
	}
	
	public abstract void editarContenido(Object cambio);
	
	public abstract Object obtenerInformacion();
	
	@Override
	public String toString() {
		String cadenaActividades = "";
		if (preRequisitos.size() > 0) {
			for (Actividad actividad: preRequisitos) {
				cadenaActividades += actividad.getID() + "//";
			}
		}else {
			cadenaActividades = "NA";
		}
		return ID + "%" + descripcion + "%" + objetivo + "%" + tipo + "%" + "Contenido" + "%" + duracionEsperada + "%" + nivelDificultad + "%" + cadenaActividades;
	}
}