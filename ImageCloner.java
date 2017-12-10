/*
Nombre: Santos Lopez Tzoy
Carnet: 15002241
Seccion: AN
CC2
Keep up hard work, ang Go Bears!
*/
import java.util.*;
import java.io.*;
import java.util.Scanner;
public class ImageCloner{


	/*Mensaje que muestra mientras la imagen se esta clonando*/
	public static void mensaje(){
		System.out.println("Cargando...");
		System.out.println("Espere un momento.");
	}

	/*Metodo para clonar una imagen. El parametro image es el texto que le pasamos a este metodo
	como imagen a clonar*/
	public String clone(String image){
		File file = new File(image);
		FileInputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null;

		/*si lo que se ingreso como imagen a clonar (texto) se encuentra en nuestra carpeta existe
		entonces procedemos a clonar la imagen
		*/
		if(file.exists()){
			try{
				fileInputStream = new FileInputStream(file);
				fileOutputStream = new FileOutputStream("copia-"+image);
				byte arreglo[]=new byte[(int)file.length()];
				for(int i=0;i<arreglo.length-1;i++){
					arreglo[i]=(byte)fileInputStream.read();
				}
				fileOutputStream.write(arreglo);
				System.out.println("La imagen ha sido clonada correctamente");
				fileOutputStream.close();
			}catch(Exception ex){
				System.out.println("Se produjo el siguiente error: "+ex);
			}
		}else{
			System.out.println("La imagen no se encontro");
		}
	return image;
	}


	/*Formato de ejecucion del programa, y alguna otra informacion */
	public static void information(){
		System.out.println("Informacion");
		System.out.println("Formatos de imagenes aceptadas: BMP, PNG, JPG y GIF");
		System.out.println("Width y Height permitidos: cualquier dimension");
		System.out.println("Comando para clonar una imagen: java ImageCloner nombreDeTuImagen.formato");
		System.out.println("Comando para salirse del programa: java ImageCloner -exit");

	}
	public static void main(String[] args){
		int noParametros = args.length;
		//el numero de parametros empieza despues de java ImageCloner primerParametro
		if(noParametros==1){
			if(args[0].equals("-help")){
				information();
			}else if(args[0].equals("-exit")){
				System.out.println("Saliendo...");
				System.exit(0);
			}else{
				/*asumimos que el otro parametro ingresado es el nombre de la imagen,
				aunque despues usamos un filtro en un if para confirmar que este texto ingresado como imagen
				existe*/
				File file = new File(args[0]);
				if(file.exists()){
					mensaje();//cuando la imagen se esta clonando mostramos estos textos
					ImageCloner imageCloner = new ImageCloner();
					imageCloner.clone(args[0]);
				}else{
					System.out.println("La imagen ingresada no existe.");
				}
			}
		}else{
			System.out.println("Usage: java ImageCloner imagenAClonar.bmp");
		}
	}

}
