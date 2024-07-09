package map;

import entity.Entity;

import java.util.*;

public class WorldMap {
    private final Map<Cell, Entity> cells;
    final int width;
    final int height;

    public WorldMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.cells = new HashMap<>();
    }

    public Map<Cell, Entity> getCells() {
        return cells;
    }

    public Entity getEntity(Cell cell) {
        return cells.get(cell);
    }

    public void setEntity(Cell cell, Entity entity) {
        cells.put(cell, entity);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void updateEntity(Cell cell, Entity entity) {
        cells.put(cell, entity);
    }

    public void removeEntity(Cell cell) {
        cells.remove(cell);
    }

    public boolean contains(Cell cell) {
        return cells.containsKey(cell);
    }

    public void moveEntity(Entity entity, Cell currentCell, Cell targetCell) {
        removeEntity(currentCell);
        removeEntity(targetCell);
        updateEntity(targetCell, entity);
    }
}
