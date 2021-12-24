package controllers;

import helpers.connectors.ClientConnector;
import utils.Resource;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
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

    ClientConnector connector;

    @FXML
    public void initialize() {
        connector = MenuController.connector;
    }

    //исправить так, чтобы передавались все кнопки
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
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                    if(mouseEvent.getClickCount() == 2){
                        DialogController dialogController = new DialogController();
                        try {
                            dialogController.start(new Stage());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }
}
