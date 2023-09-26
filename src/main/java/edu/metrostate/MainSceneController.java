package edu.metrostate;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainSceneController implements ValueChangedListener, EventHandler<ActionEvent> {

    @FXML
    private Label label;

    @FXML
    private Label value;

    @FXML
    private MainToolBar mainToolBar;

    @FXML
    private Button centerButton;

    @FXML
    private Button centerButton2;

    private ValueStore store;

    private EventHandler<ActionEvent> addButtonHandler;

    private final String valueFormatString = "Current value: %d";

    public void initialize() {
        label.setText("Hello, ICS372 JavaFX");
        centerButton.setOnAction(this);
    }

    public void setValueStore(ValueStore store) {
        this.store = store;
        if (this.store != null) {
            this.store.registerValueChangeListener(this);
        }
    }

    public void addButtonHandler(EventHandler<ActionEvent> eventHandler) {
        this.addButtonHandler = eventHandler;
        centerButton2.setOnAction(addButtonHandler);
    }

    @Override
    public void onValueChange(int newValue) {
        value.setText(String.format(valueFormatString, newValue));
    }

    @Override
    public void handle(ActionEvent event) {
        System.out.println("handle: " + event.toString() + " eventType: " + event.getEventType().toString());
    }
}
