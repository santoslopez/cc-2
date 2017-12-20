/*  CC2 - 2015
    Laboratorio #9 
    @author Andrea Quan */


/* No modifique esta clase */
public abstract class Numero {
    
	public abstract String toString();
	public abstract boolean isZero();
	public abstract Numero add(Numero n);
	public abstract Numero extract(Numero n);
	public abstract Numero multiply(Numero n);
	public abstract void increase();
	public abstract void decrease();
}