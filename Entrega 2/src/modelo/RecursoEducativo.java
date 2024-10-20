package modelo;

public class RecursoEducativo extends Contenido {
	private String recurso;
	
	public RecursoEducativo(String recurso) {
		this.recurso = recurso;
	}

	@Override
	public void editarContenido(Object recurso) {
		this.recurso = (String) recurso;
	}

	@Override
	public String interactuar() {
		return recurso;
	}
}