package persistencia;

import java.io.IOException;
import java.util.List;

import modelo.Actividad;
import modelo.LearningPath;
import modelo.usuario.*;

public class CentralPersistencia {
	private static String RutaUsuarios = "datos/usuarios.json";
	private static String RutaCaminos = "datos/caminos.json";
	private PersistenciaUsuarios persistenciaU = new PersistenciaUsuarios();
	private PersistenciaLearningPaths persistenciaC = new PersistenciaLearningPaths();
	
	public void cargarDatos(List<Profesor> profesores, List<Estudiante> estudiantes, List<LearningPath> caminos, List<Actividad> actividades) {
		try {
			cargarUsusarios(profesores, estudiantes);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void cargarUsusarios(List<Profesor> profesores, List<Estudiante> estudiantes) throws IOException {
		persistenciaU.cargarArchivo(RutaUsuarios, profesores, estudiantes);
	}
}