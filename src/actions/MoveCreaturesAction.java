package actions;

import creature.Creature;
import map.Cell;
import map.WorldMap;

import java.util.HashSet;
import java.util.Set;

public class MoveCreaturesAction extends Action {

    @Override
    public void perform(WorldMap map) {
        Set<Cell> processedCells = new HashSet<>();

        for (int i = 0; i < map.getHeight(); i++) {
            for (int j = 0; j < map.getWidth(); j++) {
                Cell cell = new Cell(i, j);
                if (!processedCells.contains(cell) && map.getEntity(cell) instanceof Creature creature) {
                    Cell targetCell = creature.makeMove(map, cell);
                    processedCells.add(targetCell);
                    processedCells.add(cell);
                }
            }
        }
    }
}
