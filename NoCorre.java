import java.io.*;

public class NoCorre {
    public static void main(String[] args) throws Exception {
        BufferedReader tec = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("\n**** CC2 - Laboratorio #1 - Ejercicio #2 ****\n");
        System.out.println("Ingrese una oracion: ");
        String oracion = tec.readLine();

        String[] separados = oracion.split("\\s");
        System.out.println("\n Cantidad de palabras en la oracion: " + separados.length);
        String ppalabra = oracion.substring(0,oracion.indexOf(" "));
        System.out.println(" Primera palabra: " + ppalabra);
        String pletra = ppalabra.substring(0,1);/*unicamente colocamos el valor de cero coma 1 para obtener la primera letra*/
        System.out.println(" Primera letra de primera palabra: " + pletra);
        /*le restamos uno a la longitud de la palabra, le estabamos sumando uno*/
        String uletra = ppalabra.substring(ppalabra.length()-1,ppalabra.length());
        /*faltaba poner las comillas dobles*/
        System.out.println("");
        String s = "esperanza";
        /*empieza desde cero por eso muestre posicion 7*/
        System.out.println("La letra z en \"esperanza\" esta en la posicion: " + s.indexOf("z"));
        /*corregimos el numero, siempre empieza de cero por eso es 3*/
        System.out.println("La segunda e en \"esperanza\" esta en la posicion: " + s.indexOf("e",3));
        System.out.println();
        System.out.println("Si llego hasta aca sin ningun error, y el output de su programa es el esperado, su ejercicio esta correcto ;)");

    }
}
