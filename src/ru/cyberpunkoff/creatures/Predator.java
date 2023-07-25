package ru.cyberpunkoff.creatures;

import ru.cyberpunkoff.creatures.Creature;

import java.awt.*;

public class Predator extends Creature {
    int damage;

    public Predator() {
        this.healthPoints = 15;
        this.velocity = 2;
        this.damage = 4;
    }

    public Predator(int healthPoints, int velocity, int damage) {
        this.healthPoints = healthPoints;
        this.velocity = velocity;
        this.damage = damage;
    }

    @Override
    public void makeMove() {

    }

    @Override
    public Color getColor() {
        return Color.RED;
    }
}
