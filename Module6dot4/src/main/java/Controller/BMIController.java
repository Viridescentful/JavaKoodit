package Controller;

import View.BMI;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import java.util.Locale;

public class BMIController {

    @FXML
    private Slider HeightSlider;

    @FXML
    private Slider WeightSlider;

    @FXML
    private Label ResultLabel;

    @FXML
    private void updateBMI() {
        System.out.println("updateBMI() called");
        double height = HeightSlider.getValue()/100.0;
        double weight = WeightSlider.getValue();
        double bmi = weight / Math.pow(height, 2);
        System.out.println("BMI: " + bmi);

        String bmiFormatted = String.format(Locale.US, "%.1f", bmi);
        ResultLabel.setText(bmiFormatted);
    }

    public static void main(String[] args) {
        BMI.launch(BMI.class);
    }
}
