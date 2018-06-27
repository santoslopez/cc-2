import java.util.concurrent.ConcurrentLinkedQueue;
import java.lang.Thread;

public class GeneradorDeTransacciones implements Runnable{
  private int tiempo;

  //variable donde almacenamos el id correlativo de la cola
  private int id=0;

  //cola donde almacenamos los datos generados por el Generador de Transacciones
  private static ConcurrentLinkedQueue<Datos> estado100 = new ConcurrentLinkedQueue<Datos>();

  //devolvemos la cola
  public ConcurrentLinkedQueue<Datos> getEstado100(){
    return estado100;
  }

  public GeneradorDeTransacciones(int tiempo){
    this.tiempo=tiempo;
  }


  public GeneradorDeTransacciones(){}


  /*

  El cual se encarga de generar transacciones y colocarlas en la cola de Estado 100.
  Las transacciones se representan por un numero correlativo y un monto a pagar (el cual puede ser negativo o 0).
  Estas transacciones son generadas en tiempos aleatorios.

  */

  public void ejecutar(int tiempo){
    try {
      //por siempre
      while (true) {
        //establecemos el limite del tiempo en que una nueva transaccion se generara
        int tiempoRandom = (int)(Math.random()*tiempo) + 1;

        id++;

        //Establecemos el rango del monto a generar
        int inicio = -1000;
        int fin =  10000;

        //numero con generado con rango
        double montoPagarConCifras = (double)(Math.random() * (fin - inicio)+inicio);

        //monto generado a pagar con 2 cifras significativas
        double montoPagar=Math.floor((double)((montoPagarConCifras)* 100)) / 100;

        //lo pasamos al constructor de la clase
        Datos generarDatos = new Datos(id,montoPagar);

        Thread.sleep(tiempoRandom);
        System.out.println(" Se ha generado una transaccion para el estado 100: "+generarDatos + " y se ha agregado");
        //lo agregamos a la cola del estado 100
        estado100.add(generarDatos);

        //Enviamos el dato al JList del estado 100
        MenuPrincipal.getInstancia().modeloListaEstado100.addElement(generarDatos);
      }
    }catch (Exception e) {
      System.out.println("Se produjo el siguiente error: "+e.getMessage());
    }
  }


  @Override
  public void run(){
    this.ejecutar(tiempo);
  }
}
