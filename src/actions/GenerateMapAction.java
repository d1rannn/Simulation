package actions;

import map.MapClass;
import map.MapClassUtils;

public class GenerateMapAction extends Action {
    private final MapClassUtils mapClassUtils;

    public GenerateMapAction(MapClassUtils mapClassUtils) {
        this.mapClassUtils = mapClassUtils;
    }

    @Override
    public void perform(MapClass map) {
        mapClassUtils.generateNewMap();
    }
}