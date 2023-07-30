package ru.cyberpunkoff.actions;

import ru.cyberpunkoff.objects.Rock;

public class SpawnRockAction extends SpawnEntityAction<Rock> {

    public SpawnRockAction() {
        this.spawnRate = 0.15;
    }

    @Override
    Rock createEntity() {
        return new Rock();
    }
}
