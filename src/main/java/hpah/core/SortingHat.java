package hpah.core;

public class SortingHat {

    public void chooseHouse(Wizard wizard){

        int sum = 0;
        for(char c : wizard.getName().toCharArray()){
            sum += c;
        }
        switch (sum%4){
            case 0 -> {
                wizard.setHouse(House.GRYFFINDOR);
            }
            case 1 -> {
                wizard.setHouse(House.SLYTHERIN);
            }
            case 2 -> {
                wizard.setHouse(House.RAVENCLAW);
            }
            case 3 -> {
                wizard.setHouse(House.HUFFLEPUFF);
            }
        }
    }

}
