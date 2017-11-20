/*
Nombre: Santos Lopez Tzoy
Carnet: 15002241
Seccion: AN
Keep up your hard work, and Go Bears!
*/

import java.util.*;
import java.io.*;
public class BmpHandlerCore{
  private int ancho;
  private int alto;
  private int cabeceraBitmap;
  private int bitmap;

  //en este arreglo de byte vamos a guardar los valores del encabezado, los primeros 54 bytes
  private byte[] header= new byte[54];

  //devolvemos el ancho de la imagen
  public int getAncho(){
    return ancho;
  }

  //devolvemos el alto de la imagen
  public int getAlto(){
    return alto;
  }

  public int getCabeceraBitmap(){
    return cabeceraBitmap;
  }

  /*patron de diseno singleton para crear una unica instancia de la clase*/
  private static BmpHandlerCore instancia;
  public static BmpHandlerCore getInstancia(){
    if(instancia==null){
      instancia=new BmpHandlerCore();
    }
    return instancia;
  }


//cuando la imagen se este generando mostramos el mensaje del que se termino de procesar.
public void mensajes(String tonalidad){
  System.out.println("La imagen "+tonalidad+" fue generada correctamente");
}

//calculos para imagen Sepia
public int calculosSepia(int tonalidadRojo,int tonalidadVerde,int tonalidadAzul,double valorRojo,double valorVerde,double valorAzul){
  int ecuacion = (int)((tonalidadRojo * valorRojo) + (tonalidadVerde * valorVerde) + (tonalidadAzul * valorAzul));
  return ecuacion;
}

//los parametros posicion1, posicion2, posicion3, posicion4 realmente son las posiciones donde se encuentra el ancho, alto de la imagen
public int calcularInformacion(int posicion1,int posicion2,int posicion3,int posicion4){
  int ecuacion = (((int)header[posicion1]&0xff)<<24) | (((int)header[posicion2]&0xff)<<16) | (((int)header[posicion3]&0xff)<<8) | ((int)header[posicion4]&0xff);
  return ecuacion;
}

public String imagen(String nombreImagen){
  File archivo = new File(nombreImagen);
  FileInputStream fileInputStream = null; //archivo entrada
  FileOutputStream fileOutputStream = null;//archivo salida
  String[] colores = {"Red","Blue","Green","Sepia","Clone"};

  //verificamos si el archivo de la imagen que se ingreso como parametro existe
  if(archivo.exists()){
    try{
      String imagenSinExtension = nombreImagen.substring(0,4);//obtenemos el nombre de la imagen sin su extension

      for(int c=0;c<colores.length;c++){
        fileInputStream = new FileInputStream(archivo);
        fileOutputStream = new FileOutputStream(imagenSinExtension+colores[c]+".bmp");

        /*informacion de imagen. Leyendo los primeros 54 datos del header*/
        for(int i=0;i<=header.length-1;i++){
          header[i]=(byte)fileInputStream.read();
        }
        fileOutputStream.write(header);//escribimos el header

        /*Imprimir informacion del header. Primeros 54 bytes*/
        //System.out.println(Arrays.toString(header));

        //cabecera del bitmap
        cabeceraBitmap = ancho = BmpHandlerCore.getInstancia().calcularInformacion(17,16,15,14);
        //Obtenemos el ancho de la imagen
        ancho = BmpHandlerCore.getInstancia().calcularInformacion(21,20,19,18);
        //Obtenemos el alto de la imagen
        alto = BmpHandlerCore.getInstancia().calcularInformacion(25,24,23,22);

        /*verificamos si la imagen es bitmap, el 66 es equivalente a B y el 77 a M*/
        if((header[0]==66) && (header[1]==77) ){
          /*si la imagen no tiene el ancho y alto esperado entonces indicamos que no lo soporta*/
          if((ancho==640)&&(alto==480)){
            int tamanoCompleto = (int)archivo.length();//longitud toda la imagen
            int tamanoHeader = header.length;//longitud del encabezado
            byte restoBytes[]=new byte[tamanoCompleto-tamanoHeader];//arreglo de longitud completa - longitud encabezado
            for(int r=0;r<=restoBytes.length-1;r++){
              restoBytes[r]=(byte)fileInputStream.read();
            }
            if(c==0){
              /*imagen rojo*/
              for(int r=0;r<=restoBytes.length-1;r+=3){
                fileOutputStream.write(0);
                fileOutputStream.write(0);
                fileOutputStream.write(((int)restoBytes[r + 2]&0xff));
              }
              BmpHandlerCore.getInstancia().mensajes(colores[0]);
            }else if(c==1){
              /*imagen azul*/
              for(int b=0;b<=restoBytes.length-1;b+=3){
                fileOutputStream.write(((int)restoBytes[b ]&0xff));
                fileOutputStream.write(0);
                fileOutputStream.write(0);
              }
              BmpHandlerCore.getInstancia().mensajes(colores[1]);
            }else if(c==2){
              /*imagen verde*/
              for(int g=0;g<=restoBytes.length-1;g+=3){
                fileOutputStream.write(0);
                fileOutputStream.write(((int)restoBytes[g + 1]&0xff));
                fileOutputStream.write(0);
              }
              BmpHandlerCore.getInstancia().mensajes(colores[2]);
            }else if(c==3){
              for(int s=0;s<=restoBytes.length-1;s+=3){
                int tonalidadRojo = (int)restoBytes[s + 2] & 0xff;
                int tonalidadVerde = (int)restoBytes[s + 1] & 0xff;
                int tonalidadAzul = (int)restoBytes[s + 0] & 0xff;

                // Calculos dados por Microsoft y estos sirven para obtener la tonalidad dela imagen en sepia
                int sepiaTonalidadAzul = BmpHandlerCore.getInstancia().calculosSepia(tonalidadRojo,tonalidadVerde,tonalidadAzul,0.272,0.534,0.131);
                int sepiaTonalidadVerde = BmpHandlerCore.getInstancia().calculosSepia(tonalidadRojo,tonalidadVerde,tonalidadAzul,0.349,0.686,0.168);
                int sepiaTonalidadRojo = BmpHandlerCore.getInstancia().calculosSepia(tonalidadRojo,tonalidadVerde,tonalidadAzul,0.393,0.769,0.189);

                // si los colores de las variables en sepia son mayores a los 255 en su defecto establecemos en el segundo parametro de Math.min el valor de 255
                fileOutputStream.write(Math.min(sepiaTonalidadAzul, 255));
                fileOutputStream.write(Math.min(sepiaTonalidadVerde, 255));
                fileOutputStream.write(Math.min(sepiaTonalidadRojo, 255));
              }
              BmpHandlerCore.getInstancia().mensajes(colores[3]);
            }else{
              fileOutputStream.write(restoBytes);//clonamos la imagen
            }
            fileOutputStream.close();

          }else{
            BMPImageHandler.getInstancia().limpiarPantalla();//nos sirve para limpiar nuestra consola de pantalla
            System.out.println("El programa no soporta imagenes mayores a 640x480");
            break;
          }
        }else{
          BMPImageHandler.getInstancia().limpiarPantalla();
          System.out.println("La imagen no es bitmap");
          break;
        }

      }
    }catch(Exception e){
      System.out.println("Se produjo el siguiente error :"+e.getMessage());
    }
}else{
  BMPImageHandler.getInstancia().limpiarPantalla();//nos sirve para limpiar nuestra consola de pantalla
  System.out.println("La imagen no existe");
}
return nombreImagen;
}

}
