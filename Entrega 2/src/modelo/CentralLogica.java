package modelo;

import java.util.ArrayList;
import java.util.List;

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
		return ((Profesor) user).crearLearningPath(titulo, descripcion, objetivo, activdades);
	}
	
	public Actividad crearActividad(int ID, String descripcion, String objetivo, Contenido contenido, int nivelDificultad, int duracionEsperada, List<Actividad> preRequisitos) {
		return ((Profesor) user).crearActividad(ID, descripcion, objetivo, contenido, nivelDificultad, duracionEsperada, preRequisitos);
	}
	
	public void copiarLearninPath(LearningPath camino) {
		((Profesor) user).copiarLearninPath(camino);
	}
	
	public void cambiarTituloLearningPath(LearningPath camino, String titulo) {
		((Profesor) user).cambiarTituloLearningPath(camino, titulo);
	}
	
	public void cambiarDescrpcionLearningPath(LearningPath camino, String descripcion) {
		((Profesor) user).cambiarDescrpcionLearningPath(camino, descripcion);
	}
	
	public void cambiarObjetivoLearningPath(LearningPath camino, String objetivo) {
		((Profesor) user).cambiarObjetivoLearningPath(camino, objetivo);
	}
	
	public void agregarActividadLearningPath(LearningPath camino, Actividad actividadAgregar) {
		((Profesor) user).agregarActividadLearningPath(camino, actividadAgregar);
	}
	
	public void eliminarsActividadLearningPath(LearningPath camino, Actividad actividadEliminar) {
		((Profesor) user).eliminarsActividadLearningPath(camino, actividadEliminar);
	}
	
	public void cambiarDescrpcionActividad(Actividad actividad, String descripcion) {
		((Profesor) user).cambiarDescrpcionActividad(actividad, descripcion);
	}
	
	public void cambiarObjetivoActividad(Actividad actividad, String objetivo) {
		((Profesor) user).cambiarObjetivoActividad(actividad, objetivo);
	}
	
	public void cambiarDuracionEsperadaActividad(Actividad actividad, int duracion) {
		((Profesor) user).cambiarDuracionEsperadaActividad(actividad, duracion);
	}
	
	public void cambiarNivelDificultadActividad(Actividad actividad, int dificultad) {
		((Profesor) user).cambiarNivelDificultadActividad(actividad, dificultad);
	}
	
	public void agregarPreRequisitosActividad(Actividad actividad, Actividad actividadAgregar) {
		((Profesor) user).agregarPreRequisitosActividad(actividad, actividadAgregar);
	}
	
	public void eliminarPreRequisitosActividad(Actividad actividad, Actividad actividadEliminar) {
		((Profesor) user).eliminarPreRequisitosActividad(actividad, actividadEliminar);
	}
	
	
	
	public static void main(String[] args) {
		CentralLogica centralL = new CentralLogica();
		centralL.cargarDatos();
		centralL.iniciarSesion("j.a@mail.com", "SoyJuan123");
		/*Class<? extends Usuario> tipoUser = centralL.iniciarSesion("j.a@mail.com", "SoyJuan123");
		if (tipoUser.equals(Profesor.class)) {
			System.out.println("Es profesor");
		}else {
			System.out.println("Es estudiante");
		}*///Iniciar sesion como profesor
		//Profesor profe = (Profesor) centralL.user;
		//centralL.caminos.add(profe.crearLearningPath("camino1", "Cosas basicas", "Aprender", 1, 1, 0.2, new ArrayList<Actividad>()));
		centralL.guardarDatos();
	}
}