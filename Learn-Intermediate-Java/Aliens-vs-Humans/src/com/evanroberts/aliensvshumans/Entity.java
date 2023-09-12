package com.evanroberts.aliensvshumans;

public interface Entity {
    void takeDamage(int damage);
    void activateAbility();
    void useItem(String item);
    int getHealth();
    String getName();
}
