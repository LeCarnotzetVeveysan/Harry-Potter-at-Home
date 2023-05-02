package hpah.app;

import hpah.core.SortingHat;
import hpah.core.Wizard;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Stack;

import static hpah.other.GeneralFunctions.newCombatScene;

public class MenuController {

    public AnchorPane root;
    public SortingHat hat;
    @FXML
    public TextField nameInput;
    @FXML
    public Label houseLabel;

    public void initialize(){
        nameInput.textProperty().addListener((observable, oldValue, newValue) -> {
            // call your method here
            showFutureHouse(newValue);
        });
        hat = new SortingHat();
    }

    private void showFutureHouse(String value) {
        houseLabel.setText(value + ", you will be in House " + hat.showHouse(value));
    }

    public void clickedStartButton(MouseEvent mouseEvent) throws IOException {
        String name = nameInput.getText();
        if(!name.equals("")){
            Wizard wizard = new Wizard(name);
            SortingHat hat = new SortingHat();
            hat.assignHouse(wizard);
            GameData.setWizard(wizard);
            newCombatScene(root, "Combat scene");
        }
    }


}
