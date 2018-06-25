/*No es que sea rapido ni nada, pero este laboratorio ya lo habia trabajado una noche antes*/

import java.util.*;
import java.util.regex.*;

public class Estadisticas{
	//inicializacion de variables
	private static int aprobo = 0;//contador de curso aprobado
	private static int reprobo=0;//contador de curso perdido
	private static Random random= new Random();

	public static void main(String[] args) {

	    Scanner escaner = new Scanner(System.in);
		ciclo:
		while (true) {
		    System.out.println("Ingrese cantidad de estudiantes: ");
			String ingresarNoEstudiantes = escaner.nextLine();
			if (Pattern.matches("[0-9]+",ingresarNoEstudiantes)) {
			    int numero = Integer.parseInt(ingresarNoEstudiantes);//convertimos el texto a string

			    if (numero<=5) {
			        System.out.println("Cantidad invalida");
			        break ciclo;
				}else {
				    for (int i=0,noEstudiantes=numero;i<noEstudiantes;i++ ) {
				        int generado = (int)(Math.random() * 100) + 1;//genero un numero aleatorio de 0 a 100
				        if(generado>=61){
				            System.out.println("Generando numero aleatorio... "+generado);
				            aprobo = aprobo + 1;//guarda cuantos estudiantes aprobaron el curso
						}else{
							System.out.println("Generando numero aleatorio... "+generado);
							reprobo = reprobo + 1;//guarda cuantos estudiantes reprobaron el curso
						}

					}

					System.out.println("**********Resumen**********");
					System.out.println("Total estudiantes : " + numero);//imprime cantidad de estudiantes
					System.out.println("Total aprobaron: " + aprobo  + "  (Notas >=61)");//imprime cantidad de estudiantes que aprobaron
					System.out.println("Total reprobaron: " + reprobo);//imprime cantidad de estudiantes que reprobaro

					//se utiliza Math.rith para las cifras significativas
					double porcentajeAprobados = ((double) aprobo / (double)numero)*100;

					double porcentajeReprobados = ((double)reprobo / (double)numero)*100;

					System.out.println("Aprobaron: " + Math.rint(porcentajeAprobados) + " % ");

					System.out.println("Reprobaron: " + Math.rint(porcentajeReprobados) + " % ");

					System.out.println("----------------------------------");

					break ciclo;//nos salimos del ciclo
				}
			}else {
			    System.out.println("Lo que ingreso no son numeros\n");
			}
		}
	}
}