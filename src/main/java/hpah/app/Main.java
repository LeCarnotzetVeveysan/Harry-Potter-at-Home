package hpah.app;

import hpah.core.House;
import hpah.core.SortingHat;
import hpah.core.Wizard;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to Harry Potter at Home");
        Wizard wizard = new Wizard("Arthur");
        SortingHat hat = new SortingHat();
        House chosen = hat.chooseHouse(wizard);
        System.out.println(chosen);
    }
}
