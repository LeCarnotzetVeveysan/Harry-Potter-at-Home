package hpah.core;

public class Level3 extends AbstractLevel {
    public Level3(){
        Enemy dementor1 = new Enemy("Dementor", 1000, 1);
        Enemy dementor2 = new Enemy("Dementor", 1000, 2);
        Enemy dementor3 = new Enemy("Dementor", 1000, 3);
        super.addEnemy(dementor1);
        super.addEnemy(dementor2);
        super.addEnemy(dementor3);
    }

}
