package ru.cyberpunkoff;

import ru.cyberpunkoff.actions.Action;

import java.util.List;

public class Simulation {
    int movesCounter;

    CellMap map;

    Renderer renderer;

    List<Action> initActions;
    List<Action> turnActions;

    Simulation() {
        renderer = new Renderer(15, 15);

        map = new CellMap();

        renderer.render(map);



    }

    Simulation(int width, int height) {
        renderer = new Renderer(width, height);
        map = new CellMap(width, height);
    }

    public void nextTurn() {

        movesCounter++;

    }

    public void startSimulation() {

    }

    public void pauseSimulation() {

    }

}
