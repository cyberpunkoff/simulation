package ru.cyberpunkoff.actions;

import ru.cyberpunkoff.Cell;
import ru.cyberpunkoff.CellMap;
import ru.cyberpunkoff.Entity;

public abstract class SpawnEntityAction<T extends Entity> extends Action {
    // класс абстрактного действия по созданию новой сущности
    double spawnRate;

    @Override
    public void doAction(CellMap map) {

        double rateDelta = 1.0 / (map.getHeight() * map.getWidth());
        double rate = 0;

        while (rate < spawnRate) {
            Cell cell = map.getRandomEmptyCell();

            if (cell == null) {
                System.out.println("Impossible to spawn entity");
                break;
            }

            map.add(cell, createEntity());
            rate += rateDelta;
        }
    }

    abstract T createEntity();
}
