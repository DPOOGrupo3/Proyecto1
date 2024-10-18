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

import modelo.usuario.Estudiante;
import modelo.usuario.Profesor;
import modelo.usuario.Usuario;

public class PersistenciaUsuarios {
	private String[] titulos = {"nombre", "correo", "contrasena"};
	
	public void cargarArchivo(String ruta, List<Profesor> profesores, List<Estudiante> estudiantes) throws IOException {
		JSONObject usuarios = new JSONObject(new String(Files.readAllBytes(new File(ruta).toPath())));
		
		cargarProfesores(profesores, usuarios.getJSONArray("profesores"));
		cargarEstudiantes(estudiantes, usuarios.getJSONArray("estudiantes"));
	}
	
	public void cargarProfesores(List<Profesor> profesores, JSONArray jProfesores) {
		for (int i = 0; i < jProfesores.length(); i++) {
			JSONObject jProfesor = jProfesores.getJSONObject(i);
			Profesor profesor = new Profesor(jProfesor.getString("nombre"), jProfesor.getString("correo"), jProfesor.getString("contrasena"));
			JSONArray jCaminos = (JSONArray) jProfesor.get("caminos");
			List<String> caminos = new ArrayList<String>();
			for (int j = 0; j < jCaminos.length(); j++) {
				caminos.add(jCaminos.getString(j));
			}
			profesor.cargarLearninPathsCreados(caminos);
			profesores.add(profesor);
		}
	}
	
	public void cargarEstudiantes(List<Estudiante> estudiantes, JSONArray jEstudiantes) {
		for (int i = 0; i < jEstudiantes.length(); i++) {
			JSONObject estudiante = jEstudiantes.getJSONObject(i);
			estudiantes.add(new Estudiante(estudiante.getString("nombre"), estudiante.getString("correo"), estudiante.getString("contrasena")));
		}
	}
	
	public void guardarArchivo(String ruta, List<Profesor> profesores, List<Estudiante> estudiantes) {
		JSONObject usuarios = new JSONObject();
		JSONArray jProfesores = new JSONArray();
		JSONArray jEstudiantes = new JSONArray();
		
		for (Profesor profesor: profesores) {
			JSONObject profe = new JSONObject();
			String[] atributosProfesor = profesor.cadenaAGuardar().split("/");
			for (int i = 0; i < titulos.length; i++) {
				profe.put(titulos[i], atributosProfesor[i]);
			}
			if (atributosProfesor[3].equals("NA")) {
				JSONArray caminos = new JSONArray();
				profe.put("caminos", caminos);
			}else {
				profe.put("caminos", atributosProfesor[3]);
			}
			jProfesores.put(profe);
		}
		
		for (Usuario estudiante: estudiantes) {
			JSONObject student = new JSONObject();
			String[] atributosEstudiante = estudiante.toString().split("/");
			for (int i = 0; i < titulos.length; i++) {
				student.put(titulos[i], atributosEstudiante[i]);
			}
			jEstudiantes.put(student);
		}
		
		usuarios.put("profesores", jProfesores);
		usuarios.put("estudiantes", jEstudiantes);
		PrintWriter pw;
		try {
			pw = new PrintWriter(ruta);
			usuarios.write(pw, 2, 0);
	        pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}