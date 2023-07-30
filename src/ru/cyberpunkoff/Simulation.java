package ru.cyberpunkoff;

import ru.cyberpunkoff.actions.*;
import java.util.List;

// TODO: implement smooth graphic for more than one velocity?
// TODO: change path finding algo implementation to interface ?
// TODO: move color part to renderer +

public class Simulation {
    private final CellMap map;
    private final Renderer renderer;
    private final List<Action> initActions;
    private final List<Action> turnActions;
    int movesCounter;
    private boolean isSimulationRunning;
    private final static int SIMULATION_DELAY = 500;

    Simulation() {
        this(20, 20);
    }

    Simulation(int width, int height) {

        initActions = List.of(
                new SpawnGrassAction(),
                new SpawnTreeAction(),
                new SpawnRockAction(),
                new SpawnPredatorAction(),
                new SpawnHerbivoreAction()
        );
        turnActions = List.of(new MakeMovesAction(), new SpawnLackingGrassAction());
        renderer = new Renderer(width, height, this);
        map = new CellMap(width, height);

        for (Action action : initActions)
            action.doAction(map);

        renderer.render(map);
    }

    public void nextTurn() {
        System.out.println("Current turn " + movesCounter);
        for (Action action : turnActions)
            action.doAction(map);
        renderer.render(map);
        movesCounter++;
    }

    public void startSimulation() {
        Thread simulationThread = new Thread(() -> {
            isSimulationRunning = true;
            while (isSimulationRunning) {
                try {
                    nextTurn();
                    Thread.sleep(SIMULATION_DELAY);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        simulationThread.start();
    }

    public void pauseSimulation() {
        isSimulationRunning = false;

    }
}
