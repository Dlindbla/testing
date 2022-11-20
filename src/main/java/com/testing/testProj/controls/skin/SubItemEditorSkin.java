package com.testing.testProj.controls.skin;

import com.testing.testProj.controls.SubItemEditor;
import com.testing.testProj.items.Type;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class SubItemEditorSkin extends SkinBase<SubItemEditor> implements Skin<SubItemEditor> {
    public SubItemEditorSkin(SubItemEditor subItemEditor) {
        super(subItemEditor);

        GridPane gridPane = new GridPane();


        Label nameLabel = new Label("name");
        Label boolLabel = new Label("bool");
        Label typeLabel = new Label("type");

        TextField nameField = new TextField();
        CheckBox checkBox = new CheckBox();
        ComboBox<Type> comboBox = new ComboBox<>();


        gridPane.addRow(0, nameLabel, nameField);
        gridPane.addRow(1, boolLabel, checkBox);
        gridPane.addRow(2, typeLabel, comboBox);

        comboBox.valueProperty().addListener((obs, old, neo) -> comboBox.getSelectionModel().select(neo));

        nameField.disableProperty().bind(subItemEditor.observableSubItemProperty().isNull());
        checkBox.disableProperty().bind(subItemEditor.observableSubItemProperty().isNull());
        comboBox.disableProperty().bind(subItemEditor.observableSubItemProperty().isNull());

        subItemEditor.observableSubItemProperty().addListener((obs, old, neo) -> {
            if (old != null) {
                nameField.textProperty().unbindBidirectional(old.nameProperty());
                checkBox.selectedProperty().unbindBidirectional(old.boolProperty());
                comboBox.valueProperty().unbindBidirectional(old.typeProperty());
            }
            if (neo != null) {
                nameField.textProperty().bindBidirectional(neo.nameProperty());
                checkBox.selectedProperty().bindBidirectional(neo.boolProperty());
                comboBox.valueProperty().bindBidirectional(neo.typeProperty());
            }else{
                nameField.clear();
                checkBox.setSelected(false);
                comboBox.getSelectionModel().clearSelection();
            }
        });


        this.getChildren().add(gridPane);


    }
}
