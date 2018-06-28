import java.lang.Thread;
import java.util.LinkedList;

public class Payer implements Runnable{
  //Lista donde almacenamos el LinkedList del estado 301
  private static LinkedList<Datos> estado301 = new LinkedList<Datos>();


  //Lista donde almacenamos el LinkedList del estado 400
  private static LinkedList<Datos> estado400 = new LinkedList<Datos>();

  public LinkedList getEstado301(){
    return estado301;
  }

  public  LinkedList getEstado400(){
    return estado400;
  }

  private int tiempoDesencolarEstado300;

  private static VerificadorDeTransacciones verificador = new VerificadorDeTransacciones();

  //constructor vacio
  public Payer(){}

  public Payer(int tiempoDesencolarEstado300){
    this.tiempoDesencolarEstado300=tiempoDesencolarEstado300;
  }

  public void run(){
    this.ejecutar(tiempoDesencolarEstado300);
  }

  public void ejecutar(int tiempoDesencolarEstado300){
    try {
      while (true) {
        Thread.sleep(tiempoDesencolarEstado300);
        if (verificador.getEstado300().size()==0) {
          System.out.println("NO hay cola en el estado 300");
        }else {

          int porcentajeError = (int)(Math.random()*100);
          Datos d = verificador.getEstado300().peek();

          //si el numero generado es menor o igual a 20 lo enviamos a la lista de error 301
          if (porcentajeError<=20) {
            String dato = String.valueOf(d);
            MenuPrincipal.getInstancia().modeloListaEstado301.addElement(dato);
            estado301.add(d);
            verificador.getEstado300().poll();
            MenuPrincipal.getInstancia().modeloListaEstado300.remove(0);

          }else {
            String datoExitoso = String.valueOf(d);
            MenuPrincipal.getInstancia().modeloListaEstado400.addElement(datoExitoso);
            //agregamos el dato al estado 400
            estado400.add(d);

            //eliminamos el dato de la cola del estado 300
            verificador.getEstado300().poll();
            //eliminamos el dato del JList del estado 300
            MenuPrincipal.getInstancia().modeloListaEstado300.remove(0);
          }

        }
      }
    }catch (Exception e) {
      System.out.println("Se produjo el siguiente error-------->: "+e.getMessage());
    }

  }
}
