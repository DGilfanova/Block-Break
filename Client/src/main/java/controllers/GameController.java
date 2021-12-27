package controllers;

import client.Client;
import fertdt.ResponseMessage;
import helpers.constants.Constants;
import helpers.constants.Storage;
import helpers.handlers.GameStateHandler;
import helpers.utils.Resource;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import models.Game;
import models.elements.Field;

public class GameController {

    @FXML
    private static Pane gameField1;

    @FXML
    private static Pane gameField2;

    private static Field fieldMy;
    private static Field fieldOpposite;

    private Client client;
    private static Game game;

    public static void handleMessageForGameStart(ResponseMessage responseMessage) {
        Platform.runLater(new Runnable(){
            @Override
            public void run() {
                game.setStartBlock(GameStateHandler.processStartBlock(responseMessage.getX(), responseMessage.getY()));
                fieldMy = new Field(game.getStartBlock());
                fieldOpposite = new Field(game.getStartBlock());

                gameField1.getChildren().add(fieldMy);
                gameField2.getChildren().add(fieldOpposite);

                GUI.getStage().setScene(Resource.getScenes().get(Constants.GAME_RESOURCE_NAME));
                GUI.getStage().show();
            }
        });
    }

    public static void handleMessageForGameState(ResponseMessage responseMessage) {
    }


    public void initialize() {
        client = Storage.client;
        game = CharacterSelectionController.game;
    }
}
