
import java.util.*;
import java.util.regex.*;
public class CalculoInteres{

	//por defecto inicializamos las variables a cero
	private static Double monto=0.0;
	private static double tasaInteres=0.0;
	private static Double resultado=0.0;
	private static Double total=0.0;

	public static void main(String[] args){
		Scanner escaner = new Scanner(System.in);
		do{
			System.out.println("Ingrese monto en quetzales: ");
			String ingresarMonto = escaner.nextLine();
			if (Pattern.matches("[0-9]+(([.])?[0-9]*)?",ingresarMonto)) {
				monto = Double.parseDouble(ingresarMonto);//convertimos el string a double
			}else {
				System.out.println("El monto ingresado no es correcto\n");
			}
		}while(monto<=0);//No permite que el monto sea menor o igual a cero
		do{
			System.out.println("Ingrese tasa de interes: ");
			String ingresarTasaInteres = escaner.nextLine();
			//con esta expresion regular aceptamos numeros enteros o doubles
			if (Pattern.matches("[0-9]+(([.])?[0-9]*)?",ingresarTasaInteres)) {
				tasaInteres = Double.parseDouble(ingresarTasaInteres);//convertimos el string a double
				resultado = (monto*tasaInteres);
				total = (monto + resultado);
			}else {
				System.out.println("La tasa de interes no cumple el formato valido\n");
			}
		}while(tasaInteres<0);//No permite que la tasa de interes sea menor a cero
		System.out.println("---------------------------------------------------");
		System.out.println("INTERES: " + resultado);
		System.out.println("TOTAL CON INTERES: " + Math.rint(total*100)/100);
	  System.out.println("---------------------------------------------------");
	}
}
