import java.util.*;
import java.io.*;
import java.net.*;

public class ConectorServidor extends Thread{

  //constructor vacio
  public ConectorServidor(){

  }

  //patron de diseno singleton para crear una sola instancia de la clase
  private static ConectorServidor instancia;
  public static ConectorServidor getInstancia(){
    if (instancia==null) {
      instancia=new ConectorServidor();
    }
    return instancia;
  }

  private Socket socket;
  private ServerSocket serverSocket;
  private InputStreamReader entradaSocket;
  //salida de datos
  private DataOutputStream salida;
  private BufferedReader entrada;

  public ConectorServidor(String nombre){
    super(nombre);
  }

  public void run(){
    String text="text";
    try{
      serverSocket = new ServerSocket(Parametros.getInstancia().getNumeroPuerto());

      //generamos una conexion cuando el cliente se conecta al servidor
      socket = serverSocket.accept();

      //creacion de entrada de datos para lectura de datos
      entradaSocket = new InputStreamReader(socket.getInputStream());
      //leemos datos
      entrada = new BufferedReader(entradaSocket);

      //creacion de salida de datos para el envio de mensajes
      salida = new DataOutputStream(socket.getOutputStream());

      while (true) {
        text = entrada.readLine();
        System.out.println(text+"\n");
      }
    }catch(Exception exception){
      System.out.println("Se produjo el siguiente error servidor: "+exception.getMessage());
    }
  }

  public void enviarMensaje(String nombreUsuario,String mensaje){
    try{
      //enviamos mensajes de cualquier tipo
      salida.writeUTF(nombreUsuario+": "+mensaje+"\n");
    }catch (IOException e) {
      System.out.println("Se produjo el siguiente error: "+e.getMessage());
    }
  }


  public String leerMensaje(){
    try {
      //lee una linea de texto que nos haya enviado el emisor
      return entrada.readLine();
    }catch (IOException e) {
      System.out.println("Se produjo el siguiente error: "+e.getMessage());
    }
    return null;
  }

  public void desconectar(){
    try {
      //cerramos la conexion
      socket.close();
      //cerramos conexion del servidor
      serverSocket.close();
    }catch (Exception e) {
      System.out.println("Se produjo el siguiente error: "+e.getMessage());
    }
  }
}
