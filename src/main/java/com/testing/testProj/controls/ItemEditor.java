package com.testing.testProj.controls;

import com.testing.testProj.controls.skin.ItemEditorSkin;
import com.testing.testProj.items.ObservableItem;
import com.testing.testProj.items.ObservableSubItem;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;

public class ItemEditor extends Control{


    SimpleObjectProperty<ObservableItem> item = new SimpleObjectProperty<>(new ObservableItem());
    SimpleObjectProperty<ObservableSubItem> selectedSubItem = new SimpleObjectProperty<>(null);






    @Override
    protected Skin<ItemEditor> createDefaultSkin(){
        return new ItemEditorSkin(this);
    }

    public ObservableSubItem getSelectedSubItem() {
        return selectedSubItem.get();
    }

    public SimpleObjectProperty<ObservableSubItem> selectedSubItemProperty() {
        return selectedSubItem;
    }

    public void setSelectedSubItem(ObservableSubItem selectedSubItem) {
        this.selectedSubItem.set(selectedSubItem);
    }

    public ObservableItem getItem() {
        return item.get();
    }

    public SimpleObjectProperty<ObservableItem> itemProperty() {
        return item;
    }

    public void setItem(ObservableItem item) {
        this.item.set(item);
    }
}
