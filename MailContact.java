public class MailContact{
	private String apellido;
	private String nombre;
	private String email;
	private int grupo =32;

	public MailContact(String apellido, String nombre, String email){
		this.grupo=0;
		this.apellido=apellido;
		this.nombre=nombre;
		this.email=email;

	}
	public String getApellido(){
		return apellido;
	}
	public String getNombre(){
		return nombre;
	}
	public String getEmail(){
		return email;
	}
	public int getGrupo(){
		return grupo;
	}
	public String toString(){
		String mostrar = email + " " + apellido + " " + nombre; 
		return mostrar;
	}
	public void setGrupo(int g){
		this.grupo = g;
	}

}