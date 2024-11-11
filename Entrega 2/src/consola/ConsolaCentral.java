package consola;


import modelo.CentralLogica;
import modelo.LearningPath;
import modelo.usuario.Usuario;
import modelo.usuario.Profesor;
import modelo.usuario.Estudiante;
import consola.ConsolaEstudiante;
import consola.ConsolaProfesor;

public class ConsolaCentral extends ConsolaBasica {
	
	private static ConsolaEstudiante cEstudiante;
	private static ConsolaProfesor cProfesor;
	private static CentralLogica centralLogica;
	
	/**
	 * Metodo para iniciar sesión de un usuario corriente
	 * @throws IOException 
	 */
	private void iniciarSesion() throws IOException {
		
		String iUsername = this.pedirCadenaAlUSuario("Ingrese su usuario (username)");
		String iPassword = this.pedirCadenaAlUSuario("Ingrese su contraseña: ");
		
		Class<? extends Usuario> user = centralLogica.iniciarSesion(iUsername, iPassword);
		
	       if (user == null) {
	            
	            System.out.println("Error: No se encuentra el usuario o la contraseña es incorrecta.");

	
	       }
	

	}
	
}
