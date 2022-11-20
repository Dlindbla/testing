package com.testing.testProj;

import com.testing.testProj.controls.ItemCollection;
import com.testing.testProj.controls.ItemEditor;
import com.testing.testProj.controls.SubItemEditor;
import com.testing.testProj.controls.Util;
import com.testing.testProj.items.ObservableItem;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;
    @FXML
    VBox mainContainer;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    private ItemCollection itemCollection;
    private ItemEditor itemEditor;
    private SubItemEditor subItemEditor;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        HBox subContainer = new HBox();
        HBox buttonContainer = new HBox();
        HBox spacingContainer = new HBox();
        HBox.setHgrow(spacingContainer, Priority.ALWAYS);

        Button resetButton = new Button("reset");
        resetButton.setOnAction(actionEvent -> {
            reset();
            actionEvent.consume();
        });

        Button saveButton = new Button("save");
        saveButton.setOnAction(actionEvent -> {
            save();
            actionEvent.consume();
        });


        buttonContainer.getChildren().addAll(resetButton, saveButton);



        itemCollection = new ItemCollection();
        itemEditor = new ItemEditor();
        subItemEditor = new SubItemEditor();

        itemCollection.selectedItemProperty().addListener((obs, old, neo) -> itemEditor.setItem(neo));
        itemEditor.selectedSubItemProperty().addListener((obs, old, neo) -> subItemEditor.setObservableSubItem(neo));

        itemCollection.setItems(Util.getItems());

        HBox.setHgrow(itemCollection, Priority.ALWAYS);
        HBox.setHgrow(itemEditor, Priority.ALWAYS);
        HBox.setHgrow(subItemEditor, Priority.ALWAYS);
        VBox.setVgrow(subContainer, Priority.ALWAYS);

        List<ObservableItem> oldItems = Util.getItems();

        saveButton.setDisable(itemCollection.getItems().equals(oldItems));
        resetButton.setDisable(itemCollection.getItems().equals(oldItems));
        itemCollection.getItems().addListener((ListChangeListener<ObservableItem>) change -> {
            System.out.println("change detected");
            saveButton.setDisable(itemCollection.getItems().equals(oldItems));
            resetButton.setDisable(itemCollection.getItems().equals(oldItems));
        });




        //saveButton.disableProperty().bind(isDifferentList);
        //resetButton.disableProperty().bind(isDifferentList);

        subContainer.getChildren().addAll(itemCollection, itemEditor, subItemEditor);

        mainContainer.getChildren().addAll(subContainer, buttonContainer);
    }

    private void save() {

    }


    private void reset() {
        //itemCollection.setItems(obs2);
        //obs1 = obs2;

        itemCollection.setItems(Util.getItems());

    }


}