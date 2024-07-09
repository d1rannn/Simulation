package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import map.Cell;
import map.WorldMap;
import creature.Herbivore;
import entity.Grass;
import entity.Entity;
import findpath.BFS;

import java.util.List;

public class HerbivoreBFSTest {

    private WorldMap map;
    private Cell startCellHerbivore;
    private Herbivore herbivore;
    private Cell grassCell;

    @BeforeEach
    public void setUp() {
        map = new WorldMap(5, 5); // Create a 5x5 map
        startCellHerbivore = new Cell(0, 0);
        herbivore = new Herbivore(1, 10);
        grassCell = new Cell(2, 2);

        // Place entities on the map
        map.setEntity(startCellHerbivore, herbivore);
        map.setEntity(grassCell, new Grass());
    }

    @Test
    public void testFindPathForHerbivore() {
        List<Cell> path = BFS.findPathToNearestTarget(map, startCellHerbivore, herbivore);
        System.out.println(path);
        assertFalse(path.isEmpty(), "Path should not be empty");
        assertEquals(grassCell, path.get(path.size() - 1), "Path should lead to grass cell");
    }
}