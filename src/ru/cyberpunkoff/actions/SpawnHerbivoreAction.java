package ru.cyberpunkoff.actions;

import ru.cyberpunkoff.creatures.Herbivore;

public class SpawnHerbivoreAction extends SpawnEntityAction<Herbivore> {

    SpawnHerbivoreAction() {
        this.spawnRate = 0.4;
    }

    @Override
    Herbivore createEntity() {
        return new Herbivore();
    }
}
