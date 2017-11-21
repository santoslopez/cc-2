/*
Nombre: Santos Lopez Tzoy
Carnet: 15002241
Seccion: AN
2017
*/
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
import java.lang.*;
import java.util.regex.*;
public class Totito{


  private static Totito instancia;

  //variables que usamos para guardar los nombres de los jugadores
  private static String playerOne;
  private static String playerTwo;
  Thread t;

  //una matriz de 3x3 para representar al tablero
  private static String tablero[][]=new String[3][3];


  //generar random de tiros
  private char[] tiros = new char[]{'X','O'};
  private static char tiroAsignadoJ1;//vamos a guardar el tiro asignado al jugador 1
  private static char tiroAsignadoJ2;//vamos a guardar el tiro asignado al jugador 2


  //aplicamos singleton para crear una unica instancia de la clase
  public static synchronized Totito getInstancia(){
    if(instancia==null){
      instancia=new Totito();
    }
    return instancia;
  }



  //metodo que sirve para darle la bienvenida al jugador
  public void welcome(){
    Scanner escaner = new Scanner(System.in);
    System.out.println("Bienvenido al juego de totito de CC2");

    do{
      try{
        System.out.println("Nombre del jugador 1: ");
        playerOne = escaner.nextLine();
        tiroAsignadoJ1 = tiros[(int)(Math.random()*3)];
        //System.out.println("Se le asigno el tiro: "+tiroAsignadoJ1);
      }catch(ArrayIndexOutOfBoundsException error){
        System.out.println("Algo inesperado paso, lo siento: "+error.getMessage());
      }
    }while(playerOne.equals(""));
    do{
      try{
        System.out.println("Nombre del jugador 2: ");
        playerTwo = escaner.nextLine();
        //dependiendo el tiro que tiene asignado el jugador es el que empieza el juego
        if(tiroAsignadoJ1=='X'){
          tiroAsignadoJ2 = 'O';
          //System.out.println("Se le asigno el tiro: "+ tiroAsignadoJ2);
          System.out.println("El jugador : "+ playerOne +" es el primero en tirar");
        }else{
          tiroAsignadoJ2 = 'X';
          tiroAsignadoJ1 = 'O';
          System.out.println("Se le asigno el tiro: "+ tiroAsignadoJ2);
          System.out.println("El jugador : "+ playerTwo +" es el primero en tirar");
        }

      }catch(ArrayIndexOutOfBoundsException error){
        System.out.println("Lo siento, algo insesperado paso: "+error.getMessage());
      }

    }while(playerTwo.equals(""));

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
    System.out.print("\033[H\033[2J");
    System.out.flush();
    //System.out.printf("\033[2J");
    //System.out.printf("\033[%d;%dH", 0, 0);
  }

  //imprimos el tablero actual
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

  /*Metodo para saber si un jugador gano
  */
  public void winner(String[][] tablero,String simbolo){
    if( (((tablero[0][0].equals(simbolo)) && (tablero[0][1].equals(simbolo)) && (tablero[0][2].equals(simbolo)) )//fila 1
    || ( (tablero[1][0].equals(simbolo)) && (tablero[1][1].equals(simbolo)) && (tablero[1][2].equals(simbolo)))||//fila 2
    ( (tablero[2][0].equals(simbolo)) && (tablero[2][1].equals(simbolo)) && (tablero[2][2].equals(simbolo)) )//fila 3
    || ((tablero[0][0].equals(simbolo)) &&(tablero[1][0].equals(simbolo))&& (tablero[2][0].equals(simbolo)) )//columna 1
    || ((tablero[0][1].equals(simbolo)) &&(tablero[1][1].equals(simbolo)) && (tablero[2][1].equals(simbolo)) )//columna 2
    || ((tablero[0][2].equals(simbolo)) &&(tablero[1][2].equals(simbolo))&&(tablero[2][2].equals(simbolo)) )//columna 3

    || ((tablero[0][0].equals(simbolo)) &&(tablero[1][1].equals(simbolo))&&(tablero[2][2].equals(simbolo)) )//horizontal
    || ((tablero[0][2].equals(simbolo)) &&(tablero[1][1].equals(simbolo))&&(tablero[2][0].equals(simbolo)) )//horizontal

     )) {
       if(tiroAsignadoJ1=='X' || tiroAsignadoJ1=='O'){
         System.out.println("Felicitaciones ganaste "+playerOne);
         System.exit(0);
       }else if(tiroAsignadoJ2=='X' || tiroAsignadoJ2=='O'){
         System.out.println("Gano el jugador "+ playerTwo);
         System.exit(0);
       }
    }
  }


public static void main(String[] args){
    Totito.getInstancia().clear();
    Totito.getInstancia().welcome();
    Totito.getInstancia().init();//tablero inicial
    Totito.getInstancia().draw();

    Scanner escaner = new Scanner(System.in);
    //unicamente permite 9 tiros
    for(int i=1;i<10;i++){
      System.out.println("Ingrese su tiro: (numero del 1 al 9)");
      String tiro = escaner.nextLine();
      if(Pattern.matches("[1-9]{1}",tiro ) ){
        //asumimos que el primer jugador, el que empieza el juego, sus unicos tiros sera en 1 3 5 7 y 9
        if(i==1  || i==3  || i==5  || i==7  || i==9){
          Totito.getInstancia().move(tiro,"X");
          Totito.getInstancia().draw();
        }else if(i==2 || i==4 || i==6 || i==8){
          //asumimos que el segundo jugador sus unicos tiros sera en el segundo cuarto sexto y octavo turno
          Totito.getInstancia().move(tiro,"O");
          Totito.getInstancia().draw();
        }
        /*Solo uno de estas opciones se va activar en caso un jugador gane*/
        Totito.getInstancia().winner(tablero,"X");
        Totito.getInstancia().winner(tablero,"O");
      }else{
        System.out.println("ERROR!!!! El tiro permitido es un numero del 1 al 9");
        System.exit(0);//salimos del programa
      }
    }
  }
}
