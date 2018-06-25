/*
TablaUsuarios.java esta clase representa la tabla de usuarios en el sistema
*/
import java.util.Hashtable;
import java.util.Enumeration;
import java.util.regex.Pattern;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;

public class TablaUsuarios{

  //patron de diseno singleton para crear una sola instancia de la clase
  private static TablaUsuarios instancia;
  public static TablaUsuarios getInstancia(){
    if (instancia==null) {
      instancia=new TablaUsuarios();
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
  private HashMap <Integer,Usuario> contenido = new HashMap<Integer,Usuario>();

  public HashMap<Integer, Usuario> getContenido() {
      return contenido;
  }


  public void insert(String user,String nombre,String password){
    if(!(Pattern.matches("[a-z]{1,}+[@][a-z0-9]{1,}+[.][a-z]{1,}+[.][a-z]{1,3}",user)|| (Pattern.matches("[a-z]{1,}+[@][a-z]{1,}+[.][a-z]{3}",user) ))){
      System.out.println("\nSe produjo la siguiente excepcion: InvalidUsernameException.\nEl correo no tiene un formato correcto\nPor favor espere...");
    }else if (!(Pattern.matches("[0-9a-zA-Z]{1,}+",password))) {
      System.out.println("\nSe produjo la siguiente excepcion: NullPasswordException\nEl password no puede estar vacio\nPor favor espere...");
    }else{
      Usuario agregarDatos = new Usuario(user,nombre,password);//pasamos los datos a guardar en el constructor de la clase User
      noElemento++;//incrementamos el valor del indice del HashMap
      //agregamos los datos al HashMap
      TablaUsuarios.getInstancia().contenido.put(this.getNumeroElemento(),agregarDatos);
      System.out.println("El dato fue agregado correctamente!!!");
    }
  }

  //verificamos si el Hashtable esta vacio o de lo contrario desplegamos su contenido
  public void listar(){
    contactosVacios();
    /*recorrer y desplegar textos del hashtable*/
    for (Map.Entry<Integer, Usuario> entry : contenido.entrySet()) {
      System.out.println("ID: "+entry.getKey() + " "+entry.getValue());
    }
  }

  //metodo para eliminar datos del HashMap
  public void delete(String username){
    contactosVacios();
    Set<Integer> k = contenido.keySet();
    for (Integer key: k) {
      Usuario usuario=contenido.get(key);
      //si en cualquiera de las posiciones encontramos el dato
      if (usuario.getUsuarioCorreo().equals(username)) {
        System.out.println("El username ha sido borrado!!!");
        //eliminamos el dato del HashMap
        contenido.remove(key);
        return;
      }
    }
    System.out.println("El username "+username+ " no existe. Limpiando la pantalla... ");
  }

  //metodo que despliega un mensaje al tener el hashtable vacio
  public void contactosVacios(){
    if (contenido.size()==0) {
      System.out.println("No hay datos ingresados!!!");
      return;
    }
  }

  public void search(String username){
    contactosVacios();
    Set<Integer> k = contenido.keySet();
    for (Integer key: k) {
      Usuario usuario=contenido.get(key);
      //si en cualquiera de las posiciones encontramos el dato
      if (usuario.getUsuarioCorreo().equals(username)) {
        System.out.println("El username fue encontrado. Sus datos son:");
        System.out.println(usuario.toString());
        return;
      }
    }
    System.out.println("El username "+username+ " no existe. Limpiando la pantalla... ");
  }
}
