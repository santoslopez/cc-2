/** CC2 - 2016
    Ejercicio #2 - Lab#5 **/

import java.util.*;

public class CountElements {

	/*** ESTE ES EL METODO QUE TIENE QUE IMPLEMENTAR ***/
	public static int counter(int[][] mat, int n) {
		int contador=0;//variable que nos sirve para ir guardando la cantidad de veces que se repite el numero a buscar
		int noFilas = mat.length;//devuelve el numero de filas del arreglo
		int noColumnas = mat[0].length;//devuelve el numero de columnas del arreglo

		//dividimos el arreglo en filas y columnas para poder buscar en un arreglo bidimensional
		for (int fila=0;fila<noFilas;fila++){
			for(int columna=0;columna<noColumnas;columna++){
				if(mat[fila][columna]==n){
					contador++;
				}else{
				}
			}
		}
	return contador;
	}

    /*** Para probar que su metodo funciona **/
	public static void main(String[] args) {
		Random r = new Random();
		int altura = r.nextInt(9) + 2;
		int ancho = r.nextInt(9) + 2;
		int[][] matriz = new int[altura][];
		for (int i=0;i<matriz.length;i++) {
			int[] f = new int[ancho];
			for (int j=0;j<f.length;j++) f[j] = r.nextInt(11) + 10;
			matriz[i] = f;
		}
		int abuscar = r.nextInt(11) + 10;
		int count = counter(matriz,abuscar);
		System.out.println("Matriz: ");
		for (int k=0;k<matriz.length;k++) System.out.println(Arrays.toString(matriz[k]));
		System.out.println("Numero que se busco: " + abuscar);
		System.out.println("Ocurrencias en la matriz: " + count);

	}
}
