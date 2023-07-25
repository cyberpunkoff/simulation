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

    @Override
    public void makeMove(CellMap map) {

        for (Cell neighbour : map.getNeighbourCells(map.getCellByEntity(this))) {
            //map.add(neighbour, new Predator());
            //System.out.println(map.get(neighbour));
            if (map.get(neighbour) instanceof Herbivore herbivore) {
                if (herbivore.getHealthPoints() <= this.damage) map.remove(neighbour);
                else herbivore.setHealthPoints(herbivore.getHealthPoints() - this.damage);
                return;
            }
        }

        ArrayList<Cell> path = findPath(map, map.getCellByEntity(this), Herbivore.class);
        if (path != null) {
            map.remove(map.getCellByEntity(this));
            map.add(path.get(Math.min(velocity, path.size() - 1)), this);
        }

    }

    @Override
    public Color getColor() {
        return Color.RED;
    }
}
