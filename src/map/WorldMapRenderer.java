package map;

import creature.Herbivore;
import creature.Predator;
import entity.Entity;
import entity.Grass;
import entity.Rock;
import entity.Tree;

public class WorldMapRenderer {
    public void render(WorldMap map) {
        for (int i = 0; i < map.getHeight(); i++) {
            for (int j = 0; j < map.getWidth(); j++) {
                Cell currentCell = new Cell(i, j);
                Entity entity = map.getEntity(currentCell);
                if (entity != null) {
                    System.out.print(getSpriteForEntity(entity) + "  ");
                } else {
                    System.out.print(".  ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    private String getSpriteForEntity(Entity entity) {

        if (entity instanceof Grass) {
            return "g";
        }
        else if (entity instanceof Rock) {
            return "r";
        }
        else if (entity instanceof Tree) {
            return "t";
        }
        else if (entity instanceof Herbivore) {
            return "H";
        }
        else if (entity instanceof Predator) {
            return "P";
        }
        return "";
    }

}