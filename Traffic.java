public class Traffic{ 
	//campo privado que representa el color del semaforo
	private String color;

	//devuelve el color actual
	public String getColor(){
		return color;
	}

	public void changeColor(){
		if (this.color.equals("rojo")) {
			color="amarillo";
		}else if(this.color.equals("amarillo")){
			color="verde";
		}else if(this.color.equals("verde")){
			color="rojo";
		}	
	}		

	//dandole formato al desplegar
	public String toString(){
		String resultado = "El color actual es: "+this.getColor();
		return resultado;
	}
	//constructor vacio
	public Traffic(){
		//inicializamos el color en rojo
		this.color = "rojo";
	}


	public static void main(String[] args) {
		//construimos 
		Traffic t = new Traffic();

		System.out.println("Color por defecto: "+t.toString());
		
	}

}