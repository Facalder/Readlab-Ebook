package com.readlab;

import com.readlab.views.AppViewManager;
import com.gluonhq.charm.glisten.application.AppManager;
import com.gluonhq.charm.glisten.visual.Swatch;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import static com.gluonhq.charm.glisten.application.AppManager.HOME_VIEW;

public class MainApplication extends Application {

    private final AppManager appManager = AppManager.initialize(this::postInit);
    private final Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();

    @Override
    public void init() {
        AppViewManager.registerViewsAndDrawer();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
//        pada saat dijalankan dia mengambil 40% dari layar
        double getScreenWidth = screenBounds.getWidth();
        double getScreenHeight = screenBounds.getHeight();

        primaryStage.setMaxWidth(getScreenWidth * 0.4);
        primaryStage.setMinWidth(getScreenWidth * 0.3);

        primaryStage.setMaxHeight(getScreenHeight);
        primaryStage.setMinHeight(getScreenHeight * 0.9);

        primaryStage.centerOnScreen();
        primaryStage.initStyle(StageStyle.DECORATED);

        appManager.start(primaryStage);
    }

    private void postInit(Scene scene) {
        Swatch.BLUE.assignTo(scene);

        scene.getStylesheets().add(MainApplication.class.getResource("style.css").toExternalForm());
        ((Stage) scene.getWindow()).getIcons().add(new Image(MainApplication.class.getResourceAsStream("/icon.png")));
    }

    public static void main(String args[]) {
        launch(args);
    }
}
