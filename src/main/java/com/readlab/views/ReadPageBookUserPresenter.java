package com.readlab.views;

import com.gluonhq.charm.glisten.application.AppManager;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import com.readlab.MainApplication;
import javafx.fxml.FXML;

public class ReadPageBookUserPresenter {
    @FXML
    private View readPageUser;

    public void initialize() {
        readPageUser.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppBar appBar = AppManager.getInstance().getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.ARROW_BACK.button(e -> {
                    AppManager.getInstance().switchView(MainApplication.BOOKDETAILUSER_VIEW);
                }));
                appBar.setTitleText("[JUDUl BUKU]");
                appBar.getActionItems().add(MaterialDesignIcon.MORE_VERT.button(e -> {

                }));
                appBar.getStyleClass().add("app-bar");
            }
        });
    }
}
