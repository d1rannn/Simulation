package map;

import entity.Entity;
import map.MapClass;

public class MapRenderer {
    public void render(MapClass map) {
        int numberOfEntities = (map.getHeight() * map.getWidth()) / 2 - 1;

        MapClassUtils mapClassUtils = new MapClassUtils(map);
        mapClassUtils.generateRandomEntities(numberOfEntities);

        for (int i = 0; i < map.getHeight(); i++) {
            for (int j = 0; j < map.getWidth(); j++) {
                Cell currentCell = new Cell(i, j);
                if (map.contains(currentCell)) {
                    Entity entity = map.getEntity(currentCell);
                    System.out.print(entity.toString() + "  ");
                } else {
                    System.out.print(".  ");
                }
            }
            System.out.println();
        }
    }
}
