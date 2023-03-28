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
    private int turnTimer;

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

    public void removeDeadEnemies(){
        ArrayList<AbstractEnemy> newList = new ArrayList<>();
        for(AbstractEnemy e : enemies){
            if(!e.isDead()){
                newList.add(e);
            }
        }
        enemies = newList;
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
        if(getClass() == Level4.class){
            System.out.println("You need to get close enough to the Portkey and use Accio");
            System.out.println("The closer you are to it, the higher the success chance.");
        }
        if(getClass() == Level5.class){
            turnTimer = 10;
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
        if(getClass() == Level7.class){
            turnTimer = 20;
        }

        while (!isLevelCleared() && !player.isDead()){

            if(getClass() == Level6.class){
                if(turnTimer == 0) {
                    System.out.println("You didn't kill Dolores quickly enough. She managed to take out the fireworks.");
                    System.out.println("Distracted, she casts Avada Kedavra and kills you.");
                    player.removeHealth(player.getHealth());
                    return false;
                } else {
                System.out.println("You still have " + turnTimer + " turns before Dolores takes out the fireworks.");
                }
            } else if(getClass() == Level7.class) {
                if(turnTimer == 0) {
                    System.out.println("You survived long enough against Voldemort and Bellatrix !");
                    System.out.println("Tired, they decide to flee, far from Hogwarts.");
                    for(AbstractEnemy e : enemies){
                        e.removeHealth(e.getHealth());
                    }
                    return true;
                }
            }

            int num = getNumberOfLivingEnemies();
            System.out.println(num + (num > 1 ? " enemies remain." : " enemy remains."));
            int i = 0;
            for(AbstractEnemy e : enemies){
                if(!e.isDead()) {
                    System.out.println(i + ") " + e);
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
            boolean specialAction = false;
            System.out.println("What action do you want to do ?");
            String[] actions = new String[]{"Cast a spell", "Drink a potion", "Flee", "Attack with sword", "Advance"};
            for(i = 0; i <= 2; i++){
                System.out.println(i + ") " + actions[i]);
            }
            if(player.getPickedUpSword()){
                System.out.println(i + ") " + actions[3]);
                specialAction = true;
            }
            if(chosenEnemy.getName().equals("Portkey")){
                System.out.println(i + ") " + actions[4]);
                specialAction = true;
            }
            int actionIndex = scanner.requestInt("What action do you choose ?", specialAction ? 3 : 2);

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
                if(chosenEnemy.getName().equals("Portkey")){
                    if(chosenEnemy.isDead()){
                        return true;
                    }
                }
                if(chosenEnemy.getName().equals("Dolores Ombrage")){
                    if(chosenEnemy.isDead()){
                        System.out.println("Congratulations, you killed her before she could take out the fireworks !");
                        return true;
                    } else {
                        turnTimer--;
                    }
                }
            } else if (actionIndex == 1) {
                player.drinkPotion();
            } else if (actionIndex == 2) {
                player.removeHealth(player.getHealth());
                System.out.println("Hogwarts noted your desire to resign from the school.");
            } else if (actionIndex == 3) {
                if(player.getPickedUpSword()){
                    player.attackWithSword(chosenEnemy);
                    System.out.println("However the sword is stuck in his scales. You must abandon it.");
                    player.setPickedUpSword(false);
                } else if(chosenEnemy.getName().equals("Portkey")){
                    Random rand = new Random();
                    int amount = rand.nextInt(20);
                    chosenEnemy.modifyDistance(-1 * amount);
                    System.out.println("You get closer to the portkey by a distance of " + amount + ".");
                }

            }

            if(enemies.get(enemyIndex).isDead()){
                System.out.println("Enemy is dead. Congratulations");
            }

            removeDeadEnemies();

            for(AbstractEnemy e : enemies){
                if(!e.isDead() && e.getPower() >= 1) {
                    if(getClass() == Level7.class) {
                        if(e.getDistance() < 50){
                            ((Boss) e).castAvadaKedavra(player);
                        } else {
                            Random random = new Random();
                            int distanceWalked = random.nextInt(10, 30);
                            System.out.println(e.getName() + " got closer by a distance of " + distanceWalked);
                            e.modifyDistance(-1 * distanceWalked);
                        }
                    } else {
                        e.attack(player);
                    }
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
                int timeTaken = Math.round((endTime - startTime)/1000);
                if(timeTaken < 5){
                    player.learnSpell(new Spell('e', "Expecto patronum", 0.8));
                }
            } else {
                System.out.println("Sadly this isn't a magical animal.");
            }
        }
    }

}
