/*
Clase Parametros.java que sirve para definir el puerto a utilizar, inicializacion de metodos de envio de mensaje,
direccion ip a utilizar y declaracion de algunas variables auxiliares
*/
import java.util.Scanner;

public class Parametros{
  //definimos el numero de puerto a utilizar en el programa
  private final int numeroPuerto = 2000;

  //definimos la direccion ip a utilizar
  private final String direccionIP="127.0.0.1";

  private Scanner escaner = new Scanner(System.in);

  public Scanner getEscaner(){
    return escaner;
  }

  //devolvemos la direccion ip a utilizar
  public String getDireccionIP(){
    return direccionIP;
  }

  //devolvemos el puerto a utilizar
  public int getNumeroPuerto(){
    return numeroPuerto;
  }

  //patron de diseno singleton para crear una sola instancia de la clase
  private static Parametros instancia;
  public static Parametros getInstancia(){
    if (instancia==null) {
      instancia = new Parametros();
    }
    return instancia;
  }
}
