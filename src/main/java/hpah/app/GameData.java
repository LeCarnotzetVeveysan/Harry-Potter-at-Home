package hpah.app;

import hpah.core.Wizard;

public class GameData {

    private static Wizard wizard;
    public static int year = 1;

    public static void setWizard(Wizard toSet) {
        wizard = toSet;
    }

    public static Wizard getWizard() {
        return wizard;
    }

    public static int getYear() {
        return year;
    }

    public static void increaseYear(){
        year += 1;
    }
}
