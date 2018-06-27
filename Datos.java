//clase que representa lo que vamos a ir almacenando en las colas
public class Datos{
  //representa al numero correlativo
  private int id=0;

  //variable donde almacenamos el monto generado
  private double monto=0;

  //devolvemos el monto
  public Double getMonto(){
    return monto;
  }

  //formato id:monto
  public String toString(){
    String mensaje = ""+this.id + ":"+this.monto+"";
    return mensaje;
  }

  //constructor
  public Datos(int id,double monto){
    this.id=id;
    this.monto=monto;
  }

}
