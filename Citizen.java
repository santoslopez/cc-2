/*
Nombre: Santos Lopez Tzoy
Carnet: 15002241
Seccion: AN
Keep up your hard work, and Go Bears!
*/
import java.util.Scanner;
import java.util.regex.*;
public class Citizen{

  public static void main(String args[]){
    Scanner escaner = new Scanner(System.in);
     ciclo: while (true) {
      System.out.println("Ingrese su nombre: ");
      String nombre = escaner.nextLine();

      /*Para que un nombre sea considerado valido debe tener al menos 3 letras. Por ejemplo: Ana, Aby
      Un formato valido de nombre puede tener 1 o 2 nombres. Ejemplo: Santos o Santos Guillermo
      */

      if (Pattern.matches("[a-zA-Z]{3,}+\\s[a-zA-Z]{1,}+",nombre)||Pattern.matches("[a-zA-Z]{3,}+",nombre)) {
        System.out.println("Ingrese su apellido: ");
        String apellido = escaner.nextLine();

        /*Para que un apellido sea considerado valido debe tener al menos 3 letras. Por ejemplo: Ana, Aby
        Un formato valido de nombre puede tener 1 o 2 nombres. Ejemplo: Santos o Santos Guillermo
        */

        if (Pattern.matches("[a-zA-Z]{3,}+\\s[a-zA-Z]{1,}+",apellido)||Pattern.matches("[a-zA-Z]{3,}+",apellido)) {
          System.out.println("Ingrese su DPI: ");
          String noDPI = escaner.nextLine();

          /*Para que el numero de DPI sea considerado valido debe tener 13 numeros, sin guion. Por ejemplo: 4753633377722
          */
          if (Pattern.matches("[0-9]{13}",noDPI)) {
            System.out.println("Ingrese su edad: ");
            String edad = escaner.nextLine();
            if (Pattern.matches("[0-9]{1,3}",edad)) {
              //con charAt obtenemos el caracter, solo le mandamos en que posicion queremos obtener el caracter
              String inicialNombre = Character.toString(nombre.charAt(0));
              String inicialApellido = Character.toString(apellido.charAt(0));
              System.out.println("**********Resumen**********");
              System.out.println("Nombre: "+apellido+", "+nombre);
              System.out.println("Dpi: "+noDPI);
              System.out.println("Edad: "+Integer.parseInt(edad));
              System.out.println("Iniciales: "+ inicialNombre.toUpperCase()+inicialApellido.toUpperCase());
              break ciclo;//salimos del ciclo
            }else{
              System.out.println("La edad no tiene un formato correcto, debe tener 1 o 3 numeros\n");
            }
          }else {
            System.out.println("El DPI no tiene el formato correcto. Formato valido 13 digitos por ejemplo: 4753633377722\n");
          }
        }else {
          System.out.println("El apellido no tiene un formato correcto. Formato valido debe tener 1 o 2 apellidos\n");
        }
      }else {
        System.out.println("El nombre no tiene un formato correcto. Formato valido debe tener 1 o 2 nombres\n");
      }
    }
  }
}
