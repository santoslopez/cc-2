/*Nombre: Santos Lopez Tzoy
Carnet: 15002241
Seccion: AN
Keep up hard work, ang Go Bears!
*/
import java.io.*;
import java.util.regex.Pattern;
import java.util.*;

public class ValidDate {

	public static boolean isValidDate(String date) throws Exception{
		//si la condicion regular no cumple el formato de dd/mm/aaaa es decir dia mes y year
		if (!Pattern.matches("\\d{2}/\\d{2}/\\d{4}", date)){
			System.out.println("El formato es incorrecto. Debe estar en el formato DD/MM/AAAA");
			return false;
		}else{
			String day = String.valueOf(date.substring(0,2));//obtenemos los primeros dos numeros ingresados como dias
			String month = String.valueOf(date.substring(3,5));//obtenemos los numeros ingresados como mes
			String year=date.substring(6,10);//obtenemos los numeros ingresados como years
			int dia=Integer.parseInt(day);
			int mes=Integer.parseInt(month);
			int y=Integer.parseInt(year);
			if(y>0){
				if(mes==2){
					if(dia<=28){
						return true;
					}else{
						return false;
					}
				}else if (mes==4 || mes==6 || mes==9 || mes==11  ){
					if(dia<=30){
						return true;
					}else{
						return false;
					}
				}else if (mes==1 || mes==3 || mes==5 || mes==7  || mes==8 ||mes==10 ||mes==12  ){
					if(dia<=31){
						return true;
					}else{
						return false;
					}
				}else{
					return false;
				}
			}else{
				return false;
			}
		}
	}


	/*** Para probar que su metodo funciona **/
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Prueba de Valid Date: ");
		while(true) {
			System.out.println("Ingrese fecha a evaluar o solo presione enter para terminar: ");
			String fecha = br.readLine();
			if (fecha.length() == 0) {
				System.out.println("Saliendo...");
				return;
			} else {
				System.out.println("Fecha valida: " + isValidDate(fecha));
			}
		}
	}
}
