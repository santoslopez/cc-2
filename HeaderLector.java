import java.io.*;
import java.util.*;
public class HeaderLector{
	//en este arreglo de byte vamos a guardar los valores del encabezado, los primeros 54 bytes
	private static byte[] header= new byte[54];

	//patron de diseno singleton para crear una sola instancia de la clase
	private static HeaderLector instancia;
	public static HeaderLector getInstancia(){
		if (instancia==null) {
			instancia=new HeaderLector();
		}
		return instancia;
	}

	//metodo que nos devuelve el formato de ejecucion del programa
	public void formatoEjecucion(){
		System.out.println("Para obtener detalles de la imagen.....\n");
		System.out.println("santoslopez@galileo:~$ java HeaderLector imagen.bmp");
	}

	//los parametros posicion1, posicion2, posicion3, posicion4 realmente son las posiciones donde se encuentra el ancho, alto de la imagen
	public int calcularInformacion(int posicion1,int posicion2,int posicion3,int posicion4){
		int ecuacion = (((int)header[posicion1]&0xff)<<24) | (((int)header[posicion2]&0xff)<<16) | (((int)header[posicion3]&0xff)<<8) | ((int)header[posicion4]&0xff);
  	return ecuacion;
	}

	public static void main(String[] args){
		try {
			int numeroParametros = args.length;
			switch (numeroParametros) {
				case 1:
				FileInputStream fileInputStream = null; //archivo entrada
				File archivo = new File(args[0]);

				//verificamos si el archivo existe
				if (archivo.exists()) {
					fileInputStream = new FileInputStream(archivo);
					/*informacion de imagen. Leyendo los primeros 54 datos del header*/
					for(int i=0;i<=header.length-1;i++){
	          header[i]=(byte)fileInputStream.read();
	        }

					//Obtenemos el ancho de la imagen
					int ancho =	HeaderLector.getInstancia().calcularInformacion(21,20,19,18);
					//Obtenemos el alto de la imagen
					int alto = HeaderLector.getInstancia().calcularInformacion(25,24,23,22);

					//cabecera del bitmap
					int cabeceraBitmap = HeaderLector.getInstancia().calcularInformacion(17,16,15,14);

					/*verificamos si la imagen es bitmap, el 66 es equivalente a B y el 77 a M*/
					if((header[0]==66) && (header[1]==77) ){
						System.out.println("Primeros 54 bytes de la imagen: \n");
						System.out.println(Arrays.toString(header)+"\n");
						System.out.println("El ancho de la imagen es: "+ancho);
						System.out.println("El alto de la imagen es: "+alto);
						System.out.println("Cabecera del bitmap: "+cabeceraBitmap);
					}else {
						System.out.println("El formato de la imagen no es bitmap, no hay resultados.");
					}
				}else{
					System.out.println("El parametro ingresado como imagen: "+args[0]+ " no se encontro.\n");
				}
				break;

				default:
				HeaderLector.getInstancia().formatoEjecucion();
				break;
			}
		}catch(Exception exc){
			System.out.println("Se produjo el siguiente error: "+exc.getMessage());
		}
	}
}
