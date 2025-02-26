package View;

import Controller.PetController;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HexFormat;
import java.util.Objects;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;


public class PetView extends Application {

    private PetController controller;

    private final int canvasSize = 1000;

    private double currentX, currentY;
    private double targetX, targetY;
    private Timeline timeline;

    private boolean isRunning = false;

    private Canvas canvas = new Canvas(canvasSize, canvasSize);
    private GraphicsContext gc = canvas.getGraphicsContext2D();
    private Image rabbitImage = new Image(Objects.requireNonNull(getClass().getResource("/rabbit.png")).toExternalForm());

    public void start(Stage stage) {

        gc.setFill(Color.web(("#7df599")));
        gc.fillRect(0, 0, canvasSize, canvasSize);

        gc.drawImage(rabbitImage, (canvas.getHeight() / 2 - rabbitImage.getHeight() / 2), (canvas.getWidth() / 2 - rabbitImage.getWidth() / 2));

        currentX = canvas.getWidth() / 2 - rabbitImage.getWidth() / 2;
        currentY = canvas.getHeight() / 2 - rabbitImage.getHeight() / 2;

        targetX = currentX;
        targetY = currentY;

        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root, 1000, 1000);

        stage.setTitle("Canvas Demo");
        stage.setScene(scene);
        stage.show();

        canvas.setOnMouseMoved(event -> {
            double x = event.getX();
            double y = event.getY();

            controller.updateposition(x, y);
        });

        canvas.setOnMouseEntered(event -> {
            isRunning = true;
        });

        canvas.setOnMouseExited(event -> {
            isRunning = false;
        });

        startAnimation();
    }

    public synchronized void updateposition(ArrayList<Double> location) {
        targetX = location.get(0) - rabbitImage.getWidth() / 2;
        targetY = location.get(1) - rabbitImage.getHeight() / 2;
    }

    public void init() {
        controller = new PetController(this);
    }

    private void startAnimation() {
        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);

        KeyFrame keyFrame = new KeyFrame(Duration.millis(2), event -> {
            double deltaX = targetX - currentX;
            double deltaY = targetY - currentY;

            double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);

            if (distance < 1 || !isRunning) {
                return;
            }

            double stepX = deltaX / distance;
            double stepY = deltaY / distance;

            currentX += stepX;
            currentY += stepY;

            gc.clearRect(0, 0, canvasSize, canvasSize);

            gc.setFill(Color.web("#7df599"));
            gc.fillRect(0, 0, canvasSize, canvasSize);

            gc.drawImage(rabbitImage, currentX, currentY);
        });

        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }
}
