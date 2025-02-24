import java.util.HashMap;

public class Dictionary {
    private HashMap<String, String> dictionary;
    private final Object synclock = new Object();

    public Dictionary() {
        this.dictionary = new HashMap<>();
    }

    public synchronized void add(String key, String value) {
        synchronized (synclock) {
            this.dictionary.put(key, value);
        }
    }

    public String view(String key) {
        synchronized (synclock) {
            return this.dictionary.get(key);
        }
    }
}
