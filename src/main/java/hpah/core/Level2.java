package hpah.core;

public class Level2 extends AbstractLevel {

    public Level2(){
        Enemy basilisk = new Enemy("Basilisk", 100, 10);
        super.addEnemy(basilisk);
        Spell accio = new Spell('a',"Accio", 0.75);
        super.addSpell(accio);
    }
}
