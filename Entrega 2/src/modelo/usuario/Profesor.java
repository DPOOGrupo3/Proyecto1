package modelo.usuario;

import java.util.ArrayList;
import java.util.List;

import modelo.Actividad;
import modelo.Contenido;
import modelo.LearningPath;

public class Profesor extends Usuario{
	private List<LearningPath> caminosCreados;
	private List<LearningPath> caminosCopiados;
	private List<Actividad> actividades;
	
	public Profesor(String nombre, String email, String contraseña) {
		super(nombre, email, contraseña);
		caminosCreados = new ArrayList<LearningPath>();
		actividades = new ArrayList<Actividad>();
	}
	
	public void cargarActividades(List<String> actividadesACargar){
		if (actividadesACargar.size() > 0) {
			for (String tituloActividad: actividadesACargar) {
				for (Actividad actividad: actividades) {
					if (actividad.getTitulo().equals(tituloActividad)) {
						actividades.add(actividad);
					}
				}
			}
		}
	}
	
	public void cargarLearninPathsCreados(List<String> caminosACargar){
		if (caminosACargar.size() > 0) {
			for (String tituloCamino: caminosACargar) {
				for (LearningPath camino: caminosCreados) {
					if (camino.getTitulo().equals(tituloCamino)) {
						caminosCreados.add(camino);
					}
				}
			}
		}
	}
	
	public void crearActividad(String titulo, String descripcion, String objetivo, Contenido contenido, int nivelDificultad, int duracionEsperada, List<Actividad> preRequisitos) {
		actividades.add(new Actividad(titulo, descripcion, objetivo, contenido, nivelDificultad, duracionEsperada, preRequisitos));
	}
	
	public void crearLearningPath(String titulo, String descripcion, String objetivo, int duracionEsperada, int nivelDificultad, double rating, List<Actividad> activdades) {
		caminosCreados.add(new LearningPath(titulo, descripcion, objetivo, duracionEsperada, nivelDificultad, rating, activdades));
	}
	
	public LearningPath editarLearninPath(LearningPath camino, int opcion, Object cambio) {
		if (opcion == 0) {
			camino.cambiarTitulo((String) cambio);
		}else if (opcion == 1) {
			camino.cambiarDescripcion((String) cambio);
		}else if (opcion == 2) {
			camino.cambiarObjetivo((String) cambio);
		}else if (opcion == 3) {
			camino.agregarActivdad((Actividad) cambio);
		}else if (opcion == 4) {
			camino.eliminarActivdad((Actividad) cambio);
		}
		return camino;
	}
	
	public Actividad editarActividad(Actividad actividad, int opcion, Object cambio) {
		if (opcion == 0) {
			actividad.cambiarTitulo((String) cambio);
		}else if (opcion == 1) {
			actividad.cambiarDescripcion((String) cambio);
		}else if (opcion == 2) {
			actividad.cambiarObjetivo((String) cambio);
		}else if (opcion == 3) {
			actividad.cambiarDuracionEsperada((int) cambio);
		}else if (opcion == 4) {
			actividad.cambiarNivelDificultad((int) cambio);
		}else if (opcion == 5) {
			actividad.agregarPreRequisitos((Actividad) cambio);
		}else if (opcion == 6) {
			actividad.eliminarPreRequisitos((Actividad) cambio);
		}
		return actividad;
	}

	public String cadenaAGuardar(){
		String cadenaCaminos = "";
		if (caminosCreados.size() > 0) {
			for (LearningPath camino: caminosCreados) {
				cadenaCaminos += camino.getTitulo() + "%";
			}
			System.out.println(cadenaCaminos);
			cadenaCaminos = cadenaCaminos.substring(0, cadenaCaminos.length()-2);
			System.out.println(cadenaCaminos);
		}else {
			cadenaCaminos = "NA";
		}
		return this.toString() + "/" + cadenaCaminos;
	}
}