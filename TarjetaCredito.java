import java.util.regex.*;
import java.util.Random;
public class TarjetaCredito{
	private String numero;
	private String nombre;
	private Double limiteCredito;
	private Double tasaInteres;
	private Double saldo;
	int saldoDisponible;
	String tarjetaGenerada,grupo1,grupo2,grupo3,grupo4; //variables que utilizo para generar una tarjeta aleatoriamente
	Random generar = new Random();
	public TarjetaCredito(String numero, String nombre, Double limiteCredito, Double tasaInteres){
		if(!Pattern.matches("\\d{4}-\\d{4}-\\d{4}-\\d{4}", numero)){
			for(int i=1;i<=4;i++){
				int comparando = i;
				if(comparando==1){
					grupo1 = (generar.nextInt(4000)+5000+"-");
				}else if(comparando==2){
					grupo2 = (generar.nextInt(4000)+2000+"-");
				}else if(comparando==3){
					grupo3 = (generar.nextInt(5000)+2090+"-");

				}else if(comparando==4){
					grupo4 = (generar.nextInt(6000)+2000+"");
				}
				tarjetaGenerada = grupo1+grupo2+grupo3+grupo4;
			}
			this.numero=tarjetaGenerada;
			this.nombre=nombre;
			this.limiteCredito=limiteCredito;
			this.tasaInteres=tasaInteres;
			this.saldo=0.0;
			System.out.println("");
			System.out.println("La tarjeta se genero automaticamente");
		}else{
			this.numero = numero;
			this.nombre = nombre;
			this.limiteCredito = limiteCredito;
			this.tasaInteres = tasaInteres;
			this.saldo=0.0;
		}
	}

	public Double getLimiteCredito(){
		return limiteCredito;
	}
	public String getNombre(){
		return nombre;
	}
	public Double getTasaInteres(){
		return tasaInteres;
	}
	public String getNumero(){
		return numero;
	}
	public Double getSaldoActual(){
		Double operar = (tasaInteres * saldo);
		Double total_pagar = (operar + saldo);
		return total_pagar;

	}
	public Double getSaldoDisponible(){
		return saldo;
	}
	public boolean comprar(double monto){
		if (monto<=0||monto>limiteCredito){
			return false;
		}else{
			this.saldo= (double ) saldo + monto;
		}
		return true;
	}
	public String toString(){
		String imprimir = numero + " " + nombre + " " + saldo + " " + saldoDisponible + " " + limiteCredito + " " + tasaInteres;
		return imprimir;
	}
	public void corte(){
		Double operar = (tasaInteres * saldo);
		Double total = (operar + saldo);

	}
	public boolean pagar(Double monto){
		Double disminuir = (saldo - monto);
		if (monto<=0){
			return false;
		}else{
			this.saldo =disminuir;
			return true;
		}
	}
}