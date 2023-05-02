package hpah.core;

public class SortingHat {

    public void assignHouse(Wizard player){
        String name = player.getName().toLowerCase();
        int sum = 0;
        for(char c : name.toCharArray()){
            sum += c;
        }
        switch (sum%4){
            case 0 -> player.setHouse(House.GRYFFINDOR);
            case 1 -> player.setHouse(House.SLYTHERIN);
            case 2 -> player.setHouse(House.RAVENCLAW);
            case 3 -> player.setHouse(House.HUFFLEPUFF);
        }
        System.out.println("You are in house " + player.getHouse());
    }

    public String showHouse(String inputName){
        int sum = 0;
        for(char c : inputName.toLowerCase().toCharArray()){
            sum += c;
        }
        switch (sum%4){
            case 0 -> {
                return "Gryffindor";
            }
            case 1 -> {
                return "Slytherin";
            }
            case 2 -> {
                return "Ravenclaw";
            }
            case 3 -> {
                return "Hufflepuff";
            }
        }
        return "";
    }

}
