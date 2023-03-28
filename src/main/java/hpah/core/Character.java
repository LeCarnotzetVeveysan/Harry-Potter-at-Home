package hpah.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static hpah.core.House.*;

public abstract class Character {

    private String name;
    private int health;
    private int power;
    private int distance;


    public void setStats(String inputName, int inputHealth, int inputPower){
        name = inputName;
        health = inputHealth;
        power = inputPower;
        distance = 100;
    }

    public void attack(Character target){
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

    public int getPower() {
        return power;
    }

    public String getName(){
        return name;
    }

    public void addHealth(int amount){
        health += amount;
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
