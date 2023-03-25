package hpah.core;

public class Level1 extends AbstractLevel {

    public Level1(){
        Enemy enemy1 = new Enemy();
        super.addEnemy(enemy1);
    }

    @Override
    public void initializeLevel() {

    }
}
