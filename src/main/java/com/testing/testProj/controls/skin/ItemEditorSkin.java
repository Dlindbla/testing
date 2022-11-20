package com.testing.testProj.controls.skin;

import com.testing.testProj.controls.ItemEditor;
import com.testing.testProj.items.ObservableSubItem;
import com.testing.testProj.items.Type;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;

public class ItemEditorSkin extends SkinBase<ItemEditor> implements Skin<ItemEditor> {
    public ItemEditorSkin(ItemEditor itemEditor) {
        super(itemEditor);

        GridPane gridPane = new GridPane();

        Label nameLabel = new Label("NAME");
        Label idLabel = new Label("ID");
        Label infoLabel = new Label("INFO");

        TextField nameField = new TextField();
        TextField idField = new TextField();
        TextField infoField = new TextField();


        gridPane.addRow(0,nameLabel, nameField);
        gridPane.addRow(1,idLabel, idField);
        gridPane.addRow(2,infoLabel, infoField);

        TableView<ObservableSubItem> items = new TableView<>();
        TableColumn<ObservableSubItem, String> nameColumn = new TableColumn<>("name");
        TableColumn<ObservableSubItem, Boolean> boolColumn = new TableColumn<>("bool");
        TableColumn<ObservableSubItem, Type> typeColumn = new TableColumn<>("type");

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        boolColumn.setCellValueFactory(new PropertyValueFactory<>("bool"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));

        items.getSelectionModel().selectedItemProperty().addListener((obs,old,neo) -> {
            itemEditor.setSelectedSubItem(neo);
        });

        items.getColumns().addAll(nameColumn, boolColumn, typeColumn);

        GridPane.setColumnSpan(items, 2);
        gridPane.addRow(3,items);


        itemEditor.itemProperty().addListener((obs,old,neo) -> {
            if(old != null) {
                nameField.textProperty().unbindBidirectional(old.nameProperty());
                idField.textProperty().unbindBidirectional(old.idProperty());
                infoField.textProperty().unbindBidirectional(old.infoProperty());
                items.itemsProperty().unbindBidirectional(old.subItemsProperty());
            }
            if(neo != null) {
                items.itemsProperty().bindBidirectional(neo.subItemsProperty());
                nameField.textProperty().bindBidirectional(neo.nameProperty());
                idField.textProperty().bindBidirectional(neo.idProperty());
                infoField.textProperty().bindBidirectional(neo.infoProperty());
            }
        });
        this.getChildren().add(gridPane);
    }
}
