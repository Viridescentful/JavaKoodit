package View;

import Controller.ConverterController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.HPos;

import java.util.HashMap;


public class ConverterView extends Application {

    // initialize components that need to be accessed from multiple methods
    private Label resultLabel = new Label();
    private TextField input = new TextField();
    private ConverterController controller;

    private ChoiceBox<String> convertablechoice = new ChoiceBox<>();
    private ChoiceBox<String> convertedchoice = new ChoiceBox<>();

    public void start(Stage stage) {
        GridPane layout = new GridPane();

        Button ConvertButton = new Button("Convert");

        Label convertable = new Label("Convertable");
        Label converted = new Label("Converted");

        Label equals = new Label("=");

        layout.setHgap(10);
        layout.setVgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(30);

        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(10);

        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(30);

        layout.getColumnConstraints().addAll(col1, col2, col3);

        RowConstraints row1 = new RowConstraints();
        row1.setVgrow(Priority.ALWAYS);
        row1.setFillHeight(true);

        RowConstraints row2 = new RowConstraints();
        row2.setVgrow(Priority.ALWAYS);
        row2.setFillHeight(true);

        RowConstraints row3 = new RowConstraints();
        row3.setVgrow(Priority.ALWAYS);
        layout.getRowConstraints().addAll(row1, row2, row3);

        layout.add(convertable, 0, 0);
        layout.add(converted, 2, 0);
        GridPane.setHalignment(converted, HPos.RIGHT);

        layout.add(input, 0, 1);
        layout.add(equals, 1, 1);
        layout.add(resultLabel, 2, 1);
        GridPane.setHalignment(resultLabel, HPos.RIGHT);
        GridPane.setHalignment(equals, HPos.CENTER);

        layout.add(convertablechoice, 0, 2);
        layout.add(convertedchoice, 2, 2);
        layout.add(ConvertButton, 1, 2);
        GridPane.setHalignment(convertedchoice, HPos.RIGHT);
        GridPane.setHalignment(ConvertButton, HPos.CENTER);
        layout.setAlignment(Pos.CENTER);

        StackPane root = new StackPane(layout);
        root.setAlignment(Pos.CENTER);

        Scene view = new Scene(root, 800, 300);
        view.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        stage.setTitle("Currency Converter");

        stage.setScene(view);
        stage.show();

        ConvertButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                controller.calculate(convertablechoice.getValue(), convertedchoice.getValue(), input.getText());
            }
        });

        stage.show();
    }

    public void setchoices(HashMap currencies) {
        convertablechoice.getItems().addAll(currencies.keySet());
        convertedchoice.getItems().addAll(currencies.keySet());
    }

    public void init() {
        controller = new ConverterController(this);
    }

    public void setResult(String result) {
        this.resultLabel.setText(result);
    }
}

