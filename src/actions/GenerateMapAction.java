package actions;

import map.WorldMap;
import map.WorldMapFactory;

public class GenerateMapAction extends Action {
    private final WorldMapFactory worldMapFactory;

    public GenerateMapAction(WorldMapFactory worldMapFactory) {
        this.worldMapFactory = worldMapFactory;
    }

    @Override
    public void perform(WorldMap map) {
        worldMapFactory.fillEntities();
    }
}