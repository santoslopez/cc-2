/*  CC2 - 2015
    Laboratorio #9
    @author Andrea Quan */

/*** NO MODIFICAR ESTA CLASE ****/
public class Algorithms {
    // BUBBLE SORT
    private static void ascBSort(Ordenable[] a) {
        for (int i = 0; i < (a.length - 1); i+=1) {
            for (int j = i+1 ; j < a.length; j+=1) {
                if (a[j].lessOrEqualTo(a[i])) {
                    Ordenable aux = a[i];
                    a[i] = a[j];
                    a[j] = aux;
                }
            }
        }
    }

    private static void descBSort(Ordenable[] a) {
        for (int i = 0; i < (a.length - 1); i+=1) {
            for (int j = i+1 ; j < a.length; j+=1) {
                if (a[j].greaterOrEqualTo(a[i])) {
                    Ordenable aux = a[i];
                    a[i] = a[j];
                    a[j] = aux;
                }
            }
        }
    }

    public static void bubbleSort(Ordenable[] a,boolean asc) {
        if (asc) ascBSort(a);
        else descBSort(a);
    }

    // BINARY SEARCH
    private static int ascBSearch(Ordenable[] a, Ordenable o) {
        int start = 0;
        int end = a.length - 1;
        int indice = 0;
        while (start <= end) {
            int dif = end - start;
            if ((dif % 2) == 0) indice = start + (dif / 2);
            else indice = start + ((dif + 1) / 2);
            if (a[indice].greaterThan(o)) end = indice - 1;
            else if (a[indice].lessThan(o)) start = indice + 1;
            else if (a[indice].equalTo(o)) return indice;
        }
        return -1;
    }

    private static int descBSearch(Ordenable[] a, Ordenable o) {
        int start = 0;
        int end = a.length - 1;
        int indice = 0;
        while (start <= end) {
            int dif = end - start;
            if (dif % 2 == 0) indice = start + (dif / 2);
            else indice = start + ((dif + 1) / 2);
            if (a[indice].lessThan(o)) end = indice - 1;
            else if (a[indice].greaterThan(o)) start = indice + 1;
            else if (a[indice].equalTo(o)) return indice;
        }
        return -1;
    }

    public static int binarySearch(Ordenable[] a, Ordenable o, boolean asc) {
            if (asc) return ascBSearch(a,o);
            else return descBSearch(a,o);
    }
}


    
