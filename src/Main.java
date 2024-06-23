import map.MapClass;
import map.MapRenderer;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final Simulation simulation = new Simulation(
                new MapClass(10, 10),
                new MapRenderer()
        );
        simulation.startSimulation();
    }
}