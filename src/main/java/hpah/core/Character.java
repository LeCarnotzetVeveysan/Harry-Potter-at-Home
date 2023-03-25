package hpah.core;

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
        target.removeHealth(power);
    }

    public boolean isDead(){
        return health <= 0;
    }

    public void removeHealth(int amount){
        health -= amount;
    }

}
