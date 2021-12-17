package graphics.utils;

import graphics.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.HashMap;

@Getter
@Setter
public class Resource {

    private final static String LOAD_PAGE_PATH = "/view/loadPage.fxml";
    private final static String START_PAGE_PATH = "/view/startPage.fxml";

    private static HashMap<String, Scene> scenes = new HashMap<>();

    public static void load() throws IOException
    {
        Parent rootLoadPage = FXMLLoader.load(Main.class.getResource(LOAD_PAGE_PATH));
        Scene loadPage = new Scene(rootLoadPage);
        Parent rootStartPage = FXMLLoader.load(Main.class.getResource(START_PAGE_PATH));
        Scene startPage = new Scene(rootStartPage);

        scenes.put("loadPage", loadPage);
        scenes.put("startPage", startPage);
    }

    public static HashMap<String, Scene> getScenes() {
        return scenes;
    }

    public static void setScenes(HashMap<String, Scene> scenes) {
        Resource.scenes = scenes;
    }
}
