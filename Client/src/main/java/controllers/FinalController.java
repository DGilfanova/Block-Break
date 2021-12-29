package controllers;


import client.ResponseMessageHandler;
import client.SocketClient;
import fertdt.ResponseMessage;
import helpers.constants.Constants;
import helpers.utils.Resource;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import models.Game;

public class FinalController {

    @FXML
    public Label stateLabel;
    @FXML
    public Label pointInfo;
    @FXML
    public Button menuButton;
    @FXML
    public Button exitButton;

    @FXML
    public void exitButtonPressed(ActionEvent actionEvent) {
        System.exit(0);
    }

    private static ResponseMessageHandler responseMessageHandler;
    private static FinalController instance;
    public static Game game;

    public void initialize() {
        instance = this;

        responseMessageHandler = ResponseMessageHandler.getInstance();
        responseMessageHandler.setFinalController(instance);
        game = CharacterSelectionController.game;
    }

    public void handleMessage(ResponseMessage responseMessage) {
        Platform.runLater(new Runnable(){
            @Override
            public void run() {
                if (responseMessage.getPlayer() == Constants.PLAYER_TURN_ON) {
                    stateLabel.setText("Вы выиграли!");
                }
                if (responseMessage.getPlayer() == Constants.PLAYER_TURN_OFF) {
                    stateLabel.setText("Вы проиграли:(");
                }
                if (responseMessage.getPlayer() == Constants.PLAYER_DRAW) {
                    stateLabel.setText("Ничья!");
                }

                pointInfo.setText("Счёт " + game.getPointsMy() + " : " + game.getPointsOpponent());

                GUI.getStage().setScene(Resource.getScenes().get(Constants.FINAL_RESOURCE_NAME));
                GUI.getStage().show();
            }
        });
    }
}
