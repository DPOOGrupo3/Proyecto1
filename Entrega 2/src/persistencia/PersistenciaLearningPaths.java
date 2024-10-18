package persistencia;

import java.util.ArrayList;
import java.util.List;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import java.nio.file.Files;

import org.json.JSONArray;
import org.json.JSONObject;

import modelo.LearningPath;

public class PersistenciaLearningPaths {
	public void cargarArchivo(String ruta) {
		
	}
	
	public void guardarArchivo(String ruta, List<LearningPath> caminos) {
		JSONArray jCaminos = new JSONArray();
		
		for (LearningPath camino: caminos) {
			String[] caminoArray = camino.toString().split("/");
			JSONObject jCamino = new JSONObject();
		}
	}
}