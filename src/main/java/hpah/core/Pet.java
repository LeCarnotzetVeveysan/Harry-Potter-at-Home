package hpah.core;

public enum Pet {

    OWL("Micheline", 1),
    RAT("Pierre", 1),
    TOAD("Jean-Marc",1),
    CAT("Minouche",1),
    RABBIT("Serge",1);

    private String name;
    private int power;

    Pet(String name, int power){}

    public void attack(AbstractEnemy enemy){

    }

    public String getName(){
        return name;
    }

    public int getPower(){
        return power;
    }
}
