package hpah.core;

public class Level1 extends AbstractLevel {

    public Level1(){
        Enemy troll = new Enemy("Troll", 50, 10);
        super.addEnemy(troll);
        Spell wingardium = new Spell('w',"Wingardium leviosa", 0.75);
        super.addSpell(wingardium);
    }


}
