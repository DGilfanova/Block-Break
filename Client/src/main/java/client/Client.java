package client;

import graphics.GUI;

public class Client {
    //private final InetAddress host;
    private final int port;

    public Client(int port) {
        //this.host = host;
        this.port = port;
    }

    public void start() {
        //try (Socket socket = new Socket(this.host, this.port)) {

            this.logicStart();

            //socket.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    //Логика приложения
    public void logicStart() {
        GUI.launch(GUI.class);
    }
}
