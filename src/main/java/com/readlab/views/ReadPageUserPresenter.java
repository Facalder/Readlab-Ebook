package com.readlab.views;

import com.gluonhq.charm.glisten.animation.FadeInTransition;
import com.gluonhq.charm.glisten.application.AppManager;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class ReadPageUserPresenter {
    @FXML
    private View readPageUser;

    public void initialize() {
        readPageUser.setShowTransitionFactory(FadeInTransition::new);

        readPageUser.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppManager appManager = AppManager.getInstance();
                AppBar appBar = appManager.getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.ARROW_BACK.button(e ->
                        AppViewManager.DETAILBOOKUSER_VIEW.switchView()));
                appBar.setTitleText("Good Morning [USER]");
                appBar.getActionItems().add(MaterialDesignIcon.COLOR_LENS.button(e ->
                        System.out.println("Favorite")));
            }
        });
    }
}
