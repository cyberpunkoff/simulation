package ru.cyberpunkoff.actions;

import ru.cyberpunkoff.creatures.Herbivore;

public class SpawnHerbivoreAction extends SpawnEntityAction<Herbivore> {

    public SpawnHerbivoreAction() {
        this.spawnRate = 0.01;
    }

    @Override
    Herbivore createEntity() {
        return new Herbivore();
    }
}
