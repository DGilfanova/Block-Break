package client;

import controllers.*;
import exceptions.ClientException;
import fertdt.MessageReadingException;
import fertdt.RequestMessage;
import fertdt.ResponseMessage;
import helpers.constants.Storage;
import helpers.constants.Constants;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

@Getter
@Setter
public class SocketClient implements Client{
    private static final int PORT = 10034;

    private Socket socket;
    private List<Handler> handlers;

    public void start() throws ClientException {
        connect();
        Storage.client = this;
        read(socket);
        this.GUIStart();
    }

    public void connect() throws ClientException {
        try {
            socket = new Socket(InetAddress.getLocalHost(), PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(RequestMessage message) throws ClientException {
        try{
            socket.getOutputStream().write(message.getData());
            socket.getOutputStream().flush();
        }
        catch(IOException ex) {
            throw new ClientException("Can't send message.", ex);
        }
    }

    public static void read(Socket s) {
        Runnable runnable = () -> {
            try {
                InputStream is = s.getInputStream();
                List<Byte> list = new ArrayList<>();
                while (true) {
                    int n = is.read();
                    System.out.println(n);
                    if (n != -1) {
                        list.add((byte) n);
                        try {
                            ResponseMessage responseMessage = ResponseMessage.readMessage(list);
                            int i = 0;

                            int messageType = responseMessage.getMessageType();
                            switch (messageType) {
                                case (Constants.CHARACTER_SELECTION):{
                                    MenuController.handleMessage(responseMessage);
                                    break;
                                }
                                case (Constants.START_GAME):{
                                    CharacterSelectionController.handleMessage(responseMessage);
                                    break;
                                }
                                case (Constants.GAME_STATE):{
                                    if (i == 0) {
                                        i++;
                                        GameController.handleMessageForGameStart(responseMessage);
                                    } else {
                                        GameController.handleMessageForGameState(responseMessage);
                                    }
                                    break;
                                }
                                case (Constants.FINISH):{
                                    //FinishController.handleMessage(responseMessage);
                                    //break;
                                }
                            }

                            list.clear();
                        } catch (MessageReadingException ignored) {
                        }
                    }
                }
            } catch (IOException ignored) {
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    public void GUIStart() {
        System.setProperty("javafx.preloader", GUIPreloadController.class.getCanonicalName());
        GUI.launch(GUI.class);
    }
}
