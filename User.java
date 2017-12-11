import java.util.regex.*;
public class User{
  //declaracion de variables
  private String user;
  private String nombre;
  private String password;

  //constructor de la clase
  public User(String user,String nombre,String password){

    if(!(Pattern.matches("[a-z]{1,}+[@][a-z0-9]{1,}+[.][a-z]{1,}+[.][a-z]{1,3}",user)|| (Pattern.matches("[a-z]{1,}+[@][a-z]{1,}+[.][a-z]{3}",user) ))){
      System.out.println("\nSe produjo la siguiente excepcion: InvalidUsernameException.\nEl correo no tiene un formato correcto\nPor favor espere...");
    }else if (!(Pattern.matches("[0-9a-zA-Z]{1,}+",password))) {
      System.out.println("\nSe produjo la siguiente excepcion: NullPasswordException\nEl password no puede estar vacio\nPor favor espere...");
    }else{
      this.user=user;
      this.nombre=nombre;
      this.password=password;
      System.out.println("Sus datos se han guardado correctamente!!!\nPor favor espere...");
    }
  }

  //le vamos a dar un formato al toString para que nos despliege correctamente nuestros datos
  public String toString(){
    String dato = "Email: "+this.user + " Nombre: " + this.nombre +  " Password: " +this.password;
    return dato;
  }

}
