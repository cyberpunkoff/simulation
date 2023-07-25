package ru.cyberpunkoff;

import ru.cyberpunkoff.creatures.Herbivore;
import ru.cyberpunkoff.creatures.Predator;

import java.util.Map;
import java.util.HashMap;

public class CellMap {

    private final Map<Cell, Entity> cells;

    int width;

    int height;

    CellMap(int width, int height) {
        this.width = width;
        this.height = height;
        cells = new HashMap<>();
    }

    CellMap() {
        cells = new HashMap<>();

        Herbivore herb1 = new Herbivore();
        Herbivore herb2 = new Herbivore();
        Herbivore herb3 = new Herbivore();

        Predator pred1 = new Predator();
        Predator pred2 = new Predator();

        cells.put(new Cell(1, 2), herb1);
        cells.put(new Cell(3, 4), herb2);
        cells.put(new Cell(5, 7), herb3);

        cells.put(new Cell(11, 2), pred1);
        cells.put(new Cell(13, 7), pred2);

    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Map<Cell, Entity> getCells() {
        return cells;
    }


    public Cell getRandomEmptyCell() {

        if (cells.size() == width * height) // случай, когда вся карта занята
            return null;

        // иначе найдется хотя бы одна свободная ячейка
        while (true) {

            int x = (int) (getWidth() * Math.random());
            int y = (int) (getHeight() * Math.random());
            Cell cell = new Cell(x, y);

            if (isEmpty(cell))
                return cell;
        }

    }

    public void add(Cell cell, Entity entity) {
        cells.put(cell, entity);
    }

    public boolean isEmpty(Cell cell) {
        return !cells.containsKey(cell);
    }
}
