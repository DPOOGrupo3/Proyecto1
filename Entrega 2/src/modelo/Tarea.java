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
		this.ejercicios = (List<String>) ejercicios;
	}

	@Override
	public void interactuar() {
		for (String ejercicio: ejercicios) {
			System.out.println(ejercicio);
		}
	}
}