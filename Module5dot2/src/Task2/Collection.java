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
            System.out.println("Added item " + item + " to index " + (collection.size() - 1) + "!");
        }
    }

    public void remove(int index) {
        synchronized (collection) {
            if (index >= this.collection.size() || index < -1) {
                System.out.println("Index " + index + " does not exist!");
            } else {
                System.out.println("Removed item " + this.collection.get(index) + " from index " + index + "!");
                this.collection.remove(index);
            }
        }
    }

    public void printCollection() {
        synchronized (collection) {
            System.out.println("Collection size: " + this.collection.size());
            System.out.println("Items in collection: ");
            for (String item : this.collection) {
                System.out.println(item);
            }
        }
    }
}
