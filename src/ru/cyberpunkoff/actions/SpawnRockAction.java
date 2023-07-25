package ru.cyberpunkoff.actions;

import ru.cyberpunkoff.objects.Rock;

public class SpawnRockAction extends SpawnEntityAction<Rock> {

    public SpawnRockAction() {
        this.spawnRate = 0.2;
    }

    @Override
    Rock createEntity() {
        return new Rock();
    }
}
