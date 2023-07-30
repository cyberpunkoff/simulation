package ru.cyberpunkoff.actions;

import ru.cyberpunkoff.creatures.Predator;

public class SpawnPredatorAction extends SpawnEntityAction<Predator> {

    public SpawnPredatorAction() {
        this.spawnRate = 0.01;
    }

    @Override
    Predator createEntity() {
        return new Predator();
    }
}
