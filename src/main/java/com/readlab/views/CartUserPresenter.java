package com.readlab.views;

import com.gluonhq.charm.glisten.animation.FadeInTransition;
import com.gluonhq.charm.glisten.application.AppManager;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import com.readlab.global.IUser;
import com.readlab.models.Book;
import com.readlab.models.BookCollection;
import com.readlab.models.User;
import javafx.fxml.FXML;

public class CartUserPresenter {
    @FXML
    private View cartUSer;

    public void initialize() {
        cartUSer.setShowTransitionFactory(FadeInTransition::new);

        cartUSer.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppManager appManager = AppManager.getInstance();
                AppBar appBar = appManager.getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.ARROW_BACK.button(e ->
                        AppViewManager.HOMEUSER_VIEW.switchView()
                ));
            }
        });
    }
}
