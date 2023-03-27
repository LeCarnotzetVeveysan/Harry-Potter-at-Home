package hpah.core;

import static hpah.core.House.*;

public abstract class Character {

    public String name;
    private int health;
    private int power;

    public void setStats(String inputName, int inputHealth, int inputPower){
        name = inputName;
        health = inputHealth;
        power = inputPower;
    }

    public void attack(Character target){
        double mult = (target.getClass() == Wizard.class && ((Wizard) target).getHouse() == GRYFFINDOR) ? 0.85 : 1;
        int damage = (int) Math.round(power * mult);
        target.removeHealth(damage);
        System.out.println(name + " attacks and deals " + damage + " damage to you.");
        System.out.println("You now have " + target.getHealth() + " health.");
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

    public void removeHealth(int amount){
        health -= amount;
    }

    @Override
    public String toString(){
        return name + ", " + health + " HP, " + power + " power";
    }

}
