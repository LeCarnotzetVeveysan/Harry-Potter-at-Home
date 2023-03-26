package hpah.core;

import hpah.other.OptiScanner;

public class Spell extends AbstractSpell {

    OptiScanner scanner;

    public Spell(char code, String name, double successChance){
        super.setStats(code, name, successChance);
        scanner = new OptiScanner(System.in);
    }
    @Override
    public void spellMechanic() {
        switch (super.getSpellCode()){
            case 'w' -> spellWingardium();
        }
    }

    private void spellWingardium(){
        int test = scanner.requestInt();
        System.out.println(test);
    }
}
