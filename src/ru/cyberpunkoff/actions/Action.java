package ru.cyberpunkoff.actions;

import ru.cyberpunkoff.Cell;
import ru.cyberpunkoff.CellMap;

public abstract class Action {
    public abstract void doAction(CellMap map); // метод выполнения действия
}
