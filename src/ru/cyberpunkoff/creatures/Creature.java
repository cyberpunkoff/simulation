package ru.cyberpunkoff.creatures;

import ru.cyberpunkoff.Cell;
import ru.cyberpunkoff.CellMap;
import ru.cyberpunkoff.Entity;
import ru.cyberpunkoff.pathfinding.BreadthFirstSearchImpl;
import ru.cyberpunkoff.pathfinding.IPathFinder;

import java.util.*;

public abstract class Creature extends Entity {
    int velocity;
    int healthPoints;
    IPathFinder pathFinder = new BreadthFirstSearchImpl();

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    protected void moveToEntity(CellMap map, Class<? extends Entity> target) {
        ArrayList<Cell> path = pathFinder.findPath(map, map.getCellByEntity(this), target);
        if (path != null) {
            map.remove(map.getCellByEntity(this));
            map.add(path.get(Math.min(velocity, path.size() - 1)), this);
        }
    }


    public abstract void makeMove(CellMap map);
}
