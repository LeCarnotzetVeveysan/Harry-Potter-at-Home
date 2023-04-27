package hpah.other;

import hpah.app.GUI;
import hpah.app.GameData;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

import static java.lang.Thread.sleep;

public class GeneralFunctions {

    public static void countdown() throws InterruptedException {
        System.out.println("Get ready !");
        sleep(1000);
        System.out.print("3");
        sleep(333);
        System.out.print(".");
        sleep(333);
        System.out.print(".");
        sleep(333);
        System.out.print("2");
        sleep(333);
        System.out.print(".");
        sleep(333);
        System.out.print(".");
        sleep(333);
        System.out.print("1");
        sleep(333);
        System.out.print(".");
        sleep(333);
        System.out.println(".");
    }

    public static void newCombatScene(AnchorPane root, String title) throws IOException {
        Stage stage = (Stage) root.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(GUI.class.getResource("/fxmls/level" + GameData.getYear() + ".fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

    public static void gameOver(AnchorPane root) throws IOException {
        Stage stage = (Stage) root.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(GUI.class.getResource("/fxmls/game-over.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Game Over");
        stage.setScene(scene);
        stage.show();
    }
}
