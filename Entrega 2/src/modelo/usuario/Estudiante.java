package modelo.usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelo.LearningPath;
import modelo.actividad.Actividad;

public class Estudiante extends Usuario{
	private List<LearningPath> caminosInscritos;
	private Map<LearningPath, Map<Actividad, Double>> progresoActividades;
	
	public Estudiante(String nombre, String email, String contraseña) {
		super(nombre, email, contraseña);
		this.caminosInscritos = new ArrayList<>();
        this.progresoActividades = new HashMap<>();
	}
	
	public void inscribirseEnLearningPath(LearningPath camino) {
        if (!caminosInscritos.contains(camino)) {
            caminosInscritos.add(camino);
            progresoActividades.put(camino, new HashMap<>());
        }
    }

    public void registrarProgreso(Actividad actividad, double porcentaje) {
        for (LearningPath camino : caminosInscritos) {
            if (camino.getActivdades().contains(actividad)) {
                progresoActividades.get(camino).put(actividad, porcentaje);
                break;
            }
        }
    }

    public double consultarProgresoLearningPath(LearningPath camino) {
        if (progresoActividades.containsKey(camino)) {
            Map<Actividad, Double> progreso = progresoActividades.get(camino);
            double totalProgreso = 0;
            for (Double porcentaje : progreso.values()) {
                totalProgreso += porcentaje;
            }
            return totalProgreso / progreso.size();
        }
        return 0;
    }

    public List<LearningPath> getCaminosInscritos() {
        return caminosInscritos;
    }

    @Override
    public String toString() {
        return super.toString() + " - Estudiante";
    }

	public void inscribirCamino(LearningPath learningPath1) {
		// TODO Auto-generated method stub
		
	}
	
	
}