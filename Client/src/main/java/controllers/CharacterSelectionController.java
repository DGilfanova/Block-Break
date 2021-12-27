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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    public Label errorText,nameLabel,normalSkillLabel,specialSkillLabel;

    @FXML
    public ImageView damageImage, specialSkillImage, normalSkillImage;

    private HashSet<Integer> characters = new HashSet<>();

    private Client client;
    public static Game game;

    public void initialize() {
        client = Storage.client;

        game = new Game();

        for (AbstractCharacter c: game.getCharacters()) {
            ToggleGroup gr = new ToggleGroup();
            ToggleButton button = new ToggleButton();

            button.setStyle("-fx-min-width: 100px;-fx-min-height: 100px;-fx-background-image: url('" + c.getImagePath() + "');-fx-background-size: 100% 100%;");
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
                    nameLabel.setText(c.getName());
                    normalSkillLabel.setText(c.getNormalSkill());
                    specialSkillLabel.setText(c.getSpecialSkill());
                    specialSkillImage.setImage(new Image(c.getSpecialSkillImage()));
                    damageImage.setImage(new Image(c.getDamageImage()));
                    normalSkillImage.setImage(new Image(c.getNormalSkillImage()));
                }
            });

            button.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    nameLabel.setText("");
                    normalSkillLabel.setText("");
                    specialSkillLabel.setText("");
                    specialSkillImage.setImage(null);
                    damageImage.setImage(null);
                    normalSkillImage.setImage(null);
                }
            });

            pane.getChildren().add(button);
        }
    }

    @FXML
    private void chooseButtonAction(ActionEvent event) {
        if (characters.size() == Constants.MAXIMUM_CHARACTERS_NUM) {
            errorText.setVisible(false);

            Iterator<Integer> it = characters.iterator();
            int[] chars = new int[Constants.MAXIMUM_CHARACTERS_NUM];
            int c = 0;
            while(it.hasNext()){
                chars[c] = it.next();
                c++;
            }

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

                GUI.getStage().setScene(Resource.getScenes().get(Constants.GAME_RESOURCE_NAME));
                GUI.getStage().show();
            }
        });
    }
}
