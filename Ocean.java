/** CC2 2015 - Laboratorio #4
    Ejercicio #3 - Ocean**/

import java.util.*;
public class Ocean {
    AquaticAnimal aquaticAnimal;
    //Ocean  aquaticAnimal[] = new Ocean();
    private int dimensionOceano;
    public static int defaultCapacity;
    private int fila;
    private int columna;
    private char tipoAnimal;
    
    public Ocean(int dimensions) {
        if(dimensionOceano<defaultCapacity){
            this.dimensionOceano=defaultCapacity;            
        }else{
            this.dimensionOceano=dimensions;
        }
    }
    
    public int getCapacity() {
        int capacidad = (dimensionOceano * dimensionOceano);
        return capacidad;
    }
    
    public void fill(int fila, int columna, char t) {
        this.dimensionOceano = fila;
        this.dimensionOceano= fila;
        this.tipoAnimal = t;
    }
    
    public void empty(int fila, int columna) {
        this.fila=fila;
        this.columna=columna;
    }
    
    public void cycle() {
        /* Escriba su implementacion aqui */
    }
    
    public String toString() {
        
        return "";
        /* Escriba su implementacion aqui */
    }
}