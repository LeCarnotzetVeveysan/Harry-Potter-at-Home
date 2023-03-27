package hpah.core;

import hpah.other.OptiScanner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import static hpah.core.House.SLYTHERIN;
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
            case 'a' -> spellAccio(player, enemy);
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

        if (!enemy.getName().equals("Troll")) {
            System.out.println("However, this spell is useless here");
        } else {

            System.out.println("""
                    To beat the troll, you need  to lift up an object in the room and drop it on it's head.\s
                    You will be given some letters and you must find and object name with some or all of item.\s
                    The quicker you find it, the more damage will be inflicted. \s
                    Watching the scene from the movie might help you with this spell.""");
            System.out.println("Are you ready ?");

            System.out.println("Are you ready to start the fight (Y - Yes / N - No) ?");
            String choice = scanner.requestString().toLowerCase();

            if (choice.equals("y") || choice.equals("yes")) {
                System.out.println("Perfect !");
                String[] objects = new String[]{"gg", "gg", "gg"};
                //String[] objects = new String[]{"tp", "perfume", "manhole"};
                Random random = new Random();
                String chosenObject = objects[random.nextInt(3)];
                String[] tempLetters = chosenObject.split("");
                ArrayList<String> letters = new ArrayList<>();
                for (String s : tempLetters) {
                    letters.add(s);
                }
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
                    int timeTaken = Math.round((endTime - startTime) / 1000);
                    System.out.println("You took " + timeTaken + " seconds to find the object");
                    int damageDealt = 20 - timeTaken;
                    damageDealt = player.getHouse() == SLYTHERIN ? (int) Math.round(damageDealt * 1.2) : damageDealt;
                    System.out.println("You deal " + damageDealt + " to the troll.");
                    enemy.removeHealth(damageDealt);
                    System.out.println("He now has " + (Math.max(enemy.getHealth(), 0)) + " health.");
                } else {
                    System.out.println("Sadly this isn't an object");
                }
            }
        }
    }

    private void spellAccio(Wizard player, AbstractEnemy enemy) {
        if (player.getPickedUpSword()) {
            System.out.println("The sword you have at your side absorbed all the spell energy. A shame.");
        } else if(enemy.getName().equals("Basilisk")){
            System.out.println("Do you pull out a canine or a molar ?");
            int chosenToothIndex = scanner.requestInt("0) A canine \n1) A molar", 1);
            if(chosenToothIndex == 0){
                System.out.println("A canine is successfully ripped out. You then repel it right to his head.");
                System.out.println("The canine hit him right between the eyes. It pierces the scales and kills him.");
                enemy.removeHealth(enemy.getHealth());
            } else {
                System.out.println("You manage to pull out a molar. However, you get knocked out when it hits you.");
            }
        }
    }
}
