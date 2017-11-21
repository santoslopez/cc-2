import java.util.*;

public class AlgorithmsProfiler{
  private int numeroInteraciones;
  private int casillas;
  private int condiciones;
  private int asignacionesVariables;
  private int operacionesAritmeticas;

  public int getLastNumberOfIterations(){
    return numeroInteraciones;
  }
  public int getLastNumberOfVisitedCells(){
    return casillas;
  }
  public int getLastNumberOfEvaluatedConditions(){
    return condiciones;
  }
  public int getLastNumberOfVariableAssignments() {
    return asignacionesVariables;
  }
  public int getLastNumberOfArithmeticOperations(){
    return operacionesAritmeticas;
  }

  public void clearProfile(){
    this.numeroInteraciones=0;
    this.casillas=0;
    this.condiciones=0;
    this.asignacionesVariables=0;
    this.operacionesAritmeticas=0;
  }
  public AlgorithmsProfiler(){
    this.numeroInteraciones=0;
    this.casillas=0;
    this.condiciones=0;
    this.asignacionesVariables=0;
    this.operacionesAritmeticas=0;
  }
  /*
  //inicializar los campos en convertimos
  public AlgorithmsProfiler(int numeroInteraciones,int casillas,int condiciones,int asignacionesVariables,int operacionesAritmeticas){
    this.numeroInteraciones=0;
    this.casillas=0;
    this.condiciones=0;
    this.asignacionesVariables=0;
    this.operacionesAritmeticas=0;
  }
  */

  //para que funciona binary search el arreglo debe estar ordenado
  public int binarySearch(int array[],int number,boolean value){
    if(value==false){

    }
    int longitudArreglo = array.length-1;
    int middle;
    for(int count=0;count<=longitudArreglo;count++){
      if(((longitudArreglo - count)%2)==0){
        middle=((count)+(longitudArreglo-count))/2;
      }else{
        middle=((count)+(longitudArreglo-count+1))/2;
        if(array[middle]>number){
          longitudArreglo=(middle-1);
        }else if(array[middle]<number){
          count=(middle+1);
        }else{
          return middle;
        }
      }
    }
    return -1;

  }

  public void bubbleSort(int array[],boolean condition){
    int longitudArreglo = array.length;
    int aux;
    int aux2;
    for(int i=0;i<longitudArreglo-2;i++){
      for(int j=i+1;j<longitudArreglo-1;i++){
        if(array[j]<array[i]){
          aux = array[j];
          array[j]=array[i];
          array[i]=aux;
          j=j+1;
        }
      }
      i = i+1;
    }
  }

  public void selectionSort(int array[],boolean condition){
    int longitudArreglo = array.length;
    for(int i=0;i<longitudArreglo-2;i++){
      int min=i;
      for(int j=i+1;j<longitudArreglo-1;j++){
        if(array[j]<array[min]){
          min=j;
          j=j+1;
        }
      }
      array[i]=array[min];
      i=i+1;
    }
  }

  public void insertionSort(int array[],boolean condition){
    int longitudArreglo = array.length;
    int j;
    for(int i=1;i<longitudArreglo-1;i++){
      int aux = array[i];
      j = i -1;
      while(j>=0&& array[j]>aux){
        array[j+1]=array[j];
        j=j-1;
      }
      array[j+1]=aux;
      i=i+1;
    }
  }
  //probando nuestros metodos
  public static void main(String[] args){
    AlgorithmsProfiler a = new AlgorithmsProfiler();
    //arreglo declarado
    int array[]={1,3,7,9,10,16,17,23,24,25,43,67,78,89,100};
    System.out.println("Arreglo original");
    System.out.println(Arrays.toString(array));

    System.out.println("Arreglo con el metodo bubbleSort");
    a.bubbleSort(array,true);
    System.out.println(Arrays.toString(array));
  }
}
