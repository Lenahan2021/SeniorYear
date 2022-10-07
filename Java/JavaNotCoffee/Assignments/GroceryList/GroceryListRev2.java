import java.util.Scanner;

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
               //why use next?... Google it. If you want to learn more
               
               System.out.println("cost: ");
               double cost=ui.nextDouble();

               groceryList[i]=new GroceryItem(name, cost);
          }
     }

     private static void printArray(String[] arr){
          //length is an attribute
          for(int i=0;i<arr.length;i++){
               System.out.println(arr[i]);
          }
     }
     private static void printArray(GroceryItem[] arr){
          //length is an attribute
          for(int i=0;i<arr.length;i++){
               System.out.println(arr[i]);
          }
     }
     private static void printHorizontalArray(String[] arr){
          //item,item,item,item,item
          String out = "";
          for(int i=0;i<arr.length;i++){
               if(i!=arr.length-1){
                    out+=arr[i];
                    out+=",";
               }
               else{
                    out+=arr[i];
               }
          }
          System.out.println(out);
     }

     private static void removeItem(String name) {

     }
     private static void addItem(GroceryItem item) {
     }
     private static void findItem(String name){}
     private static double totalCost(){return 0.0;}
}