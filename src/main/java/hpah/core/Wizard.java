package hpah.core;

import java.util.ArrayList;

import static hpah.core.House.HUFFLEPUFF;

public class Wizard extends Character {

    private Pet pet;
    private Wand wand;
    private House house;
    private ArrayList<Spell> knownSpells;
    private int numberOfPotions;
    private boolean pickedUpSword, hasSwitchedSides;

    public Wizard(String inputName){
        super.setStats(inputName, 200, 200,25);
        pet = null;
        wand = null;
        house = null;
        knownSpells = new ArrayList<>();
        numberOfPotions = 3;
        pickedUpSword = false;
        hasSwitchedSides = false;
    }

    public void defend(){}

    public void setHouse(House inputHouse){
        house = inputHouse;
    }

    public void setWand(Wand inputWand){
        wand = inputWand;
    }

    public Wand getWand(){
        return wand;
    }

    public void learnSpell(Spell inputSpell){
        knownSpells.add(inputSpell);
    }

    public House getHouse(){
        return house;
    }

    public ArrayList<Spell> getKnownSpells() {
        return knownSpells;
    }

    public boolean getPickedUpSword() {
        return pickedUpSword;
    }

    public void setPickedUpSword(boolean input){
        pickedUpSword = input;
    }

    public boolean getHasSwitchedSides() {
        return hasSwitchedSides;
    }

    public void setHasSwitchedSides(boolean input){
        hasSwitchedSides = input;
    }

    public int getNumberOfPotions(){
        return numberOfPotions;
    }

    public void drinkPotion(){
        double mult = house == HUFFLEPUFF ? 1.5 : 1;
        int amount = (int) Math.round(mult * 25);
        super.addHealth(amount);
        System.out.println("You drank a potion and gained " + amount + " health.");
        numberOfPotions--;
    }

    public void gainPotion(){
        numberOfPotions++;
    }
}
