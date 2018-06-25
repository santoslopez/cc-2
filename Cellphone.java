public class Cellphone{
	private String telefono;
	private String marca;
	private int empresa;
	private int minutosDisponibles;
	private String nombreEmpresa;


	public String getEmpresa(){
		if (this.empresa==1) {
			nombreEmpresa = "Tigo";
		}else if (this.empresa==2) {
			nombreEmpresa = "Claro";
		}else if (this.empresa==3) {
			nombreEmpresa = "Telefonica";
		}else{
			nombreEmpresa = "Indefinido";
		}
		return nombreEmpresa;
	}

	public void changeEmpresa(String cambiarEmpresa){
		//dependiendo de que empresa recibamos eso sera el nuevo valor de la variable
		if (cambiarEmpresa.equals("Tigo")) {
			this.empresa=1;
		}else if (cambiarEmpresa.equals("Claro")) {
			this.empresa=2;
		}else if (cambiarEmpresa.equals("Telefonica")) {
			this.empresa=3;
		}else{
			this.empresa=0;
		}
	}

	//devolvemos el numero de telefono
	public String getNumero(){
		return telefono;
	}


	//reseteamos los minutos actuales a 250
	public void resetMinutos(){
		this.minutosDisponibles=250;
	}

	//devuelve la marca de la empresa
	public String getMarca(){
		return marca;
	}

	//devolvemos saldo disponible
	public int saldoMinutos(){
		return minutosDisponibles;
	}

	public void consumirMinutos(int x){
		if (x>this.minutosDisponibles) {
			this.minutosDisponibles=0;
		}else{
			//a la cantidad de minutos actuales le quitamos lo que acabamos de consumir
			this.minutosDisponibles -=x;
		}
	}

	//que muestra el numero, la empresa y la marca del telefono (sin etiquetarlos)
	public String toString(){
		String resultado = this.telefono + " "+this.empresa + " "+this.marca;
		return resultado;
	}

	public Cellphone(String telefono,String empresa,String marca){

		this.telefono=telefono;

		//dependiendo el valor del String empresa, si cumple los siguientes le agrega el valor correspondiente
		switch (empresa) {
			case "Tigo":
			this.empresa=1;
			break;

			case "Claro":
			this.empresa=2;
			break;

			case "Telefonica":
			this.empresa=3;
			break;

			default:
			this.empresa=0;
			break;
		}
		//inicializar minutos con 250 minutos
		this.minutosDisponibles = 250;
		this.marca=marca;
	}
}
