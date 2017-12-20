/*  CC2 - 2015
    Laboratorio #9 */

/*** NO MODIFICAR ESTA INTERFAZ ****/

public interface Ordenable {
    // el objeto es menor al parametro o
    public boolean lessThan(Ordenable o);
    // el objeto es mayor al parametro o
    public boolean greaterThan(Ordenable o);
    // el objeto es exactamente igual que el parametro o
    public boolean equalTo(Ordenable o);
    // el objeto es mayor o igual que el parametro o
    public boolean greaterOrEqualTo(Ordenable o);
    // el objeto es menor o igual que el parametro o
    public boolean lessOrEqualTo(Ordenable o);
}