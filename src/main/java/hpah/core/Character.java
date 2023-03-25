package hpah.core;

public abstract class Character {

    private int health;
    private int power;

    public void attack(Character target){
        target.removeHealth(power);
    }

    public boolean isDead(){
        return health <= 0;
    }

    public void removeHealth(int amount){
        health -= amount;
    }

}
