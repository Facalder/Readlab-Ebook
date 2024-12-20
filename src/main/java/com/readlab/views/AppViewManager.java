package com.readlab.views;

import com.gluonhq.charm.glisten.afterburner.AppView;
import com.gluonhq.charm.glisten.afterburner.AppViewRegistry;
import com.gluonhq.charm.glisten.afterburner.Utils;
import com.gluonhq.charm.glisten.application.AppManager;
import com.gluonhq.charm.glisten.control.Avatar;
import com.gluonhq.charm.glisten.control.NavigationDrawer;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import com.readlab.MainApplication;
import javafx.scene.image.Image;
import java.util.Locale;

import static com.gluonhq.charm.glisten.afterburner.AppView.Flag.HOME_VIEW;
import static com.gluonhq.charm.glisten.afterburner.AppView.Flag.SHOW_IN_DRAWER;
import static com.gluonhq.charm.glisten.afterburner.AppView.Flag.SKIP_VIEW_STACK;

public class AppViewManager {

    public static final AppViewRegistry REGISTRY = new AppViewRegistry();

    public static final AppView LOGIN_VIEW = view("Login", LoginPresenter.class, MaterialDesignIcon.HOME, SHOW_IN_DRAWER, HOME_VIEW, SKIP_VIEW_STACK);
    public static final AppView HOMEUSER_VIEW = view("HomeUser", HomeUserPresenter.class, MaterialDesignIcon.DASHBOARD, SHOW_IN_DRAWER);
    
    private static AppView view(String title, Class<?> presenterClass, MaterialDesignIcon menuIcon, AppView.Flag... flags ) {
        return REGISTRY.createView(name(presenterClass), title, presenterClass, menuIcon, flags);
    }

    private static String name(Class<?> presenterClass) {
        return presenterClass.getSimpleName().toUpperCase(Locale.ROOT).replace("PRESENTER", "");
    }
    
    public static void registerViewsAndDrawer() {
        for (AppView view : REGISTRY.getViews()) {
            view.registerView();
        }

        NavigationDrawer.Header header = new NavigationDrawer.Header("Gluon Application",
                "Multi View Project",
                new Avatar(21, new Image(MainApplication.class.getResourceAsStream("/icon.png"))));

        Utils.buildDrawer(AppManager.getInstance().getDrawer(), header, REGISTRY.getViews()); 
    }
}
