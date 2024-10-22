package modelo;

import java.util.ArrayList;
import java.util.List;

public class Tarea extends Contenido {
	List<String> ejercicios;
	boolean enviada;
	
	public Tarea(ArrayList<String> ejercicios) {
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
}