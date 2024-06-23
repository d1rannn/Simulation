package map;

import entity.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class MapClass {
    private final HashMap<Cell, Entity> cells;
    final int height;
    final int width;

    public MapClass(int height, int width) {
        this.height = height;
        this.width = width;
        this.cells = new HashMap<>();
    }

    public Set<Cell> getCells() {
        return cells.keySet();
    }

    public Entity getEntity(Cell cell) {
        return cells.get(cell);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void add(Cell cell, Entity entity) {
        cells.put(cell, entity);
    }

    public void delete(Cell cell) {
        cells.remove(cell);
    }

    public boolean contains(Cell cell) {
        return cells.containsKey(cell);
    }

    public void updateEntity(Cell cell, Entity entity) {
        cells.put(cell, entity);
    }

    public List<Cell> getAdjacentCells(Cell cell) {
        List<Cell> adjacentCells = new ArrayList<>();
        int x = cell.getX();
        int y = cell.getY();

        // Horizontal and vertical neighbors
        if (x > 0) adjacentCells.add(new Cell(x - 1, y));
        if (x < width - 1) adjacentCells.add(new Cell(x + 1, y));
        if (y > 0) adjacentCells.add(new Cell(x, y - 1));
        if (y < height - 1) adjacentCells.add(new Cell(x, y + 1));

        // Diagonal neighbors
        if (x > 0 && y > 0) adjacentCells.add(new Cell(x - 1, y - 1));
        if (x > 0 && y < height - 1) adjacentCells.add(new Cell(x - 1, y + 1));
        if (x < width - 1 && y > 0) adjacentCells.add(new Cell(x + 1, y - 1));
        if (x < width - 1 && y < height - 1) adjacentCells.add(new Cell(x + 1, y + 1));

        return adjacentCells;
    }
}
