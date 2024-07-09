package creature;

import entity.Entity;
import entity.Grass;
import map.Cell;
import map.WorldMap;

public class Herbivore extends Creature {

    public Herbivore(int speed, int hp) {
        super(speed, hp);
    }

    @Override
    public boolean isTarget(Entity entity) {
        return entity instanceof Grass;
    }


    @Override
    public void interactWithEntity(Entity entity, WorldMap map, Cell currentCell, Cell targetCell) {
        int currentHp = this.getHp();
        this.setHp(currentHp + 2);
        map.moveEntity(this, currentCell, targetCell);
    }
}