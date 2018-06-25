/*  CC2 - 2018
    Laboratorio #8
    @author Andrea Quan */

import java.util.LinkedList;

public class Contact {
	private String nombre;
    private String direccion;
	private LinkedList<String> telefonos;

	private LinkedList<String> copyLkdList(LinkedList<String> original) {
		LinkedList<String> nueva = new LinkedList<String>();
		for (int i=0; i<original.size(); i++) {
			nueva.add(original.get(i));
		}
		return nueva;
	}


	public Contact(String nom, String dir, String tel) {
		this.nombre = new String(nom);
        this.direccion = new String(dir);
		this.telefonos = new LinkedList<String>();
		this.telefonos.add(new String(tel));
	}


	public String getNombre() {
		return this.nombre;
	}

	public LinkedList<String> getTelefonos() {
		return copyLkdList(this.telefonos);
	}

	public void addTelefono(String str) {
		this.telefonos.add(new String(str));
	}

	public String toString() {
		String s = "Nombre: " + this.nombre;
                s += "\nDireccion: " + this.direccion;
		s += "\nTelefonos:\n";
		for (int i=0; i<this.telefonos.size(); i++) {
			s = s + "(" + (i+1) + ") " + this.telefonos.get(i) + "\n";
		}
		return s;
	}


}
