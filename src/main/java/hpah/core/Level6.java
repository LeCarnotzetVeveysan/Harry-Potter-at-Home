package hpah.core;

public class Level6 extends AbstractLevel {
    public Level6(){
        Boss deatheater1 = new Boss("Deatheater1", 100, 10);
        super.addEnemy(deatheater1);
        Boss deatheater2 = new Boss("Deatheater2", 100, 20);
        super.addEnemy(deatheater2);
        Boss deatheater3 = new Boss("Deatheater3", 100, 30);
        super.addEnemy(deatheater3);
        Spell sectum = new Spell('s', "Sectumsempra", 0.5);
        super.addSpell(sectum);
    }
}
