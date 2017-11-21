/*  CC2 - 2016
    Laboratorio #5 - Ejercicio #3 */

public class TestingTVCable
{
	private static String pass(boolean b){
		String s = "no";
		if (b)
			s = "si";
		return s;
	}
	public static void main(String[] args)
	{
		try{
		String a[] = {"History", "Discovery", "TNT"};
		String b[] = {"History", "Discovery", "TNT"};
		String c[] = {"Animal Planet", "Universal", "HBO"};
		int n = 5;

		TVCable t1 = new TVCable(a);
		System.out.println("Televisora 1\n"+t1);
		TVCable t2 = new TVCable(b);
		System.out.println("Televisora 2\n"+t2);
		TVCable t3 = new TVCable(c);
		System.out.println("Televisora 3\n"+t3);
		TVCable t4 = new TVCable(n);
		System.out.println("Televisora 4 (vacia)\n"+t4);

		t4.setCanal(2, "Guia de programacion");
		t4.setCanal(4, "ESPN");
		t4.setCanal(5, "FOX");
		System.out.println("Televisora 4 (3 canales)\n:"+t4);

		System.out.println("El canal 3 en la Televisora 2 es "+t2.getCanal(3) + " igual TNT");

		//System.out.println("Las Televisoras 1 y 2 son iguales (si) "+ pass(t1.equals(t2)));
		//System.out.println("Las Televisoras 1 y 3 son iguales (no) "+pass(t1.equals(t3)));

		}catch(Exception e){
			System.out.println("Se produjo un error :"+ e);
		}

	}
}
