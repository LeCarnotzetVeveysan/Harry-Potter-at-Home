package hpah.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static hpah.core.House.*;

public abstract class Character {

    private String name;
    private int health;
    private int maximumHealth;
    private int power;
    private int distance;


    public void setStats(String inputName, int inputHealth, int inputMax, int inputPower){
        name = inputName;
        health = inputHealth;
        maximumHealth = inputMax;
        power = inputPower;
        distance = 100;
    }

    public void increaseHealth(){
        maximumHealth += 25;
        health += 25;
    }

    public void increasePower(){
        power += 10;
    }

    public void enemyAttack(Character target){
        double mult = (target.getClass() == Wizard.class && ((Wizard) target).getHouse() == GRYFFINDOR) ? 0.85 : 1;
        int damage = (int) Math.round(power * mult);
        target.removeHealth(damage);
        System.out.println(name + " attacks and deals " + damage + " damage to you.");
        if(target.isDead()){
            System.out.println("Sadly, you died.");
        } else {
            System.out.println("You now have " + target.getHealth() + " health.");
        }
    }

    public void attackEnemy(AbstractEnemy target){
        int damage = power;
        target.removeHealth(damage);
        System.out.println("You attack " + target.getName() + " and deal " + damage + " damage.");
        if(target.isDead()){
            System.out.println("Enemy is dead.");
        }
    }

    public void attackWithSword(Character target){
        target.removeHealth(target.getHealth());
        System.out.println("Your attack insta-killed the Basilisk.");
    }

    public boolean isDead(){
        return health <= 0;
    }

    public int getHealth(){
        return health;
    }

    public int getMaxhealth(){return maximumHealth; }

    public int getPower() {
        return power;
    }

    public void addPower(int amount){
        power += amount;
    }

    public String getName(){
        return name;
    }

    public void addHealth(int amount){
        health += amount;
        if(health > maximumHealth){
            health = maximumHealth;
        }
    }

    public void removeHealth(int amount){
        health -= amount;
    }

    public int getDistance() {
        return distance;
    }

    public void modifyDistance(int amount){
        distance += amount;
    }

    @Override
    public String toString(){
        List<String> reqDistance = new ArrayList<>(Arrays.asList("Portkey", "Voldemort", "Bellatrix Lestrange"));
        return name + ", " + health + " HP " + (reqDistance.contains(name) ? (", Distance : " + getDistance()) : "");
    }

}
