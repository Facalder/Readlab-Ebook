package com.readlab.views;

import com.gluonhq.charm.glisten.animation.FadeInTransition;
import com.gluonhq.charm.glisten.application.AppManager;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.readlab.global.IDebug;
import com.readlab.global.IUser;
import com.readlab.models.User;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.TouchEvent;

import java.util.ResourceBundle;

public class RegisterPresenter {

    @FXML
    private View registerUser;

    @FXML
    private TextField emailField;

    @FXML
    private TextField fullnameField;

    @FXML
    private PasswordField passwordField;

    private Alert alert;

    public void initialize() {
        registerUser.setShowTransitionFactory(FadeInTransition::new);

        registerUser.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppManager appManager = AppManager.getInstance();
                AppBar appBar = appManager.getAppBar();
                appBar.setVisible(false);
                appBar.setStyle("-fx-background-color: #2563eb; -fx-effect: none;");
            }
        });
    }

    @FXML
    protected void HandleUserRegister() {
        try {
            if (!IDebug.isDebug) {
                String email = emailField.getText();
                String fullname = fullnameField.getText();
                String password = passwordField.getText();

                if(email.isEmpty() || fullname.isEmpty() || password.isEmpty()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("EMPTY FIELD");
                    alert.setHeaderText("Error");
                    alert.setContentText("Please fill all fields!");
                    alert.showAndWait();

                    throw new Exception("[ERROR] - Please fill all fields");
                }

                if (IUser.user_list.isEmpty()) {
                    for (int i = 0; i < 9; i++) {
                        IUser.user_list.add(new User(i, "Reader", email, fullname, password));

                        try {
                            if (IUser.user_list.get(i-1).getUser_email().equals(email)) {
                                alert = new Alert(Alert.AlertType.ERROR);
                                alert.setTitle("EMAIL ALREADY REGISTERED");
                                alert.setHeaderText("Error");
                                alert.setContentText("Email already registered!");
                                alert.showAndWait();

                                throw new Exception("[ERROR] - Email already registered");
                            }else {
                                AppViewManager.HOMEUSER_VIEW.switchView();
                            }
                        }catch (Exception e) {
                            throw new Exception("[ERROR] - Email already registered");
                        }

                        throw new Exception("[SUCCESS] - Register successful");
                    }
                }
            }else {
                AppViewManager.HOMEUSER_VIEW.switchView();
            }

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void NavigateToLogin() {
        try {
            AppViewManager.LOGIN_VIEW.switchView();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
