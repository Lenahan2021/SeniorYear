import java.util.ArrayList;

public class Category {
    String name;
    ArrayList<Entry> entries;

    public Category(String name, ArrayList<Entry> entry) {
        this.name = name;
        this.entries = entry;
    }
}
