/*Necesario para las lecturas de datos*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.regex.*;

public class NewCitizen{

    //metodo main principal
	public static void main(String[] args) throws IOException {

		BufferedReader lectura = new BufferedReader(new InputStreamReader(System.in));

        //invocamos al metodo para mostrar el mensaje que pide los datos
        System.out.println("Ingrese el primer nombre: ");
		String primerNombre = lectura.readLine();
		System.out.println("Ingrese el segundo nombre: ");
		String segundoNombre = lectura.readLine();
		System.out.println("Ingrese el apellido del padre: ");
		String primerApellido = lectura.readLine();
		System.out.println("Ingrese el apellido de madre: ");
		String segundoApellido = lectura.readLine();
		System.out.println("Ingrese la fecha de nacimiento: ");
		String fechaNacimiento = lectura.readLine();

        /*verificamos que la fecha de nacimiento es correcto*/
        if (Pattern.matches("[0-9]{2}-[0-9]{2}-[0-9]{4}",fechaNacimiento)){
            //desplegando informacion
            System.out.println("Nombre: "+primerApellido+ " "+segundoApellido+ " , "+primerNombre+ " "+segundoNombre);
            System.out.println("Nacimiento: "+fechaNacimiento);
            String inicialesCiudadano = primerNombre.substring(0,1).concat(segundoNombre.substring(0,1)).concat(primerApellido.substring(0,1)).concat(segundoApellido.substring(0,1));
            //aqui almacenamos los digitos del year de nacimiento
            String anoNacimiento = fechaNacimiento.substring(6,10);
            System.out.println("Iniciales: "+inicialesCiudadano);
            System.out.println("ID: "+inicialesCiudadano+"-"+anoNacimiento);
        }else{
            System.out.println("La fecha de nacimiento no cumple el formato de dd-mm-aaaa");
        }


	}
}