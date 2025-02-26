package View;

import javafx.application.Platform;

import java.util.ArrayList;

public class BackgroundComputation {
    private PetView gui;

    public BackgroundComputation(PetView gui) {
        this.gui = gui;
    }

    public void startComputation(ArrayList<Double> location) {
        new Thread(() -> {
            try {
                // This represents a long-running computation
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Platform.runLater(() -> gui.updateposition(location)); // safe way to update GUI
        }).start();
    }
}
