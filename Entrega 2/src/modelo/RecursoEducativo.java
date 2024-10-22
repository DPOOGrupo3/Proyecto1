package modelo;

public class RecursoEducativo extends Contenido {
	private String recurso;
	private String tipo;
	
	public RecursoEducativo(String recurso, String tipo) {
		this.recurso = recurso;
		this.tipo = tipo;
	}

	@Override
	public void editarContenido(Object recurso) {
		this.recurso = (String) recurso;
	}

	@Override
	public Object obtenerInformacion() {
		String cadenaImprimir = "";
		if (tipo.equals("Video")) {
			cadenaImprimir = "Aquí tienes la forma de acceder al video: ";
		}else if (tipo.equals("Sitio Web")) {
			cadenaImprimir = "Aquí tienes la URL para acceder al sitio web: ";
		}else if (tipo.equals("Libro")) {
			cadenaImprimir = "Aquí tienes la forma de acceder al libro: ";
		}else if (tipo.equals("Recurso Adjunto")) {
			cadenaImprimir = "Aquí tienes la forma de acceder al recurso adjunto: ";
		}
		return cadenaImprimir + "\n" +recurso;
	}
}