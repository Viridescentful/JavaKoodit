package Controller;

import View.PetView;
import View.BackgroundComputation;
import Model.Pet;

import java.util.ArrayList;


public class PetController {
    private PetView gui;
    private Pet pet;

    public PetController(PetView gui) {
        this.gui = gui;
        this.pet = new Pet();
    }

    public void updateposition(double x, double y) {
        pet.setLocation(x, y);

        //BackgroundComputation computation = new BackgroundComputation(gui);
        //computation.startComputation(pet.getLocation());

        gui.updateposition(pet.getLocation());
    }
}
