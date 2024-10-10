package modelo;

import java.util.ArrayList;
import java.util.List;

public class Ejercicios extends Contenido {
	List<String> ejercicios;
	
	public Ejercicios(ArrayList<String> ejercicios) {
		this.ejercicios = ejercicios;
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