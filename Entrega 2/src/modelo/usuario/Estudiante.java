package modelo.usuario;

import java.util.ArrayList;
import java.util.List;

import modelo.LearningPath;

public class Estudiante extends Usuario{
	private List<LearningPath> caminosInscritos;
	
	public Estudiante(String nombre, String email, String contraseña) {
		super(nombre, email, contraseña);
	}
	
	public void inscribirCamino(LearningPath camino) {
		caminosInscritos.add(camino);
	}

	public ArrayList<String> getCaminosInscritos() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}