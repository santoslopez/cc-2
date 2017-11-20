//Nombre: Santos Lopez Tzoy
//Carnet: 15002241
//Seccion: AN
import java.util.*;
import java.util.Random;
public class PlayList{
	Random random = new Random();
	PlayList playList;
	private String listaCanciones;
	private int numeroCancion = 8;

	/*variables que me sirven para poner un inicio y un final a la lista de reproduccion,
	basicamente estas variables los utilizo en los metodos forward y backward*/
	int empieza = 1;//Donde empieza la lista de canciones
	int termina = 10;//Donde termina la lista de canciones

	public PlayList(String listaCanciones,int numeroCancion){
		this.listaCanciones=listaCanciones;
		this.numeroCancion=1;
	}

	public String getCancionActual(){//devuelve un string con el nombre de la canción que se esta reproduciendo en el momento
		Scanner esc = new Scanner(listaCanciones);
		esc.useDelimiter(";");
		String cancionActual="";
		String dif="";
		/*la variable contador cuando sea igual al numero de cancion que se esta reproduciondo
		capturamos en otra variable el nombre de la cancion
		*/
		int cont=0;
		while(esc.hasNext()){
			cont++;
			if(cont==numeroCancion){
				cancionActual = esc.next();//guardamos el nombre de la cancion que se esta reproduciendo
			}else{
				dif = esc.next();
			}
		}
		return cancionActual;
	}
	public String toString(){//devuelve las canciones una debajo de la otra
		Scanner esc = new Scanner(listaCanciones);
		esc.useDelimiter(";");

		/*la variable contador lo uso para saber que cancion se esta reproduciendo
		y de esta forma en la linea donde se encuentra el contador poder capturar el nombre de la cancion.
		*/
		int cont=0;
		while(esc.hasNext()){
			cont++;
			if(cont==numeroCancion){
				//nombre = esc.next();//guardamos el nombre de la cancion que se esta reproduciendo
				System.out.println(esc.next()+" <--");//imprimimos e indicamos con las flechas que la cancion se esta reproduciendo
			}else{
				System.out.println(esc.next());
			}
		}
		return "";
	}
	public void forward(){//la canción a reproducir es la siguiente en la lista
		if (numeroCancion==termina){
			this.numeroCancion =  1;
		}else{
			this.numeroCancion = numeroCancion + 1;
		}

	}
	public void backward(){//retrocede una canción en la lista
		if(numeroCancion==empieza){
			this.numeroCancion=termina;
		}else{
			this.numeroCancion=numeroCancion - 1;
		}
	}
	public Byte gotoCancion(byte numero){//reproduce el numero de canción dada
		if(numero>=empieza||numero<=termina){
			this.numeroCancion=numero;
		}
		return numero;
	}
	public void random(){
		int rnd = (int)(random.nextDouble() * 10) + 1;//el número random generado va tener un rango de 1 a 10
		this.numeroCancion = rnd;
	}
}
