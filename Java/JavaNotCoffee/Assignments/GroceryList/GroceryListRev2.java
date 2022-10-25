import java.util.Scanner;
import java.util.Arrays;

/*
     Things to add:
          addItem(GroceryItem item)
          removeItem(GroceryItem item)
          findItem() -> returns String -> "item#\titemName\titemCost"
          totalCost() -> returns double
          modifyCost(newCost)
          sortItemsByCost()

*/


public class GroceryListRev2 {
     public static void main(String[] args) {
          //Build a grocery list
          Scanner ui = new Scanner(System.in);
          System.out.println("How many items? ");
          int howmany = ui.nextInt();

          GroceryItem[] groceryList = new GroceryItem[howmany];

          for(int i=0;i<groceryList.length;i++){
               System.out.println("name: ");
               String name=ui.next();        
               
               System.out.println("cost: ");
               double cost=ui.nextDouble();

               groceryList[i]=new GroceryItem(name, cost);
          }

          
          String input = "";
          while (!input.equals("q")) {

               printGl(groceryList);

               System.out.println("You can (a)dd, (r)emove, (f)ind Item, (t)otal cost, (m)odifyCost, (s)ortItemsByCost or (q)uit");

               input = ui.next();

               if (input.equals("a")) {
                    System.out.println("name: ");
                    String name=ui.next();        
               
                    System.out.println("cost: ");
                    double cost=ui.nextDouble();
                    GroceryItem item = new GroceryItem(name, cost);
                    groceryList = addItem(item, groceryList);
               }
               else if (input.equals("r")) {
                    System.out.println("What is the name of the item you would like to remove?");
                    String name = ui.next();
                    groceryList = removeItem(name, groceryList);
               } 
               else if (input.equals("f")) {
                    System.out.println("What is the name of the item?: ");
                    String name = ui.next();
                    if (!findItem(name, groceryList)) {
                         System.out.println("Item cannot be found!");
                    }
               } 
               else if (input.equals("t")) {
                    double total = totalCost(groceryList);
                    System.out.println("Your total list amount is $"+total);
               }
               else if (input.equals("m")) {
                    System.out.println("What is the name of the item you would like to modify?");
                    String name = ui.next();

                    System.out.println("What is the new cost of this item?");
                    double cost = ui.nextDouble();

                    groceryList = modifyCost(name, cost, groceryList);
               }
               else if (input.equals("s")) {
                    groceryList = sortItemsByCost(groceryList);
               } else {
                    System.out.println("Invalid choice.");
               }
          }
          
     }
     private static void printGl(GroceryItem[] arr){
          //length is an attribute
          System.out.println("GroceryList");
          for(int i=0;i<arr.length;i++){
               System.out.println(String.valueOf(i+1)+".   "+arr[i].toString());
          }
     }

     private static GroceryItem[] removeItem(String name, GroceryItem[] gl) {

          if (findItem(name, gl)) {
               GroceryItem[] newGl = new GroceryItem[gl.length-1];
               boolean itemRemoved = false;
               int count = 0;
               for (int i = 0; i < gl.length; i++) {
                    if (name.equals(gl[i].getName())) {
                         itemRemoved = true;
                    } else {
                         newGl[count] = gl[i];
                         count++;
                    }
               }
               return newGl;
          } else {
               System.out.println("Item cannot be found to remove");
               return gl;
          }
     }
     private static GroceryItem[] addItem(GroceryItem item, GroceryItem[] gl)
     {    
          GroceryItem[] newGl = new GroceryItem[gl.length+1];
          for (int i = 0; i < gl.length; i++) {
               newGl[i] = gl[i];
          }
          newGl[newGl.length-1] = item;
          System.out.println("Item was added.");
          return newGl;
     }
     private static boolean findItem(String name, GroceryItem[] gl)
     {
          boolean nameFound = false;
          for (int i = 0; i < gl.length; i++) {
               if (name.equals(gl[i].getName())) {
                    nameFound = true;
                    System.out.println(String.valueOf(i+1)+".   "+ gl[i].toString());
               }
          }
          return nameFound;
     }
     
     private static double totalCost(GroceryItem[] gl){
          double total = 0.0;
          for (int i = 0; i < gl.length; i++) {
               total += gl[i].getCost();
          }
          return total;
     }

     private static GroceryItem[] modifyCost(String name, double cost, GroceryItem[] gl) {
          if (findItem(name, gl)) {
               for (int i=0; i < gl.length; i++) {
                    if (name.equals(gl[i].getName())) {
                         gl[i].setCost(cost);
                         System.out.println("Cost has been changed");
                    }
               }
          } else {
               System.out.println("Didn't find name of item");
          }
          return gl;
     }


     //https://www.tutorialspoint.com/java/util/arrays_sort_double.htm
     private static GroceryItem[] sortItemsByCost(GroceryItem[] gl) {
          GroceryItem[] sortedGl = new GroceryItem[gl.length];

          double[] costArray = new double[gl.length];

          for (int i =0; i < gl.length; i++) {
               costArray[i] = gl[i].getCost();
          }

          Arrays.sort(costArray);

          for (int i = 0; i < costArray.length; i++) {
               for (int j =0; j < gl.length; j++) {
                    if (gl[j].getCost() == costArray[i]) {
                         sortedGl[i] = gl[j];
                    }
               }
          }
          
          System.out.println("Your items are now sorted by Cost. ");
          return sortedGl;
     }
}
