package hpah.core;

public class SortingHat {

    public void assignHouse(Wizard player){

        int sum = 0;
        for(char c : player.getName().toCharArray()){
            sum += c;
        }
        switch (sum%4){
            case 0 -> player.setHouse(House.GRYFFINDOR);
            case 1 -> player.setHouse(House.SLYTHERIN);
            case 2 -> player.setHouse(House.RAVENCLAW);
            case 3 -> player.setHouse(House.HUFFLEPUFF);
        }
    }

}
