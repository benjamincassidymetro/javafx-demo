package edu.metrostate;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class IncrementValueHandler implements EventHandler<ActionEvent> {

    private ValueStore valueStore;

    public IncrementValueHandler(ValueStore valueStore) {
        this.valueStore = valueStore;
    }

    @Override
    public void handle(ActionEvent event) {
        valueStore.increment();
    }
}
