package Controller;

import View.DictionaryView;
import Model.Dictionary;

public class DictionaryController {

    private DictionaryView gui;
    private Dictionary dictionary = new Dictionary();

    public DictionaryController(DictionaryView gui) {
        this.gui = gui;

        dictionary.add("Plutonium", "A radioactive metallic element with the atomic number 94");
        dictionary.add("Argon", "A colourless, odourless gas that is totally inert to other substances");
    }

    public void receive(String key) {
        gui.setResult(dictionary.view(key));
    }
}
