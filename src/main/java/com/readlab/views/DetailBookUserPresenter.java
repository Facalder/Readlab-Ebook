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
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class DetailBookUserPresenter {

    @FXML
    private Label bookPublisher;

    @FXML
    private Label bookLanguage;

    @FXML
    private Label bookISBN;

    @FXML
    private Label bookAuthor;

    @FXML
    private Label bookCategory;

    @FXML
    private Label bookFileSize;

    @FXML
    private Label bookPages;

    @FXML
    private Label bookDescription;

    @FXML
    private ImageView bookImage;

    @FXML
    private Label bookTitle;

    @FXML
    private View detailBookUser;

    private Book book;
    private User user;

    public void initialize() {
        detailBookUser.setShowTransitionFactory(FadeInTransition::new);

        detailBookUser.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppManager appManager = AppManager.getInstance();
                AppBar appBar = appManager.getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.ARROW_BACK.button(e ->
                        AppViewManager.HOMEUSER_VIEW.switchView()
                ));
                appBar.getActionItems().add(MaterialDesignIcon.BOOKMARK_BORDER.button(e ->
                        AddBookCollection()
                ));
            }
        });
    }

    @FXML
    void navigateToReadPage() {
        AppViewManager.READPAGEUSER_VIEW.switchView();
    }

    private void AddBookCollection() {
        try {
            if (IUser.book_collection_list.isEmpty()) {
                if (book != null) {
                    IUser.book_collection_list.add(new BookCollection(book, Integer.toString(user.getUser_id()) , "My Collection", "My Collection"));
                }else {
                    throw new Exception("[ERROR] - There's no book!");
                }

                /*try {
                    for (int i = 0; i < IUser.book_collection_list.size(); i++) {
                        if (Objects.equals(IUser.book_collection_list.get(i).getBook_collection_id(), Integer.toString(user.getUser_id()))) {
                            AppBar appBar = AppManager.getInstance().getAppBar();
                            appBar.getMenuItems().clear();

                            int idx = i;

                            appBar.getActionItems().add(MaterialDesignIcon.BOOKMARK.button(e -> {
                                IUser.book_collection_list.remove(idx);
                                appBar.getMenuItems().clear();
                                appBar.getMenuItems().add(MaterialDesignIcon.BOOKMARK_BORDER.button( e2 -> {

                                }));
                            }));
                        }
                    }
                }catch (Exception e) {

                }*/

                throw new Exception("[SUCCESS] - Add to collection successful");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
