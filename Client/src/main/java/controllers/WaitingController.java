package controllers;

import client.ResponseMessageHandler;
import client.SocketClient;
import fertdt.ResponseMessage;
import helpers.constants.Constants;
import helpers.utils.Resource;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class WaitingController {

    private static WaitingController instance;
    private static ResponseMessageHandler responseMessageHandler;

    @FXML
    public Label waitLabel;

    public static WaitingController getInstance() {
        return instance;
    }

    public void initialize() {
        instance = this;

        responseMessageHandler = ResponseMessageHandler.getInstance();
        responseMessageHandler.setWaitingController(instance);
    }

    public void handleStartMessage(ResponseMessage responseMessage) {
        Platform.runLater(new Runnable(){
            @Override
            public void run() {
                GUI.getStage().setScene(Resource.getScenes().get(Constants.CHARACTER_SELECTION_RESOURCE_NAME));
                GUI.getStage().show();
            }
        });
    }
}
