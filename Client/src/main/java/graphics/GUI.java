package graphics;

import graphics.entities.elements.Field;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUI extends Application {

    private static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        //Parent root = FXMLLoader.load(getClass().getResource("/view/loadApp.fxml"));
//        primaryStage.setTitle("Block Break");
//        primaryStage.getIcons().add(new Image(getClass().getResource("/images/appIcon.png").toString()));
//        primaryStage.setResizable(false);
        int[][] array = new int[][]{{1, 2, 3, 4}, {1, 3, 3, 4}, {1, 3,3,4}, {3, 2, 2, 2}};
        Field field = new Field(array);
        primaryStage.setScene(new Scene(field));
        primaryStage.show();
    }

    public static Stage getStage() {
        return stage;
    }

}
