package ru.cyberpunkoff.actions;

import ru.cyberpunkoff.CellMap;
import ru.cyberpunkoff.Entity;
import ru.cyberpunkoff.creatures.Creature;

public class MakeMovesAction extends Action {
    @Override
    public void doAction(CellMap map) {
        Entity[] entities = map.getCells().values().toArray(new Entity[0]);
        for (Entity entity : entities) {
            if (entity instanceof Creature)
                ((Creature) entity).makeMove(map);
        }
    }
}
