package clientlauncher;

import client.Client;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ClientLauncher {
    public static void main(String[] args) {
        //try {
            //InetAddress host = InetAddress.getByName("a");
            int port = 11001;

            Client client = new Client(port);
            client.start();

//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }
    }
}
