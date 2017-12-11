/*
UserTable.java esta clase representa la tabla de usuarios en el sistema
*/
import java.util.Hashtable;
import java.util.Enumeration;
import java.util.*;

public class UserTable{

  //patron de diseno singleton para crear una sola instancia de la clase
  private static UserTable instancia;
  public static UserTable getInstancia(){
    if (instancia==null) {
      instancia=new UserTable();
    }
    return instancia;
  }

  //variable que va almacenar el indice del elemento agregado
  private int noElemento = 0;

  //devolvemos el numero de indice del elemento
  public int getNumeroElemento(){
    return noElemento;
  }

  //Hashtable para almacenar los datos (usuario,password y nombre)
  private HashMap <Integer,User> contenido = new HashMap<Integer,User>();

  public HashMap<Integer, User> getContenido() {
      return contenido;
  }


  public void insert(String username,String nombre,String password){
    User agregarDatos = new User(username,nombre,password);//pasamos los datos a guardar en el constructor de la clase User
    noElemento++;//incrementamos el valor del indice del HashMap
    //agregamos los datos al HashMap
    UserTable.getInstancia().contenido.put(this.getNumeroElemento(),agregarDatos);

  }

  //verificamos si el Hashtable esta vacio o de lo contrario desplegamos su contenido
  public void listar(){
    if (contenido.isEmpty()) {
      System.out.println(">>>>>>>>>"+UserTable.getInstancia().contenido.size());
      System.out.println("No hay datos ingresados!!!\nPor favor espere...");//mostramos un mensaje que no hay datos
      PasswordsLibrary.getInstancia().esperar(5000);//luego de 5 segundos limpiamos la pantalla y regresamos al menu principal
      PasswordsLibrary.getInstancia().limpiarPantalla();
      PasswordsLibrary.getInstancia().menu();//regresamos al menu principal
    }
    System.out.println();

    /*recorrer y desplegar textos del hashtable*/
    for (Map.Entry<Integer, User> entry : contenido.entrySet()) {
      //System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue());
      System.out.println("ID: "+entry.getKey() + " "+entry.getValue());
    }
  }

  public void delete(String username){
    try {

      if (username.length()>=0 ) {
        contenido.remove(username);
      }else{
        System.out.println("El username no puede estar vacio");
      }
    }catch(Exception UserDoesNotExistsException){
      System.out.println("Se produjo el siguiente error: UserDoesNotExistsException. El usuario no existe");
    }
  }

  public void search(String username){
    try {
      if (UserTable.getInstancia(). getContenido().containsKey(Integer.parseInt(username)) ) {
        System.out.println("El resultado es: "+true+ " El username se encontro");
      }else {
        System.out.println("El resultado es: "+false+ " ERROR!!! El username NO esta contenido ");
      }
    }catch (Exception e) {
      System.out.println("Se produjo el siguiente error: "+e.getMessage());
    }
  }
}
