/*Algunos ejercicios los habia trabajado en casa, asumi que los laboratorios eran los mismos a años anteriores*/

import java.util.*;
import java.util.regex.*;

public class CalculoDescuento{

    //patron de diseno singleton pra crear una sola instancia de la clase
    private static CalculoDescuento instancia;
    public static CalculoDescuento getInstancia(){
        if (instancia==null){
            instancia = new CalculoDescuento();
        }
        return instancia;
    }

	//por defecto inicializamos las variables a cero
	private static Double monto=0.0;
	private static double tasaInteres=0.0;
	private static Double resultado=0.0;
	private static Double total=0.0;

	public void mensajeError(String mensaje){
		System.out.println(mensaje);
	}

	public static void main(String[] args){
		Scanner escaner = new Scanner(System.in);
		do{
			System.out.println("Ingrese monto en quetzales: ");
			String ingresarMonto = escaner.nextLine();
			if (Pattern.matches("[0-9]+(([.])?[0-9]*)?",ingresarMonto)) {
				monto = Double.parseDouble(ingresarMonto);//convertimos el string a double
			}else {
				CalculoDescuento.getInstancia().mensajeError("ERROR!!! El monto ingresado es incorrecto");
			}
		}while(monto<=0);//No permite que el monto sea menor o igual a cero

		do{
			System.out.println("Ingrese tasa de interes: ");
			String ingresarTasaInteres = escaner.nextLine();
			//con esta expresion regular aceptamos numeros enteros o doubles
			if (Pattern.matches("[0-9]+(([.])?[0-9]*)?",ingresarTasaInteres)) {
				tasaInteres = Double.parseDouble(ingresarTasaInteres);//convertimos el string a double
				resultado = (monto * (tasaInteres / 100));
				total = (monto + resultado);
			}else {
				CalculoDescuento.getInstancia().mensajeError("ERROR!!! La tasa de interes no cumple el formato valido");
			}
		}while(tasaInteres<0);//No permite que la tasa de interes sea menor a cero
		System.out.println("---------------------------------------------------");
		System.out.println("INTERES: " + resultado);
		System.out.println("TOTAL CON INTERES: " + Math.floor((double)((monto - resultado)* 100)) / 100 );
		System.out.println("---------------------------------------------------");
	}

}