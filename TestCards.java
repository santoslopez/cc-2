/*  CC2 - 2015
    Laboratorio #9 
    @author Andrea Quan */

/*** NO MODIFICAR ESTA CLASE ****/

import java.util.*;

public class TestCards {
    public static void main(String[] args) {
        Card[] arreglo1 = new Card[8];
        Card[] arreglo2 = new Card[8];
        Random r = new Random();
        // Llena el arreglos de Cartas aleatorias
        for (int i=0;i<arreglo1.length;i+=1) {
            arreglo1[i] = new Card((byte)(r.nextInt(12)+1), (byte)(r.nextInt(4)+1));
        }
        for (int i=0;i<arreglo2.length;i+=1) {
            arreglo2[i] = new Card((byte)(r.nextInt(12)+1), (byte)(r.nextInt(4)+1));
        }
        // Cartas a buscar
        Card uno = new Card((byte)(r.nextInt(12)+1), (byte)(r.nextInt(4)+1));
        Card dos = new Card((byte)(r.nextInt(12)+1), (byte)(r.nextInt(4)+1));
        Card tres = arreglo1[r.nextInt(arreglo1.length)];
        Card cuatro = arreglo2[r.nextInt(arreglo2.length)];
        
        // PRUEBA ASCENDENTE
        System.out.println("\n");
        System.out.println("Prueba Ascendente:");       
        // Despliega el arreglo
        System.out.println("original: " + Arrays.toString(arreglo1));
        // ordenamos ascendentemente
        Algorithms.bubbleSort(arreglo1,true);
        System.out.println("ascendente: " + Arrays.toString(arreglo1));
        // busqueda
        System.out.println("La carta " + uno + " se encuentra en la posicion: "
                        + Algorithms.binarySearch(arreglo1,uno,true));
        System.out.println("La carta " + dos + " se encuentra en la posicion: " 
                        + Algorithms.binarySearch(arreglo1,dos,true));
        System.out.println("La carta " + tres + " se encuentra en la posicion: " 
                        + Algorithms.binarySearch(arreglo1,tres,true));
        // PRUEBA DESCENDENTE
        System.out.println("\n");
        System.out.println("Prueba Descendente:");        
        // Despliega el arreglo
        System.out.println("original: " + Arrays.toString(arreglo2));
        // ordenamos descendente
        Algorithms.bubbleSort(arreglo2,false);
        System.out.println("descendente: " + Arrays.toString(arreglo2));               
        // busqueda
        System.out.println("La carta " + uno + " se encuentra en la posicion: "
                        + Algorithms.binarySearch(arreglo2,uno,false));
        System.out.println("La carta " + dos + " se encuentra en la posicion: " 
                        + Algorithms.binarySearch(arreglo2,dos,false));
        System.out.println("La carta " + cuatro + " se encuentra en la posicion: " 
                        + Algorithms.binarySearch(arreglo2,cuatro,false));        
        
    }
}