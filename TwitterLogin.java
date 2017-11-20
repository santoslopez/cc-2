import java.util.*;
import java.util.regex.*;
public class TwitterLogin{
  Scanner sc;

  public TwitterLogin(){
		sc = new Scanner(System.in);
	}

  public String getString(String string){
		String pedir="";
		while(pedir.equals("")){
			System.out.println(string);
			pedir=sc.nextLine();
		}
		return pedir;
	}
	public static void main(String[] args){
    TwitterLogin twitterLogin = new TwitterLogin();
		String nombre,apellido,correoElectronico,password,confirmarPassword;
		nombre = twitterLogin.getString("Ingrese su nombre: ");
		apellido = twitterLogin.getString("Ingrese su apellido: ");
		correoElectronico = twitterLogin.getString("Ingrese su correo electronico: ");
		password = twitterLogin.getString("Ingrese su password");
		confirmarPassword = twitterLogin.getString("Confirmar password");
    /*Si cumple todas las condiciones*/
    if((Pattern.matches("[a-zA-Z]{1,}+\\s[a-zA-Z]{1,}+", nombre) &&
    (Pattern.matches("[a-zA-Z]{1,}+\\s[a-zA-Z]{1,}+", apellido) )
    && (Pattern.matches("[a-zA-Z0-9]{6,}+", password))
    && (password.equals(confirmarPassword) )
    )
    ) {
      System.out.println("Gracias por registrarte.!!!");

    }
    /*Si no cumple algunas condiciones*/
		if(!(Pattern.matches("[a-zA-Z]{1,}+\\s[a-zA-Z]{1,}+", nombre))) {
    System.out.println("No se cumplio el formato del nombre");
		}
    if(!(Pattern.matches("[a-zA-Z]{1,}+\\s[a-zA-Z]{1,}+", apellido))) {
      System.out.println("No se cumplio el formato del apellido");
    }
    if(!(Pattern.matches("[a-zA-Z0-9]{6,}+", password))) {
      System.out.println("Longitud de password debe ser mayor a 6");
    }
    if(!password.equals(confirmarPassword)){
      System.out.println("Los passwords no coinciden.");
    }
	}
}
