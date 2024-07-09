package actions;

import creature.Creature;
import map.Cell;
import map.WorldMap;

import java.util.HashSet;
import java.util.Set;

public class MoveCreaturesAction extends Action {

    @Override
    public void perform(WorldMap map) {
        for (int i = 0; i < map.getHeight(); i++) {
            for (int j = 0; j < map.getWidth(); j++) {
                Cell cell = new Cell(i, j);
                if (map.getEntity(cell) != null && map.getEntity(cell) instanceof Creature creature) {
                    creature.makeMove(map, cell);
                }
            }
        }
    }
}