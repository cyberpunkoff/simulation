package ru.cyberpunkoff.creatures;

import ru.cyberpunkoff.Entity;

public abstract class Creature extends Entity {
    int velocity;
    int healthPoints;

    public abstract void makeMove();
}
