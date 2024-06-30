package map;

import creature.Herbivore;
import creature.Predator;
import entity.Entity;
import entity.Grass;
import entity.Rock;
import entity.Tree;

import java.util.Random;

public class MapClassUtils {
    private final MapClass map;
    private final Random random;
    private final MapRenderer renderer;

    public MapClassUtils(MapClass map, MapRenderer renderer) {
        this.map = map;
        this.renderer = renderer;
        this.random = new Random();
    }

    public void generateRandomEntities(int numberOfEntities) {
        for (int i = 0; i < numberOfEntities; i++) {
            int x, y;
            Cell cell;
            do {
                x = random.nextInt(map.getWidth());
                y = random.nextInt(map.getHeight());
                cell = new Cell(x, y);
            } while (map.contains(cell));

            Entity entity = createRandomEntity();
            map.add(cell, entity);
        }
    }

    private Entity createRandomEntity() {
        int choice = random.nextInt(5);
        return switch (choice) {
            case 0 -> new Grass();
            case 1 -> new Rock();
            case 2 -> new Tree();
            case 3 -> new Herbivore(1, 6);
            case 4 -> new Predator(1, 10, 4);
            default -> null;
        };
    }

    public void generateNewMap() {
        int numberOfEntities = (map.getHeight() * map.getWidth()) / 3 - 1;

        generateRandomEntities(numberOfEntities);
    }
}
