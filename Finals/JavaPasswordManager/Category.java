import java.util.ArrayList;

public class Category {
    public String name;
    public ArrayList<Entry> entries = new ArrayList<Entry>();

    public Category(String name) {
        this.name = name;
    }
}
