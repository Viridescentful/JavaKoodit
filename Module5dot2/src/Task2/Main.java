package Task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


public class Main extends Thread {
    private Collection collection;
    private String string;

    public Main(Collection collection, String string) {
        this.collection = collection;
        this.string = string;
    }

    public void run() {
        this.collection.add(this.string);
    }

    public static void main(String[] args) {
        Collection newcollection = new Collection();

        ArrayList<Main> list = new ArrayList();

        for (int i = 0; i < 10; i++) {
            Main newmain = new Main(newcollection, "Bello"+i);
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
