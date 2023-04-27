package hpah.app;

import hpah.core.Wizard;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Stack;

import static hpah.other.GeneralFunctions.newCombatScene;

public class MenuController {

    public AnchorPane root;
    @FXML
    public TextField nameInput;

    public void clickedStartButton(MouseEvent mouseEvent) throws IOException {
        String name = nameInput.getText();
        if(!name.equals("")){
            Wizard wizard = new Wizard(name);
            GameData.setWizard(wizard);
            newCombatScene(root, "Combat scene");
        }
    }
}
