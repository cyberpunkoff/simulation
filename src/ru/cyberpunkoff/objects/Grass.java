package ru.cyberpunkoff.objects;

import ru.cyberpunkoff.Entity;

import java.awt.*;

public class Grass extends Entity {
    @Override
    public Color getColor() {
        return new Color(0, 100, 0); // TODO: find better way to do it
    }
}
