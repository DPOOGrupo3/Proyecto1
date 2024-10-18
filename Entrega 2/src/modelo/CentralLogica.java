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
	
	public Class<? extends Usuario> iniciarSesion(String email, String contrasena) {
		boolean logged = false;
		int numUsuario = 0;
		do {
			if (profesores.size() > numUsuario && profesores.get(numUsuario).iniciarSesion(email, contrasena)) {
				user = profesores.get(numUsuario);
				logged = true;
			}else if (estudiantes.size() > numUsuario && estudiantes.get(numUsuario).iniciarSesion(email, contrasena)) {
				user = estudiantes.get(numUsuario);
				logged = true;
			}
			numUsuario += 1;
		}while (logged == false);
		return user.getClass();
	}
	
	public void cargarDatos() {
		centralP.cargarDatos(profesores, estudiantes, caminos, actividades);
	}
	
	public void guardarDatos() {
		centralP.guardarDatos(profesores, estudiantes, caminos, actividades);
	}
	
	public static void main(String[] args) {
		CentralLogica centralL = new CentralLogica();
		centralL.cargarDatos();
		for (Profesor prof: centralL.profesores) {
			System.out.println(prof);
		}
		Class<? extends Usuario> tipoUser = centralL.iniciarSesion("j.a@mail.com", "SoyJuan123");
		if (tipoUser.equals(Profesor.class)) {
			System.out.println("Es profesor");
		}
	}
}