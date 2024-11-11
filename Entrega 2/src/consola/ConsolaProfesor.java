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
}
