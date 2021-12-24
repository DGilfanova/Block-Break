package client;

import exceptions.ClientException;
import graphics.GUI;
import graphics.controllers.GUIPreloadController;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class SocketClient implements Client{

    public void start() throws ClientException {
        this.GUIStart();
    }

    public void GUIStart() {
        System.setProperty("javafx.preloader", GUIPreloadController.class.getCanonicalName());
        GUI.launch(GUI.class);
    }
}
