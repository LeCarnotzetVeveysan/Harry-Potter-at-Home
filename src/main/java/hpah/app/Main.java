package hpah.app;

import hpah.core.House;
import hpah.core.SortingHat;
import hpah.core.Wizard;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner consoleScanner = new Scanner(System.in);
        System.out.println("Welcome to Harry Potter at Home");
        System.out.println("What's your name ? ");
        Wizard wizard = new Wizard(consoleScanner.nextLine());
        SortingHat sortingHat = new SortingHat();
        sortingHat.chooseHouse(wizard);
        System.out.println("You are now in house " + wizard.getHouse());


    }
}
