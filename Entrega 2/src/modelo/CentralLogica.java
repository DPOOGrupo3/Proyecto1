package modelo;

import java.util.ArrayList;
import java.util.List;

import modelo.actividad.Actividad;
import modelo.usuario.*;
import persistencia.CentralPersistencia;

public class CentralLogica {
	private List<Profesor> profesores;
	private List<Estudiante> estudiantes;
	private List<LearningPath> caminos;
	private List<Actividad> actividades;
	private CentralPersistencia centralP = new CentralPersistencia();
	private Usuario user;
	
	public CentralLogica() {
		profesores = new ArrayList<Profesor>();
		estudiantes = new ArrayList<Estudiante>();
		caminos = new ArrayList<LearningPath>();
		actividades = new ArrayList<Actividad>();
	}
	
	public void cargarDatos() {
		centralP.cargarDatos(profesores, estudiantes, caminos, actividades);
	}
	
	public void guardarDatos() {
		centralP.guardarDatos(profesores, estudiantes, caminos, actividades);
	}
	
	public Class<? extends Usuario> iniciarSesion(String email, String contrasena) {
		for (Profesor profesor: profesores) {
			if (profesor.iniciarSesion(email, contrasena)) {
				user = profesor;
				break;
			}
		}
		for (Estudiante estudiante: estudiantes) {
			if (estudiante.iniciarSesion(email, contrasena)) {
				user = estudiante;
				break;
			}
		}
		return user.getClass();
	}
	
	
	
	public LearningPath crearLearningPath(String titulo, String descripcion, String objetivo, List<Actividad> activdades) {
		LearningPath camino = ((Profesor) user).crearLearningPath(titulo, descripcion, objetivo, activdades);
		caminos.add(camino);
		return camino;
	}
	
	public Actividad crearActividad(String descripcion, String objetivo, String tipo, int nivelDificultad, int duracionEsperada, List<String> preRequisitos, String recurso, String tipoRecurso, List<String> ejercicios, List<String> preguntas, List<String> opciones, List<Integer> respuestas, double calificacionMin) {
		List<Actividad> listaPreRequisitos = new ArrayList<Actividad>();
		for (String pre: preRequisitos) {
			listaPreRequisitos.add(encontrarActividadPorID(pre));
		}
		Actividad actividad = ((Profesor) user).crearActividad(descripcion, objetivo, tipo, nivelDificultad, duracionEsperada, listaPreRequisitos, recurso, tipoRecurso, ejercicios, preguntas, opciones, respuestas, calificacionMin);
		actividades.add(actividad);
		return actividad;
	}
	
	private LearningPath encontrarLearningPathPorID(String IDCamino) {
		for (LearningPath camino: caminos) {
			if (camino.getID().equals(IDCamino)) {
				return camino;
			}
		}
		return new LearningPath("", "", "", "", new ArrayList<Actividad>());
	}
	
	private Actividad encontrarActividadPorID(String IDActividad) {
		for (Actividad actividad: actividades) {
			if (actividad.getID().equals(IDActividad)) {
				return actividad;
			}
		}
		return null;
	}
	
	private LearningPath encontrarLearningPathPorIDActividad(String IDActividad) {
		for (LearningPath camino: caminos) {
			for (Actividad actividad: camino.getActivdades()) {
				if (actividad.getID().equals(IDActividad)) {
					return camino;
				}
			}
		}
		return null;
	}
	
	public void copiarActividad(String IDActividad) {
	    Actividad actividadOriginal = encontrarActividadPorID(IDActividad);
	    if (actividadOriginal != null) {
	        Actividad actividadCopia = actividadOriginal.copy();
	        actividades.add(actividadCopia);
	    }
	}
	
	public void eliminarLearningPathCreado(String IDCamino) {
		LearningPath camino = encontrarLearningPathPorID(IDCamino);
		if (!camino.equals(null)) {
			((Profesor) user).eliminarLearningPathCreado(camino);
			caminos.remove(camino);
		}
	}
	
	public void cambiarTituloLearningPath(String IDCamino, String titulo) {
		LearningPath camino = encontrarLearningPathPorID(IDCamino);
		if (!camino.equals(null)) {
			((Profesor) user).cambiarTituloLearningPath(camino, titulo);
		}
	}
	
	public void cambiarDescrpcionLearningPath(String IDCamino, String descripcion) {
		LearningPath camino = encontrarLearningPathPorID(IDCamino);
		if (!camino.equals(null)) {
			((Profesor) user).cambiarDescripcionLearningPath(camino, descripcion);
		}
	}
	
	public void cambiarObjetivoLearningPath(String IDCamino, String objetivo) {
		LearningPath camino = encontrarLearningPathPorID(IDCamino);
		if (!camino.equals(null)) {
			((Profesor) user).cambiarObjetivoLearningPath(camino, objetivo);
		}
	}
	
	public void agregarActividadLearningPath(String IDCamino, String IDActividad) {
		LearningPath camino = encontrarLearningPathPorID(IDCamino);
		Actividad actividadAgregar = encontrarActividadPorID(IDActividad);
		if (!camino.equals(null) && !actividadAgregar.equals(null)) {
			((Profesor) user).agregarActividadLearningPath(camino, actividadAgregar);
		}
	}
	
	public void eliminarsActividadLearningPath(String IDCamino, String IDActividad) {
		LearningPath camino = encontrarLearningPathPorID(IDCamino);
		Actividad actividadEliminar = encontrarActividadPorID(IDActividad);
		if (!camino.equals(null) && !actividadEliminar.equals(null)) {
			((Profesor) user).eliminarActividadLearningPath(camino, actividadEliminar);
			actividades.remove(actividadEliminar);
		}
	}
	
	public void cambiarDescrpcionActividad(String IDActividad, String descripcion) {
		Actividad actividad = encontrarActividadPorID(IDActividad);
		((Profesor) user).cambiarDescripcionActividad(actividad, descripcion);
	}
	
	public void cambiarObjetivoActividad(String IDActividad, String objetivo) {
		Actividad actividad = encontrarActividadPorID(IDActividad);
		if (!actividad.equals(null)) {
			((Profesor) user).cambiarObjetivoActividad(actividad, objetivo);
		}
	}
	
	public void cambiarDuracionEsperadaActividad(String IDActividad, int duracion) {
		Actividad actividad = encontrarActividadPorID(IDActividad);
		LearningPath camino = encontrarLearningPathPorIDActividad(IDActividad);
		if (!actividad.equals(null) && !camino.equals(null)) {
			((Profesor) user).cambiarDuracionEsperadaActividad(actividad, duracion, camino);
		}
	}
	
	public void cambiarNivelDificultadActividad(String IDActividad, int dificultad) {
		Actividad actividad = encontrarActividadPorID(IDActividad);
		LearningPath camino = encontrarLearningPathPorIDActividad(IDActividad);
		if (!actividad.equals(null) && !camino.equals(null)) {
			((Profesor) user).cambiarNivelDificultadActividad(actividad, dificultad, camino);
		}
	}
	
	public void agregarPreRequisitosActividad(String IDActividad, String IDActividadAgregar) {
		Actividad actividad = encontrarActividadPorID(IDActividad);
		Actividad actividadAgregar = encontrarActividadPorID(IDActividadAgregar);
		if (!actividad.equals(null) && !actividadAgregar.equals(null)) {
			((Profesor) user).agregarPreRequisitosActividad(actividad, actividadAgregar);
		}
	}
	
	public void eliminarPreRequisitosActividad(String IDActividad, String IDActividadEliminar) {
		Actividad actividad = encontrarActividadPorID(IDActividad);
		Actividad actividadEliminar = encontrarActividadPorID(IDActividadEliminar);
		if (!actividad.equals(null) && !actividadEliminar.equals(null)) {
			((Profesor) user).eliminarPreRequisitosActividad(actividad, actividadEliminar);
		}
	}
	
	public void actualizarVersionLP(String IDCamino) {
		LearningPath camino = encontrarLearningPathPorID(IDCamino);
		camino.cambiarVersion();
	}
	
	public static void main(String[] args) {
		CentralLogica centralL = new CentralLogica();
		centralL.cargarDatos();
		centralL.iniciarSesion("j.p", "SoyJuan123");
		centralL.eliminarLearningPathCreado("JCPG1");
		List<Actividad> act = new ArrayList<Actividad>();
		List<String> pre = new ArrayList<String>();
		act.add(centralL.crearActividad("Cosas basicas", "Aprender", "RE", 0, 0, pre, "Hola Soy Stor", "Libro", null, null, null, null, 0));
		centralL.crearLearningPath("Camino 1", "Cosas basicas", "Aprender", act);
		/*Class<? extends Usuario> tipoUser = centralL.iniciarSesion("j.a@mail.com", "SoyJuan123");
		if (tipoUser.equals(Profesor.class)) {
			System.out.println("Es profesor");
		}else {
			System.out.println("Es estudiante");
		}*///Iniciar sesion como profesor
		centralL.guardarDatos();
	}

	public Usuario BuscarUsuario(String iUsername, String iPassword) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}