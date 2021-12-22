package graphics.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class MenuController {

    @FXML
    private Pane contentPane;
    @FXML
    private Button hostGameButton;
    @FXML
    private Button enterButton;
    @FXML
    private Label errorLabel;
    @FXML
    private TextField addressTextField;
    @FXML
    private Button connectButton;

    public void initialize() {
        errorLabel.setVisible(false);
        addressTextField.setVisible(false);
        enterButton.setVisible(false);
    }

    @FXML
    private void hostButtonPressed(ActionEvent actionEvent) {
        //найти соперника
    }

    @FXML
    private void connectButtonPressed(ActionEvent actionEvent) {
        addressTextField.setVisible(true);
        enterButton.setVisible(true);
    }

    @FXML
    private void enterButtonPressed(ActionEvent actionEvent) {

    }
}
