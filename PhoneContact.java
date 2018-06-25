public class PhoneContact{
	private String nombre;
	private String apellido;
	private String telefono;
	private boolean favorito;


	//retornamos el apellido
	public String getLastName(){
		return apellido;
	}

	//retornamos el nombre
	public String getFirstName(){
		return nombre;
	}

	//retornamos el valor del telefono
	public String getPhoneNumber(){
		return telefono;
	}

	public boolean isFavorite(){
		if((this.telefono!=null)&& this.favorito==true )  {
			return true;
		}else{
			return false;			
		}

	}


	public void setAsFavorite(){
		if ((this.telefono!=null)&&(this.favorito==false) )  {
			this.favorito=true;
		//}else{
			//this.favorito=true;
		}
	}

	public String toString(){
		String resultado = this.telefono + " " + this.apellido + " " + this.nombre;
		return resultado;
	}

	//comparamos si los telefonos son iguales
	public boolean equals(PhoneContact otroTelefono){
		if (this.telefono.equals(otroTelefono.telefono )) {
			return true;
		}else {
			return false;
		}
	}
	//constructor
	public PhoneContact(String apellido,String nombre,String telefono){
		this.apellido=apellido;
		this.nombre=nombre;
		this.telefono=telefono;
		//inicializando el campo favorito en falso
		this.favorito=false;
	}

}