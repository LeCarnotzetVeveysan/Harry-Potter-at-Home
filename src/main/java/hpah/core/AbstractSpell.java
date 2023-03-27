package hpah.core;

import java.util.Random;

import static hpah.core.House.RAVENCLAW;

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

    public String getName() {
        return name;
    }

    public boolean spellAttempt(Wizard player){
        Random random = new Random();
        double attempt = random.nextDouble(1);
        double bonus = player.getHouse() == RAVENCLAW ? 0.1 : 0;
        if(attempt < successChance + bonus){
            System.out.println("Your attempt to cast " + name + " is successful.");
            return true;
        } else {
            System.out.println("Sadly, you were not precise enough while casting your spell.");
            return false;
        }
    }

    public abstract void spellMechanic(Wizard player, AbstractEnemy enemy) throws InterruptedException;
}
