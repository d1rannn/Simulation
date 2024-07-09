package findpath;

import creature.Creature;
import entity.Entity;
import map.Cell;
import map.WorldMap;

import java.util.*;

public class BFS {

    public static List<Cell> findPathToNearestTarget(WorldMap map, Cell startCell, Creature creature) {
        Queue<Cell> queue = new LinkedList<>();
        Map<Cell, Cell> cameFrom = new HashMap<>();
        Set<Cell> visited = new HashSet<>();

        queue.add(startCell);
        visited.add(startCell);
        cameFrom.put(startCell, null);

        while (!queue.isEmpty()) {
            Cell current = queue.poll();
            if (current == null) continue;

            // Check if current cell has the target entity
            Entity entity = map.getEntity(current);
            if (creature.isTarget(entity)) {
                // Reconstruct path
                return reconstructPath(cameFrom, current);
            }

            // Explore neighbors
            for (Cell neighbor : getAdjacentCells(map, current)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                    cameFrom.put(neighbor, current);
                }
            }
        }
        return new ArrayList<>(); // Return an empty list if no path is found
    }

    private static List<Cell> reconstructPath(Map<Cell, Cell> cameFrom, Cell endCell) {
        List<Cell> path = new ArrayList<>();
        for (Cell at = endCell; at != null; at = cameFrom.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);
        return path;
    }

    private static List<Cell> getAdjacentCells(WorldMap map, Cell cell) {
        List<Cell> adjacentCells = new ArrayList<>();
        int x = cell.getX();
        int y = cell.getY();

        // Add horizontal and vertical neighbours
        if (x > 0) adjacentCells.add(new Cell(x - 1, y));
        if (x < map.getWidth() - 1) adjacentCells.add(new Cell(x + 1, y));
        if (y > 0) adjacentCells.add(new Cell(x, y - 1));
        if (y < map.getHeight() - 1) adjacentCells.add(new Cell(x, y + 1));

        // Add diagonal neighbours
        if (x > 0 && y > 0) adjacentCells.add(new Cell(x - 1, y - 1));
        if (x > 0 && y < map.getHeight() - 1) adjacentCells.add(new Cell(x - 1, y + 1));
        if (x < map.getWidth() - 1 && y > 0) adjacentCells.add(new Cell(x + 1, y - 1));
        if (x < map.getWidth() - 1 && y < map.getHeight() - 1) adjacentCells.add(new Cell(x + 1, y + 1));

        return adjacentCells;
    }
}