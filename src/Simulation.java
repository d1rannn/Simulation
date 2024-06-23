import actions.Action;
import actions.GenerateMapAction;
import actions.MoveCreaturesAction;
import actions.RenderMapAction;
import creature.Creature;
import entity.Entity;
import map.Cell;
import map.MapClass;
import map.MapClassUtils;
import map.MapRenderer;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private final MapClass map;
    private final MapClassUtils mapClassUtils;
    private int countMoves;
    private final MapRenderer renderer;
    private final List<Action> initActions;
    private final List<Action> turnActions;

    public Simulation(MapClass map, MapRenderer renderer) {
        this.map = map;
        this.renderer = renderer;
        this.mapClassUtils = new MapClassUtils(map, renderer); // Initialize mapClassUtils
        this.initActions = new ArrayList<>();
        this.turnActions = new ArrayList<>();
        this.countMoves = 0;
    }

    public void nextTurn() {
        System.out.println("Turn: " + countMoves);
        // Perform all turn actions
        for (Action action : turnActions) {
            action.perform(map);
        }

        // Reset movement state for all creatures after turn
        for (Cell cell : map.getCells()) {
            Entity entity = map.getEntity(cell);
            if (entity instanceof Creature) {
                ((Creature) entity).setAlreadyMove(false);
            }
        }

        // Render the map after actions are performed
        renderer.render(map);

        // Increment the count of moves
        countMoves++;
    }

    public void startSimulation() {
        createActions();

        // Perform all initial actions
        for (Action action : initActions) {
            action.perform(map);
        }

        // Render the initial state of the map
        renderer.render(map);

        // Start the simulation by executing turns
        while (true) {
            nextTurn();
            try {
                // Adding a sleep interval to observe the turns, can be adjusted or removed as necessary
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void createActions() {
        initActions.add(new GenerateMapAction(mapClassUtils));
        initActions.add(new RenderMapAction(renderer));

        turnActions.add(new MoveCreaturesAction());
    }
}