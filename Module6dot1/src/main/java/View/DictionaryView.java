package View;

import Controller.DictionaryController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.EventHandler;
import javafx.scene.layout.FlowPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;


public class DictionaryView extends Application {

    // initialize components that need to be accessed from multiple methods
    private Label result = new Label("N/A");
    private TextField textField = new TextField();
    private DictionaryController controller;

    public void start(Stage stage) {

        Button castButton = new Button("View");
        FlowPane pane = new FlowPane();

        stage.setTitle("Word Dictionary");

        // add outside margins for components
        Insets insets = new Insets(10, 10, 10, 10);
        pane.setMargin(result, insets);
        pane.setMargin(castButton, insets);
        pane.setMargin(textField, insets);

        // reserve space for result
        result.setMinWidth(100);
        result.setAlignment(Pos.CENTER);

        pane.getChildren().add(textField);
        pane.getChildren().add(castButton);
        pane.getChildren().add(result);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

        castButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                controller.receive(textField.getText());
            }
        });

        stage.show();
    }


    public void init() {
        controller = new DictionaryController(this);
    }

    public void setResult(String result) {
        this.result.setText(result);
    }
}

