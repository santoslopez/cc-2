/* 
    CC2 Interciclo - 2016
    Laboratorio #2 */

import java.io.*;
import java.util.regex.Pattern;
import java.util.Random;

public class PruebaTarjeta {

	public static void main(String[] args) throws Exception{
		BufferedReader tec = new BufferedReader(new InputStreamReader(System.in));
		TarjetaCredito[] tarjetas = new TarjetaCredito[3];
		System.out.println("\n\n\n\n\n\n\n");
		System.out.println("*************** SISTEMA DE TARJETAS DE CREDITO ***************\n");
		for(int i = 1; i <= 3; i++) {
			String nombre, numero;
			double limite, tasa;
			System.out.println("  Añadir tarjeta #" + i + ":");
			System.out.print("     - Ingrese numero de tarjeta asi -> xxxx-xxxx-xxxx-xxxx <- : ");
			numero = tec.readLine();
			if (!Pattern.matches("\\d{4}-\\d{4}-\\d{4}-\\d{4}", numero))
				System.out.println("          * ERROR con el numero, se generara numero aleatorio!");
			System.out.print("     - Ingrese propietario: ");
			nombre = tec.readLine();
			while(true) {
				System.out.print("     - Ingrese limite de credito: ");
				String l = tec.readLine();
				try {
					limite = Double.parseDouble(l);
					if (limite <= 0)
						throw new Exception("Negativo");
					break;
				} catch(Exception e) {
					System.out.println("          * ERROR, limite no valido!");
				}
			}
			while(true) {
				System.out.print("     - Ingrese tasa de interes: ");
				String l = tec.readLine();
				try {
					tasa = Double.parseDouble(l);
					if (tasa <= 0)
						throw new Exception("Negativo");
					break;
				} catch(Exception e) {
					System.out.println("       * ERROR, tasa no valida!");
				}
			}
			tarjetas[i - 1] = new TarjetaCredito(numero, nombre, limite, tasa);	
			System.out.println();		
		}
		System.out.println("   Tarjetas añadidas: \n");
		for(int i = 0; i < 3; i++) {
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("     * Tarjeta #" + (i + 1) + ":");
			System.out.println("        - Nombre de tarjeta: " + tarjetas[i].getNombre());
			System.out.println("        - Numero de tarjeta: " + tarjetas[i].getNumero());
			System.out.println("        - Nombre de tarjeta: " + tarjetas[i].getNombre());
			System.out.println("        - Saldo actual de tarjeta: " + tarjetas[i].getSaldoActual());
			System.out.println("        - Saldo disponible de tarjeta: " + tarjetas[i].getSaldoDisponible());
			System.out.println("        - Limite de credito de tarjeta: " + tarjetas[i].getLimiteCredito());
			System.out.println("        - Tasa de interes de tarjeta: " + tarjetas[i].getTasaInteres());
			System.out.println();System.out.println();
			System.out.println("Presione ENTER para continuar...");
			tec.readLine();
		}
		Random r = new Random();
		for(int i = 0; i < 3; i++) {
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("           ***** PRUEBA TARJETA " + (i + 1) + " *****\n");
			while(true) {
				double p =  (double)r.nextInt(100000);
				System.out.println("     - Compra aleatoria de: Q" + p);
				if (tarjetas[i].comprar(p)) break;
				System.out.println("       * ERROR! No se efectuo la compra\n");
			}
			System.out.println("     - Compra efectuada correctamente!\n");
			System.out.println(tarjetas[i]);
			System.out.println("Presione ENTER para continuar...");
			tec.readLine();
		}
	}
}