package modelo.usuario;

import java.util.List;

import modelo.LearningPath;

public class Estudiante extends Usuario{
	private List<LearningPath> caminosInscritos;
	
	public Estudiante(String nombre, String email, String contraseña) {
		super(nombre, email, contraseña);
	}
	
	
}