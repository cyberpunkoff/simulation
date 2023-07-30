package ru.cyberpunkoff.pathfinding;

import ru.cyberpunkoff.Cell;
import ru.cyberpunkoff.CellMap;
import ru.cyberpunkoff.Entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearchImpl implements IPathFinder {
    @Override
    public ArrayList<Cell> findPath(CellMap map, Cell startCell, Class<? extends Entity> target) {
        // Breadth first search algorithm implementation
        Queue<ArrayList<Cell>> paths = new LinkedList<>();
        paths.add(new ArrayList<>(Collections.singletonList(startCell)));
        ArrayList<Cell> path;
        ArrayList<Cell> temp;
        ArrayList<Cell> visitedCells = new ArrayList<>();

        while (!paths.isEmpty()) {
            path = paths.poll();
            Cell lastCell = path.get(path.size()-1);
            for (Cell neighbour : map.getNeighbourCells(lastCell)) { // checking all neighbours of last cell of the path
                Entity neighbourEntity = map.get(neighbour);
                if (neighbourEntity == null) {
                    if (!visitedCells.contains(neighbour)) {
                        visitedCells.add(neighbour);
                        temp = new ArrayList<>(path);
                        temp.add(neighbour);
                        paths.add(temp);
                    }
                } else if (neighbourEntity.getClass() == target) return path; // if we have required class among neighbours
            }
        }
        return null; // no path exists
    }
}
