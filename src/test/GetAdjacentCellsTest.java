package test;

import map.Cell;
import map.MapClass;

import java.util.List;

public class GetAdjacentCellsTest {
    public static void main(String[] args) {
        MapClass map = new MapClass(5, 5);

        // Test different coordinates
        testAdjacentCells(map, new Cell(2, 2)); // Center of the map
        testAdjacentCells(map, new Cell(0, 0)); // Top-left corner
        testAdjacentCells(map, new Cell(4, 4)); // Bottom-right corner
        testAdjacentCells(map, new Cell(0, 4)); // Bottom-left corner
        testAdjacentCells(map, new Cell(4, 0)); // Top-right corner
    }

    private static void testAdjacentCells(MapClass map, Cell cell) {
        List<Cell> adjacentCells = map.getAdjacentCells(cell);
        System.out.println("Adjacent cells to " + cell + ":");
        for (Cell adjacentCell : adjacentCells) {
            System.out.println(adjacentCell);
        }
        System.out.println();
    }
}
