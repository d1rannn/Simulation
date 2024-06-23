package creature;

import entity.Entity;
import entity.Grass;
import map.Cell;
import map.MapClass;

public class Herbivore extends Creature {

    public Herbivore(int speed, int hp) {
        super(speed, hp);
        super.type = "H";
    }

    @Override
    public boolean isTarget(Entity entity) {
        return entity instanceof Grass;
    }

    @Override
    public void interactWithEntity(Entity entity, MapClass map, Cell currentCell, Cell targetCell) {
        map.delete(targetCell);
        map.add(targetCell, this);
    }

}