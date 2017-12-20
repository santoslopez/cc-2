/*
Card.java representa las cartas de una baraja o naipes
*/

public class Card{
  private static byte numeroDeCarta;
  private static byte simboloCarta;

  public int getNumeroDeCarta(){
    return (int)numeroDeCarta;
  }

  public static char getNumero(){
    int numeroCarta = (int)numeroDeCarta;
    char figuraNumeroCarta = '?';
    switch (numeroCarta) {
      case 1:
      numeroDeCarta = 1;
      figuraNumeroCarta = 'A';
      break;
      case 2:
      numeroDeCarta = 2;
      figuraNumeroCarta = '2';
      break;
      case 3:
      numeroDeCarta = 3;
      figuraNumeroCarta = '3';
      break;
      case 4:
      numeroDeCarta = 4;
      figuraNumeroCarta = '4';
      break;
      case 5:
      numeroDeCarta = 5;
      figuraNumeroCarta = '5';
      break;
      case 6:
      numeroDeCarta = 6;
      figuraNumeroCarta = '6';
      break;
      case 7:
      numeroDeCarta = 7;
      figuraNumeroCarta = '7';
      break;
      case 8:
      numeroDeCarta = 8;
      figuraNumeroCarta = '8';
      break;
      case 9:
      numeroDeCarta = 9;
      figuraNumeroCarta = '9';
      break;
      case 10:
      numeroDeCarta = 10;
      figuraNumeroCarta = 'J';
      break;
      case 11:
      numeroDeCarta = 11;
      figuraNumeroCarta = 'Q';
      break;
      case 12:
      numeroDeCarta = 12;
      figuraNumeroCarta = 'K';
      break;
    }
    return figuraNumeroCarta;
  }

  public Card(byte numeroDeCarta,byte simboloCarta){
    this.numeroDeCarta=numeroDeCarta;
    this.simboloCarta=simboloCarta;
  }

  public String toString(){
    String resultado = String.valueOf(getNumero())+":"+String.valueOf(getNumeroDeCarta());
    return resultado;
  }


}
