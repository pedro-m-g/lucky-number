/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luckynumber;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

/**
 *
 * @author pedro
 */
public class AppController implements Initializable {
    
    @FXML
    private Label result;

    @FXML
    private DatePicker datePicker;

    @FXML
    private void calculate(ActionEvent event) {
        LocalDate birthday = datePicker.getValue();
        result.setText("" + luckyNumber(birthday));
    }
    
    private int luckyNumber(LocalDate birthday) {
        int day = sumOfDigits(birthday.getDayOfMonth());
        int month = sumOfDigits(birthday.getMonthValue());
        int year = sumOfDigits(birthday.getYear());
        return sumOfDigits(day + month + year);
    }
    
    private int sumOfDigits(int n) {
        int sum = 0;
        while (n >= 10) {
            sum += n % 10;
            n /= 10;
        }
        sum += n;
        return sum;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
}
