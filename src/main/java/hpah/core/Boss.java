package hpah.core;

import java.util.ArrayList;

public class Boss extends AbstractEnemy {

    private Wand wand;

    public Boss(String inputName, int inputHealth, int inputPower){
        super.setStats(inputName, inputHealth, inputHealth, inputPower);
    }

    public void setWand(Wand inputWand){
        wand = inputWand;
    }

    public void castAvadaKedavra(Wizard target){
        if(super.getName().equals("Voldemort")) {
            Wand enemyWand = target.getWand();
            if (enemyWand.getCore() == wand.getCore()) {
                if (enemyWand.getSize() == wand.getSize()) {
                    System.exit(0);
                } else {
                    int sizeDifference = Math.abs(enemyWand.getSize() - wand.getSize());
                    if (sizeDifference >= 10) {
                        System.out.println("You managed to return the spell to it's owner. ");
                        System.out.println("Voldemort is now dead.");
                    }
                }
            } else {
                System.out.println("You weren't able to protect yourself from the forbidden spell. You died. ");
            }
        } else {
            System.out.println("You weren't able to protect yourself from the forbidden spell. You died. ");
        }
    }
}
