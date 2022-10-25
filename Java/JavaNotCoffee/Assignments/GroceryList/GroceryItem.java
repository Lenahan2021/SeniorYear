public class GroceryItem {

     public String name;
     public double cost;

     //need the no arg constructor technically

     public GroceryItem(String nameP,double costP) {
          this.name=nameP;
          this.cost=costP;
     }

     //getters and setters
     public void setName(String newName){
          this.name=newName;
     }
     public String getName(){
          return this.name;
     }
     public void setCost(double newCost){
          this.cost=newCost;
     }
     public double getCost(){
          return this.cost;
     }

     //toString
     public String toString(){
          return this.name +" - $"+String.valueOf(this.cost);
     }

}