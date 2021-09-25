package main;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.stream.*;

public class IntStreamExample {

 public static void main(String[] args) {
  int multiplicator = 5;
  int[] array = {1,2,4,5,-5,6,4,0,5,1,-13,12,1231,123};
  try {
   double mean = Arrays.
    stream(array).
    average().
    orElse(Double.NaN);  
      int min = IntStream.
    of(array).
    sorted().
    findFirst().
    getAsInt();
      int indexOfMin = IntStream
    .range(0, array.length)
                .filter(i -> min == array[i])
                .findFirst()
                .orElse(-1);
      int zeroRepeat = IntStream
    .range(0, array.length)
    .filter(i -> 0 == array[i])
    .toArray()
    .length; 
      int positives =  IntStream
    .range(0, array.length)
    .filter(i -> 0 < array[i])
    .toArray()
    .length; 
      int[] moltipliedArray = IntStream
    .of(array)
    .map(i -> multiplicator * i)
    .toArray();
      System.err.println("Our array: " + Arrays.toString(array));
      System.err.println("mean: " + mean);
      System.err.println("min: " + min);
      System.err.println("Index of minimum element: " + indexOfMin);
      System.err.println("Number of 0 entrances: " + zeroRepeat);
      System.err.println("Number of positive entrances: " + positives);
      System.err.print("Multiplied by " + multiplicator + " array: ");
      for(int i : moltipliedArray){ 
       System.err.print(i + " ");
      }
  } catch(NoSuchElementException e) {
   System.err.print("No elements in array");
  }
 }
}