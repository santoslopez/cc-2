import java.util.concurrent.ConcurrentLinkedQueue;
import java.lang.Thread;

public class ProcesadorDeTransaccionesNuevas implements Runnable{
  private int tiempoDesencolarTransaccionE100;


  //cola donde vamos a ir almacenando los datos pasados del estado 100 al 200
  private static ConcurrentLinkedQueue<Datos> estado200 = new ConcurrentLinkedQueue<Datos>();

  //devolvemos la cola
  public ConcurrentLinkedQueue<Datos> getEstado200(){
    return estado200;
  }

  public ProcesadorDeTransaccionesNuevas(int tiempoDesencolarTransaccionE100){
    this.tiempoDesencolarTransaccionE100=tiempoDesencolarTransaccionE100;
  }

  public ProcesadorDeTransaccionesNuevas(){}

  //creamos una instancia
  private GeneradorDeTransacciones g = new GeneradorDeTransacciones();

  @Override
  public void run(){
    this.ejecutar(tiempoDesencolarTransaccionE100);
  }

  /*

  Este saca transacciones en estado 100, una por una y las pasa a estado 200.
  El procesador saca transacciones cada cierto tiempo, y este es un tiempo fijo.

  */

  public void ejecutar(int tiempoDesencolarTransaccionE100){
    try {


      while (true) {
        //verificamos que por lo menos hay colas en el estado 100
        if (g.getEstado100().size()<=0) {
          System.out.println(" El  no realizo nada. No hay datos en el estado 100");
          Thread.sleep(1000);

        //si en nuestra cola si hay datos
        }else {
          Datos dato = g.getEstado100().peek();
          Thread.sleep(tiempoDesencolarTransaccionE100);
          //agregamos el dato el estado 200
          estado200.add(dato);
          System.out.println("Hubo un movimiento del estado 100 al 200!!!!! Dato agregado: "+dato);

          //enviamos los datos al JList del estado 200 en la intefaz grafica
          MenuPrincipal.getInstancia().modeloListaEstado200.addElement(String.valueOf(dato));

          MenuPrincipal.getInstancia().modeloListaEstado100.remove(0);

          g.getEstado100().poll();//quitamos el dato en el estado 100 que enviamos al estado 200

          //System.out.println(estado200);
        }
      }
    }catch (Exception e) {
      System.out.println("Se produjo el siguiente error: "+e.getMessage());
    }
  }

}
