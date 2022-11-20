package com.testing.testProj.controls.skin;

import com.testing.testProj.controls.ItemCollection;
import com.testing.testProj.items.ObservableItem;
import javafx.scene.control.Skin;
import javafx.scene.control.SkinBase;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ItemCollectionSkin extends SkinBase<ItemCollection> implements Skin<ItemCollection> {
    public ItemCollectionSkin(ItemCollection itemCollection) {
        super(itemCollection);

        TableView<ObservableItem> observableItemTableView = new TableView<>();

        TableColumn<ObservableItem, String> nameColumn = new TableColumn<>("name");
        TableColumn<ObservableItem, String> idColumn = new TableColumn<>("id");
        TableColumn<ObservableItem, String> infoColumn = new TableColumn<>("info");


        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        infoColumn.setCellValueFactory(new PropertyValueFactory<>("info"));

        observableItemTableView.getColumns().addAll(nameColumn, idColumn, infoColumn);

        observableItemTableView.getSelectionModel().selectedItemProperty().addListener((obs,old,neo) -> itemCollection.setSelectedItem(neo));

        observableItemTableView.setItems(itemCollection.getItems());

        observableItemTableView.setMaxHeight(Double.MAX_VALUE);

        this.getChildren().addAll(observableItemTableView);

    }
}
