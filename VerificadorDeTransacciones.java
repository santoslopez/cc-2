import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.LinkedList;
import java.lang.Thread;
import java.text.SimpleDateFormat;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;


public class VerificadorDeTransacciones implements Runnable{
  private final Logger logArchivo = Logger.getLogger("VerificadorDeTransacciones");
  private String mensaje="";

  private Handler consoleHandler;
  private Handler fileHandler;
  private SimpleFormatter simpleFormatter;

  public static String getError(Exception e) {
    StringWriter sWriter = new StringWriter();
    PrintWriter pWriter = new PrintWriter(sWriter);
    e.printStackTrace(pWriter);
    return sWriter.toString();
  }

  private int tiempoDesencolarEstado200;

  //en esta estructura vamos a ir almacenando los valores provinientes del estado 200 (montos mayores a 0)
  private static ConcurrentLinkedQueue<Datos> estado300 = new ConcurrentLinkedQueue<Datos>();

  //creamos una instancia de la clase ProcesadorDeTransaccionesNuevas
  private ProcesadorDeTransaccionesNuevas g = new ProcesadorDeTransaccionesNuevas();

  //Lista donde almacenamos los datos que son invalidos (menores a 0) provinientes de la cola 200
  private static LinkedList<Datos> estado201 = new LinkedList<Datos>();

  //devolvemos la lista
  public LinkedList<Datos> getEstado201(){
    return this.estado201;
  }

  //devolvemos la cola 300
  public static ConcurrentLinkedQueue<Datos> getEstado300(){
    return estado300;
  }

  public VerificadorDeTransacciones(){}

  public VerificadorDeTransacciones(int tiempoDesencolarEstado200){
    this.tiempoDesencolarEstado200=tiempoDesencolarEstado200;
  }

  @Override
  public void run(){
    this.ejecutar(tiempoDesencolarEstado200);
  }

  public void ejecutar(int tiempoDesencolarEstado200){
    try {

      consoleHandler = new ConsoleHandler();
      fileHandler = new FileHandler("./informacion-transacciones.log", true);

      fileHandler.setFormatter(new SimpleFormatter());
      logArchivo.addHandler(fileHandler);
      consoleHandler.setLevel(Level.ALL);
      fileHandler.setLevel(Level.ALL);

      //id inicial de la transaccion
      logArchivo.log(Level.INFO, "Bitacora inicializada");


      while (true) {
        //verificamos que por lo menos hay colas en el estado 100
        if (g.getEstado200().size()<=0) {
          System.out.println(" El  no realizo nada. No hay datos en el estado 100");
          //despues de este tiempo empezamos a agregar el primer dato
          Thread.sleep(500);
          //si en nuestra cola si hay datos
        }else {
          Datos dato = g.getEstado200().peek();
          //si el monto es mayor a 0 lo enviamos al estado 300
          if (dato.getMonto()>0) {
            estado300.add(dato);
            mensaje="Movimiento del estado 200 al 300!!!!! Dato agregado: "+dato;

            logArchivo.log(Level.INFO, mensaje);
            //enviamos los datos al JList del estado 200 en la intefaz grafica al estado 300
            MenuPrincipal.getInstancia().modeloListaEstado300.addElement(String.valueOf(dato));

            //removemos en el JList del estado 200 el dato que se envio al estado 300
            MenuPrincipal.getInstancia().modeloListaEstado200.remove(0);

            g.getEstado200().poll();//quitamos el dato en el estado 100 que enviamos al estado 200

            //si el monto es menor lo enviamos al estado 201
          }else {
            estado201.add(dato);
            mensaje="Estado 201 activo, recibio el dato: "+dato + " del estado 200";
            logArchivo.log(Level.INFO, mensaje);
            //enviamos los datos al JList del estado 200 en la intefaz grafica
            MenuPrincipal.getInstancia().modeloListaEstado201.addElement(String.valueOf(dato));

            MenuPrincipal.getInstancia().modeloListaEstado200.remove(0);
            g.getEstado200().poll();//lo eliminamos dle estado 200
          }
          Thread.sleep(tiempoDesencolarEstado200);
        }
      }
    }catch (Exception e) {
      mensaje = "Se produjo el siguiente error: "+e.getMessage();
      logArchivo.log(Level.SEVERE, VerificadorDeTransacciones.getError(e));
    }
  }

}
