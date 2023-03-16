package hpah.core;

import java.util.ArrayList;

public abstract class AbstractLevel {

    private String location;
    private ArrayList<Spell> taughtSpells = new ArrayList<>();
    private ArrayList<AbstractEnemy> enemies = new ArrayList<>();

    public void addEnemy(AbstractEnemy enemy){
        enemies.add(enemy);
    }

    public void addSpell(Spell spell){
        taughtSpells.add(spell);
    }
    public ArrayList<Spell> getTaughtSpells(){
        return taughtSpells;
    }

    public ArrayList<AbstractEnemy> getEnemies() {
        return enemies;
    }

    public boolean isLevelCleared(){
        for(AbstractEnemy e : enemies){
            if(!e.isDead()){
                return false;
            }
        }
        return true;
    }
}
