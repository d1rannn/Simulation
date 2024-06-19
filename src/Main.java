import map.MapClass;
import map.MapClassUtils;
import map.MapRenderer;

public class Main {
    public static void main(String[] args) {
        MapClass map = new MapClass(10, 10);
        MapRenderer mapRenderer = new MapRenderer();

        mapRenderer.render(map);
    }
}