package ru.cyberpunkoff.creatures;

import ru.cyberpunkoff.creatures.Creature;

import java.awt.*;

public class Predator extends Creature {
    int damage;

    @Override
    public void makeMove() {

    }

    @Override
    public Color getColor() {
        return Color.RED;
    }
}
