/*Algunos ejercicios los habia trabajado en casa, asumi que los laboratorios eran los mismos a años anteriores*/

import java.util.*;
import java.util.regex.*;

public class CirculacionSAT{
    public static void main(String[] args){
        Scanner escaner = new Scanner(System.in);
        ciclo:
		while (true) {
		    System.out.println("Ingrese el numero de placa: ");
		    String numeroPlaca = escaner.nextLine();
			System.out.println("Ingrese el numero de NIT: ");
			String numeroNIT = escaner.nextLine();
			if ((Pattern.matches("[ABCDFGHJKLMNPQRSTVWZ]{3}\\d{3}",numeroPlaca) )&& (Pattern.matches("[1-9]{1}\\d{4,7}-[0-9K]",numeroNIT))) {
				System.out.println("NIT Y PLACAS VALIDOS");
				break ciclo;//nos salimos del ciclo
			}	else if (((!(Pattern.matches("[ABCDFGHJKLMNPQRSTVWZ]{3}\\d{3}",numeroPlaca) ))&& (!(Pattern.matches("[1-9]{1}\\d{4,7}-[0-9K]",numeroNIT))) )) {
				System.out.println("NIT Y PLACAS NO VALIDOS");
				break ciclo;//nos salimos del ciclo
			} else if (Pattern.matches("[1-9]{1}\\d{4,7}-[0-9K]",numeroNIT) && (!(Pattern.matches("[ABCDFGHJKLMNPQRSTVWZ]{3}\\d{3}",numeroPlaca)))) {
				System.out.println("El nit es valido, el numero de placa es invalido");
				break ciclo;//nos salimos del ciclo
			} else if (!(Pattern.matches("[1-9]{1}\\d{4,7}-[0-9K]",numeroNIT)) && (Pattern.matches("[ABCDFGHJKLMNPQRSTVWZ]{3}\\d{3}",numeroPlaca))) {
				System.out.println("El nit es INVALIDO y el numero de placa es valido");
				break ciclo;//nos salimos del ciclo
			}
		}
	}
}