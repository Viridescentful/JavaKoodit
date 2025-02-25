package Task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Random;


public class Main extends Thread {
    private Collection collection;
    private String string;
    private String state;

    public Main(Collection collection, String string, String state) {
        this.collection = collection;
        this.string = string;
        this.state = state;
    }

    public void run() {
        if (this.state.equals("Add")) {
            this.collection.add(this.string);
        } else {
            this.collection.remove(Integer.parseInt(this.string));
        }
    }

    public static void main(String[] args) {
        Collection newcollection = new Collection();

        ArrayList<Main> list = new ArrayList();

        int threads = Runtime.getRuntime().availableProcessors();

        for (int i = 0; i < (threads / 2); i++) {
            Main newmain = new Main(newcollection, "Hello"+i, "Add");
            list.add(newmain);
            newmain.start();
        }

        try {
           for (Main main : list) {
               main.join();
           }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < (threads / 2); i++) {
            Main newmain = new Main(newcollection, String.valueOf((new Random().nextInt(threads / 2) + 1)), "Remove");
            list.add(newmain);
            newmain.start();
        }

        try {
            for (Main main : list) {
                main.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        newcollection.printCollection();
    }
}
