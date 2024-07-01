package actions;

import map.WorldMap;

abstract public class Action {
    abstract public void perform(WorldMap map);
}