import java.util.ArrayList;

//Spencer
public class Category {
    //creating the name and the entries list
    public String name;
    public ArrayList<Entry> entries = new ArrayList<Entry>();

    public Category(String name) {
        this.name = name;
    }
}
