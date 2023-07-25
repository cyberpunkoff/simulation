package ru.cyberpunkoff.actions;

import ru.cyberpunkoff.objects.Grass;

public class SpawnGrassAction extends SpawnEntityAction<Grass> {

    public SpawnGrassAction() {
        spawnRate = 0.2;
    }

    @Override
    Grass createEntity() {
        return new Grass();
    }
}
