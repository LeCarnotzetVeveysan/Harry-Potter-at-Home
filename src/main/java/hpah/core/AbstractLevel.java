package hpah.core;

import hpah.other.OptiScanner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import static hpah.core.House.GRYFFINDOR;
import static hpah.core.House.SLYTHERIN;
import static hpah.other.GeneralFunctions.countdown;

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

    public int getNumberOfLivingEnemies(){
        int count = 0;
        for(AbstractEnemy e : enemies){
            if(!e.isDead()){
                count++;
            }
        }
        return count;
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

        learnSpells(player);
        ArrayList<Spell> spells = player.getKnownSpells();
        if(getClass() == Level2.class){
            if(player.getHouse() == GRYFFINDOR && !player.getPickedUpSword()){
                System.out.println("You see a SortingHat by the wall and a shiny object coming out of it.");
                System.out.println("You walk up to it and pick up Godric Gryffindor's sword.");
                player.setPickedUpSword(true);
            }
        }
        if(getClass() == Level3.class){
            learnPatronum(player);
        }
        if(getClass() == Level6.class){
            if(player.getHouse() == SLYTHERIN){
                System.out.println("You may change sides and join the Deatheaters. ");
                System.out.println("Do you choose to do it ? This means resigning from your Hogwarts diploma.");
                String choice = scanner.requestString().toLowerCase();

                if (choice.equals("y") || choice.equals("yes")) {
                    player.setHasSwitchedSides(true);
                    return false;
                } else {
                    System.out.println("Then prepare for a fight !");
                }
            }
        }


        while (!isLevelCleared() && !player.isDead()){

            int num = getNumberOfLivingEnemies();
            System.out.println(num + (num > 1 ? " enemies remain." : " enemy remains."));
            int i = 0;
            for(AbstractEnemy e : enemies){
                if(!e.isDead()) {
                    System.out.println(i + ")" + e);
                    i++;
                }
            }

            int enemyIndex;
            if(enemies.size() > 1){
                enemyIndex = scanner.requestInt("Which enemy do you want to attack ?", enemies.size() - 1);
            } else {
                enemyIndex = 0;
            }
            AbstractEnemy chosenEnemy = enemies.get(enemyIndex);

            //Choose action
            System.out.println("What action do you want to do ?");
            String[] actions = new String[]{"Cast a spell", "Drink a potion", "Flee", "Attack with sword"};
            for(i = 0; i <= 2; i++){
                System.out.println(i + ") " + actions[i]);
            }
            if(player.getPickedUpSword()){
                System.out.println(i + ") " + actions[3]);
            }
            int actionIndex = scanner.requestInt("What action do you choose ?", player.getPickedUpSword() ? 3 : 2);

            if(actionIndex == 0) {

                String quest = "What spell do you want to use  against " + chosenEnemy.getName() + " ?";

                for (i = 0; i <= spells.size() - 1; i++) {
                    System.out.println(i + ") " + spells.get(i).getName());
                }

                int choice = scanner.requestInt(quest, spells.size() - 1);
                Spell chosenSpell = spells.get(choice);
                if (chosenSpell.spellAttempt(player)) {
                    chosenSpell.spellMechanic(player, chosenEnemy);
                }
            } else if (actionIndex == 1) {
                player.drinkPotion();
            } else if (actionIndex == 2) {
                player.removeHealth(player.getHealth());
                System.out.println("Hogwarts noted your desire to resign from the school.");
            } else if (actionIndex == 3) {
                player.attackWithSword(chosenEnemy);
            }

            if(enemies.get(enemyIndex).isDead()){
                System.out.println("Enemy is dead. Congratulations");
            }

            for(AbstractEnemy e : enemies){
                if(!e.isDead()) {
                    e.attack(player);
                }
            }

        }

        return !player.isDead();
    }

    private void learnPatronum(Wizard player) throws InterruptedException {
        System.out.println("To learn Expecto Patronum, you will need to know the magical animals of the world.");
        System.out.println("I will give you letters, and you must find an animal with part or all of them.");
        System.out.println("Are you ready ?");
        String choice = scanner.requestString().toLowerCase();

        if (choice.equals("y") || choice.equals("yes")) {
            String[] objects = new String[]{"griffin", "basilisk", "centaur", "chimera", "elf"};
            Random random = new Random();
            String chosenObject = objects[random.nextInt(5)];
            String[] tempLetters = chosenObject.split("");
            ArrayList<String> letters = new ArrayList<>();
            letters.addAll(Arrays.asList(tempLetters));
            for (int i = 0; i < random.nextInt(2); i++) {
                letters.add(String.valueOf((char) random.nextInt(97, 122)));
            }
            Collections.shuffle(letters);
            countdown();
            System.out.println("Letters are " + Arrays.toString(letters.toArray()));
            long startTime = System.currentTimeMillis();
            System.out.println("What is the hidden object ?");
            String answer = scanner.requestString();
            if (answer.toLowerCase().equals(chosenObject)) {
                long endTime = System.currentTimeMillis();
                int timeTaken = (int) Math.round((endTime - startTime)/1000);
                if(timeTaken < 5){
                    player.learnSpell(new Spell('e', "Expecto patronum", 0.8));
                }
            } else {
                System.out.println("Sadly this isn't a magical animal.");
            }
        }
    }

}
