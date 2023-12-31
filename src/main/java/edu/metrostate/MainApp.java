package edu.metrostate;

import edu.metrostate.images.ImageUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;

public class MainApp extends Application {

    private final ValueStore store;

    public MainApp() {
        this.store = new ValueStore();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("scene.fxml"));
        BorderPane root = loader.load();

        IncrementValueHandler handler = new IncrementValueHandler(this.store);

        MainSceneController mainSceneController = loader.getController();
        mainSceneController.setValueStore(store);
        mainSceneController.addButtonHandler(handler);

        MainToolBar mainToolBar = new MainToolBar();
        MainToolBarController mainToolBarController = new MainToolBarController(mainToolBar, store, handler);
        root.setTop(mainToolBar);

        ImageView imageView = new ImageView(ImageUtil.keyboardImage());
        root.setLeft(imageView);

        Scene scene = new Scene(root);

        loadStylesheetIntoScene(scene);

        stage.setTitle("ICS 372 - HelloFX");
        stage.setScene(scene);
        stage.show();
    }

    private void loadStylesheetIntoScene(Scene scene) {
        URL stylesheetURL = getClass().getResource("style.css");
        if (stylesheetURL == null) {
            return;
        }
        String urlString = stylesheetURL.toExternalForm();
        if (urlString == null) {
            return;
        }
        scene.getStylesheets().add(urlString);
    }
}