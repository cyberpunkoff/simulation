package ru.cyberpunkoff;

import ru.cyberpunkoff.creatures.Herbivore;
import ru.cyberpunkoff.creatures.Predator;

import java.util.HashMap;

import java.util.StringTokenizer;

public class Map {

    private final java.util.Map<Cell, Entity> map;

    Map() {
        map = new HashMap<>();

        Herbivore herb1 = new Herbivore();
        Herbivore herb2 = new Herbivore();
        Herbivore herb3 = new Herbivore();

        Predator pred1 = new Predator();
        Predator pred2 = new Predator();

        map.put(new Cell(1, 2), herb1);
        map.put(new Cell(3, 4), herb2);
        map.put(new Cell(5, 7), herb3);

        map.put(new Cell(11, 2), pred1);
        map.put(new Cell(13, 7), pred2);




    }

    public java.util.Map<Cell, Entity> getMap() {
        return map;
    }


}
