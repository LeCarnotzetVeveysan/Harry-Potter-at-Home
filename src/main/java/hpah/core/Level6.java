package hpah.core;

public class Level6 extends AbstractLevel {
    public Level6(){
        Boss deatheater1 = new Boss("D1", 1000, 10);
        super.addEnemy(deatheater1);
        Boss deatheater2 = new Boss("D1", 1000, 10);
        super.addEnemy(deatheater2);
        Boss deatheater3 = new Boss("D1", 1000, 10);
        super.addEnemy(deatheater3);
    }
}
