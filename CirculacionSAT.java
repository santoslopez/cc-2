import java.util.*;
import java.util.regex.*;
public class CirculacionSAT{
	public static void main(String[] args){
		//CirculacionSAT circulacionSat = new CirculacionSAT();
		Scanner escaner = new Scanner(System.in);
		ciclo:
		while (true) {
			System.out.println("Ingrese el numero de placa: ");
			String numeroPlaca = escaner.nextLine();
			/*Para que sea una placa valida segun las instrucciones del laboratorio:
			-Solo tiene seis simbolos
			-Los tres primeros simbolos son letras mayusculas no vocales
			-Los ultimos tres simbolos son digitos
			*/

			/*Para que un NIT sea valido segun las instrucciones del laboratorio:
			-El primer simbolo es un digito del 1 al 9
			-Despues del primer simbolo debe tener de 4 a 7 digitos (del 0 al 9)
			-Despues de los digitos debe tener un guion (-)
			-Despues de guion, puede tener un digito o una K
			*/
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
