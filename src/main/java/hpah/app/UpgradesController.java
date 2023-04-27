package hpah.app;

import hpah.core.Wizard;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

import static hpah.other.GeneralFunctions.newCombatScene;

public class UpgradesController {

    private Wizard player;
    @FXML
    private Label victoryLabel;
    @FXML
    private AnchorPane root;

    public void initialize(){
        victoryLabel.setText("Congratulations ! You passed year " + GameData.getYear() + " ! ");
        GameData.increaseYear();
        player = GameData.getWizard();
        player.gainPotions();
    }

    public void clickedHealthButton(MouseEvent mouseEvent) throws IOException {
        player.increaseHealth();
        GameData.setWizard(player);
        newCombatScene(root, "Fight scene");
    }

    public void clickedPowerButton(MouseEvent mouseEvent) throws IOException {
        player.increasePower();
        GameData.setWizard(player);
        newCombatScene(root, "Fight scene");
    }
}
