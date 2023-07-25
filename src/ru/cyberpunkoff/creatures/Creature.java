package ru.cyberpunkoff.creatures;

import ru.cyberpunkoff.Cell;
import ru.cyberpunkoff.CellMap;
import ru.cyberpunkoff.Entity;

import java.util.*;

public abstract class Creature extends Entity {
    int velocity;
    int healthPoints;

    protected ArrayList<Cell> findPath(CellMap map, Cell startCell, Class target) {
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
