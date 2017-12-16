/*
Keep up your hard work, and go Bears!
Name: Santos Lopez Tzoy
Carnet: 15002241
Seccion: AN
Year: 2017
*/

import java.util.regex.*;
import java.util.Scanner;
import java.util.Arrays;
import java.lang.Thread;

public class Airline{

  private static int asientosDisponibles=0;//guardamos la cantidad de asientos disponibles
  private static int asientosNoDisponibles=0;//guardamos la cantidad de asientos no disponibles
  private static String nombrePasajero;//guardamos el nombre del pasajero
  private static String edadPasajero;//guardamos la edad del pasajero
  private static Scanner escaner = new Scanner(System.in);

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
    int numeroAsiento=1;
    for (int fila=0; fila<(asiento/6);fila++ ) {
      for (int columna=0;columna<6;columna++) {
        arregloAsientos[fila][columna]=String.valueOf(numeroAsiento++)+"*";
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
        String nombre = escaner.nextLine();
        System.out.println("Ingrese su edad: ");
        String edad = escaner.nextLine();
        Airline.getInstancia().mostrarAsientos(arregloAsientos);
        //ciclo que nos permite volver a pedir el numero de asiento a reservar en caso el ingresado es incorrecto
        while(true){
          System.out.println("Ingrese el numero de asiento a reservar: ");
          String reservarAsiento = escaner.nextLine();
          if (Pattern.matches("[0-9]{1,}",reservarAsiento)) {
            int numeroAsiento = Integer.parseInt(reservarAsiento);
            //verificamos que el asiento ingresado sea mayor o igual a 1 y menor o igual a la longitud del arreglo de asientos
            if (numeroAsiento>=1 && numeroAsiento<=longitudArregloAsientos) {

              for (int fila=0; fila<(totalAsientos/6);fila++ ) {
                for (int columna=0;columna<6;columna++) {
                  if (arregloAsientos[fila][columna].equals(reservarAsiento+"*")) {
                    arregloAsientos[fila][columna]=reservarAsiento+"X";
                    System.out.println("Se reservo correctamente el asiento\nPor favor espere...");
                    SistemaOperativo.getInstancia().mensaje(1000);
                    SistemaOperativo.getInstancia().limpiarPantalla();//limpiamos la pantalla
                    Airline.getInstancia().menu();//dibujamos la interfaz
                    asientosNoDisponibles++;//sumamos un asiento no disponible
                    asientosDisponibles--;//restamos un asiento disponible
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
        Airline.getInstancia().menu();//dibujamos la interfaz
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

          Airline.getInstancia().inicializarAsientos(arregloAsientos,asiento);

          //dibujamos la interfaz
          Airline.getInstancia().menu();
          while (true) {
            System.out.println("\nIngrese una opcion del menu: ");
            String ingresar = escaner.nextLine();
            if (Pattern.matches("[1-5]",ingresar)) {
              switch (ingresar) {
                case "1":
                Airline.getInstancia().reservarAsiento(arregloAsientos,asiento);

                break;

                case "2":
                System.out.println("NO DISPONIBLE OPCION 2");
                break;

                case "3":
                System.out.println("NO DISPONIBLE OPCION 3");
                break;

                case "4":
                System.out.println("NO DISPONIBLE OPCION 4");
                break;

                case "5":
                //estadoAsientos(arregloAsientos,asiento);
                System.exit(0);//cerramos el programa
                break;

                default:
                SistemaOperativo.getInstancia().limpiarPantalla();//limpiamos la pantalla
                Airline.getInstancia().menu();
                break;

              }
            }else {
              System.out.println("ERROR!!! Opcion invalida");
              SistemaOperativo.getInstancia().mensaje(1000);
              SistemaOperativo.getInstancia().limpiarPantalla();//limpiamos la pantalla
              Airline.getInstancia().menu();
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
