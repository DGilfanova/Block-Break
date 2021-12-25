package controllers;

import client.Client;
import fertdt.ResponseMessage;
import helpers.adapters.StorageAdapter;
import utils.Resource;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CharacterSelectionController {

    @FXML
    public Button mainButton;

    @FXML
    public Button croshButton;

    @FXML
    public Button persButton;

    @FXML
    public Button ratButton;

    @FXML
    public Button spiderButton;

    @FXML
    public Button animButton;

    //добавляешь в arraylist и передаешь в след сцену, где уже выбираешь скиллы
    //в методах проверяешь длину листа
    //private ArrayList<> heroes;
    private Client client;

    public void initialize() {
        client = StorageAdapter.client;
    }

    @FXML
    private void croshDoubleMouseClicked(MouseEvent mouseEvent) {
        getButton(croshButton);
    }

    @FXML
    public void persDoubleMouseClicked(MouseEvent mouseEvent) {
        getButton(persButton);
    }
    @FXML
    private void animDoubleMouseClicked(MouseEvent mouseEvent) {
        getButton(animButton);
    }
    @FXML
    private void ratDoubleMouseClicked(MouseEvent mouseEvent) {
        getButton(ratButton);
    }

    @FXML
    private void spiderDoubleMouseClicked(MouseEvent mouseEvent) {
        getButton(spiderButton);
    }

    @FXML
    private void mainButtonPressed(ActionEvent event) {
        GUI.getStage().setScene(Resource.getScenes().get("mainView"));
        GUI.getStage().show();
    }

    private void getButton(Button button) {
        button.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                DialogController dialogController = new DialogController();
                try {
                    dialogController.start(new Stage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void handleMessage(ResponseMessage responseMessage) {

    }
}
