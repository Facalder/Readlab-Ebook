package com.readlab.views;

import com.gluonhq.charm.glisten.application.AppManager;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import com.readlab.MainApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class HomeUserPresenter {

    @FXML
    private View homeuser;

    @FXML
    private VBox imageDetail;

    @FXML
    private Label label;

    public void initialize() {
        homeuser.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppBar appBar = AppManager.getInstance().getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> {
                    AppManager.getInstance().getDrawer().open();
                }));
                appBar.setTitleText("Home");
                appBar.getActionItems().add(MaterialDesignIcon.NOTIFICATIONS.button(e -> {

                }));
                appBar.getStyleClass().add("app-bar");
            }
        });
    }
    
    @FXML
    public void handleBookDetail() {
        try {
            AppManager.getInstance().switchView(MainApplication.BOOKDETAILUSER_VIEW);
        }catch (Exception e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}
