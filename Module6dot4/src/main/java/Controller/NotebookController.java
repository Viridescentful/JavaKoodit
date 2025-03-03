package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import Model.Notebook;
import Model.Note;
import View.NotebookView;

import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Locale;

public class NotebookController {
    private Notebook notebook;

    public NotebookController() {
        notebook = new Notebook();
    }

    @FXML
    private TextField titlefield;

    @FXML
    private TextField removefield;

    @FXML
    private TextArea notetextfield;

    @FXML
    private ListView<Note> notelist;

    @FXML
    private void enableTextWrapping() {
        notelist.setCellFactory(param -> {
            ListCell<Note> cell = new ListCell<Note>() {

                @Override
                protected void updateItem(Note item, boolean empty) {
                    super.updateItem(item, empty);

                    if (item != null) {
                        Text text = new Text(item.toString());
                        text.setWrappingWidth((notelist.getWidth() / 8)); // Adjust the width as needed
                        setGraphic(text);
                    } else {
                        setGraphic(null);
                    }
                }
            };
            return cell;
        });
    }

    @FXML
    private void setNotes() {
        notelist.setItems(FXCollections.observableArrayList(notebook.getNotes()));
        enableTextWrapping();
    }

    @FXML
    private void AddNote() {
        notebook.addNote(titlefield.getText(), notetextfield.getText());
        setNotes();
    }

    @FXML
    private void RemoveNote() {
        notebook.removeNote(removefield.getText());
        setNotes();
    }



}