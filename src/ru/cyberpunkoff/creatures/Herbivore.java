package ru.cyberpunkoff.creatures;

import ru.cyberpunkoff.creatures.Creature;

import java.awt.*;

public class Herbivore extends Creature {

    public Herbivore() {
        this.healthPoints = 10;
        this.velocity = 3;
    }

    public Herbivore(int healthPoints, int velocity) {
        this.healthPoints = healthPoints;
        this.velocity = velocity;
    }
    @Override
    public void makeMove() {
        if

    }

    @Override
    public Color getColor() {
        return Color.PINK;
    }
}
