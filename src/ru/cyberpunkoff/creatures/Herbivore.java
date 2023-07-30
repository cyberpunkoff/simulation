package ru.cyberpunkoff.creatures;

import ru.cyberpunkoff.Cell;
import ru.cyberpunkoff.CellMap;
import ru.cyberpunkoff.objects.Grass;

public class Herbivore extends Creature {

    public Herbivore() {
        this.healthPoints = 10;
        this.velocity = 1;
    }

    public Herbivore(int healthPoints, int velocity) {
        this.healthPoints = healthPoints;
        this.velocity = velocity;
    }

    // eating grass method
    // true - eat succeed; false - no grass
    private boolean eat(CellMap map) {
        for (Cell neighbour : map.getNeighbourCells(map.getCellByEntity(this))) {
            if (map.get(neighbour) instanceof Grass) {
                map.remove(neighbour);
                healthPoints++;
                return true;
            }
        }
        return false;
    }

    @Override
    public void makeMove(CellMap map) {

        // if there is nothing to eat moving to the closest grass
        if (!eat(map))
            moveToEntity(map, Grass.class);

    }
}
