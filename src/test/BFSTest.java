package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import map.Cell;
import map.WorldMap;
import creature.Herbivore;
import creature.Predator;
import entity.Grass;
import entity.Entity;
import findpath.BFS;

import java.util.List;

public class BFSTest {

    private WorldMap map;
    private Cell startCellHerbivore;
    private Cell startCellPredator;
    private Herbivore herbivore;
    private Predator predator;
    private Cell grassCell;
    private Cell herbivoreCell;

    @BeforeEach
    public void setUp() {
        map = new WorldMap(5, 5); // Create a 5x5 map
        startCellHerbivore = new Cell(0, 0);
        startCellPredator = new Cell(4, 4);
        herbivore = new Herbivore(1, 10);
        predator = new Predator(1, 10, 5);
        grassCell = new Cell(2, 2);
        herbivoreCell = new Cell(2, 2);

        // Place entities on the map
        map.setEntity(startCellHerbivore, herbivore);
        map.setEntity(startCellPredator, predator);
        map.setEntity(grassCell, new Grass());
        map.setEntity(herbivoreCell, new Herbivore(1, 10));
    }

    @Test
    public void testFindPathForPredator() {
        List<Cell> path = BFS.findPathToNearestTarget(map, startCellPredator, predator);
        System.out.println(path);
        assertFalse(path.isEmpty(), "Path should not be empty");
        assertEquals(herbivoreCell, path.get(path.size() - 1), "Path should lead to herbivore cell");
    }
}