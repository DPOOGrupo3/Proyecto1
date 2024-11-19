package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import modelo.LearningPath;
import modelo.actividad.Actividad;
import modelo.actividad.RecursoEducativo;
import modelo.usuario.Profesor;

import java.util.ArrayList;
import java.util.List;

public class ProfesorTest {

    private Profesor profesor;
    private LearningPath learningPath;
    private Actividad actividad;

    @BeforeEach
    void setUp() {
        profesor = new Profesor("Juan Pérez", "juan.perez@mail.com", "password123");
        List<Actividad> actividades = new ArrayList<>();
        learningPath = new LearningPath("LP001", "Path de Prueba", "Descripción inicial", "Objetivo inicial", actividades);
        actividad = new RecursoEducativo("Leer PDF", "Comprender el contenido", "RE", 30, 3.5, new ArrayList<>(), "PDF de prueba", "PDF");
    }

    @Test
    void testCrearLearningPath() {
        LearningPath nuevoPath = profesor.crearLearningPath("Nuevo Path", "Descripción", "Objetivo", new ArrayList<>());
        assertNotNull(nuevoPath, "El Learning Path creado no debe ser nulo.");
        assertEquals("Nuevo Path", nuevoPath.getTitulo(), "El título del Learning Path no coincide.");
        assertEquals(1, profesor.getCaminosCreados().size(), "El número de caminos creados debe ser 1.");
    }

    @Test
    void testEliminarLearningPath() {
        profesor.crearLearningPath(learningPath.getTitulo(), learningPath.getDescripcion(), learningPath.getObjetivo(), new ArrayList<>());
        profesor.eliminarLearningPathCreado(learningPath);
        assertEquals(0, profesor.getCaminosCreados().size(), "El Learning Path no se eliminó correctamente.");
    }

    @Test
    void testCambiarTituloLearningPath() {
        profesor.crearLearningPath(learningPath.getTitulo(), learningPath.getDescripcion(), learningPath.getObjetivo(), new ArrayList<>());
        profesor.cambiarTituloLearningPath(learningPath, "Nuevo Título");
        assertEquals("Nuevo Título", learningPath.getTitulo(), "El título del Learning Path no se actualizó correctamente.");
    }

    @Test
    void testAgregarActividadLearningPath() {
        profesor.agregarActividadLearningPath(learningPath, actividad);
        assertEquals(1, learningPath.getActivdades().size(), "La actividad no se agregó correctamente.");
    }

    @Test
    void testEliminarActividadLearningPath() {
        profesor.agregarActividadLearningPath(learningPath, actividad);
        profesor.eliminarActividadLearningPath(learningPath, actividad);
        assertEquals(0, learningPath.getActivdades().size(), "La actividad no se eliminó correctamente.");
    }
}
