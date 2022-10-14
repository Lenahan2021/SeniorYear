import java.lang.reflect.Array;

public class ArrayNotes {
    public static void main(String[] args) {
        //Array -> List... A sequence of data that is not mutable -> doesn't change
        /*
            Python -> List
            listy = []
            listy = [1,2,3,"True"]
         */

         /*
            Primitive *binary , booleans, ints, doubles, char
            Non-primitave - Array, String, Dictionary, Tuples()


            Array -> List and ArrayList
          */

          /*
           * datatype[] nameOfArray = { the data};
           * 
           */
          int[] numbers = {0,1,2,3,4,5,6,7,8,9};

          double[] decimalNumbers = {1,2,3,4,5,6,7,8,9};

          System.out.println(numbers);
          System.out.println(numbers[0]);
          System.out.println(numbers[1]+4); //5
          numbers[1]=numbers[1]+4; //reset 1 to 5
          System.out.println(numbers);
          printHorizontalArray(numbers);
    }

    private static void printArray(int[] arr) {
        for (int i=0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

    private static void printHorizontalArray(int[] arr) {
        for (int i =0; i < arr.length; i++) {
            if (i < arr.length-1) {
                System.out.print(arr[i] + ",");
            } else {
                System.out.print(arr[i]);
            }
        }
    }
}