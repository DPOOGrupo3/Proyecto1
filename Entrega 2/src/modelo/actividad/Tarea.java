package modelo.actividad;

import java.util.ArrayList;
import java.util.List;

public class Tarea extends Actividad {
	List<String> ejercicios;
	boolean enviada;
	
	public Tarea(String descripcion, String objetivo, String tipo, int nivelDificultad, double duracionEsperada, List<Actividad> preRequisitos, List<String> ejercicios) {
		super(descripcion, objetivo, tipo, nivelDificultad, duracionEsperada, preRequisitos);
		this.ejercicios = ejercicios;
		this.enviada = false;
	}

	@Override
	public void editarContenido(Object ejercicios) {
		if (ejercicios.getClass() == List.class) {
			this.ejercicios = (List<String>) ejercicios;
		}
	}
	
	public void enviarTarea(List<String> respuestas) {
		enviada = true;
	}

	@Override
	public Object obtenerInformacion() { 
		/*for (String ejercicio: ejercicios) {
			System.out.println(ejercicio);
		}*/
		return ejercicios;
	}
	
	@Override
	public String toString() {
		String cadena = "";
		if (ejercicios.size() > 0) {
			for (String ejercicio: ejercicios) {
				cadena += ejercicio + "%";
			}
			cadena.substring(0, cadena.length()-1);
		}else {
			cadena = "NA";
		}
		return cadena;
	}
}