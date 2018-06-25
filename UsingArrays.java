import java.util.*;
import java.util.regex.*;
import java.util.Random;
import java.io.*;
import java.lang.Math;

public class UsingArrays{
	//patron de diseno singleton para crear una sola instancia de la clase
	private static UsingArrays instancia;
	public static UsingArrays getInstancia(){
		if (instancia==null) {
			instancia=new UsingArrays();
		}
		return instancia;
	}

	//generar numero aleatorio
	public void generarNumeroAleatorio(int [] arregloGrande){
		for (int i=0; i<arregloGrande.length; i++) {
			int numeroGenerado =  (int) (Math.random() * 20) + 1;
			arregloGrande[i]=numeroGenerado;

		}
	}

	//llenamos un arreglon aleatorioamente con un numero definido desde un rando permitido para generar
	public void llenarArregloRangos(int[] primerArreglo,int fin,int inicio){
		Random random = new Random();
		int numeroGenerado = (int)(Math.random() * (fin - inicio)+inicio);
		for (int i=0;i<=primerArreglo.length-1 ;i++) {
			primerArreglo[i]=numeroGenerado;
		}
	}

	//llenar arreglo descendentemente con la longitud del arreglo mas grande
	public void llenarDescendentemente(int [] arreglo){
		/*Llenamos el arreglo de longitud mas larga, de forma descendente (De N hasta 1). */
		int longitud  = arreglo.length-1;
		for(int descendente=0;descendente<arreglo.length;descendente++){
			arreglo[descendente]=longitud;
			longitud--;
		}
	}

	//llenamos el arreglo con datos pidiendole al usuario que ingrese los mismos
	public void llenarArregloManualmente(int [] arreglo) throws Exception{
		int longitudArreglo = arreglo.length-1;
		int contador = 0;
		BufferedReader lectura = new BufferedReader(new InputStreamReader(System.in));
		boolean salir = false;
		while((contador<longitudArreglo) && (salir==false)){
			contador++;
			System.out.println("Ingrese el valor de la posicion: "+contador+ " del arreglo");
			String ingresado = lectura.readLine();
			//verificamos que estos datos sean numeros
			if (Pattern.matches("[0-9]+",ingresado)) {
				int valorIngresado = Integer.parseInt(ingresado);
				arreglo[contador]=valorIngresado;//llenamos el arreglo en la posicion con el valor ingresado
			}else {
				System.out.println("ERROR!!! No se puede llenar el arreglo con esto");
				//el contador se resta para que nos mantengamos en la posicion del arreglo donde no se pudo ingresar el dato ingresado
				contador = contador - 1;
				salir = false;
			}
		}
	}

	public static void main(String[] args) throws Exception{
		//almacenamos el numero de argumentos del programa
		int numeroArgumentos = args.length;
		if (numeroArgumentos==2) {
			String primerNumero = args[0];
			String segundoNumero = args[1];
			if ((Pattern.matches("[0-9]+",primerNumero) ) && (Pattern.matches("[0-9]+",segundoNumero) ) ) {
				int n1 = Integer.parseInt(primerNumero);
				int n2 = Integer.parseInt(segundoNumero);

				//si los numeros son mayores a 15 y distintos entres si
				if ((n1!=n2)&&(n1>15)&&(n2>15)) {
					System.out.println("Ejercicio 1 terminado -> Argumentos de 2 numeros se cumple");
					//creamos el primer arreglo de longitud n1
					int primerArreglo[] = new int[n1];

					//creamos el segundo arreglo de longitud n2
					int segundoArreglo[] = new int[n2];

					System.out.println("\nEJercicio 2 terminado -> 2 arreglos de enteros creados ");
					System.out.println("Primer arreglo de longitud: "+primerArreglo.length + " y "+" segundo arreglo de longitud: "+segundoArreglo.length);
					//desplegando los arreglos
					System.out.println("\nEjercico 3: ");
					System.out.println("Primer argumento, arreglo creado: ");
					System.out.println(String.valueOf(Arrays.toString(primerArreglo)));
					System.out.println("Segundo argumento, arreglo creado");
					System.out.println(String.valueOf(Arrays.toString(segundoArreglo)));

					System.out.println("\nEjercicio 4: ");
					//si el primer arreglo es de longitud mayor al otro
					if (primerArreglo.length>segundoArreglo.length) {
						//llenamos el primer arreglo con los numeros generados
						UsingArrays.getInstancia().llenarArregloRangos(primerArreglo,60,15);
						System.out.println("\nLlenando el primer arreglo por ser el mayor con el numero generado: ");
						System.out.println(String.valueOf(Arrays.toString(primerArreglo)));


					}else {
						//asumimos que el segundo arreglo es el grande
						UsingArrays.getInstancia().llenarArregloRangos(segundoArreglo,60,15);
						System.out.println("Llenando el segundo arreglo por ser el mayor con el numero generado: ");
						System.out.println(String.valueOf(Arrays.toString(segundoArreglo)));
					}
					System.out.println("\nEjercicio 5: llenar con numeros aleatorios entre 1 y 20 ");
					UsingArrays.getInstancia().generarNumeroAleatorio(segundoArreglo);
					System.out.println("Arreglo llenado con los numeros mencionados. Resultados abajo: ");
					System.out.println("\nEjercicio 6: Desplegando arreglos: ");
					System.out.println(String.valueOf(Arrays.toString(primerArreglo)));
					System.out.println("Arreglo llenado con numeros aleatorios en el rango mencionado");
					System.out.println(String.valueOf(Arrays.toString(segundoArreglo)));
				  System.out.println("\nEjercicio 7: Llene el arreglo mas grande de numeros del n hasta 1, descendentemente (n es el tamanio del arreglo). \n(Tiene que hacerlo manualmente, no hay metodo en la clase Arrays para esto) ");

					//basicamente llenamos el arreglo de forma descendente solo necesitamos saber el arreglo mas grande
					if (primerArreglo.length>segundoArreglo.length) {
						UsingArrays.getInstancia().llenarDescendentemente(primerArreglo);
						System.out.println("Arreglo llenado de forma descendente. \nEjercicio 8");
						System.out.println(Arrays.toString(primerArreglo));
						//llenando el arreglo pequeno
						System.out.println("\nEjercicio 9 - Llenando el arreglo pequeno manualmente desde el teclado");
						UsingArrays.getInstancia().llenarArregloManualmente(segundoArreglo);
						System.out.println("\nEjercicio 10 - Desplegando resultados");
						System.out.println(Arrays.toString(primerArreglo));
						System.out.println("\nEjercicio 11 - Ordenando arreglo con funcion Sort");
						Arrays.sort(segundoArreglo);
						System.out.println("Arreglo ordenado.");
						System.out.println("\nEjercicio 12 - Desplegando arreglo ordenado");
						System.out.println(Arrays.toString(segundoArreglo));
					}else{
						UsingArrays.getInstancia().llenarDescendentemente(segundoArreglo);
						System.out.println("Arreglo llenado de forma descendente. \nEjercicio 8");
						System.out.println(Arrays.toString(segundoArreglo));

						//llenando el arreglo pequeno
						System.out.println("\nEjercicio 9 - Llenando el arreglo pequeno manualmente desde el teclado");
						UsingArrays.getInstancia().llenarArregloManualmente(primerArreglo);
						System.out.println("\nEjercicio 10 - Desplegando resultados");
						System.out.println(Arrays.toString(primerArreglo));

						System.out.println("\nEjercicio 11 - Ordenando arreglo con funcion Sort");
						Arrays.sort(primerArreglo);
						System.out.println("Arreglo ordenado.");
						System.out.println("\nEjercicio 12 - Desplegando arreglo ordenado");
						System.out.println(Arrays.toString(primerArreglo));
					}


				}else {
					System.out.println("Error, valores invalidos");
				}
			}else {
				System.out.println("ERROR!!! El primer argumento : "+primerNumero + " o el segundo argumento: "+segundoNumero + " no son numeros");
			}
		}else {
			System.out.println("El numero de argumentos es incorrecto!!!");

		}
	}
}
