package ru.cyberpunkoff.actions;

import ru.cyberpunkoff.creatures.Predator;

public class SpawnPredatorAction extends SpawnEntityAction<Predator> {

    SpawnPredatorAction() {
        this.spawnRate = 0.25;
    }

    @Override
    Predator createEntity() {
        return new Predator();
    }
}