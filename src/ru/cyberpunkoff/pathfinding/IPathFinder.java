package ru.cyberpunkoff.pathfinding;

import ru.cyberpunkoff.Cell;
import ru.cyberpunkoff.CellMap;
import ru.cyberpunkoff.Entity;

import java.util.ArrayList;

public interface IPathFinder {
    public ArrayList<Cell> findPath(CellMap map, Cell startCell, Class<? extends Entity> target);
}
