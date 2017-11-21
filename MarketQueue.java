import java.io.*;
import java.util.*;
public class MarketQueue{
	private static int numeroDeCola;//correlativo, conforme se van creando colas
	private static int personasEnLaCola;//numero maximo de personas en la cola
	private static int contador;//variable contador para tener un conteo de numero de colas creadas
	private static MarketQueue mayor_capacidad;

	public static int getQueueNumber(){//devuelve el numero de cola
		//int mayor_capacidad = personasEnLaCola;

		return numeroDeCola;
	}
	public static int getCapacity(){//devuelve la capacidad
		return personasEnLaCola;
	}
	public MarketQueue(int personasEnLaCola){
		this.personasEnLaCola=personasEnLaCola;
	}
	public static int getNumberOfQueues(){//devuelve el conteo de colas creadas
		if(numeroDeCola>=0){
			numeroDeCola +=1;
		}
		return numeroDeCola;
	}
	public static MarketQueue getMaxCapacityQueue(){
		return mayor_capacidad;
	}
	public String toString(){//devuelve o muestra el numero de cola y su capacidad
		String mostrar = numeroDeCola + " " + personasEnLaCola;
		return mostrar;
	}
}