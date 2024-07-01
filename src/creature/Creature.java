package creature;

import entity.Entity;
import map.Cell;
import map.WorldMap;

import java.util.List;
import java.util.Random;

abstract public class Creature extends Entity {
    private final int speed;
    private int hp;
    private final Random random = new Random();

    public Creature(int speed, int hp) {
        this.speed = speed;
        this.hp = hp;
    }

    public int getSpeed() {
        return speed;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    abstract public boolean isTarget(Entity entity);

    abstract public void interactWithEntity(Entity entity, WorldMap map, Cell currentCell, Cell targetCell);

    public Cell makeMove(WorldMap map, Cell currentCell) {
        List<Cell> adjacentCells = map.getAdjacentCells(currentCell);

        for (Cell targetCell : adjacentCells) {
            Entity entity = map.getEntity(targetCell);
            if (isTarget(entity)) {
                interactWithEntity(entity, map, currentCell, targetCell);
                return targetCell;
            }
        }

        // Move in a random direction if no target found
        Cell newCell = adjacentCells.get(random.nextInt(adjacentCells.size()));
        map.updateEntity(currentCell, null);
        map.updateEntity(newCell, this);
        return newCell;
    }
}
