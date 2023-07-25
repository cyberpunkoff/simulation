package ru.cyberpunkoff.actions;

import ru.cyberpunkoff.objects.Tree;

public class SpawnTreeAction extends SpawnEntityAction<Tree> {

    public SpawnTreeAction() {
        this.spawnRate = 0.1;
    }

    @Override
    Tree createEntity() {
        return new Tree();
    }
}
