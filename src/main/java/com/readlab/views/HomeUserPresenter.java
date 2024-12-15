package com.readlab.views;

import com.gluonhq.charm.glisten.afterburner.AppView;
import com.gluonhq.charm.glisten.animation.BounceInRightTransition;
import com.gluonhq.charm.glisten.animation.FadeInTransition;
import com.gluonhq.charm.glisten.application.AppManager;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.FloatingActionButton;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.fxml.FXML;

public class HomeUserPresenter {

    @FXML
    private View homeUser;

    public void initialize() {
        homeUser.setShowTransitionFactory(FadeInTransition::new);

        homeUser.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppManager appManager = AppManager.getInstance();
                AppBar appBar = appManager.getAppBar();
                appBar.setTitleText("Good Morning [USER]");
                appBar.getActionItems().add(MaterialDesignIcon.SHOPPING_BASKET.button(e ->
                       AppViewManager.CARTUSER_VIEW.switchView()));
            }
        });
    }

    @FXML
    void navigateToDetailBook() {
        try {
            AppViewManager.DETAILBOOKUSER_VIEW.switchView();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
