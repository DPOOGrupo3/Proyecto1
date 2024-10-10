package persistencia;

import java.util.List;

import modelo.usuario.Usuario;

public class PersistenciaUsuarios {
	public void cargarArchivo(String ruta) {
		
	}
	
	public void guardarArchivo(String ruta, List<Usuario> users) {
		for (Usuario user: users) {
			String[] userArray = user.toString().split("/");
		}
	}
}