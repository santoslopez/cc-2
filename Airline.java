/*
Keep up hard work, and go Bears!
Name: Santos Lopez Tzoy
Carnet: 15002241
Seccion: AN
Year: 2017
*/

import java.util.regex.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.InputMismatchException;
public class Airline{

  private static int asientosDisponibles;//guardamos la cantidad de asientos disponibles
  private static int asientosNoDisponibles;//guardamos la cantidad de asientos no disponibles
  private static String nombrePasajero;//guardamos el nombre del pasajero
  private static String edadPasajero;//guardamos la edad del pasajero


  //patron de diseno singleton para crear una sola instancia de la clase
  private static Airline airline;
  public synchronized static Airline getInstancia(){
    if(airline==null){
      airline = new Airline();
    }
    return airline;
  }

  /*Get que nos devuelve la informacion de asientos disponibles, asientos no disponibles, nombre*/
  public int getAsientosDisponibles(){
    return asientosDisponibles;
  }
  public int getAsientosNoDisponibles(){
    return asientosNoDisponibles;
  }

  public String getNombrePasajero(){
    return nombrePasajero;
  }

  public String getEdadPasajero(){
    return edadPasajero;
  }

  //dibuja la interfaz del menu principal
  public static void menuInterfaz(){
    System.out.println("");
    System.out.println("Menu principal");
    System.out.println(".......................");
    System.out.println("1. Reservaciones");
    System.out.println("2. Cancelaciones");
    System.out.println("3. Listado viajeros con reservaciones");
    System.out.println("4. Lista de asientos disponibles");
    System.out.println("5. Salir");
  }

  //imprimir los asientos
  public static void mostrarAsientos(String arregloAsientos[][]){
    for(int i=0;i<arregloAsientos.length;i++){
      System.out.println(Arrays.toString(arregloAsientos[i]));
    }
  }

 /*Esto nos sirve para mostrar la cantidad de asientos disponibles y no disponibles
lo usamos tambien para ver si los asientos al menos uno esta disponible para pedir datos
 */
 public static void estadoAsientos(String arregloAsientos[][], int asiento){
   asientosDisponibles=0;
   asientosNoDisponibles=0;
   int cont=0;
   for(int f=0;f<(asiento/6);f++){
     for(int c=0;c<6;c++){
       cont = cont+1;
       //verificamos que el asiento se encuentre en nuestro arreglo y lo reservamos si esta disponible.
       if(arregloAsientos[f][c].equals(String.valueOf(cont)+"X")){
         asientosNoDisponibles = asientosNoDisponibles + 1;
       }else if(arregloAsientos[f][c].equals(String.valueOf(cont)+"D")){
         asientosDisponibles = asientosDisponibles + 1;
       }
     }
   }
   System.out.println("Cantidad asientos ocupados: "+asientosNoDisponibles);
   System.out.println("Cantidad asientos disponibles: "+asientosDisponibles);
 }

  public static void main(String[] args){
      Scanner escaner = new Scanner(System.in);
      Airline airline = new Airline();
      while(true){
        System.out.println("Ingrese numero de asiento");
        String asientos = escaner.nextLine();
        /*Nos aseguramos que se ingrese algun valor y que sea numerico con al menos dos digitos*/
        if(!asientos.equals("") && (Pattern.matches("[0-9]{2,}+", asientos))) {
          int asiento = Integer.parseInt(asientos);/*convertimos lo ingresado a entero*/
          /*si cumple nuestro filtro entonces es un numero mayor a 47*/
          if(asiento>=48){
            if((asiento%6)==0){
              /*creamos un arreglo bidimensional. Teniendo en cuenta que las filas tienen unicamente
              6 columnas. Al numero de asiento ingresado lo dividimos con 6 para obtener la cantidad de filas*/
              String arregloAsientos[][]=new String[(asiento/6)][6];
              /*Llenamos el arreglo con numeros del 1 hasta el numero de asiento ingresado*/
              String usuariosConReServaciones[][]=new String[(asiento/6)][6];

              int asignarNumero=0;//usamos este contador para asignar un numero al siento
              for(int f=0;f<(asiento/6);f++){
                for(int c=0;c<6;c++){
                  asignarNumero=asignarNumero+1;//asignando numero a todos los asientos
                  arregloAsientos[f][c]=String.valueOf(asignarNumero)+"*";
                  usuariosConReServaciones[f][c]=String.valueOf(" ");
                }
              }
              char exit = 'f';
              while(true){
                exit = 'f';
                if(exit=='f'){
                  menuInterfaz();
                  String opcion = escaner.nextLine();
                  //en las opciones del menu unicamente puede ser un digito de 1 a 5
                  if(Pattern.matches("[1-5]{1}", opcion)){
                    int opc=Integer.parseInt(opcion);
                    switch(opc){
                      case 1:
                      while(true){
                        System.out.println ("Nombre del pasajero: ");
                        nombrePasajero = escaner.nextLine();
                        if(!nombrePasajero.equals("")){
                          break;
                        }
                      }
                      while(true){
                        System.out.println("Edad del pasajero: ");
                        edadPasajero = escaner.nextLine();
                        if(!edadPasajero.equals("")) {
                          try{
                            int age = Integer.parseInt(edadPasajero);
                            if(age>=0){
                              break;
                            }
                          }catch(NumberFormatException nfe){
                            /*si lo que se ingreso no es un numero mostramos este mensaje.*/
                            System.out.println("ERROR!!! La edad del pasajero debe ser un numero");
                          }
                        }
                      }
                      System.out.println("Listado de asientos disponibles");
                      /*Imprimos el arreglo de asientos*/
                      for(int i=0;i<arregloAsientos.length;i++){
                        System.out.println(Arrays.toString(arregloAsientos[i]));
                      }
                      char cerrando = 's';
                      while(cerrando=='s'){
                        try{
                          System.out.println("Ingrese No. asiento a reservar: ");
                          String reservarAsiento=escaner.nextLine();
                          if(!reservarAsiento.equals("")){
                            int miAsiento = Integer.parseInt(reservarAsiento);
                            if((miAsiento>0) && (miAsiento<=asiento)){
                              cerrando='t';
                              for(int f=0;f<(asiento/6);f++){
                                for(int c=0;c<6;c++){
                                  //verificamos que el asiento se encuentre en nuestro arreglo y lo reservamos si esta disponible.
                                  if(arregloAsientos[f][c].equals(String.valueOf(miAsiento)+"*")){
                                    arregloAsientos[f][c]=(String.valueOf(miAsiento)+ "X");
                                    usuariosConReServaciones[f][c]=(String.valueOf(miAsiento )+ " "+nombrePasajero + " "+edadPasajero );
                                    System.out.println(" ");
                                    System.out.println("<<<<<<<<<<<<<<<CC2>>>>>>>>>>>>>>>");
                                    System.out.println("Resumen: ");
                                    System.out.println("Los asientos no disponibles tienen la letra: X");
                                    System.out.println("Los asientos disponible tienen asignado el: *");
                                    System.out.println("El asiento se reservo correctamente.");
                                    System.out.println(" ");

                                    mostrarAsientos(arregloAsientos);

                                  }else if(arregloAsientos[f][c].equals(String.valueOf(miAsiento)+ "X")){
                                    System.out.println("El asiento NO esta disponible");
                                    System.out.println("No se hizo la reservacion.");
                                  }
                                }
                              }
                              break;
                            }else{
                              System.out.println("El No. de asiento es incorrecto");
                            }
                          }
                        }catch(Exception ex){
                          System.out.println(ex.getMessage() +" debe ingresar un valor numerico");
                        }
                      }
                      if(cerrando=='t'){
                        break;
                      }


                        break;
                        case 2:
                        char s='f';
                        while(s=='f'){

                          System.out.println("Ingrese No. de asiento que tiene asignado (actualmente ocupado: X): ");
                          String asientoAsignado = escaner.nextLine();
                          if(!asientoAsignado.equals("")&& (Pattern.matches("[1-9]{1,}+", asientoAsignado))){
                            //s='t';
                            int convertirAsientoAsignado = Integer.parseInt(asientoAsignado);
                            if (convertirAsientoAsignado>0 && convertirAsientoAsignado<=asiento) {
                              System.out.println("Listado de asientos: ");
                              mostrarAsientos(arregloAsientos);
                              System.out.println(" ");
                              for(int f=0;f<(asiento/6);f++){
                                for(int c=0;c<6;c++){
                                  //verificamos que el asiento se encuentre en nuestro arreglo y lo reservamos si esta disponible.
                                  if(arregloAsientos[f][c].equals(asientoAsignado+"X")){
                                    arregloAsientos[f][c]=asientoAsignado+ "*";
                                    usuariosConReServaciones[f][c]=" ";
                                    s='t';
                                    System.out.println("El asiento se cancelo (disponible).");
                                    //System.out.println("El viajero es: " +Airline.getInstancia().getNombrePasajero());
                                    System.out.println("No me cree? Por favor revise en opcion 4 del case");
                                  }else if(arregloAsientos[f][c].equals(asientoAsignado+"*")){
                                    System.out.println("El asiento NO se cancelo: ");
                                    System.out.println("Puede deberse a que actualmente esta disponible");

                                    break;
                                  }
                                }
                              }
                            }else{
                              System.out.println("El No. de asiento es incorrecto.");
                            }

                          }else{
                            System.out.println("El numero de asiento unicamente debe de llevar numeros");
                          }
                        }
                        if(s=='t'){
                          break;
                        }
                        //System.out.println("a");
                        break;
                        case 3:
                        mostrarAsientos(usuariosConReServaciones);
                        //System.out.println();
                        break;
                        case 4:
                        mostrarAsientos(arregloAsientos);
                        break;
                        case 5:
                        //int asientosNoDisponibles=0;
                        //int asientosDisponibles=0;
                        //int cont=0;

                        estadoAsientos(arregloAsientos,asiento);

                        System.exit(0);
                        default:

                        System.out.println("Opcion no valida del menu");
                        break;
                      }
                    }else{
                      System.out.println("ERROR!!! La opcion es invalida");
                    }
                  }else{
                    exit = 't';
                    break;
                  }
                }

              }else{
                System.out.println("El numero debe ser multiplo de 6");
              }
            }else{
              /*el numero es menor a 47*/
              System.out.println("El No. debe ser mayor a 47");
            }
          }else{
            System.out.println("Por favor, ingrese un valor.");
          }
        }
  }
}
