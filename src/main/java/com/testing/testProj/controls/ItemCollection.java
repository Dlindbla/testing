package com.testing.testProj.controls;

import com.testing.testProj.controls.skin.ItemCollectionSkin;
import com.testing.testProj.items.ObservableItem;
import javafx.beans.Observable;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;
import java.util.List;

public class ItemCollection extends Control {

    private final ObservableList<ObservableItem> items = FXCollections.observableArrayList(
            obs -> new Observable[]{
                    obs.infoProperty(),
                    obs.idProperty(),
                    obs.getSubItems(),
                    obs.nameProperty()
    });


    private SimpleObjectProperty<ObservableItem> selectedItem = new SimpleObjectProperty<>(new ObservableItem());


    public ItemCollection(List<ObservableItem> items){
        setItems(items);
    }

    public ItemCollection() {

    }


    @Override
    protected Skin<ItemCollection> createDefaultSkin(){
        return new ItemCollectionSkin(this);
    }

    public ObservableList<ObservableItem> getItems() {
        return items;
    }

    public void setItems(List<ObservableItem> items) {
        this.items.setAll(items);
    }

    public ObservableItem getSelectedItem() {
        return selectedItem.get();
    }

    public SimpleObjectProperty<ObservableItem> selectedItemProperty() {
        return selectedItem;
    }

    public void setSelectedItem(ObservableItem selectedItem) {
        this.selectedItem.set(selectedItem);
    }
}
