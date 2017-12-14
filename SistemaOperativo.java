/*

Clase SistemaOperativo.java que nos permite limpiar la pantalla de la consola sin importar si estamos en el SO
Windows o Ubuntu, para lograr esto averiguamos primero que SO estamos utilizando

*/
public class SistemaOperativo{
  //patron de diseno singleton para crear una sola instancia de la clase
  private static SistemaOperativo instancia;
  public static SistemaOperativo getInstancia(){
    if (instancia==null) {
      instancia=new SistemaOperativo();
    }
    return instancia;
  }

  /*vamos averiguar que sistema operativo estamos utilizando*/
  private static String sistemaOperativo = System.getProperty("os.name").toLowerCase();

  //devolvemos el nombre del sistema operativo
  public String getSistemaOperativo(){
    return sistemaOperativo;
  }

  //metodo que nos permite limpiar la pantalla de la consola sin importar si es Windows o Ubuntu
  public void limpiarPantalla(){
    try {
      //si nuestro sistema operativo es Windows
      if (SistemaOperativo.getInstancia().getSistemaOperativo().indexOf("win")>=0 ) {
        SistemaOperativo.getInstancia().windows();
        //si nuestro sistema operativo es Linux
      }else if (SistemaOperativo.getInstancia().getSistemaOperativo().indexOf("lin")>=0) {
        SistemaOperativo.getInstancia().ubuntu();
      }else{
      }
    }catch(Exception exception){
      System.out.println("Se produjo el siguiente error: "+exception.getMessage());
    }
  }

  //metodo para limpiar la consola, terminal o pantalla de Windows
  public void windows(){
    try {
      new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }catch(Exception exception){
      System.out.println("Se produjo el siguiente error: "+exception.getMessage());
    }
  }

  //limpiamos la consola de esta forma si nuestro sistema operativo es ubuntu
  public void ubuntu(){
    System.out.print("\033\143");
    System.out.flush();
  }
}
