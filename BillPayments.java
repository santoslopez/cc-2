/*
Clase BillPayments.java que ejecuta todo el programa
*/

import java.util.regex.Pattern;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BillPayments{

  public static Thread [] generador;
  public Thread [] getAllHilos(){
    return generador;
  }

  //patron de diseno singleton para crear una sola instancia de la clase
  private static BillPayments instancia;
  public static BillPayments getInstancia(){
    if (instancia==null) {
      instancia=new BillPayments();
    }
    return instancia;
  }


  static final String tiempoGeneradorTransacciones="Tiempo de Generador de Transacciones: ";
  static final String tiempoProcesadorTransacciones="Tiempo de Procesador de Transacciones: ";
  static final String tiempoVerificadorTransacciones="Verificador de Transacciones: ";
  static final String tiempoPayer="Tiempo del Payer: ";

  public static void main(String[] args) {
    //limpiamos la consola
    LimpiarConsola.getInstancia().ejecutar();

    int numeroArgumentos = args.length;
    //verificamos la cantidad de argumentos ingresados
    switch (numeroArgumentos) {
      case 0:
      System.out.println("ERROR!!! No ingreso ningun argumento");
      break;

      case 4:

      if ((Pattern.matches("[0-9]+",args[0])) && (Pattern.matches("[0-9]+",args[1])) && (Pattern.matches("[0-9]+",args[2])) && (Pattern.matches("[0-9]+",args[3]))){
        try {
          LimpiarConsola.getInstancia().ejecutar();
          //mandamos a llamar el menu principal
          MenuPrincipal.getInstancia().ejecutar();

          Thread t1 = new Thread(new GeneradorDeTransacciones());
          Thread t2 = new Thread(new ProcesadorDeTransaccionesNuevas());
          Thread t3 = new Thread(new VerificadorDeTransacciones());

          generador = new Thread[]{t1,t2,t3};

          for (int i=0;i<generador.length;i++ ) {
            generador[i].start();
          }

        }catch (Exception e) {
          System.out.println("Se produjo el siguiente error: "+e.getMessage());
        }
      }else {
        System.out.println("Por favor verifique que todos los tiempos ingresados son correctos: ");
        System.out.println(tiempoGeneradorTransacciones+"-> " +args[0]);
        System.out.println(tiempoProcesadorTransacciones+"-> "+args[1]);
        System.out.println(tiempoVerificadorTransacciones+"-> "+args[2]);
        System.out.println(tiempoPayer+"-> "+args[3]);
      }
      break;

      //cantidad argumento invalido
      default:
      System.out.println("ERROR!!! La cantidad de argumentos es invalido");
      break;
    }
  }

}
