package hpah.app;

import hpah.core.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner consoleScanner = new Scanner(System.in);
        System.out.println("Welcome to Harry Potter at Home");
        System.out.println("What's your name ? ");
        Wizard wizard = new Wizard(consoleScanner.nextLine());

        System.out.println("What core do you want your wand to be ? :");
        String coreTypes = "";
        for(int i = 0; i < Core.values().length; i++){
            coreTypes += i + ") " + Core.values()[i] + " - ";
        }
        coreTypes = coreTypes.substring(0,coreTypes.length() - 3);
        System.out.println(coreTypes);
        int chosenCoreIndex, chosenLength;
        do{
            chosenCoreIndex = consoleScanner.nextInt();
            consoleScanner.nextLine();
        } while(chosenCoreIndex < 0 || chosenCoreIndex >= Core.values().length);
        Core chosenCore = Core.values()[chosenCoreIndex];

        System.out.println("What length do you want your wand to be (cm) ? :");
        do{
            chosenLength = consoleScanner.nextInt();
            consoleScanner.nextLine();
        } while(chosenLength <= 0 || chosenLength >= 31);

        wizard.setWand(new Wand(chosenCore, chosenLength));

        SortingHat sortingHat = new SortingHat();
        sortingHat.chooseHouse(wizard);
        System.out.println("You are now in house " + wizard.getHouse());

        System.out.println("Are you ready to start your journey (Y - Yes / N - No) ?");
        String choice = consoleScanner.nextLine().toLowerCase();

        if(choice.equals("y") || choice.equals("yes")){
            System.out.println("Perfect");
        } else {
            System.out.println("Come back next year then.");
        }

    }
}
