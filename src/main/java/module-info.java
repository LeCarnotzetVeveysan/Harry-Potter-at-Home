module rpghp.rph_potter {
    requires javafx.controls;
    requires javafx.fxml;


    opens rpghp.rph_potter to javafx.fxml;
    exports rpghp.rph_potter;
}