package controllers;

import client.ResponseMessageHandler;
import client.SocketClient;
import fertdt.ResponseMessage;
import helpers.constants.Constants;
import helpers.handlers.GameStateHandler;
import helpers.utils.Resource;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import models.Game;
import models.elements.Field;

public class GameController {

    @FXML
    public Pane gameField1;

    @FXML
    public Pane gameField2;

    private static GameController instance;
    private static SocketClient client;
    private static ResponseMessageHandler responseMessageHandler;
    private static Game game;
    private boolean turn = false;

    public void handleMessageForGameStart(ResponseMessage responseMessage) {
        int [][] a = GameStateHandler.processStartBlock(responseMessage.getX(), responseMessage.getY());
        game.setStartBlock(a);

        Field fieldMy = new Field(game.getStartBlock());
        Field fieldOpposite = new Field(game.getStartBlock());

        gameField1.getChildren().add(fieldMy);
        gameField2.getChildren().add(fieldOpposite);

        Platform.runLater(new Runnable(){
            @Override
            public void run() {
                GUI.getStage().setScene(Resource.getScenes().get(Constants.GAME_RESOURCE_NAME));
                GUI.getStage().show();
            }
        });
    }

    public void handleMessageForGameState(ResponseMessage responseMessage) {
        //учитывать turn

        //баллы

        //перерисовка полей
    }

    public void handleMessageForTurn(ResponseMessage responseMessage) {
        if (responseMessage.getPlayer() == Constants.PLAYER_TURN_ON) {
            turn = true;
        } else {
            turn = false;
        }
    }

    public void initialize() {
        instance = this;

        client = SocketClient.getInstance();
        responseMessageHandler = ResponseMessageHandler.getInstance();
        responseMessageHandler.setGameController(instance);
        game = CharacterSelectionController.game;
    }

    public static GameController getInstance() {
        return instance;
    }
}
