import java.net.*;
import java.io.*;

public class ConectorCliente extends Thread{
  private Socket socket;
  private ServerSocket serverSocket;
  private InputStreamReader entradaSocket;
  private DataOutputStream salida;
  private BufferedReader entrada;

  public ConectorCliente(){
    try {
      socket = new Socket(Parametros.getInstancia().getDireccionIP(),Parametros.getInstancia().getNumeroPuerto());
      //creacion de entrada de datos para lectura de mensajes
      entradaSocket = new InputStreamReader(socket.getInputStream());
      entrada = new BufferedReader(entradaSocket);

      //creacion de salida de datos para el envio de mensajes
      salida = new DataOutputStream(socket.getOutputStream());
      salida.writeUTF("Ya estoy conectado!!!\n");
    }catch (Exception e) {
      System.out.println("Se produjo el siguiente error: "+e.getMessage());
    }
  }

  public void run(){
    String texto;
    while (true) {
      try {
        texto=entrada.readLine();
        System.out.println(texto+"\n");
      }catch (Exception e) {
        System.out.println("Se produjo el siguiente error: "+e.getMessage());
      }
    }
  }

  public void enviarMensaje(String username,String mensaje){
    try {
      //salida = new DataOutputStream(socket.getOutputStream());
      salida.writeUTF(username+" :"+mensaje+"\n");
    }catch (Exception e) {
      System.out.println("Se produjo el siguiente error: "+e.getMessage());
    }
  }

  public String leerMensaje(){
    try {
      return entrada.readLine();
    }catch (Exception e) {

    }
    return null;
  }
}
