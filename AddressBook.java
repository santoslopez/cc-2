import java.util.Hashtable;
import java.util.Enumeration;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class AddressBook{
  //patron de diseno singleton para crear una sola instancia de la clase
  private static AddressBook instancia;
  public static AddressBook getInstancia(){
    if (instancia==null) {
      instancia=new AddressBook();
    }
    return instancia;
  }

  //HashMap donde vamos a ir agregando datos, buscando, eliminando y listando
  private HashMap<Integer,Contact> listadoHashMap = new HashMap<Integer,Contact>();

  //variable que representa la llave en el HashMap al ingresar un contacto se incrementa
  private Integer contador=0;

  public void buscarContacto(String nombre){
    contactosVacios();
    Set<Integer> k = listadoHashMap.keySet();
    for (Integer key: k) {
      Contact contacto=listadoHashMap.get(key);
      if (contacto.getNombre().equals(nombre)) {
        System.out.println("El usuario fue encontrado. Sus datos son:");
        System.out.println("Nombre: "+contacto.toString());
        System.out.println("Regresando al menu principal... Cargando");
        return;
      }
    }
    System.out.println("El usuario "+nombre+ " no existe. Limpiando la pantalla... ");
  }


  public void eliminarContacto(String nombre){
    contactosVacios();
    Set<Integer> k = listadoHashMap.keySet();
    for (Integer key: k) {
      Contact contacto=listadoHashMap.get(key);
      if (contacto.getNombre().equals(nombre)) {
        System.out.println("El usuario fue encontrado. Sus datos son:");
        System.out.println(contacto.toString());
        listadoHashMap.remove(key);
        System.out.println("USUARIO ELIMINADO!!!");
        System.out.println("\nRegresando al menu principal... Cargando");
        return;
      }
    }
    System.out.println("El usuario "+nombre+ " no existe. \nLimpiando la pantalla... ");
  }

  public void contactosVacios(){
    if (listadoHashMap.size()==0) {
      System.out.println("No hay datos ingresados!!!\nLimpiando la pantalla...Cargando");
      return;
    }
  }

  public void listarContactos(){
    contactosVacios();
    Integer key;
    Iterator<Integer> lista = listadoHashMap.keySet().iterator();
    while (lista.hasNext()) {
      System.out.println("Datos: ");
      key = lista.next();
      System.out.println("ID: "+key + " "+listadoHashMap.get(key));
    }
  }

  public void menu(){
    try {
      System.out.println("1. Ingresar contacto");
      System.out.println("2. Buscar contacto");
      System.out.println("3. Eliminar contacto");
      System.out.println("4. Listar contactos");
      System.out.println("5. Salir");
      BufferedReader lect = new BufferedReader(new InputStreamReader(System.in));
      System.out.println("Ingrese el numero de opcion: ");
      String opcion = lect.readLine();

      switch (opcion) {
        case "1":
        System.out.println("Ingrese su nombre: ");
        String nombre = lect.readLine();
        Set<Integer> clave = listadoHashMap.keySet();
        for (Integer key: clave) {
          Contact contacto=listadoHashMap.get(key);
          if (contacto.getNombre().equals(nombre)) {
            System.out.println("El usuario fue encontrado. Sus datos son:");
            System.out.println(contacto.toString());

            //boolean salir = true;
            while(true){
              System.out.println("Desea ingresar un nuevo numero para el contacto\n Escriba si o no (solo la palabra)");
              String confirmar = lect.readLine();
              //si la opcion ingresada es no regresamos al menu principal
              if (confirmar.toLowerCase().equals("no")) {
                System.out.println("Regresando al menu principal!!!");
                LimpiarConsola.getInstancia().mensaje(1000);
                LimpiarConsola.getInstancia().limpiar();
                AddressBook.getInstancia().menu();
              }else if (confirmar.toLowerCase().equals("si")) {
                System.out.println("Ingrese el OTRO telefono del contacto: ");
                String otroTelefono = lect.readLine();
                contacto.addTelefono(otroTelefono);
                System.out.println("El telefono FUE agregado correctamente!!!\nRegresando al menu principal");
                LimpiarConsola.getInstancia().mensaje(1000);
                LimpiarConsola.getInstancia().limpiar();
                AddressBook.getInstancia().menu();
              }else {
                System.out.println("La opcion ingresada: "+confirmar + " es incorrecta!!!");
                System.out.println("Solo escriba la palabra si o no");
              }
            }
            //return;
          }
        }
        System.out.println("Ingrese su direccion: ");
        String direccion = lect.readLine();
        System.out.println("Ingrese su telefono: ");
        String telefono = lect.readLine();
        Contact contacto = new Contact(nombre,direccion,telefono);
        System.out.println("El contacto se agrego");
        contador++;
        listadoHashMap.put(contador,contacto);
        LimpiarConsola.getInstancia().mensaje(1000);
        LimpiarConsola.getInstancia().limpiar();
        AddressBook.getInstancia().menu();
        break;

        case "2":
        System.out.println("Ingrese el nombre del contacto a buscar: ");
        String buscarContacto = lect.readLine();
        AddressBook.getInstancia().buscarContacto(buscarContacto);
        LimpiarConsola.getInstancia().mensaje(3000);
        LimpiarConsola.getInstancia().limpiar();
        AddressBook.getInstancia().menu();
        break;

        case "3":
        System.out.println("Ingrese el nombre del contacto a eliminar: ");
        String eliminarContacto = lect.readLine();
        AddressBook.getInstancia().eliminarContacto(eliminarContacto);
        LimpiarConsola.getInstancia().mensaje(3000);
        LimpiarConsola.getInstancia().limpiar();
        AddressBook.getInstancia().menu();
        break;

        case "4":
        AddressBook.getInstancia().listarContactos();
        LimpiarConsola.getInstancia().mensaje(3000);
        LimpiarConsola.getInstancia().limpiar();
        AddressBook.getInstancia().menu();
        break;

        case "5":
        System.exit(0);
        break;

        default:
        System.out.println("Opcion incorrecta!!!Por favor espere...Cargando...");
        LimpiarConsola.getInstancia().mensaje(1000);
        LimpiarConsola.getInstancia().limpiar();
        AddressBook.getInstancia().menu();
        break;


      }
    }catch (Exception e) {
      System.out.println("Se produjo el siguiente error: "+e.getMessage());
    }


  }


  public static void main(String[] args) {
    //limpiamos la consola
    LimpiarConsola.getInstancia().limpiar();
    //mostramos el menu
    AddressBook.getInstancia().menu();
  }
}


class LimpiarConsola{
  private static LimpiarConsola instancia;
  public static LimpiarConsola getInstancia(){
    if (instancia==null) {
      instancia=new LimpiarConsola();
    }
    return instancia;
  }

  private String sistemaOperativo = System.getProperty("os.name").toLowerCase();

  public void limpiar(){
    try {
      if (this.sistemaOperativo.indexOf("win")>=0) {
        new ProcessBuilder("cmd","c","/cls").inheritIO().start().waitFor();
      }else if (this.sistemaOperativo.indexOf("lin")>=0) {
        System.out.print("\033\143");
        System.out.flush();
      }
    }catch (Exception e) {
      System.out.println("Se produjo el siguiente error: "+e.getMessage());
    }
  }

  public void mensaje(int tiempo){
    try {
      Thread.sleep(tiempo);
    }catch (Exception e) {
      System.out.println("Se produjo el siguiente error: "+e.getMessage());
    }
  }
}
