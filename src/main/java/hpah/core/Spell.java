package hpah.core;

import hpah.other.OptiScanner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import static java.lang.Thread.sleep;

public class Spell extends AbstractSpell {

    OptiScanner scanner;

    public Spell(char code, String name, double successChance){
        super.setStats(code, name, successChance);
        scanner = new OptiScanner(System.in);
    }
    @Override
    public void spellMechanic(Wizard player, AbstractEnemy enemy) throws InterruptedException {
        switch (super.getSpellCode()){
            case 'w' -> spellWingardium(player, enemy);
        }
    }

    private void countdown() throws InterruptedException {
        System.out.println("Get ready !");
        sleep(1000);
        System.out.print("3");
        sleep(333);
        System.out.print(".");
        sleep(333);
        System.out.print(".");
        sleep(333);
        System.out.print("2");
        sleep(333);
        System.out.print(".");
        sleep(333);
        System.out.print(".");
        sleep(333);
        System.out.print("1");
        sleep(333);
        System.out.print(".");
        sleep(333);
        System.out.println(".");
    }

    private void spellWingardium(Wizard player, AbstractEnemy enemy) throws InterruptedException {

        System.out.println("To beat the troll, you need  to lift up anobject in the room and drop it on it's head. \n" +
                "You will be given some letters and you must find and object name with some or all of htem \n." +
                "The quicker you find it, the more damage will be inflicted.");
        System.out.println("Are you ready ?");

        System.out.println("Are you ready to start the fight (Y - Yes / N - No) ?");
        String choice = scanner.requestString().toLowerCase();

        if (choice.equals("y") || choice.equals("yes")) {
            System.out.println("Perfect !");
            String[] objects = new String[]{"tp", "perfume", "manhole"};
            Random random = new Random();
            while(!enemy.isDead() && !player.isDead()){
                String chosenObject = objects[random.nextInt(3)];
                String[] tempLetters = chosenObject.split("");
                ArrayList<String> letters = new ArrayList<>();
                for(String s : tempLetters){
                    letters.add(s);
                }
                for(int i = 0; i < random.nextInt(2); i++){
                    letters.add(String.valueOf((char) random.nextInt(97,122)));
                }
                Collections.shuffle(letters);
                countdown();
                System.out.println("Letters are " + Arrays.toString(letters.toArray()));
                long startTime = System.currentTimeMillis();
                System.out.println("What is the hidden object ?");
                String answer = scanner.requestString();
                if(answer.toLowerCase().equals(chosenObject)){
                    long endTime = System.currentTimeMillis();
                    int timeTaken = Math.round((endTime - startTime)/1000);
                    System.out.println("You took " + timeTaken + " seconds to find the object");
                    int damageDealt = 20 - timeTaken;
                    System.out.println("You deal " + damageDealt + " to the troll.");
                    enemy.removeHealth(damageDealt);
                    System.out.println("He now has " + (Math.max(enemy.getHealth(), 0)) + " health.");
                } else {
                    System.out.println("Sadly this isn't an object");
                }
                if(enemy.isDead()){
                    System.out.println("Enemy is dead. Congratulations");
                } else {

                    enemy.attack(player);
                    System.out.println("You now have " + player.getHealth() + " health.");

                }
            }
        }
    }
}
