package graphics.controllers;

import client.Client;
import client.SocketClient;
import fertdt.RequestMessage;
import fertdt.ResponseMessage;
import graphics.GUI;
import graphics.utils.Resource;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.concurrent.CountDownLatch;

public class MenuController {

    private Client client;

    @FXML
    private Button backButton;
    @FXML
    private Pane contentPane;
    @FXML
    private Button hostGameButton;
    @FXML
    private Button enterButton;
    @FXML
    private Label errorLabel;
    @FXML
    private TextField addressTextField;
    @FXML
    private Button connectButton;
    @FXML
    private VBox vBox;

    public void initialize() {
    }

    @FXML
    private void hostButtonPressed(ActionEvent actionEvent) {
        hostGameButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });
    }

    @FXML
    private void connectButtonPressed(ActionEvent actionEvent) {
        GUI.getStage().setScene(Resource.getScenes().get("connByIdView"));
        GUI.getStage().setResizable(true);
        GUI.getStage().show();
    }

    @FXML
    private void enterButtonPressed(ActionEvent actionEvent) {
        enterButton.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Service<Void> service = new Service<Void>() {
                    @Override
                    protected Task<Void> createTask() {
                        return new Task<Void>() {
                            @Override
                            public Void call() throws InterruptedException {
                                final CountDownLatch latch = new CountDownLatch(1);
                                Platform.runLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        try {
                                            RequestMessage message = RequestMessage.createStartRequestMessage(0);

                                            System.out.println(message.toString());
                                        } finally {
                                            latch.countDown();
                                        }
                                    }
                                });
                                latch.await();
                                return null;
                            }
                        };
                    }
                };
                service.start();
            }
        });
    }

    @FXML
    private void backButtonPressed(ActionEvent actionEvent) {
        GUI.getStage().setScene(Resource.getScenes().get("menuView"));
        GUI.getStage().setResizable(true);
        GUI.getStage().show();
    }
}
