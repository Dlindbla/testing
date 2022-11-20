module com.testing.testProj {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires ffmpeg;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;


    opens com.testing.testProj to javafx.fxml;
    exports com.testing.testProj;
    exports com.testing.testProj.items;
    opens com.testing.testProj.items to javafx.fxml;
    exports com.testing.testProj.controls;
    opens com.testing.testProj.controls to javafx.fxml;
    exports com.testing.testProj.controls.skin;
    opens com.testing.testProj.controls.skin to javafx.fxml;
}