package hpah.core;

public class Test {

    public static void main(String[] args) {
        Wizard wizard = new Wizard("micheline");
        SortingHat sortingHat = new SortingHat();
        sortingHat.chooseHouse(wizard);
    }
}
