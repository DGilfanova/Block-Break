import exceptions.ClientException;
import fertdt.Message;
import fertdt.RequestMessage;
import fertdt.ResponseMessage;

public interface Client {
    public void start() throws ClientException;
    public ResponseMessage sendMessage(RequestMessage message) throws ClientException;
}
