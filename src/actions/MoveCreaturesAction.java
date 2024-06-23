package actions;

import creature.Creature;
import map.Cell;
import map.MapClass;

public class MoveCreaturesAction extends Action {

    @Override
    public void perform(MapClass map) {
        for (int i = 0; i < map.getHeight(); i++) {
            for (int j = 0; j < map.getWidth(); j++) {
                Cell cell = new Cell(i, j);
                if (map.getEntity(cell) instanceof Creature && !((Creature) map.getEntity(cell)).isAlreadyMove()) {
                    ((Creature) map.getEntity(cell)).setAlreadyMove(true);
                    ((Creature) map.getEntity(cell)).makeMove(map, cell);
                }
            }
        }
    }
}
