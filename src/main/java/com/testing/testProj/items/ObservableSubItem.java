package com.testing.testProj.items;

import javafx.beans.property.*;

import java.util.Objects;

public class ObservableSubItem {


    SimpleStringProperty name = new SimpleStringProperty();
    SimpleBooleanProperty bool = new SimpleBooleanProperty();
    SimpleObjectProperty<Type> type = new SimpleObjectProperty<>(Type.Other);



    public ObservableSubItem() {
    }

    public ObservableSubItem(String name, boolean bool, Type type) {
        setName(name);
        setBool(bool);
        setType(type);
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

    public boolean isBool() {
        return bool.get();
    }

    public SimpleBooleanProperty boolProperty() {
        return bool;
    }

    public void setBool(boolean bool) {
        this.bool.set(bool);
    }

    public Type getType() {
        return type.get();
    }

    public SimpleObjectProperty<Type> typeProperty() {
        return type;
    }

    public void setType(Type type) {
        this.type.set(type);
    }

    @Override
    public String toString() {
        return "ObservableSubItem{" +
                "name=" + name +
                ", bool=" + bool +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObservableSubItem that = (ObservableSubItem) o;
        return Objects.equals(name.getValue(), that.name.getValue()) && Objects.equals(bool.getValue(), that.bool.getValue()) && Objects.equals(type.getValue(), that.type.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, bool, type);
    }
}
