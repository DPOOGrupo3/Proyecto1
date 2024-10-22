package modelo.usuario;

import java.util.ArrayList;
import java.util.List;

import modelo.Actividad;
import modelo.Contenido;
import modelo.LearningPath;

public class Profesor extends Usuario{
	private List<LearningPath> caminosCreados;
	private List<LearningPath> caminosCopiados;
	
	public Profesor(String nombre, String email, String contraseña) {
		super(nombre, email, contraseña);
		caminosCreados = new ArrayList<LearningPath>();
		caminosCopiados = new ArrayList<LearningPath>();
	}
	
	public void cargarLearninPathsCreados(List<String> caminosACargar, List<LearningPath> caminosCompletos){
		if (caminosACargar.size() > 0) {
			for (String tituloCamino: caminosACargar) {
				for (LearningPath camino: caminosCompletos) {
					if (camino.getTitulo().equals(tituloCamino)) {
						caminosCreados.add(camino);
					}
				}
			}
		}
	}
	
	public void cargarLearninPathsCopiados(List<String> caminosACargar){
		if (caminosACargar.size() > 0) {
			for (String tituloCamino: caminosACargar) {
				for (LearningPath camino: caminosCreados) {
					if (camino.getTitulo().equals(tituloCamino)) {
						caminosCopiados.add(camino);
					}
				}
			}
		}
	}
	
	public Actividad crearActividad(String descripcion, String objetivo, Contenido contenido, int nivelDificultad, int duracionEsperada, List<Actividad> preRequisitos) {
		Actividad actividad = new Actividad(descripcion, objetivo, contenido, nivelDificultad, duracionEsperada, preRequisitos);
		return actividad;
	}
	
	private String generarIDLP() {
		String[] nombresApellidos = super.getNombre().split(" ");
		String ID = "";
		for (String inicial: nombresApellidos) {
			ID += inicial.substring(0, 1);
		}
		return ID + String.valueOf(caminosCreados.size() + 1);
	}
	
	public LearningPath crearLearningPath(String titulo, String descripcion, String objetivo, List<Actividad> activdades) {
		String ID = generarIDLP();
		LearningPath camino = new LearningPath(ID, titulo, descripcion, objetivo, activdades);
		caminosCreados.add(camino);
		return camino;
	}
	
	public void copiarLearninPath(LearningPath camino) {
		caminosCopiados.add(camino.copiarCamino(this));
	}
	
	public void eliminarLearningPathCreado(LearningPath camino) {
		caminosCreados.remove(camino);
	}
	
	public void cambiarTituloLearningPath(LearningPath camino, String titulo) {
		camino.cambiarDescripcion(titulo);
	}
	
	public void cambiarDescrpcionLearningPath(LearningPath camino, String descripcion) {
		camino.cambiarDescripcion(descripcion);
	}
	
	public void cambiarObjetivoLearningPath(LearningPath camino, String objetivo) {
		camino.cambiarDescripcion(objetivo);
	}
	
	public void agregarActividadLearningPath(LearningPath camino, Actividad actividadAgregar) {
		camino.agregarActivdad(actividadAgregar);
	}
	
	public void eliminarActividadLearningPath(LearningPath camino, Actividad actividadEliminar) {
		camino.eliminarActivdad(actividadEliminar);
	}
	
	public void cambiarDescrpcionActividad(Actividad actividad, String descripcion) {
		actividad.cambiarDescripcion(descripcion);
	}
	
	public void cambiarObjetivoActividad(Actividad actividad, String objetivo) {
		actividad.cambiarDescripcion(objetivo);
	}
	
	public void cambiarDuracionEsperadaActividad(Actividad actividad, int duracion, LearningPath camino) {
		actividad.cambiarDuracionEsperada(duracion);
		camino.cambiarDuracionEsperada();
	}
	
	public void cambiarNivelDificultadActividad(Actividad actividad, int dificultad, LearningPath camino) {
		actividad.cambiarNivelDificultad(dificultad);
		camino.cambiarNivelDificultad();
	}
	
	public void agregarPreRequisitosActividad(Actividad actividad, Actividad actividadAgregar) {
		actividad.agregarPreRequisito(actividadAgregar);
	}
	
	public void eliminarPreRequisitosActividad(Actividad actividad, Actividad actividadEliminar) {
		actividad.eliminarPreRequisito(actividadEliminar);
	}
	
	private String cadenaCaminos(List<LearningPath> caminos) {
		String cadenaCaminos = "";
		if (caminos.size() > 0) {
			for (LearningPath camino: caminos) {
				cadenaCaminos += camino.getID() + "%";
			}
			cadenaCaminos = cadenaCaminos.substring(0, cadenaCaminos.length()-1);
		}else {
			cadenaCaminos = "NA";
		}
		return cadenaCaminos;
	}
	
	@Override
	public String toString() {
		super.toString();
		return super.toString() + "/" + cadenaCaminos(caminosCreados) + "/" + cadenaCaminos(caminosCopiados);
	}
}