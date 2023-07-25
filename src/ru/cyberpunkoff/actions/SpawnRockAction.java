package ru.cyberpunkoff.actions;

import ru.cyberpunkoff.objects.Rock;

public class SpawnRockAction extends SpawnEntityAction<Rock> {

    SpawnRockAction() {
        this.spawnRate = 0.3;
    }

    @Override
    Rock createEntity() {
        return new Rock();
    }
}
