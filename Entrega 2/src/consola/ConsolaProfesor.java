package consola;

import modelo.CentralLogica;
import modelo.LearningPath;
import modelo.actividad.Actividad;
import modelo.usuario.Profesor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConsolaProfesor extends ConsolaBasica {
	
	private Profesor profesorA;
	private CentralLogica centralLogica;
	
	public ConsolaProfesor (Profesor user, CentralLogica centralLogica) {
		this.profesorA = user;
		this.centralLogica = centralLogica;
	}
	
	/**
     * Método para ejecutar el menú principal del profesor.
     */
    public void correrConsola() {
        String[] opcionesMenu = {"Crear Learning Path", "Crear Actividad", "Ver Learning Paths", "Salir"};
        int opcion = mostrarMenu("Menú Profesor", opcionesMenu);
    }
    
    
    /**
     * Método para crear un nuevo Learning Path.
     */
    private void crearLearningPath() throws IOException {
    	String titulo = pedirCadenaAlUSuario("Ingrese el titulo del Learning Path: ");
    	String descripcion = pedirCadenaAlUSuario("Ingrese la descripcion del Learning Path: ");
    	String objetivo = pedirCadenaAlUSuario("Ingrese el objetivo del Learning Path: ");
    	
    	
    	LearningPath nuevoPath = centralLogica.crearLearningPath(titulo, descripcion, objetivo, new ArrayList<>());
    	System.out.println("Learning Path creado con exito: " + nuevoPath.getID());
    	
    	correrConsola();
    			
    }
    
    /**
     * Método para crear una nueva actividad.
     */
    private void crearActividad() throws IOException {
    	String descripcion = pedirCadenaAlUSuario("Ingrese la descirpcion de la actividad: ");
    	String objetivo = pedirCadenaAlUSuario("Ingrese el objetivo de la actividad: ");
    	String tipo = pedirCadenaAlUSuario("Ingrese el tipo de la actividad: ");
    	String nivelDificultad = pedirCadenaAlUSuario("Ingrese el nivel de dificultad de la actividad: ");
    	String duracion = pedirCadenaAlUSuario("Ingrese la duracion de la actividad: ");
    	
    	Actividad nuevaActividad = centralLogica.crearActividad(descripcion, objetivo, tipo, nivelDificultad, duracion, new ArrayList<>() , null, null, null, null, null, null, 0);
    	
    	System.out.println("Actividad creada con exito con ID: " + nuevaActividad.getID());
    	
    	correrConsola();
    }
    
    
    /**
     * Método para ver todos los Learning Paths creados por el profesor.
     */
    private void verLearningPaths() {
        correrConsola();
   
    
    }
}
