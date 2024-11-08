package org.example.opt2_wk3_inclassex;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.Locale;
import java.util.ResourceBundle;

public class HelloController {
    @FXML
    public Label distanceLabel;
    @FXML
    public Label fuelLabel;
    @FXML
    public javafx.scene.control.TextField distanceInput;
    @FXML
    public javafx.scene.control.TextField fuelInput;
    public Label result;
    public Button calculateBtn;

    Locale currentLocale;
    Locale localeEN = new Locale("en", "US");
    Locale localeIR = new Locale("fa", "IR");
    Locale localeFR = new Locale("fr", "FR");
    Locale localeJP = new Locale("ja", "JP");

    public void initialize() {
        if (currentLocale == null) {
            currentLocale = localeEN;
        }
        ResourceBundle.getBundle("messages", currentLocale);
        distanceLabel.setText(ResourceBundle.getBundle("messages", currentLocale).getString("distanceLabel"));
        fuelLabel.setText(ResourceBundle.getBundle("messages", currentLocale).getString("fuelLabel"));
        calculateBtn.setText(ResourceBundle.getBundle("messages", currentLocale).getString("calculateBtn"));
    }

    public void changeEN(ActionEvent actionEvent) {
        currentLocale = localeEN;
        initialize();
    }

    public void changeFA(ActionEvent actionEvent) {
        Locale locale = localeIR;
        currentLocale = locale;
        distanceLabel.setText(ResourceBundle.getBundle("messages", locale).getString("distanceLabel"));
        fuelLabel.setText(ResourceBundle.getBundle("messages", locale).getString("fuelLabel"));
        calculateBtn.setText(ResourceBundle.getBundle("messages", locale).getString("calculateBtn"));
    }

    public void changeFR(ActionEvent actionEvent) {
        Locale locale = localeFR;
        currentLocale = locale;
        distanceLabel.setText(ResourceBundle.getBundle("messages", locale).getString("distanceLabel"));
        fuelLabel.setText(ResourceBundle.getBundle("messages", locale).getString("fuelLabel"));
        calculateBtn.setText(ResourceBundle.getBundle("messages", locale).getString("calculateBtn"));
    }

    public void changeJA(ActionEvent actionEvent) {
        Locale locale = localeJP;
        currentLocale = locale;
        distanceLabel.setText(ResourceBundle.getBundle("messages", locale).getString("distanceLabel"));
        fuelLabel.setText(ResourceBundle.getBundle("messages", locale).getString("fuelLabel"));
        calculateBtn.setText(ResourceBundle.getBundle("messages", locale).getString("calculateBtn"));

    }

    public void calculate(ActionEvent actionEvent) {
        ResourceBundle currentBundle = ResourceBundle.getBundle("messages", currentLocale);
        try {
            double distance = Double.parseDouble(distanceInput.getText());
            double fuel = Double.parseDouble(fuelInput.getText());

            if (fuel == 0) {
                result.setText(currentBundle.getString("fuelError"));
            } else {
                double efficiency = distance / fuel;

                result.setText(currentBundle.getString("efficiencyTxt") + " " + efficiency + " " + currentBundle.getString("kml"));
            }
        } catch (NumberFormatException e) {
            result.setText(currentBundle.getString("validation"));
        }
    }
}