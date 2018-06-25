/*
Keep up your hard work, and go Bears!
Name: Santos Lopez Tzoy
Carnet: 15002241
Seccion: AN
Year: 2018
*/

import java.util.regex.*;
import java.util.Scanner;
import java.util.Arrays;
import java.lang.Thread;

public class NewAirline{

  private static int asientosDisponibles=0;//guardamos la cantidad de asientos disponibles
  private static int asientosNoDisponibles=0;//guardamos la cantidad de asientos no disponibles
  private static String nombrePasajero;//guardamos el nombre del pasajero
  private static String edadPasajero;//guardamos la edad del pasajero
  private static Scanner escaner = new Scanner(System.in);
  private static String usuariosReservaciones[][];

  //patron de diseno singleton para crear una sola instancia de la clase
  private static NewAirline newAirline;
  public synchronized static NewAirline getInstancia(){
    if(newAirline==null){
      newAirline = new NewAirline();
    }
    return newAirline;
  }

  /*Get que nos devuelve la informacion de asientos disponibles, asientos no disponibles, nombre*/
  public int getAsientosDisponibles(){
    return asientosDisponibles;
  }

  //modificamos el valor de los asientos disponibles
  public void setAsientosDisponibles(int asientosDisponibles){
    this.asientosDisponibles=asientosDisponibles;
  }
  //modificamos el valor de los asientos NO disponibles
  public void setAsientosNODisponibles(int asientosNoDisponibles){
    this.asientosNoDisponibles=asientosNoDisponibles;
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
  public static void menu(){
    System.out.println("\n1. Reservar\n2. Cancelar\n3. Listado viajeros con reservaciones\n4. Lista de asientos disponibles\n5. Salir");
  }

  //imprimir los asientos
  public static void mostrarAsientos(String arregloAsientos[][]){
    for(int i=0;i<arregloAsientos.length;i++){
      //asientosDisponibles++;//inicializamos todos los asientos como disponibles
      System.out.println(Arrays.toString(arregloAsientos[i]));
    }
  }

  //metodo que inicializa los numeros de asientos
  public void inicializarAsientos(String arregloAsientos[][],int asiento){
    int numeroAsiento=0;
    for (int fila=0; fila<(asiento/6);fila++ ) {
      for (int columna=0;columna<6;columna++) {
        arregloAsientos[fila][columna]=String.valueOf(numeroAsiento++)+"*";
        //inicializamos todas las habitaciones sin reservaciones de usuarios
        usuariosReservaciones[fila][columna]=String.valueOf(" ");
        asientosDisponibles++;
      }
    }
  }

  public void reservarAsiento(String arregloAsientos[][],int totalAsientos){

    for(int i=0;i<arregloAsientos.length;i++){
      //averiguamos la longitud del arreglo de asientos, posteriormente esta variable la vamos a usar como la cantidad maxima de asientos
      int longitudArregloAsientos = arregloAsientos[i].length;

      if(asientosDisponibles>=1){
        System.out.println("Ingrese su nombre: ");
        String nombrePasajero = escaner.nextLine();
        System.out.println("Ingrese su edad: ");
        String edadPasajero = escaner.nextLine();
        NewAirline.getInstancia().mostrarAsientos(arregloAsientos);
        //ciclo que nos permite volver a pedir el numero de asiento a reservar en caso el ingresado es incorrecto
        while(true){
          System.out.println("Ingrese el numero de asiento a reservar: ");
          String reservarAsiento = escaner.nextLine();
          if (Pattern.matches("[0-9]+",reservarAsiento)) {
            int numeroAsiento = Integer.parseInt(reservarAsiento);
            //verificamos que el asiento ingresado sea mayor o igual a 1 y menor o igual a la longitud del arreglo de asientos
            if ((numeroAsiento<=longitudArregloAsientos-1) || numeroAsiento>=0) {

              for (int fila=0; fila<(totalAsientos/6);fila++ ) {
                for (int columna=0;columna<6;columna++) {
                  if (arregloAsientos[fila][columna].equals(reservarAsiento+"*")) {
                    arregloAsientos[fila][columna]=reservarAsiento+"X";

                    //almacenamos los datos del pasajero que hizo la reservacion
                    usuariosReservaciones[fila][columna]="No: "+reservarAsiento+ " "+nombrePasajero + " "+edadPasajero ;

                    System.out.println("Se reservo correctamente el asiento\nPor favor espere...");
                    SistemaOperativo.getInstancia().mensaje(1000);
                    SistemaOperativo.getInstancia().limpiarPantalla();//limpiamos la pantalla
                    NewAirline.getInstancia().menu();//dibujamos la interfaz
                    asientosNoDisponibles++;//sumamos un asiento no disponible
                    asientosDisponibles--;//restamos un asiento disponible

                  //si seleccionamos una habitacion ocupada
                  }else if(arregloAsientos[fila][columna].equals(reservarAsiento+"X") ) {
                    System.out.println("ERROR!!! No puede reservar una habitacion ocupado");
                  }
                }
              }
              break;
            }else{
              System.out.println("ERROR!!! El numero de asientos es incorrecto");
            }
          }else {
            System.out.println("ERROR!!! Debe ingresar un numero valido");
          }
        }
        break;
      }else {
        System.out.println("ERROR!!! Todos los asientos estan ocupados");
        System.out.println("Asientos ocupados: "+asientosNoDisponibles);
        System.out.println("Asientos disponibles: "+asientosDisponibles);
        System.out.println("\n\n\nLimpiando la pantalla. Por favor espere...");
        SistemaOperativo.getInstancia().mensaje(3000);//mostramos los mensajes anteriores en este tiempo
        SistemaOperativo.getInstancia().limpiarPantalla();//limpiamos la pantalla
        NewAirline.getInstancia().menu();//dibujamos la interfaz
        break;
      }
    }
  }

  public static void main(String[] args){
    //limpiamos la consola de windows o ubuntu
    SistemaOperativo.getInstancia().limpiarPantalla();
    while (true) {
      System.out.println("Ingrese el numero de asiento (>=48, y debe ser un multiplo de 6)");
      String asientos = escaner.nextLine();
      if(Pattern.matches("[0-9]{1,}+", asientos)) {
        int asiento = Integer.parseInt(asientos);/*convertimos lo ingresado a entero*/
        //nos aseguramos que el numero sea mayor a 48 y sea divisible dentro de 6
        if ((asiento>=6) && ((asiento%6)==0) ) {
          SistemaOperativo.getInstancia().limpiarPantalla();//limpiamos la pantalla
          String arregloAsientos[][]=new String[(asiento/6)][6];

          //arreglo donde vamos a guardar los usuarios que tienen reservaciones
          usuariosReservaciones=new String[(asiento/6)][6];

          NewAirline.getInstancia().inicializarAsientos(arregloAsientos,asiento);

          //dibujamos la interfaz
          NewAirline.getInstancia().menu();
          while (true) {
            System.out.println("\nIngrese una opcion del menu: ");
            String ingresar = escaner.nextLine();
            if (Pattern.matches("[1-5]",ingresar)) {
              switch (ingresar) {
                case "1":
                NewAirline.getInstancia().reservarAsiento(arregloAsientos,asiento);

                break;

                case "2":
                NewAirline.getInstancia().mostrarAsientos(arregloAsientos);
                while(true){
                  System.out.println("Ingrese No. de asiento que tiene asignado (actualmente ocupado: X): ");
                  String asientoAsignado = escaner.nextLine();
                  if(!asientoAsignado.equals("")&& (Pattern.matches("[0-9]{1,}+", asientoAsignado))){
                    int convertirAsientoAsignado = Integer.parseInt(asientoAsignado);
                    if (convertirAsientoAsignado>=0 && convertirAsientoAsignado<=asiento) {
                      System.out.println("Listado de asientos: ");
                      mostrarAsientos(arregloAsientos);
                      System.out.println(" ");
                      for(int f=0;f<(asiento/6);f++){
                        for(int c=0;c<6;c++){
                          //verificamos que el asiento se encuentre en nuestro arreglo y lo reservamos si esta disponible.
                          if(arregloAsientos[f][c].equals(asientoAsignado+"X")){
                            System.out.println("El asiento "+arregloAsientos[f][c] + " se cancelo (disponible).");
                            arregloAsientos[f][c]=asientoAsignado+"*";
                            System.out.println("Datos del viajero: ");
                            System.out.println(usuariosReservaciones[f][c]);
                            usuariosReservaciones[f][c]=" ";
                            //Le quitamos 1 asiento no disponible y lo agregamos a disponible
                            NewAirline.getInstancia().setAsientosDisponibles(asientosDisponibles + 1);
                              NewAirline.getInstancia().setAsientosNODisponibles(asientosNoDisponibles - 1);
                            break;
                          }else if(arregloAsientos[f][c].equals(asientoAsignado+"*")){
                            System.out.println("El asiento NO se cancelo: ");
                            System.out.println("Puede deberse a que actualmente esta disponible");

                          }
                        }
                      }
                      break;
                    }else{
                      System.out.println("El No. de asiento es incorrecto.");
                    }

                  }else{
                    System.out.println("El numero de asiento unicamente debe de llevar numeros");
                  }
                }


                case "3":
                System.out.println("Datos de usuarios con reservaciones");
                NewAirline.getInstancia().mostrarAsientos(usuariosReservaciones);
                break;

                case "4":
                System.out.println("\n");
                System.out.println("Los asientos disponibles tienen el *");
                System.out.println("Los asientos NO disponibles tienen la X");
                NewAirline.getInstancia().mostrarAsientos(arregloAsientos);
                break;

                case "5":
                //imprimimos el estado del vuelo o sea asientos disponibles y no disponibles
                System.out.println("Cantidad de asientos ocupados: "+NewAirline.getInstancia().getAsientosNoDisponibles());
                System.out.println("Cantidad de asientos disponibles: "+NewAirline.getInstancia().getAsientosDisponibles());
                System.exit(0);//cerramos el programa
                break;

                default:
                SistemaOperativo.getInstancia().limpiarPantalla();//limpiamos la pantalla
                NewAirline.getInstancia().menu();
                break;

              }
            }else {
              System.out.println("ERROR!!! Opcion invalida");
              SistemaOperativo.getInstancia().mensaje(1000);
              SistemaOperativo.getInstancia().limpiarPantalla();//limpiamos la pantalla
              NewAirline.getInstancia().menu();
            }
          }

        }else {
          System.out.println("ERROR!!! El numero de asiento debe ser >=48, y multiplo de 6)\nPor favor espere...");
          SistemaOperativo.getInstancia().mensaje(1000);
          SistemaOperativo.getInstancia().limpiarPantalla();//limpiamos la pantalla
        }
      }else {
        System.out.println("ERROR!!! Debe ingresar numeros\nPor favor espere...");
        SistemaOperativo.getInstancia().mensaje(1000);
        SistemaOperativo.getInstancia().limpiarPantalla();//limpiamos la pantalla
      }
    }
  }

}

/*
Clase SistemaOperativo.java nos permite averiguar que SO estamos usando y luego limpiar la pantalla de consola
*/


class SistemaOperativo{
	//patron de diseno singleton para crear una sola instancia de la clase
	private static SistemaOperativo instancia;
	public static SistemaOperativo getInstancia(){
		if (instancia==null) {
			instancia=new SistemaOperativo();
		}
		return instancia;
	}

  /*vamos averiguar que sistema operativo estamos utilizando*/
	private static String sistemaOperativo = System.getProperty("os.name").toLowerCase();

  //devolvemos el nombre del sistema operativo
  public String getSistemaOperativo(){
    return sistemaOperativo;
  }

	//para limpiar la pantalla de la consola
	public void limpiarPantalla(){
		try {
			//si nuestro sistema operativo es Windows
			if (SistemaOperativo.getInstancia().getSistemaOperativo().indexOf("win")>=0 ) {
				SistemaOperativo.getInstancia().windows();
				//si nuestro sistema operativo es Linux
			}else if (SistemaOperativo.getInstancia().getSistemaOperativo().indexOf("lin")>=0) {
				System.out.print("\033\143");
				System.out.flush();
			}{

			}
		}catch(Exception exception){
			System.out.println("Se produjo el siguiente error: "+exception.getMessage());
		}
	}

  //metodo para limpiar la consola, terminal o pantalla de Windows
	public void windows(){
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		}catch(Exception exception){
			System.out.println("Se produjo el siguiente error: "+exception.getMessage());
		}
	}

  //desplegamos un mensaje en este tiempo para posteriormente limpiar la consola
  public void mensaje(int tiempo){
    try {
      Thread.sleep(tiempo);
    }catch (Exception e) {
      System.out.println("Se produjo el siguiente error: "+e.getMessage());
    }
  }
}
