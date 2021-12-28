package client;

import exceptions.ClientException;
import fertdt.RequestMessage;

public interface Client {
    void start() throws ClientException;
    void connect() throws ClientException;
    void sendMessage(RequestMessage message) throws ClientException;
}
