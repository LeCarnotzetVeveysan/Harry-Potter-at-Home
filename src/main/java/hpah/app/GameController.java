package hpah.app;

import hpah.core.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

import static hpah.other.GeneralFunctions.gameOver;

public class GameController {

    public Wizard wizard;
    private AbstractEnemy[] enemies;
    @FXML
    public AnchorPane root;
    @FXML
    public Label playerHP, enemy1HP, enemy2HP, enemy3HP, enemy4HP;
    @FXML
    public Label playerPotions;
    @FXML
    public ImageView swordImage;

    public void initialize(){
        wizard = GameData.getWizard();
        setEnemies();
        showStats();
    }

    private void loadUpgradesScene() throws IOException {
        Stage stage = (Stage) root.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(GUI.class.getResource("/fxmls/upgrades.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Upgrades");
        stage.setScene(scene);
        stage.show();
    }

    public void showStats(){
        playerHP.setText(wizard.getHealth() + " / " + wizard.getMaxhealth() + " HP");
        playerPotions.setText("N° of potions : " + wizard.getNumberOfPotions());
        if(enemies[0] != null) {
            enemy1HP.setText(enemies[0].getHealth() + " / " + enemies[0].getMaxhealth() + " HP");
        }
        if(enemies[1] != null) {
            enemy2HP.setText(enemies[1].getHealth() + " / " + enemies[1].getMaxhealth() + " HP");
        }
        if(enemies[2] != null) {
            enemy3HP.setText(enemies[2].getHealth() + " / " + enemies[2].getMaxhealth() + " HP");
        }
        if(enemies[3] != null) {
            enemy4HP.setText(enemies[3].getHealth() + " / " + enemies[3].getMaxhealth() + " HP");
        }
    }

    public boolean areAllEnemiesDead(){
        for (int i = 0; i <= 3; i++){
            if(enemies[i] != null){
                if(!enemies[i].isDead()){
                    return false;
                }
            }
        }
        return true;
    }

    private void resultsOrAttack() throws IOException {
        if(wizard.isDead()){
            gameOver(root);
        } else if(areAllEnemiesDead()){
            loadUpgradesScene();
        } else {
            for (AbstractEnemy e : enemies){
                if(e != null) {
                    e.attack(wizard);
                }
            }
        }
    }

    private void setEnemies() {
        enemies = new AbstractEnemy[]{null, null, null, null};
        switch (GameData.getYear()){
            case 1 -> enemies[0] = new Enemy("Troll", 50, 10);
            case 2 -> enemies[0] = new Enemy("Basilisk", 100, 10);
            case 3 -> {
                enemies[0] = new Enemy("Dementor", 1000, 5);
                enemies[1] = new Enemy("Dementor", 1000, 6);
                enemies[2] = new Enemy("Dementor", 1000, 7);
                enemies[3] = new Enemy("Dementor", 1000, 8);
            }
            case 4 -> {
                enemies[0] = new Boss("Voldemort", 1000, 0);
                enemies[1] = new Boss("Peter pettigrew", 1000, 10);
            }
            case 5 -> enemies[0] = new Boss("Dolores Ombrage", 100, 10);
            case 6 -> {
                enemies[0] = new Boss("Deatheater", 100, 10);
                enemies[1] = new Boss("Deatheater", 100, 10);
                enemies[2] = new Boss("Deatheater", 100, 10);
            }
            case 7 -> {
                enemies[0] = new Boss("Voldemort", 1000, 10);
                enemies[1] = new Boss("Bellatrix Lestrange", 1000, 10);
            }
        }
        if(enemies[1] == null){
            enemy2HP.setText("");
        }
        if(enemies[2] == null){
            enemy3HP.setText("");
        }
        if(enemies[3] == null){
            enemy4HP.setText("");
        }
    }

    public void killAllEnemies() throws IOException {
        for (int i = 0; i <= 3; i++){
            enemies[i] = null;
        }
        loadUpgradesScene();
    }

    public void clickedPotion() throws IOException {
        if(wizard.getNumberOfPotions() > 0){
            wizard.drinkPotion();
        }
        resultsOrAttack();
        showStats();
    }

    public void clickedExpecto() throws IOException {
        if(GameData.getYear() == 3){
            killAllEnemies();
        }
        resultsOrAttack();
        showStats();
    }

    public void clickedSword() throws IOException {
        if(wizard.getPickedUpSword()){
            wizard.attackWithSword(enemies[0]);
        }
        resultsOrAttack();
        showStats();
    }

    public void clickedAccio() throws IOException {
        if(GameData.getYear() == 2){
            if(wizard.getHouse() == House.GRYFFINDOR){
                if(wizard.getPickedUpSword()){
                    //Do nothing
                } else {
                    wizard.setPickedUpSword(true);
                    swordImage.setImage(null);
                }
            } else {
                //Say pulled tooth
                wizard.attack(enemies[0]);
            }
        } else if (GameData.getYear() == 4){
            Random random = new Random();
            if(random.nextInt(100) < (wizard.getHouse() == House.RAVENCLAW ? 90 : 80)){
                killAllEnemies();
            } else {
                //do nothing
                resultsOrAttack();
                showStats();
            }
        } else {
            //Tell there is no item
            resultsOrAttack();
            showStats();
        }
    }

    public void clickedWingardium() throws IOException {
        for(AbstractEnemy e : enemies){
            if(e != null){
                if(e.getName().equals("Troll") || e.getName().equals("Dolores Ombrage")){
                    wizard.attack(e);
                }
            }
        }
        resultsOrAttack();
        showStats();
    }

    public void clickedSectum() throws IOException {
        for(AbstractEnemy e : enemies){
            if(e != null){
                wizard.attack(e);
            }
        }
        resultsOrAttack();
        showStats();
    }

    public void clickedSwitch() throws IOException {
        if(GameData.getYear() == 6){
            wizard.setHasSwitchedSides(true);
            gameOver(root);
        } else {
            // Do nothing
        }
        resultsOrAttack();
        showStats();
    }
}
