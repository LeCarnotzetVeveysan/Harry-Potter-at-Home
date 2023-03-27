package hpah.app;

import hpah.core.*;
import hpah.other.OptiScanner;

import java.util.ArrayList;
import java.util.Arrays;

public class Game {

    private OptiScanner scanner;
    private String playerName;
    public Game(String inputPlayerName){
        playerName = inputPlayerName;
        scanner = new OptiScanner(System.in);
    }

    public void playGame() throws InterruptedException {
        System.out.println("Welcome to Harry Potter at Home " +  playerName);

        Wizard wizard = new Wizard(playerName);

        System.out.println("A wizard needs a wand to fight.");
        System.out.println("What core do you want your wand to be ? :");
        String coreTypes = "";
        for(int i = 0; i < Core.values().length; i++){
            coreTypes += i + ") " + Core.values()[i] + " - ";
        }
        coreTypes = coreTypes.substring(0,coreTypes.length() - 3);

        System.out.println(coreTypes);
        int chosenCoreIndex = scanner.requestInt("", Core.values().length - 1);
        Core chosenCore = Core.values()[chosenCoreIndex];
        int chosenLength = scanner.requestInt("What length do you want your wand to be (cm) ? ", 30);

        wizard.setWand(new Wand(chosenCore, chosenLength));

        SortingHat sortingHat = new SortingHat();
        sortingHat.chooseHouse(wizard);
        System.out.println(playerName + ", you are now in house " + wizard.getHouse());

        System.out.println("Are you ready to start your journey (Y - Yes / N - No) ?");
        String choice = scanner.requestString().toLowerCase();

        if(choice.equals("y") || choice.equals("yes")){
            System.out.println("Perfect");

            Level1 year1 = new Level1();
            Level2 year2 = new Level2();
            Level3 year3 = new Level3();
            Level3 year4 = new Level3();
            Level3 year5 = new Level3();
            Level3 year6 = new Level3();
            Level3 year7 = new Level3();
            ArrayList<AbstractLevel> years = new ArrayList<>(Arrays.asList(
                    year1, year2, year3, year4, year5, year6, year7 ));

            for (int i = 0; i <= 6; i++){
                boolean succeeded = years.get(i).playLevel(wizard);
                if(!succeeded){
                    break;
                } else {
                    System.out.println("Congratulations ! You passed year " + (i + 1) + ". " + (6-i) + " years to go.");
                }
            }

            if(wizard.isDead()){
                System.out.println("Sadly, you are dead, therefore you can't get your wizards diploma.");
            } else {
                System.out.println("You successfully passed all your years at Hogwarts. Here is your diploma");
                System.out.println("You are now a wizard harry !");
            }

        } else {
            System.out.println("Come back next year then.");
        }
    }
}
