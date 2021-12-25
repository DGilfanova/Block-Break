package client;

import exceptions.ClientException;
import fertdt.RequestMessage;

public interface Client {
    public void start() throws ClientException;
    public void connect() throws ClientException;
    public void sendMessage(RequestMessage message) throws ClientException;
}
