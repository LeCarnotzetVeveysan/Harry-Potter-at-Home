package hpah.app;

import hpah.core.Wizard;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GameOverController {

    @FXML
    private ImageView image;
    @FXML
    private AnchorPane root;

    public void initialize() throws FileNotFoundException {
        Wizard wizard = GameData.getWizard();

        if(wizard.getHasSwitchedSides()){
            image.setImage(new Image(new FileInputStream("/src/main/resources/pictures/deatheater-mark.jpg")));
        } else if(wizard.isDead()) {
            image.setImage(new Image(new FileInputStream("/src/main/resources/pictures/skull.jpg")));
        } else {
            image.setImage(new Image(new FileInputStream("/src/main/resources/pictures/hogwarts-logo.png")));
        }
    }

    public void clickedNewGame() throws IOException {
        Stage stage = (Stage) root.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(GUI.class.getResource("/fxmls/menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Menu");
        stage.setScene(scene);
        stage.show();
    }
}
