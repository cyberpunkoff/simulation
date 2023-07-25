package ru.cyberpunkoff;

import ru.cyberpunkoff.creatures.Herbivore;
import ru.cyberpunkoff.creatures.Predator;

import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

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

    public Cell getCellByEntity(Entity entity) {
        for (Map.Entry<Cell, Entity> entry : cells.entrySet()) {
            if (entry.getValue().equals(entity))
                return entry.getKey();
        }
        return null;
    }


    public Entity get(Cell cell) {
        if (!isEmpty(cell))
            return cells.get(cell);
        return null;
    }



    public boolean isEmpty(Cell cell) {
        return !cells.containsKey(cell);
    }

    public Set<Cell> getNeighbourCells(Cell cell) {

        Set<Cell> neighbours = new HashSet<>();

        if (cell == null)
            return neighbours;

        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                if (x == 0 && y == 0 || x * y != 0) continue;

                int newX = cell.getX() + x;
                int newY = cell.getY() + y;
                if (newX >= 0 && newX < width && newY >= 0 && newY < height)
                    neighbours.add(new Cell(newX, newY));
            }
        }
        return neighbours;
    }

    public <T> HashMap<Cell, T> getEntitiesOfType(Class<T> type) {
        return cells.entrySet().stream()
                .filter(e -> type.isInstance(e.getValue()))
                .map(e -> (Map.Entry<Cell, T>) e)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b)
                -> b, HashMap::new));
    }

    public void remove(Cell cell) {
        cells.remove(cell);
    }

    public int size() {
        return this.width * this.height;
    }
}
