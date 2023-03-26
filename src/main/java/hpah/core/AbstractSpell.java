package hpah.core;

import java.util.Random;

public abstract class AbstractSpell {

    private char spellCode;
    private String name;
    private double successChance;

    public void setStats(char inputCode, String inputName, double inputSuccess){
        spellCode = inputCode;
        name = inputName;
        successChance = inputSuccess;
    }

    public char getSpellCode() {
        return spellCode;
    }

    public boolean spellAttempt(){
        Random random = new Random();
        double attempt = random.nextDouble(1);
        if(attempt < successChance){
            System.out.println("Your attempt to cast " + name + " is successful");
            return true;
        } else {
            return false;
        }
    }

    public abstract void spellMechanic();

}
