/*
	CC2 Interciclo - 2016 
        Laboratorio 2
*/

import java.io.*;

public class TestCellphone {
	public static void main(String[] args) {

		Cellphone cel1 = new Cellphone("50894567","Tigo","Apple");
		System.out.println("Se creo el telefono: " + cel1.toString());
		Cellphone cel2 = new Cellphone("30194597","Movistar","Samsung");
		System.out.println("Se creo el telefono: " + cel2.toString());
		Cellphone cel3 = new Cellphone("30089022","Claro","Huawei");
		System.out.println("Se creo el telefono: " + cel3.toString());
		Cellphone cel4 = new Cellphone("12345678","No se sabe","Blackberry");
		System.out.println("Se creo el telefono: " + cel4.toString());

		System.out.println("El numero del primer telefono es: " + cel1.getNumero());
		System.out.println("La marca del segundo telefono es: " + cel2.getMarca());
		System.out.println("El saldo del tercer telefono es: " + cel3.saldoMinutos());
		System.out.println("La empresa del cuarto telefono es: " + cel4.getEmpresa());

		System.out.println("Cambiando empresa cuarto telefono a Claro...");
		cel4.changeEmpresa("Claro");
		System.out.println("La empresa del cuarto telefono es: " + cel4.getEmpresa());

		System.out.println("Consumiendo 150 minutos primer telefono...");	
		cel1.consumirMinutos(150);
		System.out.println("Saldo de primer telefono: " + cel1.saldoMinutos());
		System.out.println("Consumiendo 100 minutos primer telefono...");	
		cel1.consumirMinutos(100);
		System.out.println("Saldo de primer telefono: " + cel1.saldoMinutos());
		System.out.println("Consumiendo 600 minutos segundo telefono...");	
		cel2.consumirMinutos(600);
		System.out.println("Saldo de segundo telefono: " + cel2.saldoMinutos());
		System.out.println("Reset saldo primer telefono...");	
		cel1.resetMinutos();
		System.out.println("Saldo de primer telefono: " + cel1.saldoMinutos());

	}
}