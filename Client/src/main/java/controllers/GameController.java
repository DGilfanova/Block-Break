package controllers;

import client.ResponseMessageHandler;
import client.SocketClient;
import fertdt.RequestMessage;
import fertdt.ResponseMessage;
import helpers.constants.Constants;
import helpers.handlers.GameStateHandler;
import helpers.utils.Resource;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import models.Game;
import models.characters.AbstractCharacter;
import models.elements.Cell;
import models.elements.Field;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameController {

    @FXML
    public Pane gameField1;

    @FXML
    public Pane gameField2;

    @FXML
    public Label errorLabel,pointLabel,movingLabel;

    @FXML
    public Button normalMove,normalSkill,specialSkill,myChar1,myChar2,myChar3;

    private static GameController instance;
    private static SocketClient client;
    private static ResponseMessageHandler responseMessageHandler;
    private static Game game;
    private ArrayList<AbstractCharacter> usedCharacters = new ArrayList<>();
    private boolean turn,clicked;

    public static GameController getInstance() {
        return instance;
    }

    public void handleMessageForGameStart(ResponseMessage responseMessage) {

        Platform.runLater(new Runnable(){
            @Override
            public void run() {
                int [][] a = GameStateHandler.processStartBlock(responseMessage.getX(), responseMessage.getY());
                game.setStartBlock(a);

                Field fieldMy = new Field(game.getStartBlock());
                Field fieldOpposite = new Field(game.getStartBlock());

                gameField1.getChildren().add(fieldMy);
                gameField2.getChildren().add(fieldOpposite);

                Iterator<Integer> it = CharacterSelectionController.characters.iterator();
                int[] chars = new int[Constants.MAXIMUM_CHARACTERS_NUM];
                int c = 0;
                while(it.hasNext()){
                    chars[c] = it.next();
                    c++;
                }
                List<AbstractCharacter> myCharacters = GameStateHandler.processStartCharacters(chars,game);

                List<Button> buttonList = new ArrayList<>();
                buttonList.add(myChar1);
                buttonList.add(myChar2);
                buttonList.add(myChar3);

                for(int i = 0; i<Constants.MAXIMUM_CHARACTERS_NUM;i++){
                    buttonList.get(i).setStyle("-fx-min-width: 100px;-fx-min-height: 100px;-fx-background-image: url('"
                            + myCharacters.get(i).getImagePath() + "');-fx-background-size: 100% 100%;");
                    int finalI = i;
                    buttonList.get(i).setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            getFieldHover(myCharacters.get(finalI),fieldMy);
                        }
                    });
                }
                GUI.getStage().setScene(Resource.getScenes().get(Constants.GAME_RESOURCE_NAME));
                GUI.getStage().show();
            }
        });
    }

    public void handleMessageForGameState(ResponseMessage responseMessage) {
        Platform.runLater(new Runnable(){
            @Override
            public void run() {
                fail(null);

                pointLabel.setText(String.valueOf(responseMessage.getPointsMy()[0]));

                int [][] a = GameStateHandler.processStartBlock(responseMessage.getX(), responseMessage.getY());
                game.setStartBlock(a);

                Field fieldMy = new Field(game.getStartBlock());
                Field fieldOpposite = new Field(game.getStartBlock());

                gameField1.getChildren().add(fieldMy);
                gameField2.getChildren().add(fieldOpposite);
            }
        });
    }

    public void handleMessageForTurn(ResponseMessage responseMessage) {
        Platform.runLater(new Runnable(){
            @Override
            public void run() {
                if (responseMessage.getPlayer() == Constants.PLAYER_TURN_ON) {
                    turn = true;
                    movingLabel.setText("Ваш ход");
                } else {
                    turn = false;
                    movingLabel.setText("Ход противника");
                }
            }
        });
    }

    public void initialize() {
        instance = this;

        client = SocketClient.getInstance();
        responseMessageHandler = ResponseMessageHandler.getInstance();
        responseMessageHandler.setGameController(instance);
        game = CharacterSelectionController.game;

    }


    public void getFieldHover(AbstractCharacter character, Field fieldMy){
        for(int i=0;i<Constants.FIELD_WIDTH;i++) {
            for (int j=0; j<Constants.FIELD_HEIGHT; j++) {
                Cell cell1 = fieldMy.getCell(i, j);
                Color[] colors = new Color[Constants.MAXIMUM_CELLS_HOVER];
                int[][] block = character.getCells();
                cell1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        for (int i = 0; i < block.length; i++) {
                            int j = 0;
                            int x = cell1.getCellX() + block[i][j];
                            j++;
                            int y = cell1.getCellY() + block[i][j];
                            if (x >= 0 && x < Constants.FIELD_WIDTH && y >= 0 && y < Constants.FIELD_HEIGHT) {
                                Cell c = fieldMy.getCell(x, y);
                                colors[i] = (Color) c.getFill();
                                c.setFill(Color.GRAY);
                            }
                        }
                    }
                });
                cell1.setOnMouseExited(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {

                        for (int i = 0; i < block.length; i++) {
                            int j = 0;
                            int x = cell1.getCellX() + block[i][j];
                            j++;
                            int y = cell1.getCellY() + block[i][j];
                            if (x >= 0 && x < Constants.FIELD_WIDTH && y >= 0 && y < Constants.FIELD_HEIGHT) {
                                Cell c = fieldMy.getCell(x, y);
                                c.setFill(colors[i]);
                            }
                        }
                    }
                });
                cell1.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    List<Integer> coordX = new ArrayList<>();
                    List<Integer> coordY = new ArrayList<>();
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        if(usedCharacters.size()>=Constants.MAXIMUM_CHARACTERS_NUM){
                            usedCharacters.clear();
                        }

                        if(usedCharacters.contains(character)){
                            fail("Вы уже ходили этим персонажем");
                        }

                        if(!turn){
                            fail("Не Ваш ход");
                        }

                        if(!(usedCharacters.contains(character)) && turn) {
                            clicked = true;
                            fail(null);
                            for (int i = 0; i < block.length; i++) {
                                int j = 0;
                                int x = cell1.getCellX() + block[i][j];
                                j++;
                                int y = cell1.getCellY() + block[i][j];
                                if (x >= 0 && x < Constants.FIELD_WIDTH && y >= 0 && y < Constants.FIELD_HEIGHT) {
                                    coordX.add(x);
                                    coordY.add(y);
                                    Cell c = fieldMy.getCell(x, y);
                                    c.setFill(Color.GRAY);
                                }
                            }

                            usedCharacters.add(character);
                            RequestMessage requestMessage = RequestMessage.createNormalMoveMessage(Math.toIntExact(character.getId()), listToArray(coordX), listToArray(coordY));
                            client.sendMessage(requestMessage);
                        }
                    }
                });
            }
        }
    }

    public void fail(String s){
        errorLabel.setText(s);
        errorLabel.setVisible(true);
    }

    public int[] listToArray(List<Integer> list){
        int[] array = new int[list.size()];
        for(int i = 0; i<list.size();i++){
            array[i] = list.get(i);
        }
        return array;
    }
}
