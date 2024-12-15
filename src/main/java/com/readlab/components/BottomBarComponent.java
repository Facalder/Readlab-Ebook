package com.readlab.components;

import com.gluonhq.charm.glisten.application.AppManager;
import com.readlab.MainApplication;
import javafx.fxml.FXML;

public class BottomBarComponent {
    @FXML
    public void navigateToHome() {
        try {
            AppManager.getInstance().switchView(MainApplication.HOMEUSER_VIEW);
            throw new Exception("[SUCCESS] Berhasil Membuka Halaman Home");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    public void navigateToSearch() {
        try {
            AppManager.getInstance().switchView(MainApplication.SEARCHUSER_VIEW);
            throw new Exception("[SUCCESS] Berhasil Membuka Halaman Search");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    public void navigateToWhistlist() {
        try {
            AppManager.getInstance().switchView(MainApplication.SEARCHUSER_VIEW);
            throw new Exception("[SUCCESS] Berhasil Membuka Halaman Whistlist");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    public void navigateToAccount() {
        try {
            AppManager.getInstance().switchView(MainApplication.SEARCHUSER_VIEW);
            throw new Exception("[SUCCESS] Berhasil Membuka Halaman Account");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
