package controllers;

import helpers.utils.Resource;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InitPreloadController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {}

    public void loadResources(){

        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(2500);
                Resource.loadScenes();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        try {
            t1.start();
            t1.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
