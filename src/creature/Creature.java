package creature;

import entity.Entity;
import map.Cell;
import map.MapClass;

import java.util.List;
import java.util.Random;

abstract public class Creature extends Entity {
    private final int speed;
    private int hp;
    private boolean alreadyMove;
    private final Random random = new Random();

    public Creature(int speed, int hp) {
        this.speed = speed;
        this.hp = hp;
        alreadyMove = false;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isAlreadyMove() {
        return alreadyMove;
    }

    public void setAlreadyMove(boolean alreadyMove) {
        this.alreadyMove = alreadyMove;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    abstract public boolean isTarget(Entity entity);

    abstract public void interactWithEntity(Entity entity, MapClass map, Cell currentCell, Cell targetCell);

    public void makeMove(MapClass map, Cell currentCell) {
        List<Cell> adjacentCells = map.getAdjacentCells(currentCell);

        for (Cell targetCell : adjacentCells) {
            Entity entity = map.getEntity(targetCell);
            if (isTarget(entity)) {
                interactWithEntity(entity, map, currentCell, targetCell);
                return;
            }
        }

        // Move in a random direction if no creature found
        Cell newCell = adjacentCells.get(random.nextInt(adjacentCells.size()));
        map.updateEntity(currentCell, null);
        map.add(newCell, this);
    }
}