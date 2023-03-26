package hpah.app;

import hpah.core.*;
import hpah.other.OptiScanner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        OptiScanner scanner = new OptiScanner(System.in);
        System.out.println("What's your name ?");
        String playerName = scanner.requestString();

        Game mainGame = new Game(playerName);
        mainGame.playGame();

        System.out.println("fini");


    }
}
