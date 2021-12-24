package helpers.connectors;

import exceptions.ClientException;
import fertdt.MessageReadingException;
import fertdt.RequestMessage;
import fertdt.ResponseMessage;
import controllers.MenuController;
import helpers.connectors.ClientConnector;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SocketClientConnector implements ClientConnector {
    private static final int PORT = 10034;

    private Socket socket;

    public SocketClientConnector() {
        connect();
    }

    public void connect() throws ClientException {
        try {
            socket = new Socket(InetAddress.getLocalHost(), PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ResponseMessage sendMessage(RequestMessage message) throws ClientException {
        try{
            socket.getOutputStream().write(message.getData());
            socket.getOutputStream().flush();
            return ResponseMessage.readMessage(socket.getInputStream());
        }
        catch(IOException|MessageReadingException ex) {
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
                    if (n != -1) {
                        list.add((byte) n);
                        try {
                            ResponseMessage responseMessage = ResponseMessage.readMessage(list);
                            System.out.println(responseMessage);
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
}
