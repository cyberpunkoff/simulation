package ru.cyberpunkoff.creatures;

import ru.cyberpunkoff.Cell;
import ru.cyberpunkoff.CellMap;
import ru.cyberpunkoff.Entity;
import ru.cyberpunkoff.objects.Grass;

import java.util.*;

public abstract class Creature extends Entity {
    int velocity;
    int healthPoints;

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
        ArrayList<Cell> path = findPath(map, map.getCellByEntity(this), target);
        if (path != null) {
            map.remove(map.getCellByEntity(this));
            map.add(path.get(Math.min(velocity, path.size() - 1)), this);
        }
    }

    protected ArrayList<Cell> findPath(CellMap map, Cell startCell, Class<? extends Entity> target) {
        // Реализация алгоритма поиска в ширину

        Queue<ArrayList<Cell>> paths = new LinkedList<>();
        paths.add(new ArrayList<>(Collections.singletonList(startCell)));
        ArrayList<Cell> path;
        ArrayList<Cell> temp;
        ArrayList<Cell> visitedCells = new ArrayList<>();

        while (!paths.isEmpty()) {
            path = paths.poll();
            Cell lastCell = path.get(path.size()-1);
            for (Cell neighbour : map.getNeighbourCells(lastCell)) {
                //map.add(neighbour, new Predator());

                Entity neighbourEntity = map.get(neighbour);
                if (neighbourEntity == null) {
                    if (!visitedCells.contains(neighbour)) {
                        visitedCells.add(neighbour);
                        temp = new ArrayList<>(path);
                        temp.add(neighbour);
                        paths.add(temp);
                    }
                } else if (neighbourEntity.getClass() == target) return path; // среди соседей есть искомый элемент
            }
        }
        return null;
    }
    public abstract void makeMove(CellMap map);
}
