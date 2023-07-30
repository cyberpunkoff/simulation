package ru.cyberpunkoff.creatures;

import ru.cyberpunkoff.Cell;
import ru.cyberpunkoff.CellMap;
import ru.cyberpunkoff.creatures.Creature;
import ru.cyberpunkoff.objects.Grass;

import java.awt.*;
import java.util.ArrayList;

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

    // attack method: true - attack succeed; false - no target
    private boolean attack(CellMap map) {
        for (Cell neighbour : map.getNeighbourCells(map.getCellByEntity(this))) {
            //map.add(neighbour, new Predator());
            //System.out.println(map.get(neighbour));
            if (map.get(neighbour) instanceof Herbivore herbivore) {
                if (herbivore.getHealthPoints() <= this.damage) map.remove(neighbour);
                else herbivore.setHealthPoints(herbivore.getHealthPoints() - this.damage);
                return true;
            }
        }
        return false;
    }

    @Override
    public void makeMove(CellMap map) {
        if (!attack(map))
            moveToEntity(map, Herbivore.class);
    }
}
