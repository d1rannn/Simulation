import actions.Action;
import actions.GenerateMapAction;
import actions.MoveCreaturesAction;
import actions.RenderMapAction;
import creature.Creature;
import entity.Entity;
import map.Cell;
import map.WorldMap;
import map.WorldMapFactory;
import map.WorldMapRenderer;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Simulation {
    private final WorldMap map;
    private final WorldMapFactory worldMapFactory;
    private final WorldMapRenderer renderer;
    private int countMoves;
    private final List<Action> initActions;
    private final List<Action> turnActions;

    public Simulation(WorldMap map, WorldMapRenderer renderer) {
        this.map = map;
        this.renderer = renderer;
        this.worldMapFactory = new WorldMapFactory(map);
        this.initActions = new ArrayList<>();
        this.turnActions = new ArrayList<>();
        this.countMoves = 1;
    }

    public void nextTurn() {
        System.out.println("Turn: " + countMoves);

        performTurnActions();
        moveCreatures(map);
        renderMap();
        incrementTurnCount();
    }

    private void performTurnActions() {
        for (Action action : turnActions) {
            action.perform(map);
        }
    }

    private void performInitActions() {
        for (Action action : initActions) {
            action.perform(map);
        }
    }

    private void moveCreatures(WorldMap map) {
        Set<Cell> originalCells = map.getCells().keySet();
        List<Cell> cells = new ArrayList<>(originalCells); // Copy of Cells

        for (Cell cell : cells) {
            Entity entity = map.getEntity(cell);
            if (entity instanceof Creature) {
                ((Creature) entity).makeMove(map, cell);
            }
        }
    }

    private void renderMap() {
        renderer.render(map);
    }

    private void incrementTurnCount() {
        countMoves++;
    }

    public void start() {

        createActions();
        performInitActions();

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
        initActions.add(new GenerateMapAction(worldMapFactory));
        initActions.add(new RenderMapAction(renderer));

        turnActions.add(new MoveCreaturesAction());
    }
}