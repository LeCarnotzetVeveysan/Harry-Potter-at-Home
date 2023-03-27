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

    public boolean playLevel(Wizard player) throws InterruptedException {
        //Print level desc

        //Print enemies
        System.out.println(Arrays.toString(enemies.toArray()));
        learnSpells(player);
        ArrayList<Spell> spells = player.getKnownSpells();

        while (!isLevelCleared() && !player.isDead()){

            for(int i = 0; i <= spells.size() - 1; i++){
                System.out.println(i + ") " + spells.get(i).getName());
            }

            //Choose enemy iff more than 1
            int enemyIndex;
            if(enemies.size() > 1){
                enemyIndex = scanner.requestInt("Which enemy do you want to attack ?", enemies.size() - 1);
            } else {
                enemyIndex = 0;
            }

            AbstractEnemy chosenEnemy = enemies.get(enemyIndex);
            String quest = "What spell do you want to use  against " + chosenEnemy.getName() + " ?";

            int choice = scanner.requestInt(quest, spells.size() - 1);
            Spell chosenSpell = spells.get(choice);
            if(chosenSpell.spellAttempt()){
                chosenSpell.spellMechanic(player, chosenEnemy );
            }
            if(enemies.get(enemyIndex).isDead()){
                System.out.println("Enemy is dead. Congratulations");
            } else {
                enemies.get(enemyIndex).attack(player);
            }

        }

        return !player.isDead();
    }

}
