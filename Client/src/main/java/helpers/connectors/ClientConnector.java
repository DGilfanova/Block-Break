package helpers.connectors;

import exceptions.ClientException;
import fertdt.RequestMessage;
import fertdt.ResponseMessage;

public interface ClientConnector {
    public void connect() throws ClientException;
    public ResponseMessage sendMessage(RequestMessage message) throws ClientException;
}
