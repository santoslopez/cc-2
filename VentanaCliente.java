import java.util.Scanner;

public class VentanaCliente{
  //variable donde vamos almacenar el mensaje
  private static String mensajeCliente="";

  private ConectorCliente cliente;
  public ConectorCliente getCliente(){
    return cliente;
  }

  //patron de diseno singleton para crear una sola instancia de la clase
  private static VentanaCliente instancia;
  public static VentanaCliente getInstancia(){
    if (instancia==null) {
      instancia=new VentanaCliente();
    }
    return instancia;
  }

  public void iniciarCliente(){
    cliente = new ConectorCliente();
    cliente.start();
  }

  //metodo principal
  public static void main(String[] args) {
    SistemaOperativo.getInstancia().limpiarPantalla();
    VentanaCliente.getInstancia().iniciarCliente();
    System.out.println("Cliente por favor ingrese su nombre de usuario: ");
    Scanner escaner = new Scanner(System.in);
    String username = escaner.nextLine();
    System.out.println("\n\nAhora puedes escribir mensajes. Presiona Enter para enviar el mensaje");
    while (true) {
      mensajeCliente = Parametros.getInstancia().getEscaner().nextLine();
      VentanaCliente.getInstancia().getCliente().enviarMensaje(username,mensajeCliente);
    }
  }

}
