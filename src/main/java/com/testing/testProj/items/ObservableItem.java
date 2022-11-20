package com.testing.testProj.items;

import javafx.beans.Observable;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.Objects;

public class ObservableItem {


    private SimpleStringProperty name = new SimpleStringProperty();
    private SimpleStringProperty id = new SimpleStringProperty();
    private SimpleStringProperty info = new SimpleStringProperty();


    private final ObservableList<ObservableSubItem> subItemsObs = FXCollections.observableArrayList(
            obs -> new Observable[]{
                    obs.nameProperty(),
                    obs.boolProperty(),
                    obs.typeProperty()
            }
    );


    private final SimpleObjectProperty<ObservableList<ObservableSubItem>> subItems = new SimpleObjectProperty<>(subItemsObs);


    public ObservableItem(String name, String id, String info, List<ObservableSubItem> items) {
        setName(name);
        setId(id);
        setInfo(info);
        subItemsObs.setAll(items);
    }

    public ObservableList<ObservableSubItem> getSubItemsObs() {
        return subItemsObs;
    }


    public ObservableItem() {
    }

    public ObservableList<ObservableSubItem> getSubItems() {
        return subItems.get();
    }

    public SimpleObjectProperty<ObservableList<ObservableSubItem>> subItemsProperty() {
        return subItems;
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public void setInfo(String info) {
        this.info.set(info);
    }

    public String getId() {
        return id.get();
    }

    public String getInfo() {
        return info.get();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public SimpleStringProperty infoProperty() {
        return info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObservableItem that = (ObservableItem) o;
        return Objects.equals(name.getValue(), that.name.getValue()) &&
                Objects.equals(id.getValue(), that.id.getValue()) &&
                Objects.equals(info.getValue(), that.info.getValue()) &&
                Objects.equals(subItemsObs, that.subItemsObs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, info, subItemsObs, subItems);
    }

}
