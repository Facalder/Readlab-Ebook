package com.readlab.views;

import com.gluonhq.charm.glisten.application.AppManager;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.TextField;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import com.readlab.MainApplication;
import com.readlab.global.IMode;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class LoginUserPresenter {
    @FXML
    private View loginuser;

    @FXML
    private TextField emailUser;
    @FXML
    private TextField fullnameUser;
    @FXML
    private PasswordField passwordUser;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void handleLogin() {
        try {
            if (!IMode.DEBUG) {
                String email = emailUser.getText();
                String fullname = fullnameUser.getText();
                String password = passwordUser.getText();

                if (email.isEmpty() || fullname.isEmpty() || password.isEmpty()) {
                    throw new Exception("Email, Fullname, dan Password tidak boleh kosong!");
                }

                if (email.equals("test@gmail.com") && fullname.equals("test") && password.equals("123")) {
                    System.out.println("Validasi berhasil, mencoba memuat HomeUser.fxml");
                    AppManager.getInstance().switchView(MainApplication.HOMEUSER_VIEW);
                    System.out.println("Berhasil memuat HomeUser.fxml, mengatur scene baru");
                } else {
                    throw new Exception("Informasi login tidak valid!");
                }
            }else {
                AppManager.getInstance().switchView(MainApplication.HOMEUSER_VIEW);
            }
        } catch (Exception e) {
            System.out.println("[ERROR] " + e.getMessage() + " Tidak bisa login!");
        }
    }

    public void initialize() {
        loginuser.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppBar appBar = AppManager.getInstance().getAppBar();
                appBar.setVisible(false);
            }
        });
    }
}
