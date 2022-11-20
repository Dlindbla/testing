package com.testing.testProj.controls;

import com.testing.testProj.controls.skin.SubItemEditorSkin;
import com.testing.testProj.items.ObservableSubItem;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;

public class SubItemEditor extends Control {

    SimpleObjectProperty<ObservableSubItem> observableSubItem = new SimpleObjectProperty<>();



    @Override
    protected Skin<SubItemEditor> createDefaultSkin(){
        return new SubItemEditorSkin(this);
    }

    public ObservableSubItem getObservableSubItem() {
        return observableSubItem.get();
    }

    public SimpleObjectProperty<ObservableSubItem> observableSubItemProperty() {
        return observableSubItem;
    }

    public void setObservableSubItem(ObservableSubItem observableSubItem) {
        this.observableSubItem.set(observableSubItem);
    }
}
