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
import java.util.Objects;


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

        Label source = new Label("Source Currency");
        Label target = new Label("Target Currency");

        Label equals = new Label("=");

        layout.setHgap(10);
        layout.setVgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(20);

        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(20);

        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(20);

        layout.getColumnConstraints().addAll(col1, col2, col3);

        RowConstraints row1 = new RowConstraints();
        row1.setVgrow(Priority.ALWAYS);
        row1.setFillHeight(true);

        RowConstraints row2 = new RowConstraints();
        row2.setVgrow(Priority.ALWAYS);
        row2.setFillHeight(true);

        RowConstraints row3 = new RowConstraints();
        row3.setVgrow(Priority.ALWAYS);

        RowConstraints row4 = new RowConstraints();
        row3.setVgrow(Priority.ALWAYS);

        layout.getRowConstraints().addAll(row1, row2, row3, row4);

        layout.add(convertable, 0, 0);
        layout.add(converted, 2, 0);
        GridPane.setHalignment(converted, HPos.RIGHT);

        layout.add(input, 0, 1);
        layout.add(equals, 1, 1);
        layout.add(resultLabel, 2, 1);
        GridPane.setHalignment(resultLabel, HPos.RIGHT);
        GridPane.setHalignment(equals, HPos.CENTER);

        layout.add(source, 0, 2);
        layout.add(target, 2, 2);
        GridPane.setHalignment(target, HPos.RIGHT);

        layout.add(convertablechoice, 0, 3);
        layout.add(convertedchoice, 2, 3);
        layout.add(ConvertButton, 1, 3);
        GridPane.setHalignment(convertedchoice, HPos.RIGHT);
        GridPane.setHalignment(ConvertButton, HPos.CENTER);
        layout.setAlignment(Pos.CENTER);

        Scene view = new Scene(layout, 800, 300);

        String css = Objects.requireNonNull(getClass().getResource("/styles.css")).toExternalForm();
        view.getStylesheets().add(css);

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

