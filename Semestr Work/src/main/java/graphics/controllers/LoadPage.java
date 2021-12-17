package graphics.controllers;

import graphics.Main;
import graphics.utils.Resource;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class LoadPage implements Initializable {

    @FXML
    private ImageView loadImage;

    @FXML
    private ImageView loadIcon;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        final Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    boolean isTimer = false;
                    @Override
                    public void run() {
                        if(!isTimer){
                            if(loadImage.getOpacity() < 0) {
                                isTimer = true;
                                timer.cancel();
                                Main.stage.setScene(Resource.getScenes().get("startPage"));
                            }
                            loadImage.setOpacity(loadImage.getOpacity()-0.05);
                            loadIcon.setOpacity(loadIcon.getOpacity()-0.05);
                        }
                    }
                });
            }
        }, 500,100);
    }
}
