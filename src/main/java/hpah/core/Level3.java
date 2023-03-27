package hpah.core;

public class Level3 extends AbstractLevel {
    public Level3(){
        Enemy dementor1 = new Enemy("Dementor", 300, 10);
        Enemy dementor2 = new Enemy("Dementor", 300, 10);
        Enemy dementor3 = new Enemy("Dementor", 300, 10);
        super.addEnemy(dementor1);
        super.addEnemy(dementor2);
        super.addEnemy(dementor3);
        Spell expecto = new Spell('e',"Expecto patronum", 0.75);
        super.addSpell(expecto);
    }

}
