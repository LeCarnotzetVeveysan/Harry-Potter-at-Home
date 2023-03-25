package hpah.core;

import java.util.ArrayList;

public abstract class AbstractLevel {

    private ArrayList<Spell> taughtSpells = new ArrayList<>();
    private ArrayList<AbstractEnemy> enemies = new ArrayList<>();

    public abstract void initializeLevel();

    public void addEnemy(AbstractEnemy enemy){
        enemies.add(enemy);
    }

    public void addSpell(Spell spell){
        taughtSpells.add(spell);
    }
    public ArrayList<Spell> getTaughtSpells(){
        return taughtSpells;
    }

    public void learnSpells(Wizard player){
        for(Spell s : taughtSpells){
            player.learnSpell(s);
            System.out.println(s);
        }
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

    public boolean isHeroAlive(Wizard player){
        return !player.isDead();
    }

    public boolean playLevel(Wizard player){
        initializeLevel();
        learnSpells(player);
        while (!isLevelCleared() && isHeroAlive(player)){
            System.out.println("coucou");

        }

        return isHeroAlive(player);
    }

}
