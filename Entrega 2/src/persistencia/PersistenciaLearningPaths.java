package persistencia;

import java.util.ArrayList;
import java.util.List;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import java.nio.file.Files;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import modelo.Actividad;
import modelo.LearningPath;

public class PersistenciaLearningPaths {
	private String[] titulos = {"ID", "titulo", "descripcion", "objetivo", "duracion", "dificultad", "rating", "raters", "activdades"};
	
	public void cargarArchivo(String ruta, List<LearningPath> caminos, List<Actividad> actividadesCompleta) throws JSONException, IOException {
		JSONArray jCaminos = new JSONArray(new String(Files.readAllBytes(new File(ruta).toPath())));
		
		for (int i = 0; i < jCaminos.length(); i++) {
			JSONObject jCamino = jCaminos.getJSONObject(i);
			JSONArray jActividades = (JSONArray) jCamino.get("actividades");
			List<Actividad> actividades = obtenerActividades(jActividades, actividadesCompleta);
			LearningPath camino = new LearningPath(jCamino.getString(titulos[1]), jCamino.getString(titulos[2]), jCamino.getString(titulos[3]), actividades);
			cargarDatos(camino, jCamino.getInt(titulos[7]), jCamino.getDouble(titulos[6]));
			caminos.add(camino);
		}
	}
	
	public List<Actividad> obtenerActividades(JSONArray jActividades, List<Actividad> actividadesCompleta) {
		List<Actividad> actividades = new ArrayList<Actividad>();
		
		for (int i = 0; i < jActividades.length(); i++) {
			for (int j = 0; j < actividadesCompleta.size(); j++) {
				if (String.valueOf(actividadesCompleta.get(j).getID()).equals(jActividades.getString(i))) {
					actividades.add(actividadesCompleta.get(j));
					break;
				}
			}
		}
		return actividades;
	}
	
	public void cargarDatos(LearningPath camino, int raters, double rating) {
		camino.cambiarDuracionEsperada();
		camino.cambiarNivelDificultad();
		for (int i = 0; i < raters; i++) {
			camino.ratePath(rating);
		}
	}
	
	public void guardarArchivo(String ruta, List<LearningPath> caminos) {
		JSONArray jCaminos = new JSONArray();
		
		for (LearningPath camino: caminos) {
			JSONObject jCamino = new JSONObject();
			String[] caminoArray = camino.toString().split("/");
			
			for (int i = 0; i < titulos.length-1; i++) {
				jCamino.put(titulos[i], caminoArray[i]);
			}
			
			JSONArray jActividades = new JSONArray();
			
			if (!caminoArray[8].equals("NA")) {
				String[] actividades = caminoArray[8].split("%");
				
				for (String actividad: actividades) {
					jActividades.put(actividad);
				}
			}
			
			jCamino.put("actividades", jActividades);
			jCaminos.put(jCamino);
		}
		try {
			PrintWriter pw = new PrintWriter(ruta);
			jCaminos.write(pw, 2, 0);
	        pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}