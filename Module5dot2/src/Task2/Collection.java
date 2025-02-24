package Task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Collection {
    private List<String> collection;

    public Collection() {
        this.collection = Collections.synchronizedList(new ArrayList<>());
    }

    public void add(String item) {
        synchronized (collection) {
            this.collection.add(item);
        }
    }

    public void printCollection() {
        synchronized (collection) {
            System.out.println("Items in collection: ");
            for (String item : this.collection) {
                System.out.println(item);
            }
        }
    }
}
