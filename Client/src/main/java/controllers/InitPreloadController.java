package controllers;

import utils.Resource;
import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InitPreloadController implements Initializable {

    public static Label lblLoading;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void checkFunctions(){

        final String[] message = {""};
        Thread t1 = new Thread(() -> {
            message[0] = "Loading...";
            Platform.runLater(() -> lblLoading.setText(message[0]));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            message[0] = "Loading...";
            Platform.runLater(() -> lblLoading.setText(message[0]));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(() -> {
            message[0] = "Open";
            Platform.runLater(() -> lblLoading.setText(message[0]));

            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                        Resource.loadScenes();
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

        });

        try {
            t1.start();
            t1.join();
            t2.start();
            t2.join();
            t3.start();
            t3.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
