package graphics.controllers;

import graphics.GUI;
import graphics.utils.Resource;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

import java.io.IOException;

import java.util.Timer;
import java.util.TimerTask;

public class LoadController {

    private final static double OPACITY_STEP = 0.04;
    private final static int TASK_DELAY = 0;
    private final static int TASK_PERIOD = 100;

    @FXML
    private ImageView loadImage;

    @FXML
    private ImageView loadIcon;

    @FXML
    public void initialize() {

        try {
            Resource.loadScenes();
        } catch (IOException e) {
            e.printStackTrace();
        }

        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                    if(loadImage.getOpacity() < 0) {
                        timer.cancel();
                    }
                    loadImage.setOpacity(loadImage.getOpacity()-OPACITY_STEP);
                    loadIcon.setOpacity(loadIcon.getOpacity()-OPACITY_STEP);
            }
        }, TASK_DELAY,TASK_PERIOD);

        GUI.getStage().setResizable(true);
        GUI.getStage().setScene(Resource.getScenes().get("startView"));
        GUI.getStage().show();
    }
}
