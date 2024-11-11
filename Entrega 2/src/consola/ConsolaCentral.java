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
	
	
	/**
	 * Valida la existencia de un empleado en la galería
	 * @return El empleado buscado o null de lo contrario
	 */
	
	private Usuario autenticarUsuario() {
		String IUsername = this.pedirCadenaAlUSuario("Ingerese su usuario: ");
		String IPassword = this.pedirCadenaAlUSuario("Ingrese su contraseña: ");
		
		Usuario usuario = centralLogica.BuscarUsuario(IUsername, IPassword);
		if ( usuario != null ) {
			centralLogica.iniciarSesion(IUsername, IPassword);
			System.out.println("Incio de sision exitoso, Bienvenido" + usuario.getNombre());
		}
		
		return usuario;
	}
	
	
    
    /**
	 * Metodo para crear un nuevo usuario corriente
	 * @throws IOException 
	 */
	private void crearNuevoUsuario() throws IOException {
		
	}
	
	public void correrAplicacion() {
		
	}
	
	
	public static void main(String[] args) 
	{
		ConsolaCentral ca = new ConsolaCentral();
		ca.correrAplicacion();
	}
	

	
}
