module rpghp.rph_potter {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens hpah.core to javafx.fxml;
    exports hpah.core;
    exports hpah.app;
    opens hpah.app to javafx.fxml;
}