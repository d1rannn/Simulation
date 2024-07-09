package map;

import creature.Herbivore;
import creature.Predator;
import entity.Entity;
import entity.Grass;
import entity.Rock;
import entity.Tree;

import java.util.Random;

public class WorldMapFactory {
    private final WorldMap map;
    private final Random random;

    public WorldMapFactory(WorldMap map) {
        this.map = map;
        this.random = new Random();
    }

    public void insertRandomEntities(int numberOfEntities) {
        for (int i = 0; i < numberOfEntities; i++) {
            int x, y;
            Cell cell;
            do {
                x = random.nextInt(map.getWidth());
                y = random.nextInt(map.getHeight());
                cell = new Cell(x, y);
            } while (map.contains(cell));

            Entity entity = createRandomEntity();
            map.updateEntity(cell, entity);
        }
    }

    private Entity createRandomEntity() {
        int choice = random.nextInt(5);
        return switch (choice) {
            case 0 -> new Grass();
            case 1 -> new Rock();
            case 2 -> new Tree();
            case 3 -> new Herbivore(1, 6);
            case 4 -> new Predator(1, 10, 2);
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        };
    }

    public void fillEntities() {
        int numberOfEntities = (map.getHeight() * map.getWidth()) / 3 - 1;

        insertRandomEntities(numberOfEntities);
    }
}
