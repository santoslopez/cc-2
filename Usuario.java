
public class Usuario{
  //declaracion de variables
  private String user;
  private String nombre;
  private String password;

  //devolvemos el correo electronico
  public String getUsuarioCorreo(){
    return user;
  }

  //obtenemos el password
  public String getPassword(){
    return password;
  }
  //constructor de la clase
  public Usuario(String user,String nombre,String password){
    this.user=user;
    this.nombre=nombre;
    this.password=password;
  }

  //le vamos a dar un formato al toString para que nos despliege correctamente nuestros datos
  public String toString(){
    String dato = "Email: "+this.user + " Nombre: " + this.nombre +  " Password: " +this.password;
    return dato;
  }

}
