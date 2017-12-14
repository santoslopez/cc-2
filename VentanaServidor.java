import java.util.Scanner;

public class VentanaServidor{
  //variable donde vamos almacenar el mensaje
  private static String mensajeServidor="";

  private ConectorServidor servidor;
  public ConectorServidor getServidor(){
    return servidor;
  }

  //patron de diseno singleton para crear una sola instancia de la clase
  private static VentanaServidor instancia;
  public static VentanaServidor getInstancia(){
    if (instancia==null) {
      instancia=new VentanaServidor();
    }
    return instancia;
  }

  public void iniciarServidor(){
    servidor = new ConectorServidor("Proceso de servidor...");
    servidor.start();
    System.out.println("El servidor se ha iniciado correctamente...");
    System.out.println("Esperando conexion de cliente");
  }

  //metodo principal
  public static void main(String[] args) {
    SistemaOperativo.getInstancia().limpiarPantalla();
    System.out.println("Servidor por favor ingrese su nombre de usuario: ");
    Scanner escaner = new Scanner(System.in);
    String username = escaner.nextLine();
    System.out.println("\n\nAhora puedes escribir mensajes. Presiona Enter para enviar el mensaje");
    VentanaServidor.getInstancia().iniciarServidor();
    while (true) {
      mensajeServidor = Parametros.getInstancia().getEscaner().nextLine();
      VentanaServidor.getInstancia().getServidor().enviarMensaje(username,mensajeServidor);
    }
  }

}
