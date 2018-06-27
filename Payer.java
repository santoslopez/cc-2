import java.lang.Thread;
import java.util.LinkedList;

public class Payer implements Runnable{
  private static LinkedList estado301;

  public LinkedList getEstado301(){
    return estado301;
  }

  private int tiempoDesencolarEstado300;

  private VerificadorDeTransacciones v1 = new VerificadorDeTransacciones();

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
        //System.out.println("--------------------------------------------------------------------");
        int i = estado301.size();
        String s = String.valueOf(i);
        MenuPrincipal.getInstancia().modeloListaEstado301.addElement(s);
      }
    }catch (Exception e) {
      System.out.println("Se produjo el siguiente error-------->: "+e.getMessage());
    }

  }
}
