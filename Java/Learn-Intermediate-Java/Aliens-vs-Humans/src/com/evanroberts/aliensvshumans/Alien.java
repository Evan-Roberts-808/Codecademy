package com.evanroberts.aliensvshumans;

public class Alien implements Entity {
    private int health;
    private String name;
    private String alienRace;
    private boolean isMutated;

    public Alien(String name, String alienRace) {
        this.name = name;
        this.alienRace = alienRace;
        this.health = 100;
        this.isMutated = false;
    }

    private void mutate() {
        isMutated = true;
    }

    private void transform() {
        if (!isMutated) {
            isMutated = true;

            name = "Shapeshifted " + name;
            health += 20;
            alienRace = "Morphed " + alienRace;

        } else {
            isMutated = false;

            name = name.replace("Shapeshifted ", "");
            health -= 20;
            alienRace = alienRace.replace("Morphed ", "");

        }
    }

    private void healSelf() {
        health += 20;
    }

    @Override
    public void takeDamage(int damage) {
        health -= damage;
    }

    @Override
    public void activateAbility(){
        if (alienRace.equals("Healer")) {
            healSelf();
        } else if (alienRace.equals("Shapeshifter")) {
            transform();
        }
    }
    @Override
    public void useItem(String item) {
        if (item.equals("Mutagen")) {
            mutate();
        }
    }

    @Override
    public int getHealth(){
        return health;
    }

    @Override
    public String getName() {
        return name;
    }

}
