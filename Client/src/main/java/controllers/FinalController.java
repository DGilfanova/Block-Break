package controllers;


import fertdt.ResponseMessage;
import helpers.constants.Constants;
import helpers.utils.Resource;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class FinalController {

    @FXML
    public Label stateLabel;
    @FXML
    public Label pointLabel;
    @FXML
    public Button menuButton;
    @FXML
    public Button exitButton;

    @FXML
    public void menuButtonPressed(ActionEvent actionEvent) {
        //идем в меню
    }

    @FXML
    public void exitButtonPressed(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void setStateLabel(Label stateLabel) {
        //доработать, победил этот или другой игрок
        this.stateLabel = stateLabel;
    }

    public void setPointLabel(Label pointLabel) {
        //доработать
        this.pointLabel = pointLabel;
    }

    public static void handleMessage(ResponseMessage responseMessage) {
        Platform.runLater(new Runnable(){
            @Override
            public void run() {

                GUI.getStage().setScene(Resource.getScenes().get(Constants.CHARACTER_SELECTION_RESOURCE_NAME));
                GUI.getStage().show();
            }
        });
    }
}
