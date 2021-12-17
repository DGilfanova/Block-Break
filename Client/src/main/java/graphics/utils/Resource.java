package graphics.utils;

import graphics.GUI;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.HashMap;

public class Resource {

    private final static String START_VIEW_PATH = "/view/start.fxml";

    private static HashMap<String, Scene> scenes = new HashMap<>();

    public static void loadScenes() throws IOException
    {
        Parent rootStartPage = FXMLLoader.load(GUI.class.getResource(START_VIEW_PATH));
        Scene startView = new Scene(rootStartPage);

        scenes.put("startView", startView);
    }

    public static HashMap<String, Scene> getScenes() {
        return scenes;
    }
}
