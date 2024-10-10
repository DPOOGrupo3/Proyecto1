package modelo.usuario;

import java.util.ArrayList;
import java.util.List;

import modelo.Actividad;
import modelo.Contenido;
import modelo.LearningPath;

public class Profesor extends Usuario{
	private List<LearningPath> caminosCreados;
	private List<Actividad> actividades;
	
	public Profesor(String nombre, String email, String contraseña) {
		super(nombre, email, contraseña);
		caminosCreados = new ArrayList<LearningPath>();
	}
	
	public Actividad crearActividad(String descripcion, String objetivo, Contenido contenido, String nivelDificultad, int duracionEsperada, List<Actividad> preRequisitos) {
		return new Actividad(descripcion, objetivo, contenido, nivelDificultad, duracionEsperada, preRequisitos);
	}
	
	public void crearLearningPath(String titulo, String descripcion, String objetivo, int duracionEsperada, String nivelDificultad, double rating, List<Actividad> activdades) {
		caminosCreados.add(new LearningPath(titulo, descripcion, objetivo, duracionEsperada, nivelDificultad, rating, activdades));
	}
	
	public LearningPath editarLearninPath(LearningPath camino, int opcion) {
		if (opcion == 0) {
			camino.cambiarTitulo(null);
		}
		return camino;
	}
	
	public static void main(String[] args) {
		Profesor prof = new Profesor("Juan", "j.a@mail.com", "SoyJuan123");
		if (prof.iniciarSesion("j.a@mail.com", "SoyJuan123")) {
			ArrayList<Actividad> actividades = new ArrayList<Actividad>();
			actividades.add(prof.crearActividad("AA", "A", null, "1", 1, null));
			actividades.add(prof.crearActividad("BB", "B", null, "1", 1, actividades));
			actividades.add(prof.crearActividad("CC", "C", null, "2", 1, actividades.subList(0, actividades.size())));
			prof.crearLearningPath("LP", "lp1", "AA", 3, "2", 0.4, actividades);
			System.out.println(prof.caminosCreados.get(0).getActivdades());
		}
	}
}