package hpah.app;

import hpah.other.OptiScanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        OptiScanner scanner = new OptiScanner(System.in);
        System.out.println("What's your name ?");
        String playerName = scanner.requestString();

        Game mainGame = new Game(playerName);
        mainGame.playGame();

    }
}
