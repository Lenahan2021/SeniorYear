import java.util.Scanner;

public class GroceryListRev1 {
    public static void main(String[] args) {
        //Build a grocery list
        Scanner ui = new Scanner(System.in);
        System.out.println("How many? ");
        int howMany = ui.nextInt();
        //String[] groceryList = {}; no no, length of 0
        //define an empty array, need to define the length
        GroceryIem[] groceryList = new GroceryIem[howMany]; 

        for (int i=0; i < groceryList.length; i++) {
            System.out.println("Add an item: ");
            String name=ui.next();
            System.out.println("Add a cost: ");
            double cost = ui.nextDouble();
            groceryList[i] = new GroceryIem(name, cost);
        }
        printArray(groceryList);
    }
    private static void printArray(GroceryIem[] arr) {
        for (int i=0; i < arr.length; i++) {
            if (i!=arr.length-1) {
                System.out.print(arr[i] +",");
            } else {
                System.out.print(arr[i]);
            }
        }
    }
}
