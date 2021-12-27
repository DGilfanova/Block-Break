package controllers;

import client.Client;
import helpers.constants.Storage;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class GameController {

    @FXML
    private Pane gameField1;

    @FXML
    private Pane gameField2;

    private Client client;


    public void initialize() {
        client = Storage.client;
    }
}
