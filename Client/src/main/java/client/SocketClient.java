package client;

import controllers.*;
import exceptions.ClientException;
import fertdt.MessageReadingException;
import fertdt.RequestMessage;
import fertdt.ResponseMessage;
import helpers.constants.Constants;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

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
            throw new ClientException("Can't send message.", ex);
        }
    }

    public void GUIStart() {
        System.setProperty("javafx.preloader", GUIPreloadController.class.getCanonicalName());
        GUI.launch(GUI.class);
    }

    public void connect() throws ClientException {
        try {
            socket = new Socket(InetAddress.getLocalHost(), PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeSocket(){
        try {
            socket.close();
        } catch (IOException e) {
            //ignore
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
