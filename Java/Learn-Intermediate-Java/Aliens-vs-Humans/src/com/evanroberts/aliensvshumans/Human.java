package com.evanroberts.aliensvshumans;

public class Human implements Entity{
    private int health;
    private String name;
    private int armor;

    public Human(String name) {
        this.name = name;
        this.health = 100;
        this.armor = 0;
    }

    private void activateArmorAbility() {
        armor += 10;
    }

    private void eatFood() {
        health += 30;
    }

    @Override
    public void takeDamage(int damage) {
        int actualDamage = damage - armor;
        if (actualDamage > 0) {
            health -= actualDamage;
        }
    }

    @Override
    public void activateAbility() {
        if (armor > 0) {
            activateArmorAbility();
        } else {
            activateOffensiveAbility(null);
        }
    }
    private void activateOffensiveAbility(Entity target){
        int additionalDamage = 15;

        if (target instanceof Alien) {
            Alien alienTarget = (Alien) target;
            alienTarget.takeDamage(additionalDamage);
        }

    }
    @Override
    public void useItem(String item) {
        if(item.equals("Food")) {
            eatFood();
        }
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public String getName() {
        return name;
    }

}
