import java.util.Scanner;
import java.util.regex.*;//necesario para las expresiones regulares
import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Admin{


  //variable que almacena los datos ingresados como opcion del menu principal
  private static String opcionIngresado="";

  /*vamos averiguar que sistema operativo estamos utilizando para usar un comando para limpiar la terminal*/
  private static String sistemaOperativo = System.getProperty("os.name").toLowerCase();

  //patron de diseno singleton para crear una sola instancia de la clase
  private static Admin instancia;
  public static Admin getInstancia(){
    if (instancia==null) {
      instancia=new Admin();
    }
    return instancia;
  }

  //despues de cierto tiempo quitamos el mensaje de error (opcion invalida del menu, etc);
  public void esperar(int tiempo){
    try {
      Thread.sleep(tiempo);
    }catch(Exception ex){
      System.out.println("Se produjo el siguiente error: "+ex.getMessage());
    }
  }

  //devolvemos el nombre del sistema operativo
  public String getSistemaOperativo(){
    return sistemaOperativo;
  }

  //para limpiar la pantalla de la consola
  public void limpiarPantalla(){
    try {
      //si nuestro sistema operativo es Windows
      if (Admin.getInstancia().getSistemaOperativo().indexOf("win")>=0 ) {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

      //si nuestro sistema operativo es Linux
      }else if (Admin.getInstancia().getSistemaOperativo().indexOf("lin")>=0) {
        //System.out.print("\033[H\033[2J");//realmente no limpia ubuntu unicamente hace un salto de varias lineas

        //limpiamos la pantalla
        System.out.print("\033\143");
        System.out.flush();
      }{
      }
    }catch(Exception exception){
      System.out.println("Se produjo el siguiente error: "+exception.getMessage());
    }
  }

  //metodo que nos despliega el menu principal
  public void menu(){
    Admin.getInstancia().limpiarPantalla();
    System.out.println("1. Ingresar usuarios\n2. Buscar passwords\n3. Listar datos\n4. Eliminar usuarios\n5. Salir\n");
  }

  //metodo principal
  public static void main(String[] args) throws IOException{
    //desplegamos el menu principal
    Admin.getInstancia().menu();
    BufferedReader lectura = new BufferedReader(new InputStreamReader(System.in));

    //Ciclo para siempre estar en el menu al menos que le indiquemos al programa que deseamos salirnos
    while (true) {
      String opcionIngresado = lectura.readLine();
      //verificamos por medio de expresiones regulares que la opcion ingresada sea la correcta
        switch (opcionIngresado) {
          case "1":
          System.out.println("**********Registrar usuario**********");
          System.out.println("Ingresar correo electronico: ");
          String correo = lectura.readLine();
          //variable que la usamos para continuar preguntando los datos si el usuario NO EXISTE
          boolean continuar = true;
          //verificamos si el correo ya existe
          Set<Integer> k = TablaUsuarios.getInstancia().getContenido().keySet();
          for (Integer key: k) {
            Usuario usuario=TablaUsuarios.getInstancia().getContenido().get(key);
            //si en cualquiera de las posiciones encontramos el dato
            if (usuario.getUsuarioCorreo().equals(correo)) {
              System.out.println("El username ya existe:");
              System.out.println("Regresando al menu principal!!!");
              continuar = false;//ya no preguntamos los datos
              LimpiarConsola.getInstancia().mensaje(1000);
              LimpiarConsola.getInstancia().limpiar();
              Admin.getInstancia().menu();
            }
          }
          //seguimos preguntando los datos porque el usuario ingresado no existe
          if (continuar==true) {
            System.out.println("Ingresar nombre: ");
            String nombre = lectura.readLine();
            System.out.println("Ingresar password: ");
            String password = lectura.readLine();
            //insertamos los datos en el hashmap en caso si el correo nombre y password tiene el formato correcto
            TablaUsuarios.getInstancia().insert(correo,nombre,password);
            //luego de 3 segundos limpiamos la pantalla y regresamos al menu principal
            Admin.getInstancia().esperar(3000);
            Admin.getInstancia().limpiarPantalla();//limpiamos la pantalla
            Admin.getInstancia().menu();//regresamos al menu principal
          }

          break;

          case "2":
          System.out.println("\nIngrese el correo electronico del usuario a buscar: ");
          String buscarUsername = lectura.readLine();
          TablaUsuarios.getInstancia().search(buscarUsername);
          //luego de 3 segundos limpiamos la pantalla y regresamos al menu principal
          Admin.getInstancia().esperar(3000);
          Admin.getInstancia().limpiarPantalla();//limpiamos la pantalla
          Admin.getInstancia().menu();//regresamos al menu principal
          break;

          case "3":
          TablaUsuarios.getInstancia().listar();
          System.out.println("\nPor favor espere\nRegresando a menu principal...");
          Admin.getInstancia().esperar(3000);//luego de 3 segundos limpiamos la pantalla y regresamos al menu principal
          Admin.getInstancia().limpiarPantalla();
          Admin.getInstancia().menu();

          break;

          case "4":
          System.out.println("\n\nIngrese el correo electronico del usuario a eliminar: ");
          String usernameEliminar = lectura.readLine();
          TablaUsuarios.getInstancia().delete(usernameEliminar);
          Admin.getInstancia().esperar(3000);//luego de 2 segundos limpiamos la pantalla y regresamos al menu principal
          Admin.getInstancia().limpiarPantalla();
          Admin.getInstancia().menu();
          break;

          case "5":
          System.out.println("Saliendo del programa...\nPor favor espere...");
          Admin.getInstancia().esperar(1000);//luego de 2 segundos limpiamos la pantalla y regresamos al menu principal
          Admin.getInstancia().limpiarPantalla();
          System.exit(0);
          break;
          default:
          System.out.println("Opcion no valida\nPor favor espere...");
          Admin.getInstancia().esperar(2000);//luego de 2 segundos limpiamos la pantalla y regresamos al menu principal
          Admin.getInstancia().limpiarPantalla();
          Admin.getInstancia().menu();
          break;
        }
    }
  }
}
