package Model;

import java.util.ArrayList;

public class Notebook {
    private ArrayList<Note> notes;

    public Notebook() {
        notes = new ArrayList<Note>();
    }

    public void addNote(String title, String text) {
        for (Note note : notes) {
            if (note.getTitle().equals(title)) {
                note.setText(text);
                return;
            }
        }

        notes.add(new Note(title, text));
    }

    public void removeNote(String title) {
        for (int i = 0; i < notes.size(); i++) {
            if (notes.get(i).getTitle().equals(title)) {
                notes.remove(i);
                break;
            }
        }
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }
}
