package client;

import controllers.FinalController;
import controllers.GameController;
import controllers.WaitingController;
import fertdt.MessageReadingException;
import fertdt.ResponseMessage;
import helpers.constants.Constants;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ResponseMessageHandler implements Runnable {

    private InputStream is;

    private GameController gameController;
    private WaitingController waitingController;

    private static ResponseMessageHandler instance;

    public ResponseMessageHandler(InputStream is) {
        this.instance = this;
        this.is = is;
    }

    @Override
    public void run() {
        try {
            List<Byte> list = new ArrayList<>();
            while (true) {
                int n = is.read();
                if (n != -1) {
                    list.add((byte) n);
                    try {
                        ResponseMessage responseMessage = ResponseMessage.readMessage(list);
                        System.out.println(responseMessage);
                        boolean init = true;

                        int messageType = responseMessage.getMessageType();
                        switch (messageType) {
                            case (Constants.CHARACTER_SELECTION):{
                                waitingController.handleStartMessage(responseMessage);
                                break;
                            }
                            case (Constants.START_GAME):{
                                gameController.handleMessageForTurn(responseMessage);
                                break;
                            }
                            case (Constants.GAME_STATE):{
                                if (init) {
                                    init = false;
                                    gameController.handleMessageForGameStart(responseMessage);
                                } else {
                                    gameController.handleMessageForGameState(responseMessage);
                                }
                                break;
                            }
                            case (Constants.FINISH):{
                                FinalController.handleMessage(responseMessage);
                                break;
                            }
                        }

                        list.clear();
                    } catch (MessageReadingException ignored) {
                    }
                }
            }
        } catch (IOException ignored) {
        }
    }

    public static ResponseMessageHandler getInstance() {
        return instance;
    }
}
