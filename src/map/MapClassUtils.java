package map;

import creature.Herbivore;
import creature.Predator;
import entity.Entity;
import entity.Grass;
import entity.Rock;
import entity.Tree;

import java.util.Random;

public class MapClassUtils {
    private MapClass map;
    private Random random;

    public MapClassUtils(MapClass map) {
        this.map = map;
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
        switch (choice) {
            case 0: return new Grass();
            case 1: return new Rock();
            case 2: return new Tree();
            case 3: return new Herbivore();
            case 4: return new Predator();
            default: return null;
        }
    }

//    private void makeMoveRandomEntity() {
//        int x = random.nextInt(map.getWidth());
//        int y = random.nextInt(map.getHeight());
//
//        if (map.contains(new Cell(x, y))) {
//            int choice = random.nextInt(9);
//
//            switch (choice) {
//                case 0:
//                case 1:
//                case 2:
//                case 3:
//                case 4:
//                case 5:
//                case 6:
//                case 7:
//                case 8:
//                case 9:
//                default:
//            }
//        }
//    }
}
