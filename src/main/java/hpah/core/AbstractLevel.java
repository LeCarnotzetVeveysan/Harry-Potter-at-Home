package hpah.core;

import hpah.other.OptiScanner;

import java.util.ArrayList;
import java.util.Arrays;

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
                System.out.println("Un enemi est encore vivant");
                return false;
            }
        }
        return true;
    }

    public boolean playLevel(Wizard player){
        System.out.println(Arrays.toString(enemies.toArray()));
        learnSpells(player);
        while (!isLevelCleared() && !player.isDead()){
            System.out.println("coucou");

        }

        return !player.isDead();
    }

}
