package hpah.core;

public class Level4 extends AbstractLevel {
    public Level4(){
        Boss voldemort = new Boss("Voldemort", 10000, 0);
        super.addEnemy(voldemort);
        Boss pettigrew = new Boss("Peter pettigrew", 10000, 10);
        super.addEnemy(pettigrew);
        Enemy portkey = new Enemy("Portkey", 1,0);
        super.addEnemy(portkey);
    }
}
