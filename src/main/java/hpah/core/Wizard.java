package hpah.core;

import java.util.ArrayList;

public class Wizard extends Character {

    private String name;
    private Pet pet;
    private Wand wand;
    private House house;
    private ArrayList<Spell> knownSpells;
    private ArrayList<Potion> potions;

    public Wizard(String inputName){
        name = inputName;
        pet = null;
        wand = null;
        house = null;
        knownSpells = new ArrayList<>();
        potions = new ArrayList<>();
    }

    public void defend(){}

    public void setHouse(House inputHouse){
        house = inputHouse;
    }

    public void setWand(Wand inputWand){
        wand = inputWand;
    }

    public String getName(){
        return name;
    }

    public House getHouse(){
        return house;
    }
}
