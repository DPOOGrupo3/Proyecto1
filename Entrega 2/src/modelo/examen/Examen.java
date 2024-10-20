package modelo.examen;

import java.util.List;

import modelo.Contenido;

public abstract class Examen extends Contenido {
	private List<String> preguntas; //lista de preguntas
	
	public Examen() {
	}
	
	@Override
	public void editarContenido(Object cambio) {
		// TODO Auto-generated method stub	
	}
}