package creature;

import entity.Entity;
import findpath.BFS;
import map.Cell;
import map.WorldMap;

import java.util.List;
import java.util.Random;

abstract public class Creature extends Entity {
    private final int speed;
    private int hp;

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

    public void makeMove(WorldMap map, Cell currentCell) {
        List<Cell> pathToTarget = BFS.findPathToNearestTarget(map, currentCell, this);

        if (!pathToTarget.isEmpty()) {
            Cell nextCell = pathToTarget.get(1); // Get the next cell in the path (excluding current cell)

            Entity entity = map.getEntity(nextCell);
            if (isTarget(entity)) {
                interactWithEntity(entity, map, currentCell, nextCell);
            } else {
                map.moveEntity(this, currentCell, nextCell);
            }
        }
    }
}