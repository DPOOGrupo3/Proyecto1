package consola;

import modelo.CentralLogica;
import modelo.LearningPath;
import modelo.usuario.Estudiante;
import java.io.IOException;
import java.util.List;

public class ConsolaEstudiante extends ConsolaBasica{
	
	
	private Estudiante estudianteA;
	private CentralLogica centralLogica;
	
	public ConsolaEstudiante(Estudiante estudianteActual, CentralLogica centralLogica) {
        this.estudianteA = estudianteActual;
        this.centralLogica = centralLogica;
    }
	
	/**
     * Método para ejecutar el menú principal del estudiante.
     */
    public void correrConsola() {
        String[] opcionesMenu = {"Ver Learning Paths Disponibles", "Ver Progreso", "Salir"};
        int opcion = mostrarMenu("Menú Estudiante", opcionesMenu);
	
    }
}
