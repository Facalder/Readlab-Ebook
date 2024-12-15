package com.readlab;

import com.gluonhq.attach.lifecycle.LifecycleService;
import com.gluonhq.attach.util.Platform;
import com.gluonhq.attach.util.Services;
import com.gluonhq.charm.glisten.application.AppManager;
import com.gluonhq.charm.glisten.application.ViewStackPolicy;
import com.gluonhq.charm.glisten.control.Avatar;
import com.gluonhq.charm.glisten.control.NavigationDrawer;
import com.gluonhq.charm.glisten.control.NavigationDrawer.Item;
import com.gluonhq.charm.glisten.control.NavigationDrawer.ViewItem;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.scene.image.Image;

import javax.swing.text.View;

import static com.readlab.MainApplication.*;

public class DrawerManager {

    public static void buildDrawer(AppManager app) {
        NavigationDrawer drawer = app.getDrawer();
        
        NavigationDrawer.Header header = new NavigationDrawer.Header("Gluon Application",
                "Multi View Project",
                new Avatar(21, new Image(DrawerManager.class.getResourceAsStream("/icon.png"))));
        drawer.setHeader(header);
        
        final Item homeUserItem = new ViewItem("Home User", MaterialDesignIcon.HOME.graphic(), HOMEUSER_VIEW, ViewStackPolicy.SKIP);
        final Item bookDetailUserItem = new ViewItem("Book Detail", MaterialDesignIcon.HOME.graphic(), HOMEUSER_VIEW, ViewStackPolicy.SKIP);
        final Item searchUserItem = new ViewItem("Search User", MaterialDesignIcon.SEARCH.graphic(), SEARCHUSER_VIEW, ViewStackPolicy.SKIP);

        drawer.getItems().addAll(homeUserItem, searchUserItem);
        
        if (Platform.isDesktop()) {
            final Item quitItem = new Item("Quit", MaterialDesignIcon.EXIT_TO_APP.graphic());
            quitItem.selectedProperty().addListener((obs, ov, nv) -> {
                if (nv) {
                    Services.get(LifecycleService.class).ifPresent(LifecycleService::shutdown);
                }
            });
            drawer.getItems().add(quitItem);
        }
    }
}