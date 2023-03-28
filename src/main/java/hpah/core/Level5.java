package hpah.core;

public class Level5 extends AbstractLevel {
    public Level5(){
        Boss dolores = new Boss("Dolores Ombrage", 100, 10);
        super.addEnemy(dolores);
    }
}
