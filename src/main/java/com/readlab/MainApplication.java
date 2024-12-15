package com.readlab;

import com.readlab.views.*;
import com.gluonhq.charm.glisten.application.AppManager;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.Swatch;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.geometry.Rectangle2D;
import javafx.stage.StageStyle;

import java.util.Objects;

import static com.gluonhq.charm.glisten.application.AppManager.HOME_VIEW;

public class MainApplication extends Application {

    public static final String LOGINUSER_VIEW = HOME_VIEW;
    public static final String HOMEUSER_VIEW = "HomeUser View";
    public static final String BOOKDETAILUSER_VIEW = "DetailBookUser View";
    public static final String READPAGEUSER_VIEW = "ReadPageUser View";
    public static final String SEARCHUSER_VIEW = "SearchUser View";

    private final AppManager appManager = AppManager.initialize(this::postInit);
    private final Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();

    @Override
    public void init() {
        appManager.addViewFactory(LOGINUSER_VIEW, () -> (View) new LoginUserView().getView());
        appManager.addViewFactory(HOMEUSER_VIEW, () -> (View) new HomeUserView().getView());
        appManager.addViewFactory(BOOKDETAILUSER_VIEW, () -> (View) new BookDetailUserView().getView());
        appManager.addViewFactory(READPAGEUSER_VIEW, () -> (View) new ReadPageBookUserView().getView());
        appManager.addViewFactory(SEARCHUSER_VIEW, () -> (View) new SearchUserView().getView());

        DrawerManager.buildDrawer(appManager);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
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

        addStyleSheets(scene);
        ((Stage) scene.getWindow()).getIcons().add(new Image(Objects.requireNonNull(MainApplication.class.getResourceAsStream("/icon.png"))));
    }

    public static void addStyleSheets(Scene scene) {
        final String[] STYLESHEETS = { "style.css", "typography.css", "button.css", "color.css", "input.css", "layout.css" };

        for (String stylesheet : STYLESHEETS) {
            scene.getStylesheets().add(Objects.requireNonNull(MainApplication.class.getResource(stylesheet)).toExternalForm());
        }
    }

    public static void main(String args[]) {
        System.setProperty("java:fx.platform", "desktop");
        launch(args);
    }
}
