package ru.cyberpunkoff.creatures;

import ru.cyberpunkoff.Cell;
import ru.cyberpunkoff.CellMap;
import ru.cyberpunkoff.Entity;

import java.util.ArrayList;
import java.util.Queue;

public abstract class Creature extends Entity {
    int velocity;
    int healthPoints;

    private void findPath(Queue<ArrayList<Cell>> paths, CellMap map, Class clazz) {
        // Реализация алгоритма поиска в ширину





    }
    public abstract void makeMove();
}
