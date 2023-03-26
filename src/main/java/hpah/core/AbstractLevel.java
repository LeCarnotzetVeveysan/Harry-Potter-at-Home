package hpah.core;

import hpah.other.OptiScanner;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class AbstractLevel {

    private OptiScanner scanner = new OptiScanner(System.in);
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

    public void learnSpells(Wizard player){
        for(Spell s : taughtSpells){
            player.learnSpell(s);
            System.out.println("You learned the spell " + s.getName());
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

    public boolean playLevel(Wizard player){
        System.out.println(Arrays.toString(enemies.toArray()));
        learnSpells(player);

        while (!isLevelCleared() && !player.isDead()){

            for(int i = 0; i <= player.getKnownSpells().size() - 1; i++){
                System.out.println(i + ") " + player.getKnownSpells().get(i).getName());
            }

            System.out.println("What spell do you want to use ?");
            int choice = scanner.requestInt();
            player.getKnownSpells().get(choice).spellMechanic();
        }

        return !player.isDead();
    }

}
