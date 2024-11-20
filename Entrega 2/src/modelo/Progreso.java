package modelo;

import java.util.ArrayList;
import java.util.List;

import modelo.actividad.Actividad;

public class Progreso {
	private Double porcentaje;
	private LearningPath camino;
	private List<Actividad> actividadesTerminadas;
	private List<Actividad> actividadesPendinetes;
	
	public Progreso(LearningPath camino) {
		porcentaje = 0.0;
		this.camino = camino;
		actividadesTerminadas = new ArrayList<Actividad>();
		actividadesPendinetes = new ArrayList<Actividad>();
		cargarActividadesPendientes();
	}
	
	public Double getPorcentaje() {
		return porcentaje;
	}
	
	private void calcularPorcentaje() {
		porcentaje = (double) (actividadesTerminadas.size()/camino.getActivdades().size());
	}

	public List<Actividad> getActividadesTerminadas() {
		return actividadesTerminadas;
	}

	public List<Actividad> getActividadesPendinetes() {
		return actividadesPendinetes;
	}

	public void entregarActividad(Actividad actividad) {
		actividadesTerminadas.add(actividad);
		eliminarActividadPendiente(actividad);
		calcularPorcentaje();
	}
	
	private void cargarActividadesPendientes() {
		for (Actividad actividad: camino.getActivdades()) {
			actividadesPendinetes.add(actividad);
		}
	}
	
	private void eliminarActividadPendiente(Actividad actividad) {
		actividadesPendinetes.remove(actividad);
	}
	
	@Override
	public String toString() {
		
		return String.valueOf(porcentaje) + "%";
	}
}