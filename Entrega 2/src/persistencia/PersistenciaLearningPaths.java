package persistencia;

import java.util.List;

import modelo.LearningPath;

public class PersistenciaLearningPaths {
	public void cargarArchivo(String ruta) {
		
	}
	
	public void guardarArchivo(String ruta, List<LearningPath> caminos) {
		for (LearningPath camino: caminos) {
			String[] caminoArray = camino.toString().split("/");
		}
	}
}