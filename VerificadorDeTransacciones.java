import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.LinkedList;
import java.lang.Thread;

public class VerificadorDeTransacciones implements Runnable{

  //en esta estructura vamos a ir almacenando los valores provinientes del estado 200 (montos mayores a 0)
  private ConcurrentLinkedQueue<Datos> estado300 = new ConcurrentLinkedQueue<Datos>();

  //creamos una instancia de la clase ProcesadorDeTransaccionesNuevas
  private ProcesadorDeTransaccionesNuevas g = new ProcesadorDeTransaccionesNuevas();

  //Lista donde almacenamos los datos que son invalidos (menores a 0) provinientes de la cola 200
  private LinkedList<Datos> estado201 = new LinkedList<Datos>();

  @Override
  public void run(){
    this.ejecutar();
  }

  public void ejecutar(){
    try {
      while (true) {
        //verificamos que por lo menos hay colas en el estado 100
        if (g.getEstado200().size()<=0) {
          System.out.println(" El  no realizo nada. No hay datos en el estado 100");
          //despues de este tiempo empezamos a agregar el primer dato
          Thread.sleep(7000);
          //si en nuestra cola si hay datos
        }else {
          Datos dato = g.getEstado200().peek();
          //si el monto es mayor a 0 lo enviamos al estado 300
          if (dato.getMonto()>0) {
            estado300.add(dato);
            System.out.println("Movimiento del estado 200 al 300!!!!! Dato agregado: "+dato);
            //enviamos los datos al JList del estado 200 en la intefaz grafica al estado 300
            MenuPrincipal.getInstancia().modeloListaEstado300.addElement(String.valueOf(dato));

            //removemos en el JList del estado 200 el dato que se envio al estado 300
            MenuPrincipal.getInstancia().modeloListaEstado200.remove(0);

            g.getEstado200().poll();//quitamos el dato en el estado 100 que enviamos al estado 200

            //si el monto es menor lo enviamos al estado 201
          }else {
            estado201.add(dato);
            System.out.println("Estado 201 activo, recibio el dato: "+dato + " del estado 200");

            //enviamos los datos al JList del estado 200 en la intefaz grafica
            MenuPrincipal.getInstancia().modeloListaEstado201.addElement(String.valueOf(dato));

            MenuPrincipal.getInstancia().modeloListaEstado200.remove(0);
            g.getEstado200().poll();//lo eliminamos dle estado 200
          }
          Thread.sleep(1000);
        }
      }
    }catch (Exception e) {
      System.out.println("Se produjo el siguiente error: "+e.getMessage());
    }
  }

}
