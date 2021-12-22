import java.net.InetAddress;
import java.net.UnknownHostException;

public class AppClient {
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 11001;

    public static void main(String[] args) {
        try {
            SocketClient client = new SocketClient(InetAddress.getByName(HOST), PORT);
            client.start();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
