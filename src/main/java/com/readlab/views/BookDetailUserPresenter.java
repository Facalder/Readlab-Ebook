package com.readlab.views;

import com.gluonhq.charm.glisten.application.AppManager;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import com.readlab.MainApplication;
import javafx.fxml.FXML;

public class BookDetailUserPresenter {

    @FXML
    private View bookUserDetail;

    @FXML
    public void handleReadBook() {
        try {
            AppManager.getInstance().switchView(MainApplication.READPAGEUSER_VIEW);
        }catch (Exception e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }


    public void initialize() {
        bookUserDetail.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppBar appBar = AppManager.getInstance().getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.ARROW_BACK.button(e -> {
                    AppManager.getInstance().switchView(MainApplication.HOMEUSER_VIEW);
                }));
                appBar.setTitleText("[NAMA BUKU]");
                appBar.getActionItems().add(MaterialDesignIcon.MORE_VERT.button(e -> {

                }));
                appBar.getStyleClass().add("app-bar");
            }
        });
    }
}
