package controllers;

import fertdt.RequestMessage;
import fertdt.ResponseMessage;
import helpers.constants.Constants;
import utils.Resource;
import helpers.connectors.SocketClientConnector;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class MenuController {

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

     static SocketClientConnector connector;

    public void initialize() {
        connector = new SocketClientConnector();
    }

    @FXML
    private void hostButtonPressed(ActionEvent actionEvent) {
        hostGameButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            private final static Integer DEFAULT_ROOM_ID = 0;

            @Override
            public void handle(MouseEvent event) {
                handleStartMessage(DEFAULT_ROOM_ID);
            }
        });
    }

    @FXML
    private void connectButtonPressed(ActionEvent actionEvent) {
        GUI.getStage().setScene(Resource.getScenes().get(Constants.MENU_CONNECTION_BY_ROOM_RESOURCE_NAME));
        GUI.getStage().setResizable(true);
        GUI.getStage().show();
    }

    @FXML
    private void enterButtonPressed(ActionEvent actionEvent) {
        enterButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                errorLabel.setVisible(false);
                String roomIdText = addressTextField.getText();
                Integer roomId;
                try {
                    roomId = Integer.valueOf(roomIdText);
                } catch (NumberFormatException e) {
                    fail("Введите id комнаты!");
                    return;
                }

//                Service<Void> service = new Service<Void>() {
//                    @Override
//                    protected Task<Void> createTask() {
//                        return new Task<Void>() {
//                            @Override
//                            public Void call() throws InterruptedException {
//                                final CountDownLatch latch = new CountDownLatch(1);
//                                Platform.runLater(new Runnable() {
//                                    @Override
//                                    public void run() {
//                                        try {
//                                            controllers.GUI.getStage().setScene(Resource.getScenes().get("menuView"));
//                                            controllers.GUI.getStage().setResizable(true);
//                                            controllers.GUI.getStage().show();
//                                        } finally {
//                                            latch.countDown();
//                                        }
//                                    }
//                                });
//                                latch.await();
//                                return null;
//                            }
//                        };
//                    }
//                };
//                service.start();

                handleStartMessage(roomId);
            }
        });
    }

    @FXML
    private void backButtonPressed(ActionEvent actionEvent) {
        GUI.getStage().setScene(Resource.getScenes().get(Constants.MENU_RESOURCE_NAME));
        GUI.getStage().setResizable(true);
        GUI.getStage().show();
    }

    private void handleStartMessage(Integer roomId) {
        RequestMessage requestMessage = RequestMessage.createStartRequestMessage(roomId);
        ResponseMessage responseMessage = connector.sendMessage(requestMessage);
        if (responseMessage.getMessageType() == 1) {
            System.out.println(responseMessage);

            GUI.getStage().setScene(Resource.getScenes().get(Constants.CHARACTER_SELECTION_RESOURCE_NAME));
            GUI.getStage().setResizable(true);
            GUI.getStage().show();
        } else {
            fail("Проблемы с сервером! Попробуйте снова");
        }
    }

    private void fail(String errorText) {
        errorLabel.setText(errorText);
        errorLabel.setVisible(true);
    }
}
