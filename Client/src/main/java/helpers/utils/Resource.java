package helpers.utils;

import controllers.GUI;
import helpers.constants.Constants;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.HashMap;

public class Resource {

    public static HashMap<String, Scene> scenes = new HashMap<>();

    public static void loadScenes() throws IOException
    {
        scenes.put(Constants.MENU_RESOURCE_NAME, new Scene(FXMLLoader.load(GUI.class.getResource(Constants.MENU_VIEW_PATH))));
        scenes.put(Constants.MENU_CONNECTION_BY_ROOM_RESOURCE_NAME, new Scene(FXMLLoader.load(GUI.class.getResource(Constants.CONN_BY_ID_VIEW_PATH))));
        scenes.put(Constants.CHARACTER_SELECTION_RESOURCE_NAME, new Scene(FXMLLoader.load(GUI.class.getResource(Constants.SELECT_CHARACTER_VIEW_PATH))));
        scenes.put(Constants.GAME_RESOURCE_NAME,new Scene(FXMLLoader.load(GUI.class.getResource(Constants.GAME_VIEW_PATH))));
        scenes.put(Constants.WAITING_RESOURCE_NAME,new Scene(FXMLLoader.load(GUI.class.getResource(Constants.WAITING_VIEW_PATH))));
        scenes.put(Constants.FINAL_RESOURCE_NAME,new Scene(FXMLLoader.load(GUI.class.getResource(Constants.FINAL_VIEW_PATH))));
    }

    public static HashMap<String, Scene> getScenes() {
        return scenes;
    }
}
