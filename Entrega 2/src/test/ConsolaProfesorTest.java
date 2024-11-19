package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import consola.ConsolaProfesor;
import modelo.CentralLogica;
import modelo.LearningPath;
import modelo.actividad.RecursoEducativo;
import modelo.usuario.Profesor;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ConsolaProfesorTest {

    private ConsolaProfesor consola;
    private CentralLogica centralLogica;
    private Profesor profesor;

    @BeforeEach
    void setUp() {
        centralLogica = new CentralLogica();
        profesor = new Profesor("Juan Pérez", "juan.perez@mail.com", "password123");
        consola = new ConsolaProfesor(profesor, centralLogica);

        // Crear datos iniciales
        LearningPath path = profesor.crearLearningPath("Path Inicial", "Descripción", "Objetivo", new ArrayList<>());
        centralLogica.registrarUsuario(profesor);
        centralLogica.crearLearningPath(path.getTitulo(), path.getDescripcion(), path.getObjetivo(), new ArrayList<>());
    }

    @Test
    void testConsultarLearningPaths() {
        List<LearningPath> caminos = centralLogica.obtenerLearningPathsProfesor(profesor);
        assertNotNull(caminos, "La lista de Learning Paths no debe ser nula.");
        assertFalse(caminos.isEmpty(), "El profesor debe tener al menos un Learning Path creado.");
        assertEquals("Path Inicial", caminos.get(0).getTitulo(), "El título del Learning Path no coincide.");
    }

    @Test
    void testEliminarLearningPath() {
        LearningPath path = centralLogica.obtenerLearningPathsProfesor(profesor).get(0);
        centralLogica.eliminarLearningPathCreado(path.getID());
        List<LearningPath> caminos = centralLogica.obtenerLearningPathsProfesor(profesor);
        assertTrue(caminos.isEmpty(), "El Learning Path no se eliminó correctamente.");
    }

    @Test
    void testEditarLearningPath() {
        LearningPath path = centralLogica.obtenerLearningPathsProfesor(profesor).get(0);
        centralLogica.cambiarTituloLearningPath(path.getID(), "Nuevo Título");
        assertEquals("Nuevo Título", path.getTitulo(), "El título del Learning Path no se actualizó correctamente.");
    }

    @Test
    void testAgregarActividadLearningPath() {
        LearningPath path = centralLogica.obtenerLearningPathsProfesor(profesor).get(0);
        RecursoEducativo actividad = new RecursoEducativo("Nueva Actividad", "Aprender", "RE", 45, 3.5, new ArrayList<>(), "URL", "PDF");
        centralLogica.agregarActividadLearningPath(path.getID(), actividad.getID());
        assertEquals(1, path.getActivdades().size(), "La actividad no se agregó correctamente al Learning Path.");
    }
}


