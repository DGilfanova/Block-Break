package graphics.utils;

import graphics.GUI;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.HashMap;

public class Resource {

    private final static String MENU_VIEW_PATH = "/view/menu.fxml";

    public static HashMap<String, Scene> scenes = new HashMap<>();

    public static void loadScenes() throws IOException
    {
        scenes.put("menuView", new Scene(FXMLLoader.load(GUI.class.getResource(MENU_VIEW_PATH))));
    }

    public static HashMap<String, Scene> getScenes() {
        return scenes;
    }
}
