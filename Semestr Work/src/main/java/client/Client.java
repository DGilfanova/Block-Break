package client;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    private final InetAddress host;
    private final int port;

    public Client(InetAddress host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() {
        try (Socket socket = new Socket(this.host, this.port)) {
//            MessageReader reader = new MessageReader(socket.getInputStream());
//            MessageWriter writer = new MessageWriter(socket.getOutputStream());
//
//            //Шлем серверу первое сообщение "рукопожатие"
//            writer.writeRequest(new HandshakeRequest());
//            //Получаем ответ
//            UniqueMessage msg = reader.readMessage();
//            //Проверяем, что это ответ на рукопожатие
//            if(!(msg.message instanceof HandshakeResponse)) {
//                return;
//            }

            //Запуск логики приложения
            this.logicStart();

            //socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void logicStart() {
        //Логика приложения
        //.....
    }
}
