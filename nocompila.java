/*Agregamos estas tres librerias*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
/*Fin agregando librerias*/
public class nocompila {
/*agregamos la excepcion, y corregimos el nombre del metodo, y agregamos los corchetes que hacen falta
dentro del main*/
    public static void main(String args[]) throws IOException{
        BufferedReader tec = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\n**** CC2 - Laboratorio #1 - Ejercicio #1 ****\n");
        System.out.println("Ingrese su Nombre Completo (2 nombres y 2 apellidos): ");
        String nombre = tec.readLine();/*agregamos el tipo String a la variable*/
        String[] separados = nombre.trim().split("\\s");
        if (separados.length == 4) {
            System.out.println("\n Asumiendo que ingreso todo correctamente:");
            String n1 = separados[0];/*Le faltaba el punto y coma*/
            System.out.println(" Su primer nombre en mayusculas: " + n1.toUpperCase());
            StringBuffer a1 = new StringBuffer(separados[2]);
            System.out.println(" Su primer apellido al reves: " + a1.reverse());
            String n2 = separados[1];

            /*le faltaba al metodo length los parentesis, y faltaba el parentesis que cierra */
            System.out.println(" Cantidad de letras en segundo nombre: " + n2.length());
            String a2 = separados[3].replaceAll("[aeiou]","-");
            System.out.println(" Vocales en su segundo apellido reemplazadas por guion: " + a2);/*cambiamos el signo negativo por el positivo*/
            System.out.println("\nSi todo esta correcto, ya termino su ejercicio ;) \n");/*no es printline es print*/

        } else System.out.println("No ingreso cuatro palabras");

    }
}
