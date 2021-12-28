package client;

import controllers.*;
import exceptions.ClientException;
import fertdt.RequestMessage;
import helpers.constants.Constants;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

@Getter
@Setter
public class SocketClient implements Client{

    private static final int PORT = 10034;

    private Socket socket;
    private static SocketClient instance;

    public void start() throws ClientException {
        this.instance = this;

        connect();
        readMessages(socket);

        this.GUIStart();
    }

    public void sendMessage(RequestMessage message) throws ClientException {
        try{
            socket.getOutputStream().write(message.getData());
            socket.getOutputStream().flush();
        }
        catch(IOException ex) {
            throw new ClientException(ex);
        }
    }

    public void GUIStart() {
        System.setProperty(Constants.PRELOADER_NAME, GUIPreloadController.class.getCanonicalName());
        GUI.launch(GUI.class);
    }

    public void connect() throws ClientException {
        try {
            socket = new Socket(InetAddress.getLocalHost(), PORT);
        } catch (IOException ignored) {
        }
    }

    public void closeSocket(){
        try {
            socket.close();
        } catch (IOException ignored) {
        }
    }

    public static void readMessages(Socket s) {
        try {
            ResponseMessageHandler responseMessageHandler = new ResponseMessageHandler(s.getInputStream());
            Thread thread = new Thread(responseMessageHandler);
            thread.start();
        } catch (IOException ignored) {
        }
    }

    public static SocketClient getInstance() {
        return instance;
    }
}
