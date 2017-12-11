import java.util.Scanner;
import java.util.regex.*;//necesario para las expresiones regulares

public class PasswordsLibrary{
  //la variable escaner va permitir pedir los datos
  private static Scanner escaner = new Scanner(System.in);

  //variable que almacena los datos ingresados como opcion del menu principal
  private static String opcionIngresado="";

  /*vamos averiguar que sistema operativo estamos utilizando para usar un comando para limpiar la terminal*/
  private static String sistemaOperativo = System.getProperty("os.name").toLowerCase();

  //patron de diseno singleton para crear una sola instancia de la clase
  private static PasswordsLibrary instancia;
  public static PasswordsLibrary getInstancia(){
    if (instancia==null) {
      instancia=new PasswordsLibrary();
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
      if (PasswordsLibrary.getInstancia().getSistemaOperativo().indexOf("win")>=0 ) {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

      //si nuestro sistema operativo es Linux
      }else if (PasswordsLibrary.getInstancia().getSistemaOperativo().indexOf("lin")>=0) {
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
    PasswordsLibrary.getInstancia().limpiarPantalla();
    System.out.println("1. Ingresar usuarios\n2. Buscar passwords\n3. Listar datos\n4. Eliminar usuarios\n5. Salir\n");
  }

  //metodo principal
  public static void main(String[] args) {
    //insertamos 12 datos en el hashmap (valores por defecto) en caso si el correo nombre y password tiene el formato correcto
    UserTable.getInstancia().insert("brian@cs.harvard.edu","Brian Yu","harvard");
    UserTable.getInstancia().insert("kzidane@cs50.harvard.edu","Kareem Zidane","staff");
    UserTable.getInstancia().insert("emc@cs50.harvard.edu","Erin Carvalho","edx");
    UserTable.getInstancia().insert("malan@harvard.edu","David J. Malan","teacher");
    UserTable.getInstancia().insert("santoslopez@galileo.edu","Santos Lopez","cool");
    UserTable.getInstancia().insert("santoslopeztzoy@gmail.com","Santos Lopez","pc");
    UserTable.getInstancia().insert("lopeztzoy@gmail.com","Santos Lopez","carro");
    UserTable.getInstancia().insert("santoslopez@github.com","Santos Lopez Tzoy","slt");
    UserTable.getInstancia().insert("nodisponible@github.com","No disponible","no");
    UserTable.getInstancia().insert("taylorswitf@inventado.ndi","Taylor Swift","swift");
    //desplegamos el menu principal
    PasswordsLibrary.getInstancia().menu();


    //Ciclo para siempre estar en el menu al menos que le indiquemos al programa que deseamos salirnos
    while (true) {
      opcionIngresado = escaner.nextLine();
      //verificamos por medio de expresiones regulares que la opcion ingresada sea la correcta
      if (Pattern.matches("[0-5]",opcionIngresado)) {
        switch (opcionIngresado) {
          case "1":
          System.out.println("**********Registrar usuario**********");
          System.out.println("Ingresar correo electronico: ");
          String correo = escaner.nextLine();
          System.out.println("Ingresar nombre: ");
          String nombre = escaner.nextLine();
          System.out.println("Ingresar password: ");
          String password = escaner.nextLine();
          //insertamos los datos en el hashmap en caso si el correo nombre y password tiene el formato correcto
          UserTable.getInstancia().insert(correo,nombre,password);
          //luego de 3 segundos limpiamos la pantalla y regresamos al menu principal
          PasswordsLibrary.getInstancia().esperar(3000);
          PasswordsLibrary.getInstancia().limpiarPantalla();//limpiamos la pantalla
          PasswordsLibrary.getInstancia().menu();//regresamos al menu principal
          break;

          case "2":
          UserTable.getInstancia().listar();
          System.out.println("\nIngrese username por ID: ");
          String buscarID = escaner.nextLine();
          UserTable.getInstancia().search(buscarID);
          //luego de 3 segundos limpiamos la pantalla y regresamos al menu principal
          PasswordsLibrary.getInstancia().esperar(3000);
          PasswordsLibrary.getInstancia().limpiarPantalla();//limpiamos la pantalla
          PasswordsLibrary.getInstancia().menu();//regresamos al menu principal
          break;

          case "3":
          UserTable.getInstancia().listar();
          System.out.println("\nPor favor espere\nRegresando a menu principal...");
          PasswordsLibrary.getInstancia().esperar(7000);//luego de 5 segundos limpiamos la pantalla y regresamos al menu principal
          PasswordsLibrary.getInstancia().limpiarPantalla();
          PasswordsLibrary.getInstancia().menu();

          break;

          case "4":
          UserTable.getInstancia().listar();
          System.out.println("\n\nIngrese el ID del usuario a eliminar: ");
          String idEliminar = escaner.nextLine();
          UserTable.getInstancia().delete(idEliminar);
          PasswordsLibrary.getInstancia().esperar(5000);//luego de 2 segundos limpiamos la pantalla y regresamos al menu principal
          PasswordsLibrary.getInstancia().limpiarPantalla();
          PasswordsLibrary.getInstancia().menu();
          break;

          case "5":
          System.out.println("Saliendo del programa...\nPor favor espere...");
          PasswordsLibrary.getInstancia().esperar(2000);//luego de 2 segundos limpiamos la pantalla y regresamos al menu principal
          PasswordsLibrary.getInstancia().limpiarPantalla();
          System.exit(0);
          break;
          default:
          System.out.println("Opcion no valida\nPor favor espere...");
          PasswordsLibrary.getInstancia().esperar(2000);//luego de 2 segundos limpiamos la pantalla y regresamos al menu principal
          PasswordsLibrary.getInstancia().limpiarPantalla();
          PasswordsLibrary.getInstancia().menu();
          break;
        }
      }else{
        System.out.println("ERROR!!! La opcion ingresado es invalido\nPor favor espere...");
        PasswordsLibrary.getInstancia().esperar(2000);//luego de 2 segundos limpiamos la pantalla y regresamos al menu principal
        PasswordsLibrary.getInstancia().limpiarPantalla();
        PasswordsLibrary.getInstancia().menu();
      }
    }
  }
}
