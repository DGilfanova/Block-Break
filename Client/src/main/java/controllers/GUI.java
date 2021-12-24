package controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class GUI extends Application {

    private static Stage stage;

    @Override
    public void init() throws Exception {
        InitPreloadController initPreloadController = new InitPreloadController();
        initPreloadController.checkFunctions();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("/views/menu.fxml"));
        primaryStage.setTitle("Block Break");
        primaryStage.getIcons().add(new Image(getClass().getResource("/images/appIcon.png").toString()));
        primaryStage.setResizable(true);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static Stage getStage() {
        return stage;
    }
}
