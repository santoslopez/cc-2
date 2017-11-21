import java.util.*;
import java.util.Arrays;
import java.util.Random;//importamos para poder utilizar la clase Random
import java.util.regex.*;
public class UsingArrays{

	/*Todas las variables que voy a utilizar. Lo puse estatico para poder
	usar las variables en el main sin tener que instanciar*/
	private static String primerNumero,segundoNumero,ciclo;
	private static int n1,n2,buscarNumero;
	private static int[] primerArreglo,segundoArreglo,unionDeArreglos;

	public static int[] llenarArreglo(int longitud, int[] arreglo,String signo){
		if(signo.equals("+")){
			for(int i=0;i<arreglo.length;i++){
				arreglo[i]=longitud+1;
			}
		}else if(signo.equals("-")){
			/*Llenamos el arreglo de longitud mas larga, de forma descendente (De N hasta 1). */
			for(int descendente=0;descendente<arreglo.length;descendente++){
				arreglo[descendente]=longitud;
				longitud--;
			}
		}

		return arreglo;
	}

	public static int[] llenandoArregloRandom(int[] unionDeArreglos){
		Random random = new Random();
		int generando = 0;
		for(int i=0;i<unionDeArreglos.length;i++){
			generando=(random.nextInt(90)+10);
			unionDeArreglos[i]=generando;
		}
		System.out.println("Mostrando valores del NUEVO arreglo llenado: "+ Arrays.toString(unionDeArreglos)+"\n");

		return unionDeArreglos;
	}

	public static int[] buscandoNumero(int[]unionDeArreglos){
		int buscarNumero;
		Random random = new Random();
		bucle: //utilizo esta etiqueta para que me saque del bucle
		while(true){
			buscarNumero = (random.nextInt(90) + 10);
			int guardado =-1;
			System.out.println("Buscando el numero " + buscarNumero);
			for(int i=0;i<unionDeArreglos.length-1;i++){

				if(unionDeArreglos[i]==buscarNumero){
					guardado = i;
					System.out.println("El numero: "+ buscarNumero +  " " + " fue encontrado en el indice No: " + guardado);
					break bucle;
				}
			}
		}
		System.out.println("Todos los ejercicios fueron terminados");
		return unionDeArreglos;
	}
	public static int llenarArregloManualmente(int longitudArreglo){
		int arreglo[]= new int[longitudArreglo];
		Scanner escaner=new Scanner(System.in);
		String pedir;
		char s='s';
		while(s=='s'){
			try{
				for(int i=0;i<arreglo.length;i++){
					System.out.println("Ingrese valor No. "+ i + " para el arreglo.");
					pedir = escaner.nextLine();
					arreglo[i]=Integer.parseInt(pedir);

				}
				s='t';
			}catch(NumberFormatException nfe){
				System.out.println(nfe.getMessage()+" El arreglo acepta unicamente numeros");
				s='s';
			}
		}
		System.out.println("Ejercicio 9: ");
		System.out.println("Arreglo de menor longitud llenado de forma manual:");
		System.out.println(Arrays.toString(arreglo));
		System.out.println("Ejercicio 10 y ejercicio 11: ");
		System.out.println("Ordenando arreglo de menor longitud. Arreglo que fue llenado de forma manual");
		Arrays.sort(arreglo);

		System.out.println(Arrays.toString(arreglo));
		return longitudArreglo;
	}


	public static void main(String[] args){
		int noParametros = args.length;
		if(noParametros==2){
			int primerParametro = Integer.parseInt(args[0]);
			int segundoParametro = Integer.parseInt(args[1]);
			if(primerParametro>12 && segundoParametro>12){
				//Debe crear dos arreglos de enteros de los tamanios recibidos como argumentos
				/*primeros dos ejercicios*/


				int primerArreglo[]=new int[primerParametro];
				int segundoArreglo[]=new int[segundoParametro];

				System.out.println("1 y 2 ejercicios: se crearon dos arreglos con los parametros ingresados");
				/*ejercicio 3*/
				System.out.println("Ejercicio 3: ");
				System.out.println(Arrays.toString(primerArreglo));
				System.out.println(Arrays.toString(segundoArreglo));

				int longitudPrimerArreglo = primerArreglo.length;//obtenemos la longitud del primer arreglo
				int longitudSegundoArreglo = segundoArreglo.length;//obtenemos la longitud del arreglo 2

				Random random = new Random();
			  int random1 = (random.nextInt(50) + 10);//genera un numero entre 10 y 50
			  int random2 = (random.nextInt(10) + 1);//genera un numero entre 1 y 10

				System.out.println("Ejercicio 4: se generaron 2 numeros aleatorios para llenar cada arreglo.");
				if(longitudPrimerArreglo>longitudSegundoArreglo){

					/*ejercicio 4*/
					llenarArreglo(random1,primerArreglo,"+");//llenamos el arreglo mas grande
					llenarArreglo(random2,segundoArreglo,"+");//llenamos el arreglo mas pequeno

					/*ejercicio 5*/
					System.out.println("Ejercicio 5: ");
					System.out.println(Arrays.toString(primerArreglo));
					System.out.println(Arrays.toString(segundoArreglo));

					System.out.println("Ejercicio 6: Llenando el arreglo mas grande de forma descendente(con su propia longitud)");
					llenarArreglo(longitudPrimerArreglo,primerArreglo,"-");//llenamos el arreglo mas grande
					System.out.println("Ejercicio 7: ");
					System.out.println(Arrays.toString(primerArreglo));
					System.out.println("Ejercicio 8: el arreglo acepta unicamente numeros");

					llenarArregloManualmente(primerArreglo.length);


					System.out.println("Creando NUEVO arreglo de longitud "+ (longitudPrimerArreglo+longitudSegundoArreglo)+"\n");
			    int unionDeArreglos[]=new int[longitudPrimerArreglo+longitudSegundoArreglo];
					System.out.println(Arrays.toString(unionDeArreglos));
					UsingArrays u = new UsingArrays();
					u.llenarArreglo((random.nextInt(90)+10),unionDeArreglos,"+");
					llenandoArregloRandom(unionDeArreglos);


					buscandoNumero(unionDeArreglos);

				}else if(longitudPrimerArreglo==longitudSegundoArreglo){
					System.out.println("Como ambos arreglos son iguales no hacemos nada.");
				}else{
					/*ejercicio 4*/
					llenarArreglo(random1,segundoArreglo,"+");//llenamos el arreglo mas grande
					llenarArreglo(random2,primerArreglo,"+");//llenamos el arreglo mas pequeno
					/*ejercicio 5*/
					System.out.println("Ejercicio 5: ");
					System.out.println(Arrays.toString(segundoArreglo));
					System.out.println(Arrays.toString(primerArreglo));

					System.out.println("Ejercicio 6: Llenando el arreglo mas grande de forma descendente(con su propia longitud)");
					llenarArreglo(longitudSegundoArreglo,segundoArreglo,"-");//llenamos el arreglo mas grande
					System.out.println("Ejercicio 7: ");
					System.out.println(Arrays.toString(segundoArreglo));
					System.out.println("Ejercicio 8: el arreglo acepta unicamente numeros");
					llenarArregloManualmente(segundoArreglo.length);

					System.out.println("Creando NUEVO arreglo de longitud "+ (longitudPrimerArreglo+longitudSegundoArreglo)+"\n");
			    int unionDeArreglos[]=new int[longitudPrimerArreglo+longitudSegundoArreglo];
					System.out.println(Arrays.toString(unionDeArreglos));

					UsingArrays u = new UsingArrays();

					llenandoArregloRandom(unionDeArreglos);

					buscandoNumero(unionDeArreglos);

				}
			}else{
				System.out.println("Error, valores invalidos");
			}
		}else{
			System.out.println("Formato: UsingArrays n n");
		}
	}
}
