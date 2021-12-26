package controllers;

import client.Client;
import fertdt.RequestMessage;
import fertdt.ResponseMessage;
import helpers.constants.Storage;
import helpers.constants.Constants;
import helpers.utils.Resource;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import models.Game;
import models.characters.AbstractCharacter;

import java.util.HashSet;
import java.util.Iterator;

public class CharacterSelectionController {

    @FXML
    public FlowPane pane;

    @FXML
    public Label errorText;

    private HashSet<Integer> characters = new HashSet<>();

    private Client client;

    private Game game;

    public void initialize() {
        client = Storage.client;

        game = new Game();

        for (AbstractCharacter c: game.getCharacters()) {
            ToggleGroup gr = new ToggleGroup();
            ToggleButton button = new ToggleButton();

            //передать ссылку на фотографию(в таком же виде, как и пример)
            button.setStyle("-fx-min-width: 100px;-fx-min-height: 100px;-fx-background-image: url('" + "/images/phantom.png" + "');-fx-background-size: 100% 100%;");
            button.setToggleGroup(gr);
            button.setSelected(false);
            button.setId(c.getId().toString());

            button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    if (button.isSelected()) {
                        characters.add(Integer.valueOf(button.getId()));
                    } else {
                        characters.remove(Integer.valueOf(button.getId()));
                    }
                }
            });

            button.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    //Кристина, для тебя
                }
            });

            button.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    //тоже для тебя
                }
            });

            pane.getChildren().add(button);
        }
    }

    @FXML
    private void chooseButtonAction(ActionEvent event) {
        if (characters.size() == Constants.MAXIMUM_CHARACTERS_NUM) {
            errorText.setVisible(false);

            //отвратительно
            Iterator<Integer> it = characters.iterator();
            int[] chars = new int[Constants.MAXIMUM_CHARACTERS_NUM];
            int c = 0;
            while(it.hasNext()){
                chars[c] = it.next();
                c++;
            }

            //null или что передавать?
            RequestMessage requestMessage = RequestMessage.createCharacterAndSkillSelectMessage(chars, new int[]{1,2,3});
            client.sendMessage(requestMessage);
        } else {
            errorText.setVisible(true);
        }
    }

    public static void handleMessage(ResponseMessage responseMessage) {
        Platform.runLater(new Runnable(){
            @Override
            public void run() {
                System.out.println(responseMessage);

                GUI.getStage().setScene(Resource.getScenes().get(Constants.MAIN_RESOURCE_NAME));
                GUI.getStage().setResizable(true);
                GUI.getStage().show();
            }
        });
    }
}
