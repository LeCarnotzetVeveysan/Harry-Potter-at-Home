package hpah.core;

public class Enemy extends AbstractEnemy {


    public Enemy(String inputName, int inputHealth, int inputPower){
        super.setStats(inputName, inputHealth, inputHealth, inputPower);
    }


}
