package ru.cyberpunkoff.creatures;

import ru.cyberpunkoff.Cell;
import ru.cyberpunkoff.CellMap;
import ru.cyberpunkoff.Entity;
import ru.cyberpunkoff.creatures.Creature;
import ru.cyberpunkoff.objects.Grass;
import ru.cyberpunkoff.objects.Tree;

import java.awt.*;
import java.util.ArrayList;

public class Herbivore extends Creature {

    public Herbivore() {
        this.healthPoints = 10;
        this.velocity = 1;
    }

    public Herbivore(int healthPoints, int velocity) {
        this.healthPoints = healthPoints;
        this.velocity = velocity;
    }
    @Override
    public void makeMove(CellMap map) {
        //System.out.println("im in move");

        // TODO: may be subdivide to methods?

        for (Cell neighbour : map.getNeighbourCells(map.getCellByEntity(this))) {
            //map.add(neighbour, new Predator());
            //System.out.println(map.get(neighbour));
            if (map.get(neighbour) instanceof Grass) {
                map.remove(neighbour);

                healthPoints++;
                return;
            }
        }

        ArrayList<Cell> path = findPath(map, map.getCellByEntity(this), Grass.class);

        if (path != null) {
            map.remove(map.getCellByEntity(this));
            map.add(path.get(Math.min(velocity, path.size() - 1)), this);
        }


    }

    @Override
    public Color getColor() {
        return Color.GREEN;
    }
}
