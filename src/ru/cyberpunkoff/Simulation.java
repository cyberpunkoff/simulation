package ru.cyberpunkoff;

import ru.cyberpunkoff.actions.*;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    int movesCounter;

    CellMap map;

    Renderer renderer;

    List<Action> initActions;
    List<Action> turnActions;

    Simulation() {

        this(20, 20);
//        renderer = new Renderer(15, 15);
//
//        map = new CellMap();
//
//        renderer.render(map);



    }

    Simulation(int width, int height) {

        initActions = List.of(
                //new SpawnGrassAction(),
                //new SpawnTreeAction(),
                //new SpawnRockAction(),
                new SpawnPredatorAction(),
                new SpawnHerbivoreAction()
        );

        // TODO: implement spawn grass action if not enough
        // TODO: implement predator activity
        // TODO: implement smooth graphic for more than one velocity?
        // TODO: change path finding algo implementation to interface
        // TODO: move color part to renderer


        turnActions = List.of(
                new MakeMovesAction(),
                new SpawnLackingGrassAction()
        );

        renderer = new Renderer(width, height);
        map = new CellMap(width, height);

        for (Action action : initActions)
            action.doAction(map);

        renderer.render(map);

        startSimulation();

    }

    public void nextTurn() {

        System.out.println("Current turn " + movesCounter);
        for (Action action : turnActions)
            action.doAction(map);
        renderer.render(map);
        movesCounter++;

    }

    public void startSimulation() {
        while (true) {
            try {
                Thread.sleep(300);
                nextTurn();
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void pauseSimulation() {

    }

}
