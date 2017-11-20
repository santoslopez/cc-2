public class Cellphone{
	private String numeroTelefono;
	private String marca;
	private String empresa;//empresa a la que pertenece el celular
	private int minutosDisponibles;//minutos disponibles para las llamadas

	public Cellphone(String numeroTelefono,String empresa, String marca){
		this.numeroTelefono=numeroTelefono;
		if(empresa=="Tigo"){
			this.empresa=empresa;
		}else if(empresa=="Claro"){
			this.empresa=empresa;
		}else if(empresa=="Movistar"){
			this.empresa=empresa;
		}else if(empresa=="Indefinida"){
			this.empresa=empresa;
		}else{
			this.empresa=empresa;
		}
		this.marca=marca;
		this.minutosDisponibles=500;
	}
	public String getEmpresa(){
		return empresa;
	}
	public void changeEmpresa(String nuevaEmpresa){
		this.empresa=nuevaEmpresa;
	}
	/*Metodo que devuelve el numero de telefono*/
	public String getNumero(){
		return numeroTelefono;
	}
	public int saldoMinutos(){
		return minutosDisponibles;
	}
	public void resetMinutos(){
		this.minutosDisponibles=500;
	}
	public String getMarca(){
		return marca;
	}
	public String toString(){
		String mostrar= numeroTelefono + " " + empresa + " " + marca;
		return mostrar;
	}
	public void consumirMinutos(int x){
		if(x>this.minutosDisponibles){
			this.minutosDisponibles=0;
		}else{
			//restamos los minutos disponibles con los minutos consumidos
			this.minutosDisponibles=minutosDisponibles-x;
		}
	}
}
