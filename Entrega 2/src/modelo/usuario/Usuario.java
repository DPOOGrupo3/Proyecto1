package modelo.usuario;

public abstract class Usuario {
	private String nombre;
	private String email;
	private String contraseña;
	
	public Usuario(String nombre, String email, String contraseña) {
		this.nombre = nombre;
		this.email = email;
		this.contraseña = contraseña;
	}
	
	public boolean iniciarSesion(String login, String contraseña) {
		return (login.equals(this.email.substring(0, this.email.indexOf("@"))) && contraseña.equals(this.contraseña));
	}
	
	public String getNombre() {
		return nombre;
	}
	
	@Override
	public String toString() {
		return nombre + "/" + email + "/" + contraseña;
	}
}