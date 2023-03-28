package hpah.core;

import java.util.Random;

public class Level7 extends AbstractLevel {
    public Level7(){
        Random random = new Random();
        Boss voldemort = new Boss("Voldemort", 1000, 10);
        Wand wandVolt = new Wand(Core.values()[random.nextInt(Core.values().length - 1)], random.nextInt(30));
        voldemort.setWand(wandVolt);
        super.addEnemy(voldemort);
        Boss bellatrix = new Boss("Bellatrix Lestrange", 100, 10);
        super.addEnemy(bellatrix);
        Spell expell = new Spell('x', "Expelliarmus", 0.75);
        super.addSpell(expell);
    }
}
