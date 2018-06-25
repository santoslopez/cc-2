/*
Nombre: Santos Lopez Tzoy
Carnet: 15002241
Seccion: AN
2018
*/
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
import java.lang.*;
import java.util.regex.*;
public class Totito{

  private String sistemaOperativo = System.getProperty("os.name").toLowerCase();

  private BufferedReader lectura = new BufferedReader(new InputStreamReader(System.in));

  private static Totito instancia;

  //una matriz de 3x3 para representar al tablero
  private static String tablero[][]=new String[3][3];

  //aplicamos singleton para crear una unica instancia de la clase
  public static synchronized Totito getInstancia(){
    if(instancia==null){
      instancia=new Totito();
    }
    return instancia;
  }

  //metodo que sirve para darle la bienvenida al jugador
  public void welcome(){
    try {
      String jugador1 = "";
      String simboloJugador1="X";

      String jugador2 = "";
      String simboloJugador2="0";

      boolean salir = false;
      int noJugador = 0;
      while ((salir!=true)&& (noJugador<2)) {
        noJugador++;
        System.out.println("Ingrese el nombre del jugador NO. "+noJugador);
        String jugador = lectura.readLine();
        if (noJugador==1) {
          jugador1=jugador;
        }else if (noJugador==2) {
          jugador2=jugador;
        }
      }
      Totito.getInstancia().init();//por defecto cargamos los valores con los numeros del 1 al 9
      Totito.getInstancia().clear();
      System.out.println("Por favor espere...Cargando");
      Totito.getInstancia().tiempoEsperaMensaje(3000);
      Totito.getInstancia().clear();
      System.out.println("BIENVENIDO AL JUEGO DE TOTITO CC2 AN 2018 INTERCICLO");
      System.out.println("Informacion de jugadores: ");
      System.out.println("Jugador 1: "+jugador1);
      System.out.println("Jugador 2: "+jugador2);

      //generamos un numero aleatorio para saber que jugador empieza el juego
      Random r = new Random();
      int numeroGenerado = (int) (Math.random() * 2) + 1;

      //dibujamos el tablero actual
      Totito.getInstancia().draw();
      switch (numeroGenerado) {
        case 1:
        System.out.println("\nEmpieza primero: "+jugador1 +" le toca: X");
        Totito.getInstancia().init();//tablero inicial
        boolean saliendo2 = false;
        int i2 = 0;
        String simboloJugada = "";
        int noJugada = 0;
        while((saliendo2!=true) && (i2<=9) ){
          //System.out.println("Jugada numero: z"+i2++);
          i2++;
          noJugada = i2;
          if(Totito.getInstancia().winner(this.tablero,"X")==true) {
            System.out.println("Gano: "+jugador1);
            saliendo2 = true;
            System.exit(0);
          }else if  (Totito.getInstancia().winner(this.tablero,"O")==true) {
            System.out.println("Gano: "+jugador2);
            saliendo2 = true;
            System.exit(0);
          }else {
            System.out.println("\nHasta el momento sin ganador!!! \nJugada actual No."+noJugada);
          }
          System.out.println("Ingrese la posicion de la casilla: ");
          String casillaPosicion = lectura.readLine();
          if (Pattern.matches("[0-9]",casillaPosicion)) {

              //el primer jugador solo puede tener estas jugadas
              if ((i2==1)|| (i2==3)||(i2==5)|| (i2==7) || (i2==9)) {
                System.out.println(jugador1+" hizo su jugada. Turno del jugador: "+jugador2);
                Totito.getInstancia().tiempoEsperaMensaje(2000);
                simboloJugada="X";
                Totito.getInstancia().move(casillaPosicion,simboloJugada);
            }else {
              //el segundo jugador tiene las jugadas pares
              System.out.println(jugador2+" hizo su jugada. Turno del jugador: "+jugador1);
              Totito.getInstancia().tiempoEsperaMensaje(2000);
              simboloJugada="O";
              Totito.getInstancia().move(casillaPosicion,simboloJugada);
            }
          }else {

          }

          Totito.getInstancia().clear();
          Totito.getInstancia().draw();
        }
        break;

        case 2:
        System.out.println("\nEmpieza primero: "+jugador2 +" le toca: X");
        String simbolo="";
        Totito.getInstancia().init();//tablero inicial
        boolean saliendo = false;
        int i = 0;
        int numeroJugada = 0;
        while((saliendo!=true) && (i<=9)) {
          i++;
          noJugada = i;
          //System.out.println("Jugada numero: "+i++;
          if (((Totito.getInstancia().winner(this.tablero,"X")==true)) ) {
            saliendo = true;
            System.out.println("Gano: "+jugador2);
            System.exit(0);
            //return break;
          }else if (Totito.getInstancia().winner(this.tablero,"O")==true)  {
            saliendo = true;
            System.out.println("Gano: "+jugador1);
            System.exit(0);
          }else {
            System.out.println("\nHasta el momento sin ganador!!! \n Jugada actual No."+noJugada);
          }
          System.out.println("Ingrese la posicion de la casilla: ");
          String casillaPos = lectura.readLine();

          if (Pattern.matches("[0-9]",casillaPos)) {
            if ((i==1)|| (i==3)||(i==5)|| (i==7) || (i==9)) {
              System.out.println(jugador1+" hizo su jugada. Turno del jugador: "+jugador2);
              Totito.getInstancia().tiempoEsperaMensaje(2000);
              simbolo="X";
              Totito.getInstancia().move(casillaPos,simbolo);
            }else {
              System.out.println(jugador2+" hizo su jugada. Turno del jugador: "+jugador1);
              Totito.getInstancia().tiempoEsperaMensaje(2000);
              simbolo="O";
              Totito.getInstancia().move(casillaPos,simbolo);
            }
          }else {
            //POR CUESTIONES de borrado no se muestra el mensaje, y para no llamar tantas veces el mismo metodo lo dejo asi
            //System.out.println("El jugador desperdicio su turno!!!");
          }

          Totito.getInstancia().clear();
          Totito.getInstancia().draw();
        }
        break;

        default:
        System.out.println("Se produjo un error al generar un numero aleatorio para saber que jugador empieza");
        break;
      }

    }catch (Exception e) {
      System.out.println("Se produjo el siguiente error: "+e.getMessage());
    }
  }

  //tiempo que permitimos que se muestre el mensaje en pantalla
  public void tiempoEsperaMensaje(int milisegundos){
    try {
      Thread.sleep(milisegundos);
    }catch (Exception e) {

    }
  }
  //el tablero empieza con estos valores (empieza conlos valores del 1 al 9)
  public void init(){
    int n=0;
    for(int r=0;r<(tablero.length);r++){
      for(int c=0;c<(tablero[0].length);c++){
        n++;
        tablero[r][c]=String.valueOf(n);
      }
    }
  }

  //al parecer solo funciona en linux, limpiar pantalla
  public void clear(){
    try {
      if (this.sistemaOperativo.indexOf("win")>=0) {
        new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
      }else if (this.sistemaOperativo.indexOf("lin")>=0) {
        System.out.print("\033\143");
        System.out.flush();
      }
    }catch (Exception e) {

    }

    //System.out.printf("\033[2J");
    //System.out.printf("\033[%d;%dH", 0, 0)
  }

  //imprimos el tablero actual, en cada jugada lo vamos mostrando
  public void draw(){
    for(int i=0;i<tablero.length;i++){
      System.out.println(Arrays.toString(tablero[i]));
    }
  }

  //hacemos el movimiento
  public void move(String buscar,String simbolo){
    int n=0;
    for(int r=0;r<(tablero.length);r++){
      for(int c=0;c<(tablero[0].length);c++){
        if(tablero[r][c].equals(buscar) ){
          tablero[r][c]=simbolo;
        }
      }
    }
  }

  /*Metodo para comparar los resultados para saber si algun jugador ya gano
  */
  public boolean winner(String[][] tablero,String simbolo){
    if(  ((tablero[0][0].equals(simbolo)) && (tablero[0][1].equals(simbolo)) && (tablero[0][2].equals(simbolo)) )//fila 1
    || ( (tablero[1][0].equals(simbolo)) && (tablero[1][1].equals(simbolo)) && (tablero[1][2].equals(simbolo)))//fila 2
    || ( (tablero[2][0].equals(simbolo)) && (tablero[2][1].equals(simbolo)) && (tablero[2][2].equals(simbolo)) )//fila 3
    || ((tablero[0][0].equals(simbolo)) &&(tablero[1][0].equals(simbolo))&& (tablero[2][0].equals(simbolo)) )//columna 1
    || ((tablero[0][1].equals(simbolo)) &&(tablero[1][1].equals(simbolo)) && (tablero[2][1].equals(simbolo)) )//columna 2
    || ((tablero[0][2].equals(simbolo)) &&(tablero[1][2].equals(simbolo))&&(tablero[2][2].equals(simbolo)) )//columna 3

    || ((tablero[0][0].equals(simbolo)) &&(tablero[1][1].equals(simbolo))&&(tablero[2][2].equals(simbolo)) )//horizontal
    || ((tablero[0][2].equals(simbolo)) &&(tablero[1][1].equals(simbolo))&&(tablero[2][0].equals(simbolo)) )//horizontal

     ) {
       System.out.println("FELICIDADES!!! Ganaste");

       return true;
    }else {
      //System.out.println("No hubo ganador!!!");
      return false;
    }
  }


public static void main(String[] args){
    //metodo para limpiar la pantalla de la consola de windows o ubuntu
    Totito.getInstancia().clear();
    Totito.getInstancia().welcome();
  }
}
