package hpah.core;

public class Level4 extends AbstractLevel {
    public Level4(){
        Boss voldemort = new Boss("Voldemort", 1000, 10);
        super.addEnemy(voldemort);
        Boss pettigrew = new Boss("Peter pettigrew", 100, 10);
        super.addEnemy(pettigrew);
    }
}
