package map;

import entity.Entity;

public class MapRenderer {
    public void render(MapClass map) {
        for (int i = 0; i < map.getHeight(); i++) {
            for (int j = 0; j < map.getWidth(); j++) {
                Cell currentCell = new Cell(i, j);
                Entity entity = map.getEntity(currentCell);
                if (entity != null) {
                    System.out.print(entity.getType() + "  ");
                } else {
                    System.out.print(".  ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}