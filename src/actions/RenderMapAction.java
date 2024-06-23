package actions;

import map.MapClass;
import map.MapRenderer;

public class RenderMapAction extends Action {
    private final MapRenderer renderer;

    public RenderMapAction(MapRenderer renderer) {
        this.renderer = renderer;
    }

    @Override
    public void perform(MapClass map) {
        renderer.render(map);
    }
}