public class BMPImageHandler{

  /*patron de diseno singleton para crear una unica instancia de la clase*/

  private static BMPImageHandler instancia;

  public static BMPImageHandler getInstancia(){
    if(instancia==null){
      instancia=new BMPImageHandler();
    }
    return instancia;
  }

  /*Si el numero de parametros es incorrecto ejecutamos estos mensajes*/
  public void mensajeError(){
    System.out.println("Ejecute el comando de ayuda:");
    System.out.println("java BMPImageHandler -help");
  }

  public void esperarMensaje(){
    System.out.println("Espere un momento...");
  }

  /*sirve para mantener la pantalla limpia todo el tiempo*/
  public static void limpiarPantalla(){
		System.out.print("\033[H\033[2J");
		System.out.flush();
  }

  public static void main(String[] args){
    try{
      int numeroArgumentos = args.length;
      if (numeroArgumentos==1) {
        if(args[0].equals("-help")){
          BMPImageHandler.getInstancia().limpiarPantalla();
          System.out.println("\nEjecutar las rotaciones de la Parte 1 de este proyecto.");
          System.out.println("java BMPImageHandler -rotate imagen.bmp");
          System.out.println("\nEjecutar las imagenes thin y flat de la Parte II de este proyecto.");
          System.out.println("java BMPImageHandler -resize imagen.bmp");
          System.out.println("\nEjecutar la Parte III de este proyecto.");
          System.out.println("java BMPImageHandler -grayscale imagen.bmp");
          System.out.println("\nEjecutar la Parte V de este proyecto.");
          System.out.println("java BMPImageHandler -kernel kernel.txt imagen.bmp");
          System.out.println("\nEjecutar todas las partes de este proyecto, menos la parte IV.");
          System.out.println("java BMPImageHandler -all imagen.bmp");
        }else{
          BMPImageHandler.getInstancia().limpiarPantalla();
          BMPImageHandler.getInstancia().mensajeError();
        }
      }else if(numeroArgumentos==2 && (args[0].equals("-basics") || args[0].equals("-core"))){
        BMPImageHandler.getInstancia().limpiarPantalla();
        BMPImageHandler.getInstancia().esperarMensaje();
        BmpHandlerCore.getInstancia().imagen(args[1]);//en args[1] se encuentra el nombre de la imagen

      }else if(numeroArgumentos==2 && (args[0].equals("-grayscale"))){
        //esperarMensaje();
        //BMPToGrayscale.getInstancia().imagen(nombreImagen);
        System.out.println("Parte no realizada");

      }else if(numeroArgumentos==2 && (args[0].equals("-rotate"))){
        //esperarMensaje();
        System.out.println("Parte no realizada");
        //BmpHandlerRotator.getInstancia().rotateImage (nombreImagen);
      }else if(numeroArgumentos==2 && (args[0].equals("-all"))){
        BMPImageHandler.getInstancia().limpiarPantalla();
        BMPImageHandler.getInstancia().esperarMensaje();
        //Ejecutando parte 1 del proyecto
        BmpHandlerCore.getInstancia().imagen(args[1]);
      }else if (numeroArgumentos==3) {

      }else{
        BMPImageHandler.getInstancia().limpiarPantalla();
        BMPImageHandler.getInstancia().mensajeError();
      }
    }catch(Exception ex){
      BMPImageHandler.getInstancia().limpiarPantalla();
      System.out.println("Se produjo el siguiente error: "+ex.getMessage());
    }
  }
}
