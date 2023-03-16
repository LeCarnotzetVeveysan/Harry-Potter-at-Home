package hpah.core;

public abstract class Character {

    private int health;
    private int power;


    public void attack(){}

    public boolean isDead(){
        return health <= 0;
    }

}
