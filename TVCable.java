import java.util.*;
public class TVCable{
	String nombre;
	String[] canales = {"History","Discovery", "TNT","Animal Planet","Universal","HBO"};
	int cantidadCanales=0;
	String capacidad;
	public  TVCable(String [] canales){
		String c[] = {String.valueOf(canales)};
	}
	public TVCable(int canales){
		this.cantidadCanales=canales;
	}
	public int getCapacidad(){
		return  cantidadCanales;
	}
	public int getCanal(int n){
		return n;
	}
	public void setCanal(int n, String c){
		this.cantidadCanales = n;
		this.nombre =c;
	}
	public String toString(){
		for(int i=0;i<canales.length;i++){
			System.out.println(canales[i]);
		}
		return "";
	}
	public void equals(TVCable c){

	}
}
