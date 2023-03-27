package hpah.other;

import javafx.event.ActionEvent;

import java.io.IOException;
import java.security.Key;
import java.util.Scanner;
import java.io.InputStream;

import static javafx.scene.input.KeyCode.SPACE;

public class OptiScanner {
    private Scanner sc;
    public OptiScanner(InputStream inputStream){
        sc = new Scanner(inputStream);
    }

    public int requestInt(){
        int input = sc.nextInt();
        sc.nextLine();
        return input;
    }

    public String requestString(){
        return sc.nextLine();
    }

    public void pressSpace() {
        //Catch key pressed

    }

}

