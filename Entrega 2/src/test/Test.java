package test;

import java.util.ArrayList;
import java.util.List;

import modelo.LearningPath;
import modelo.actividad.*;
import modelo.actividad.examen.*;
import modelo.usuario.Estudiante;
import modelo.usuario.Profesor;

public class Test {

    private static int pruebasExitosas = 0;
    private static int pruebasFallidas = 0;
    private static ArrayList<String> pruebasExitoList = new ArrayList<>();
    private static ArrayList<String> pruebasFalloList = new ArrayList<>();

    public static void main(String[] args) {
        testCrearUsuario();
        testCrearLearningPath();
        testAgregarActividad();
        testInscribirEstudiante();
        testCrearRecursoEducativo();
        testCrearTarea();
        testCrearExamen();
        testCrearEncuesta();
        testCrearParcial();
        testCrearQuiz();

        System.out.println("Pruebas exitosas: " + pruebasExitosas);
        System.out.println("Pruebas fallidas: " + pruebasFallidas);
        
        if (pruebasFallidas > 0) {
            System.out.println("Pruebas exitosas:");
            for (String prueba : pruebasExitoList) {
                System.out.println("- " + prueba);
            }

            System.out.println("Pruebas fallidas:");
            for (String prueba : pruebasFalloList) {
                System.out.println("- " + prueba);
            }
        } else {
            System.out.println("¡Todas las pruebas fueron exitosas!");
        }
    }

    private static void testCrearUsuario() {
        Profesor profesor = new Profesor("Carlos", "carlos@example.com", "profesor123");
        Estudiante estudiante = new Estudiante("Ana", "ana@example.com", "estudiante123");

        if (profesor.getNombre().equals("Carlos") && estudiante.getNombre().equals("Ana")) {
            pruebasExitosas++;
            pruebasExitoList.add("testCrearUsuario");
        } else {
            pruebasFallidas++;
            pruebasFalloList.add("testCrearUsuario");
        }
    }

    private static void testCrearLearningPath() {
        Profesor profesor = new Profesor("Carlos", "carlos@example.com", "profesor123");
        LearningPath learningPath1 = profesor.crearLearningPath("Matemáticas Avanzadas", "Un camino para aprender matemáticas", "Dominar matemáticas a un nivel avanzado", new ArrayList<>());

        if (learningPath1.getTitulo().equals("Matemáticas Avanzadas")) {
            pruebasExitosas++;
            pruebasExitoList.add("testCrearLearningPath");
        } else {
            pruebasFallidas++;
            pruebasFalloList.add("testCrearLearningPath");
        }
    }

    private static void testAgregarActividad() {
        Profesor profesor = new Profesor("Carlos", "carlos@example.com", "profesor123");
        LearningPath learningPath1 = profesor.crearLearningPath("Matemáticas Avanzadas", "Un camino para aprender matemáticas", "Dominar matemáticas a un nivel avanzado", new ArrayList<>());
        Actividad actividad1 = profesor.crearActividad("Examen Parcial", "Evaluar conocimientos en matemáticas", "P", 5, 120, new ArrayList<>(), "Examen de Matemáticas", "PDF", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), 70);
        
        learningPath1.agregarActivdad(actividad1);

        if (learningPath1.getActivdades().contains(actividad1)) {
            pruebasExitosas++;
            pruebasExitoList.add("testAgregarActividad");
        } else {
            pruebasFallidas++;
            pruebasFalloList.add("testAgregarActividad");
        }
    }

    private static void testInscribirEstudiante() {
        Profesor profesor = new Profesor("Carlos", "carlos@example.com", "profesor123");
        Estudiante estudiante = new Estudiante("Ana", "ana@example.com", "estudiante123");
        LearningPath learningPath1 = profesor.crearLearningPath("Matemáticas Avanzadas", "Un camino para aprender matemáticas", "Dominar matemáticas a un nivel avanzado", new ArrayList<>());

        estudiante.inscribirCamino(learningPath1);

        if (estudiante.getCaminosInscritos().contains(learningPath1)) {
            pruebasExitosas++;
            pruebasExitoList.add("testInscribirEstudiante");
        } else {
            pruebasFallidas++;
            pruebasFalloList.add("testInscribirEstudiante");
        }
    }


    private static void testCrearRecursoEducativo() {
        RecursoEducativo recurso = new RecursoEducativo("Video sobre álgebra", "Aprender álgebra", "Recurso", 3, 30, new ArrayList<>(), "http://video.com/algebra", "Video");
        
        if (((ArrayList<String>) recurso.obtenerInformacion()).contains("http://video.com/algebra")) {
            pruebasExitosas++;
            pruebasExitoList.add("testCrearRecursoEducativo");
        } else {
            pruebasFallidas++;
            pruebasFalloList.add("testCrearRecursoEducativo");
        }
    }

    private static void testCrearTarea() {
        List<String> ejercicios = new ArrayList<>();
        ejercicios.add("Ejercicio 1");
        ejercicios.add("Ejercicio 2");
        Tarea tarea = new Tarea("Tarea de matemáticas", "Practicar operaciones", "Tarea", 4, 60, new ArrayList<>(), ejercicios);
        
        if (tarea.obtenerInformacion().equals(ejercicios)) {
            pruebasExitosas++;
            pruebasExitoList.add("testCrearTarea");
        } else {
            pruebasFallidas++;
            pruebasFalloList.add("testCrearTarea");
        }
    }

    private static void testCrearExamen() {
        List<String> preguntas = new ArrayList<>();
        preguntas.add("Pregunta 1");
        preguntas.add("Pregunta 2");
        Examen examen = new Parcial("Examen de matemáticas", "Evaluar conocimientos", "Examen", 5, 120, new ArrayList<>(), preguntas);
        
        if (examen.obtenerInformacion().equals(preguntas)) {
            pruebasExitosas++;
            pruebasExitoList.add("testCrearExamen");
        } else {
            pruebasFallidas++;
            pruebasFalloList.add("testCrearExamen");
        }
    }

    private static void testCrearEncuesta() {
        List<String> preguntas = new ArrayList<>();
        preguntas.add("Pregunta de encuesta 1");
        Encuesta encuesta = new Encuesta("Encuesta de satisfacción", "Medir satisfacción", "Encuesta", 2, 30, new ArrayList<>(), preguntas);
        
        if (encuesta.obtenerInformacion().equals(preguntas)) {
            pruebasExitosas++;
            pruebasExitoList.add("testCrearEncuesta");
        } else {
            pruebasFallidas++;
            pruebasFalloList.add("testCrearEncuesta");
        }
    }

    private static void testCrearParcial() {
        List<String> preguntas = new ArrayList<>();
        preguntas.add("Pregunta parcial 1");
        Parcial parcial = new Parcial("Parcial de matemáticas", "Evaluar conocimientos parciales", "Parcial", 5, 120, new ArrayList<>(), preguntas);
        
        if (parcial.obtenerInformacion().equals(preguntas)) {
            pruebasExitosas++;
            pruebasExitoList.add("testCrearParcial");
        } else {
            pruebasFallidas++;
            pruebasFalloList.add("testCrearParcial");
        }
    }

    private static void testCrearQuiz() {
        List<String> preguntas = new ArrayList<>();
        preguntas.add("Pregunta de quiz 1");
        List<String> opciones = new ArrayList<>();
        opciones.add("Opción A");
        opciones.add("Opción B");
        List<Integer> respuestas = new ArrayList<>();
        respuestas.add(0); 
        Quiz quiz = new Quiz("Quiz de matemáticas", "Evaluar conocimientos", "Quiz", 5, 30, new ArrayList<>(), preguntas, opciones, respuestas, 60);
        
        if (quiz.getPreguntas().equals(preguntas) && quiz.getOpciones().equals(opciones)) {
            pruebasExitosas++;
            pruebasExitoList.add("testCrearQuiz");
        } else {
            pruebasFallidas++;
            pruebasFalloList.add("testCrearQuiz");
        }
    }
}
