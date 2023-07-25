package ru.cyberpunkoff.actions;

import ru.cyberpunkoff.CellMap;
import ru.cyberpunkoff.objects.Grass;

public class SpawnLackingGrassAction extends SpawnEntityAction<Grass> {

    double minimalPopulation = 0.04;
    double targetPopulation = 0.3;

    public SpawnLackingGrassAction() {
        this.spawnRate = targetPopulation;
    }

    @Override
    public void doAction(CellMap map) {
        if ((double) map.getEntitiesOfType(Grass.class).size() / map.size() <= minimalPopulation)
            super.doAction(map);
    }

    @Override
    Grass createEntity() {
        return new Grass();
    }


}
