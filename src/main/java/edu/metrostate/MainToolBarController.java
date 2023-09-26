package edu.metrostate;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MainToolBarController {

    private final MainToolBar toolBar;
    private final ValueStore store;

    private EventHandler<ActionEvent> incrementHandler;

    MainToolBarController(MainToolBar toolBar, ValueStore store, EventHandler<ActionEvent> incrementHandler) {
        this.toolBar = toolBar;
        this.store = store;
        this.toolBar.addButton.setOnAction(incrementHandler);
        this.toolBar.subtractButton.setOnAction(action -> {
            this.store.decrement();
        });
    }
}
