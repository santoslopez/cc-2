/** CC2 2015 - Laboratorio #4
    Ejercicio #3 - FishAndShark**/

import java.util.Random;
import java.util.Scanner;

public class FishAndShark {
    public static void main(String[] args) {
        // Inicializaciones
        AquaticAnimal.maxStarveCycles = 3;
        Ocean.defaultCapacity = 10;
        Random r = new Random();
        int capacidad = r.nextInt(8) + 7;
        Scanner teclado = new Scanner(System.in);
        
        // Creamos el oceano
        Ocean oceano = new Ocean(capacidad);
        System.out.println("INICIANDO....");
        System.out.println("Creamos un oceano vacio: ");
        System.out.println(oceano);
        System.out.println("Llenamos el oceano aleatoriamente: ");
        for (int f=0; f<oceano.getCapacity(); f++) {
            for (int c=0; c<oceano.getCapacity(); c++) {
                int tipo = r.nextInt(50) % 3;
                switch(tipo) {
                    case 0: oceano.fill(f,c,'F');
                            break;
                    case 1: oceano.fill(f,c,'S');
                            break;
                    case 2: oceano.empty(f,c);
                            break;
                }
            }
        }
        System.out.println(oceano);
        
        // Ciclos de vida del oceano
        System.out.println("Iniciando Ciclos....");
        int cont = 1;
        while(cont <= 10) {
            oceano.cycle();
            System.out.println("CICLO #"+cont+"\n");
            System.out.println(oceano);
            System.out.println("\n Presione ENTER para continuar...\n");
            teclado.nextLine();
            cont += 1;
        }
            
    }
}
