package modelo;

public class Tema extends Contenido {
	private String explicacion;
	
	public Tema(String explicacion) {
		this.explicacion = explicacion;
	}

	@Override
	public void editarContenido(Object explicacion) {
		this.explicacion = (String) explicacion;
	}

	@Override
	public void interactuar() {
		System.out.println(explicacion);
	}
}