package com.testing.testProj.controls;

import com.testing.testProj.items.ObservableItem;
import com.testing.testProj.items.ObservableSubItem;
import com.testing.testProj.items.Type;

import java.util.List;

public class Util {

    public static List<ObservableItem> getItems(){
        return List.of(
                new ObservableItem("name_1", "id_1", "information about object 1",
                        List.of(
                                new ObservableSubItem("sub11", true, Type.Good),
                                new ObservableSubItem("sub12", true, Type.Soso),
                                new ObservableSubItem("sub13", true, Type.Ok)
                        )),
                new ObservableItem("name_2", "id_2", "information about object 2",
                        List.of(new ObservableSubItem("sub21", true, Type.Good),
                                new ObservableSubItem("sub22", true, Type.Soso),
                                new ObservableSubItem("sub23", true, Type.Other))
                ),
                new ObservableItem("name_3", "id_3", "information about object 3",
                        List.of(new ObservableSubItem("sub31", true, Type.Bad),
                                new ObservableSubItem("sub32", true, Type.Other),
                                new ObservableSubItem("sub33", true, Type.Ok))
                ),
                new ObservableItem("name_4", "id_4", "information about object 4",
                        List.of(new ObservableSubItem("sub41", true, Type.Bad),
                                new ObservableSubItem("sub42", true, Type.Other),
                                new ObservableSubItem("sub43", true, Type.Ok))
                )
        );
    }

}
