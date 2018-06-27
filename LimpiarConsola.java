/*Clase LimpiarConsola.java cuya funcionalidad es limpiar la consola de Windows o Ubuntu*/

public class LimpiarConsola{
  //variable donde obtenemos una una propiedad del sistema indicada mediante la clave
  private String sistemaOperativo = System.getProperty("os.name").toLowerCase();

  //patron de diseno singleton para crear una sola instancia de la clase
  private static LimpiarConsola instancia;
  public static LimpiarConsola getInstancia(){
    if (instancia==null) {
      instancia=new LimpiarConsola();
    }
    return instancia;
  }

  public void ejecutar(){
    try {
      //verificamos si nuestro sistema operativo es windows
      if (this.sistemaOperativo.indexOf("win")>=0) {
        new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
      }else if (this.sistemaOperativo.indexOf("lin")>=0) {
        System.out.print("\033\143");
        System.out.flush();
      }
    }catch (Exception e) {
      System.out.println("Se produjo el siguiente error: "+e.getMessage());
    }
  }

}
