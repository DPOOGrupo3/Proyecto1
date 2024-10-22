package modelo.examen;

import java.util.List;

import modelo.Contenido;

public abstract class Examen extends Contenido {
	private List<String> preguntas; //lista de preguntas
	
	public Examen(List<String> preguntas) {
		this.preguntas = preguntas;
	}
	
	public List<String> getPreguntas() {
		return preguntas;
	}
	
	@Override
	public void editarContenido(Object preguntas) {
		if (preguntas.getClass() == List.class) {
			this.preguntas = (List<String>) preguntas;
		}
	}
	
	@Override
	public List<String> obtenerInformacion () {
		return getPreguntas();
	}
}