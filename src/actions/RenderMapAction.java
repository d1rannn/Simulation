package actions;

import map.WorldMap;
import map.WorldMapRenderer;

public class RenderMapAction extends Action {
    private final WorldMapRenderer renderer;

    public RenderMapAction(WorldMapRenderer renderer) {
        this.renderer = renderer;
    }

    @Override
    public void perform(WorldMap map) {
        renderer.render(map);
    }
}