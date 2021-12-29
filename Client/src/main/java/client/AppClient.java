package client;

public class AppClient {

    public static void main(String[] args) {
        Client client = new SocketClient();
        client.start();
    }
}
