package creature;

import entity.Entity;
import map.Cell;
import map.WorldMap;

public class Predator extends Creature {
    private final int attackPower;

    public Predator(int speed, int hp, int attackPower) {
        super(speed, hp);
        this.attackPower = attackPower;
    }

    @Override
    public boolean isTarget(Entity entity) {
        return entity instanceof Herbivore;
    }

    @Override
    public void interactWithEntity(Entity entity, WorldMap map, Cell currentCell, Cell targetCell) {
        Herbivore herbivore = (Herbivore) entity;
        herbivore.setHp(herbivore.getHp() - attackPower);
        if (herbivore.getHp() <= 0) {
            map.delete(targetCell);
        }
    }

    @Override
    public String toString() {
        return "P";
    }
}