/*  CC2 - 2015
    Laboratorio #9 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.regex.*;

class DetallesProductos{
	private static DetallesProductos instancia;
	public static DetallesProductos getInstancia(){
		if (instancia==null) {
			instancia=new DetallesProductos();
		}
		return instancia;
	}

	private String variable1="";
	private String variable2="";

	DetallesProductos(){}

	DetallesProductos(String variable1,String variable2){
		this.variable1=variable1;
		this.variable2=variable2;
	}
}

public class Shop {
	//LinkedList donde almacenamos los precios, tallas, genero del producto,etc
	private static LinkedList<DetallesProductos> productosDetalles = new LinkedList<DetallesProductos>();

	private static RegisterMachine registerMachine=new RegisterMachine();

	private static String descripcion;
	//private static Double precio;
	private static String talla;
	private static Shop productosVendidos;

	private static double precio;

	public String getDescription(){
		return descripcion;
	}

	public double getPrice(){
		return precio;
	}

	public String getTalla(){
		return talla;
	}



  private int numeroVenta=0;
  private LinkedList<Shop> historialVentas=new LinkedList<Shop>();
	private static Product producto;
	private static DetallesProductos detallesProductos;

	private static Shop instancia;
	public static Shop getInstancia(){
		if (instancia==null) {
			instancia=new Shop();
		}
		return instancia;
	}

	public String toString(){
		String informacion = "Descripcion: "+this.getDescription()+" Precio: "+this.getPrice();
		return informacion;
	}
	// despliega la lista de productos que se han vendido hasta el momento
	public void printSoldItems(){
		if (historialVentas.isEmpty()) {
			System.out.println("No hay productos vendidos!!!");
		}
		int cantidadProductosVendidos = historialVentas.size();
		//recorremos la lista
		for (int i=0;i<cantidadProductosVendidos ;i++ ) {
			System.out.println(historialVentas.get(i));
		}
	}

	public Shop(){}

	//metodo para agregar el producto como vendido
	public void sell(Shop productosVendidos){
		this.productosVendidos=productosVendidos;
		this.historialVentas.add(numeroVenta++,productosVendidos);
	}

	public static void interfazTiposProductos(){
		System.out.println("\n1.Zapatos\n2.Calcetas o calcetines\n3.Correas\n4.Bolsas\n5.Regresar menu principal\n");
	}
	public static void main(String[] args) throws Exception{
		SistemaOperativo.getInstancia().limpiarPantalla();//limpiamos la pantalla de la consola
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//RegisterMachine RegisterMachine.getInstancia() = new RegisterMachine();

		byte opcion = 0;
		//ciclo:
		menuPrincipal:
		do {
			System.out.println("\nPayless Shoes - Menu");
			System.out.println("1. Venta");
			System.out.println("2. Productos vendidos");
			System.out.println("3. Cierre");
			System.out.println("4. Salir");
			System.out.print("Ingrese opcion: ");

			/****** NO MODIFIQUE ESTE CODIGO ******/
			try {
				opcion = (byte)(Integer.parseInt(br.readLine()));
			} catch (NumberFormatException nfe) {
				// el usuario no ingreso un numero
				System.out.print("No ingreso un numero! ");
				opcion = 10;
			}
			/**************************************/

			switch (opcion) {
				case 1: {
					System.out.println("Preparando los tipos de productos!!!");
					SistemaOperativo.getInstancia().mensaje(2000);
					SistemaOperativo.getInstancia().limpiarPantalla();
					interfazTiposProductos();//dibujamos la interfaz del programa
					String opcionCase1;
					while(true){
						opcionCase1 = br.readLine();
						if (Pattern.matches("[1-5]",opcionCase1)) {
							switch (opcionCase1) {
								case "1":
								System.out.println();
								System.out.print("Ingrese producto: ");
								String descripcionProducto = br.readLine();
								System.out.print("Ingrese precio: ");
								precio = 0.0;
								while (true) {
									try {
										precio = Double.parseDouble(br.readLine());
										break;
									} catch (NumberFormatException nfe) {
										System.out.println("No ingreso un numero, vuelva a ingresar: ");

									}
								}
								System.out.println("Ingrese la talla: ");
								String talla = br.readLine();
								System.out.println("Ingrese si es para mujer o hombre: ");
								String generoZapatos = br.readLine();
								//constructor donde almacenamos la descripcion del producto y el precio
								producto = new Product(descripcionProducto,precio);
								registerMachine.sell(producto);

								//constructor auxiliar para guardar los datos de la talla y genero del producto
								detallesProductos = new DetallesProductos(talla,generoZapatos);
								productosDetalles.add(detallesProductos);


								break;

								case "2":
								System.out.println();
								System.out.print("Ingrese producto: ");
								String descripcionProducto2 = br.readLine();
								System.out.print("Ingrese precio: ");
								precio = 0.0;
								while (true) {
									try {
										precio = Double.parseDouble(br.readLine());
										break;
									} catch (NumberFormatException nfe) {
										System.out.println("No ingreso un numero, vuelva a ingresar: ");

									}
								}
								System.out.println("Ingrese el color de la(s) calceta o calcetin(es): ");
								String talla2 = br.readLine();
								System.out.println("Ingrese si es para mujer o hombre: ");
								String generoZapatos2 = br.readLine();
								//constructor donde almacenamos la descripcion del producto y el precio
								producto = new Product(descripcionProducto2,precio);
								registerMachine.sell(producto);

								//constructor auxiliar para guardar los datos de la talla y genero del producto
								detallesProductos = new DetallesProductos(talla2,generoZapatos2);
								productosDetalles.add(detallesProductos);

								break;
								case "3":
								System.out.println();
								System.out.print("Ingrese producto: ");
								String descripcionProducto3 = br.readLine();
								System.out.print("Ingrese precio: ");
								precio = 0.0;
								while (true) {
									try {
										precio = Double.parseDouble(br.readLine());
										break;
									} catch (NumberFormatException nfe) {
										System.out.println("No ingreso un numero, vuelva a ingresar: ");

									}
								}
								System.out.println("Ingrese el color de la correa: ");
								String talla3 = br.readLine();
								System.out.println("Ingrese el largo de la correa: ");
								String generoZapatos3 = br.readLine();
								//constructor donde almacenamos la descripcion del producto y el precio
								producto = new Product(descripcionProducto3,precio);
								registerMachine.sell(producto);

								//constructor auxiliar para guardar los datos de la talla y genero del producto
								detallesProductos = new DetallesProductos(talla3,generoZapatos3);
								productosDetalles.add(detallesProductos);

								break;
								case "4":
								System.out.println("vender 4");
								break;
								case "5":
								System.out.println("Regresando al menu principal...");
								SistemaOperativo.getInstancia().mensaje(2000);
								SistemaOperativo.getInstancia().limpiarPantalla();
								continue menuPrincipal;
							}
						}else{
							System.out.println("La opcion elegida es incorrecta!!!");
							SistemaOperativo.getInstancia().mensaje(2000);
							SistemaOperativo.getInstancia().limpiarPantalla();
							interfazTiposProductos();//dibujamos la interfaz del programa
						}
					}
					//break;

					//r.totalVendido+=pre;*/
				}
				case 2: {
					registerMachine.printSoldItems();
					//Shop.getInstancia().printSoldItems();
					System.out.println("Por favor espere...Limpiando la pantalla");
					SistemaOperativo.getInstancia().mensaje(2000);
					SistemaOperativo.getInstancia().limpiarPantalla();
					break;
				}
				case 3: {
					System.out.println("Cierre: ");
					registerMachine.printSoldItems();
					System.out.println("Total vendido: Q." + registerMachine.getTotalAmountSold());
					LinkedList<Product> lista = registerMachine.closeDay();
					System.out.println("Se hizo un reset de todo!!!");
					System.out.println("Limpiando la pantalla. Por favor espere...");
					SistemaOperativo.getInstancia().mensaje(3000);
					SistemaOperativo.getInstancia().limpiarPantalla();
					break;
				}
				case 4: {
					System.out.println("Saliendo...");
					SistemaOperativo.getInstancia().mensaje(1000);
					SistemaOperativo.getInstancia().limpiarPantalla();
					break;
				}
				default: {
					System.out.println("opcion incorrecta");
					System.out.println("Limpiando la pantalla. Por favor espere...");
					SistemaOperativo.getInstancia().mensaje(1000);//despues de que transcurra este tiempo ocultamos los mensajes anteriores
					SistemaOperativo.getInstancia().limpiarPantalla();
					continue menuPrincipal;
				}
			}

		} while(opcion != 4);

	}

}

/*

Clase SistemaOperativo.java nos permite averiguar que SO estamos usando y luego nos permite ejecutar un comando
para limpiar la consola del SO para no abrumarnos tanto, o tener una interfaz mucho mas elegante.

*/


class SistemaOperativo{
	//patron de diseno singleton para crear una sola instancia de la clase
	private static SistemaOperativo instancia;
	public static SistemaOperativo getInstancia(){
		if (instancia==null) {
			instancia=new SistemaOperativo();
		}
		return instancia;
	}

  /*vamos averiguar que sistema operativo estamos utilizando*/
	private static String sistemaOperativo = System.getProperty("os.name").toLowerCase();

  //devolvemos el nombre del sistema operativo
  public String getSistemaOperativo(){
    return sistemaOperativo;
  }

	//para limpiar la pantalla de la consola
	public void limpiarPantalla(){
		try {
			//si nuestro sistema operativo es Windows
			if (SistemaOperativo.getInstancia().getSistemaOperativo().indexOf("win")>=0 ) {
				SistemaOperativo.getInstancia().windows();
				//si nuestro sistema operativo es Linux
			}else if (SistemaOperativo.getInstancia().getSistemaOperativo().indexOf("lin")>=0) {
				System.out.print("\033\143");
				System.out.flush();
			}{

			}
		}catch(Exception exception){
			System.out.println("Se produjo el siguiente error: "+exception.getMessage());
		}
	}

  //metodo para limpiar la consola, terminal o pantalla de Windows
	public void windows(){
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		}catch(Exception exception){
			System.out.println("Se produjo el siguiente error: "+exception.getMessage());
		}
	}

  //desplegamos un mensaje en este tiempo para posteriormente limpiar la consola
  public void mensaje(int tiempo){
    try {
      Thread.sleep(tiempo);
    }catch (Exception e) {
      System.out.println("Se produjo el siguiente error: "+e.getMessage());
    }
  }
}
