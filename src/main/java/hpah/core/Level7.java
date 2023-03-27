package hpah.core;

public class Level7 extends AbstractLevel {
    public Level7(){
        Boss voldemort = new Boss("Voldemort", 1000, 10);
        super.addEnemy(voldemort);
        Boss bellatrix = new Boss("Bellatrix Lestrange", 100, 10);
        super.addEnemy(bellatrix);
    }
}
