import map.WorldMap;
import map.WorldMapRenderer;

public class Main {
    public static void main(String[] args) {
        final Simulation simulation = new Simulation(
                new WorldMap(10, 10),
                new WorldMapRenderer()
        );
        simulation.start();
    }
}