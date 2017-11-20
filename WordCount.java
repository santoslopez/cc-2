/*
Nombre: Santos Lopez Tzoy
Carnet: 15002241
Seccion: AN
CC2

WordCount.java cuenta la cantidad de palabras que contiene la oracion ingresada
*/

import java.io.*;
import java.util.*;
public class WordCount{

	public static void main(String[] args){
		Scanner escaner = new Scanner(System.in);
		//si no ingresamos ningun texto vamos a repetir el ciclo
		ciclo :
		while (true) {
			System.out.println("Ingrese una oracion");
			String oracion = escaner.nextLine();
			if (oracion.length()!=0) {//si se ingreso algo
				String[] cantidadPalabras = oracion.split("\\s");
				System.out.println("\nCantidad de palabras en la oracion: " + cantidadPalabras.length);
				break ciclo;//nos salimos del ciclo
			}else {
				System.out.println("No ingreso ninguna oracion\n");//mostramos este mensaje si no se ingresa ningun texto
			}
		}
	}
}
