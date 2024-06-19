package map;

import entity.Entity;

import java.util.HashMap;
import java.util.Set;

public class MapClass {
    private HashMap<Cell, Entity> cells;
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
}
