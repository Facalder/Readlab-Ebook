package com.readlab.views;

import com.gluonhq.charm.glisten.animation.FadeInTransition;
import com.gluonhq.charm.glisten.application.AppManager;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import java.util.ResourceBundle;

import com.readlab.global.IDebug;
import com.readlab.global.IUser;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginPresenter {

    @FXML
    private View loginUser;

    @FXML
    private Label label;

    @FXML
    private TextField emailField;

    @FXML
    private TextField fullnameField;

    @FXML
    private PasswordField passwordField;

    private Alert alert;
    
    public void initialize() {
        loginUser.setShowTransitionFactory(FadeInTransition::new);

        loginUser.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppManager appManager = AppManager.getInstance();
                AppBar appBar = appManager.getAppBar();
                appBar.setVisible(false);
                appBar.setStyle("-fx-background-color: #2563eb; -fx-effect: none;");
            }
        });
    }
    
    @FXML
    protected void HandleUserLogin() {
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
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("NO USER FOUND");
                    alert.setHeaderText("Error");
                    alert.setContentText("You haven't registered yet!");
                    alert.showAndWait();

                    throw new Exception("[ERROR] - No user found");
                }else {
                    for (int i = 0; i < IUser.user_list.size(); i++) {
                        if (IUser.user_list.get(i).getUser_email().equals(email) && IUser.user_list.get(i).equals(fullname) && IUser.user_list.get(i).getUser_password().equals(password)) {
                            AppViewManager.HOMEUSER_VIEW.switchView();
                            throw new Exception("[SUCCESS] - Login successful");
                        }else {
                            alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("INVALID CREDENTIALS");
                            alert.setHeaderText("Error");
                            alert.setContentText("Invalid credentials!");
                            alert.showAndWait();

                            throw new Exception("[ERROR] - Invalid credentials");
                        }
                    }
                }
            }else {
                AppViewManager.HOMEUSER_VIEW.switchView();
            }

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    protected void NavigateToRegister() {
        try {
            AppViewManager.REGISTER_VIEW.switchView();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
