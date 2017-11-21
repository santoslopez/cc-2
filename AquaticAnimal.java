/** CC2 2015 - Laboratorio #4
    Ejercicio #3 - AquaticAnimal**/

public class AquaticAnimal {
    public static int maxStarveCycles = 0;//representa la cantidad maxima de ciclos sin alimentacion que un animal puede tener
    private static char tipoAnimal;
    private static int ciclosSinComer;
    
    public AquaticAnimal(char t) {
        if(String.valueOf(t).equals("F")){
            this.tipoAnimal=t;
            this.ciclosSinComer=0;//del pez
        }else if(String.valueOf(t).equals("S")){
            this.tipoAnimal=t;
            this.ciclosSinComer=maxStarveCycles;//tiburon
        }
  
    }
    
    public char getTipo() {
        return tipoAnimal;
    }
    public int getStarveCycles() {
        return ciclosSinComer;
    }
    
    public void starve() {
        int decrementar = maxStarveCycles - 1;
        this.ciclosSinComer = decrementar;
    }
    public void feed() {
        int reiniciar = maxStarveCycles;
        this.ciclosSinComer = reiniciar;

    }    
    public String toString() {
        if(tipoAnimal=='F'){
            tipoAnimal='F';
            
        }
        //return String.valueOf("F");
        else if(tipoAnimal=='S'){
           tipoAnimal='S';
            
        }
        return String.valueOf(tipoAnimal);
    }
}