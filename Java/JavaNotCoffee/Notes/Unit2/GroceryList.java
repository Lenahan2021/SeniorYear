import java.util.Scanner;

import java.util.Scanner;
public class GroceryList {
    public static void main(String[] args) {
        //Build a grocery list
        Scanner ui = new Scanner(System.in);
        System.out.println("How many? ");
        int howMany = ui.nextInt();
        //String[] groceryList = {}; no no, length of 0
        //define an empty array, need to define the length
        String[] groceryList = new String[howMany]; 

        for (int i=0; i < groceryList.length; i++) {
            System.out.println("Add an item: ");
            groceryList[i]=ui.next();
        }
        printArray(groceryList);
    }
    private static void printArray(String[] arr) {
        for (int i=0; i < arr.length; i++) {
            if (i!=arr.length-1) {
                System.out.print(arr[i] +",");
            } else {
                System.out.print(arr[i]);
            }
        }
    }
}
