import java.lang.Math;
public class ArrayAlgos {
    public static void main(String[] args) {
         double[] test = {12,7,13,8,4.0,3,72};
         double[] test2 = {120,57,1.3,8.5,0,3,7};
         
        System.out.printf("Sum: %f",sum(test));       
        System.out.printf("Ave: %f",ave(test));
        System.out.printf("Min: %f \n", min(test));   //
        System.out.printf("Max: %f",max(test));
         
        //returns the index if found, if not, -1
        System.out.printf("Find: %f",find(test,8));
        System.out.println("Reverse: "+printArray(reverse(test)));     //
        System.out.println("Sorted: "+printArray(sort(test)));
        System.out.println("Merge: "+printArray(merge(test,test2)));
    }

    public static double[] reverse(double[] arr) {
        double[] sorted = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            sorted[i] = arr[(arr.length-1)-i];
        }

        return sorted;
    }

    public static String printArray(double[] grades) {
        String out = "";
        for (int i = 0; i < grades.length; i++) {
            if (i != grades.length-1) {
                out += (grades[i]+",");
            }
            else {
                out += (grades[i]);
            }
        }

        return out;
    }

    public static double min(double[] one){
        double min = one[0];
        for(int i=0;i<one.length;i++){
            if(one[i]<min){
                min=one[i];
            }
        }
        return min;
    }

    public static double sum(double[] arr) {
        double total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }
        return total;
    }

    public static double[] merge(double[] arr, double[] arr2) {
        double[] mergedArray = new double[arr.length + arr2.length];
        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            mergedArray[start] = arr[i];
            start += 1;
            mergedArray[start] = arr2[i];
            start += 1;
        }
        return mergedArray;
    }

    public static double ave(double[] arr) {
        int n = arr.length;
        double total = 0;
        for(int i = 0;i<arr.length;i++){
            total+=arr[i];
        }
        return total/n;
    }

    public static double max(double[] arr){
        double pastnum=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] > pastnum){
                pastnum = arr[i];
            }
        }
        return pastnum;
    }

    public static int find(double[] arr, double i) {
        int index = -1;
        for (int j=0; j < arr.length; j++) {
            if (i==arr[j]) {
                index=j;
            }
        }

        return index;
    }

    
}