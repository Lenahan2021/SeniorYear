public class GroceryIem {
    private String name;
    private double cost;
    public GroceryIem(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    //getters and setters
    public void setName(String newName) {
        this.name = newName;
    }

    public void setCost(double newCost) {
        this.cost = newCost;
    }

    public String getName() {
        return this.name;
    }

    public String getCost() {
        return this.cost;
    }
    //toString
    public String toString() {
        return (this.name + "\t" + this.cost);
    }
}
