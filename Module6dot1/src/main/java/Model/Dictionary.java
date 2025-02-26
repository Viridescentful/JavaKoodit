package Model;

import java.util.HashMap;

public class Dictionary {
    private HashMap<String, String> dictionary;

    public Dictionary() {
        this.dictionary = new HashMap<>();
    }

    public synchronized void add(String key, String value) {
        this.dictionary.put(key, value);
    }

    public String view(String key) {
        return this.dictionary.getOrDefault(key, "No available explanation for input!");
    }
}
