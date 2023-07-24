package ru.cyberpunkoff;

import java.awt.*;

public class Simulation {
    int movesCounter;

    Map map;

    Renderer renderer;

    Simulation() {
        renderer = new Renderer(15, 15);

        map = new Map();

        renderer.render(map);



    }

    public void nextTurn() {

    }

    public void startSimulation() {

    }

    public void pauseSimulation() {

    }

}
